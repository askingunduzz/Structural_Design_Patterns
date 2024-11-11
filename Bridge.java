interface Depolama {
    void save(String filename, String content);
}

class LocalDiskDepolama implements Depolama {
    @Override
    public void save(String filename, String content) {
        System.out.println("Saving to local disk: " + filename + "\nContent: " + content);
    }
}

class CloudDepolama implements Depolama {
    @Override
    public void save(String filename, String content) {
        System.out.println("Saving to cloud: " + filename + "\nContent: " + content);
    }
}

abstract class File {
    protected Depolama Depolama;

    public File(Depolama Depolama) {
        this.Depolama = Depolama;
    }

    public abstract void save(String content);
}

class TextFile extends File {
    private String filename;

    public TextFile(Depolama Depolama, String filename) {
        super(Depolama);
        this.filename = filename + ".txt";
    }

    public void save(String content) {
        System.out.println("Saving text file...");
        Depolama.save(filename, content);
    }
}

class PDFFile extends File {
    private String filename;

    public PDFFile(Depolama Depolama, String filename) {
        super(Depolama);
        this.filename = filename + ".pdf";
    }

    public void save(String content) {
        System.out.println("Saving PDF file...");
        Depolama.save(filename, content);
    }
}

public class Bridge {
    public static void main(String[] args) {
        File textFile = new TextFile(new LocalDiskDepolama(), "report");
        textFile.save("This is a text file content.");

        System.out.println();

        File pdfFile = new PDFFile(new CloudDepolama(), "presentation");
        pdfFile.save("This is a PDF file content.");
    }
}
