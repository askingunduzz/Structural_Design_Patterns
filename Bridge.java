// Step 1: Define the Implementor Interface (Storage)
interface Storage {
    void save(String filename, String content);
}

// Step 2: Implement Concrete Storages (LocalDiskStorage and CloudStorage)

// Local Disk Storage
class LocalDiskStorage implements Storage {
    @Override
    public void save(String filename, String content) {
        System.out.println("Saving to local disk: " + filename + "\nContent: " + content);
    }
}

// Cloud Storage
class CloudStorage implements Storage {
    @Override
    public void save(String filename, String content) {
        System.out.println("Saving to cloud storage: " + filename + "\nContent: " + content);
    }
}

// Step 3: Define the Abstraction (File)
abstract class File {
    protected Storage storage;

    public File(Storage storage) {
        this.storage = storage;
    }

    public abstract void save(String content);
}

// Step 4: Extend the Abstraction (TextFile and PDFFile)

// Text File
class TextFile extends File {
    private String filename;

    public TextFile(Storage storage, String filename) {
        super(storage);
        this.filename = filename + ".txt";
    }

    @Override
    public void save(String content) {
        System.out.println("Saving text file...");
        storage.save(filename, content);
    }
}

// PDF File
class PDFFile extends File {
    private String filename;

    public PDFFile(Storage storage, String filename) {
        super(storage);
        this.filename = filename + ".pdf";
    }

    @Override
    public void save(String content) {
        System.out.println("Saving PDF file...");
        storage.save(filename, content);
    }
}

// Step 5: Testing the Bridge Pattern
public class Bridge {
    public static void main(String[] args) {
        // Saving a text file to local disk
        File textFile = new TextFile(new LocalDiskStorage(), "report");
        textFile.save("This is a text file content.");

        System.out.println();

        // Saving a PDF file to cloud storage
        File pdfFile = new PDFFile(new CloudStorage(), "presentation");
        pdfFile.save("This is a PDF file content.");
    }
}
