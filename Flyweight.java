import java.util.HashMap;
import java.util.Map;

class AgacTuru {
    private String isim;
    private String renk;
    private String desen;

    public AgacTuru(String isim, String renk, String desen) {
        this.isim = isim;
        this.renk = renk;
        this.desen = desen;
    }

    public void draw(int x, int y) {
        System.out.println(isim + " agaci: (" + x + ", " + y + "), renk " + renk + " ve desen " + desen);
    }
}

class TreeFactory {
    private static final Map<String, AgacTuru> AgacTuruMap = new HashMap<>();

    public static AgacTuru getAgacTuru(String isim, String renk, String desen) {
        String key = isim + renk + desen;
        if (!AgacTuruMap.containsKey(key)) {
            AgacTuruMap.put(key, new AgacTuru(isim, renk, desen));
            System.out.println("Yeni AgacTuru: " + isim + ", " + renk + ", " + desen);
        } else {
            System.out.println("AgacTuru'nu tekrar Kullaniyorum: " + isim + ", " + renk + ", " + desen);
        }
        return AgacTuruMap.get(key);
    }
}

class Tree {
    private int x; 
    private int y; 
    private AgacTuru type; 

    public Tree(int x, int y, AgacTuru type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}

public class Flyweight {
    public static void main(String[] args) {

        AgacTuru CamType = TreeFactory.getAgacTuru("Cam", "Yesil", "Sert");
        AgacTuru MeseType = TreeFactory.getAgacTuru("Mese", "koyu Yesil", "Cizgili");
        AgacTuru PalamutType = TreeFactory.getAgacTuru("Palamut", "Beyaz", "Cok Cizgili");

        Tree tree1 = new Tree(10, 20, CamType);
        Tree tree2 = new Tree(15, 25, CamType);  
        Tree tree3 = new Tree(30, 40, MeseType);
        Tree tree4 = new Tree(50, 60, PalamutType);
        Tree tree5 = new Tree(10, 20, MeseType);

        tree1.draw();
        tree2.draw();
        tree3.draw();
        tree4.draw();
        tree5.draw();
    }
}
