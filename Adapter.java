interface EngKonus {
    void speakEng(String sozler);
}

class FranKonus {
    public void speakFran(String sozler) {
        System.out.println("Fran Konus: " + sozler);
    }
}

class IspKonus {
    public void speakIsp(String sozler) {
        System.out.println("Isp Konus: " + sozler);
    }
}

class FranToEngCevir implements EngKonus {
    public FranToEngCevir(FranKonus FranKonus) {
    }

    public void speakEng(String sozler) {

        String translatedsozler = translateFranToEng(sozler);
        System.out.println("Translator (Fran to Eng): " + translatedsozler);
    }

    private String translateFranToEng(String sozler) {
        if (sozler.equals("Bonjour")) {
            return "Hello";
        }
        return "error";
    }
}

class IspToEngCevir implements EngKonus {
    public IspToEngCevir(IspKonus IspKonus) {
    }

    public void speakEng(String sozler) {

        String translatedsozler = translateIspToEng(sozler);
        System.out.println("Translator (Isp to Eng): " + translatedsozler);
    }

    private String translateIspToEng(String sozler) {
        if (sozler.equals("Hola")) {
            return "Hello";
        }
        return "error";
    }
}

class Konferans {
    private EngKonus Konus;

    public void CeviriAyar(EngKonus Konus) {
        this.Konus = Konus;
    }

    public void cevir(String sozler) {
        if (Konus != null) {
            Konus.speakEng(sozler);
        } else {
            System.out.println("error");
        }
    }
}

public class Adapter {
    public static void main(String[] args) {
        Konferans Konferans = new Konferans();

        FranKonus FranKonus = new FranKonus();
        EngKonus FranCevir = new FranToEngCevir(FranKonus);
        Konferans.CeviriAyar(FranCevir);
        Konferans.cevir("Bonjour");

        IspKonus IspKonus = new IspKonus();
        EngKonus IspCevir = new IspToEngCevir(IspKonus);
        Konferans.CeviriAyar(IspCevir);
        Konferans.cevir("Hola");
    }
}
