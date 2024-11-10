import java.util.HashMap;
import java.util.Map;

// Step 1: Define the Flyweight (TreeType)
class TreeType {
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing " + name + " tree at (" + x + ", " + y + ") with color " + color + " and texture " + texture);
    }
}

// Step 2: Create the Flyweight Factory
class TreeFactory {
    private static final Map<String, TreeType> treeTypeMap = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + color + texture;
        if (!treeTypeMap.containsKey(key)) {
            treeTypeMap.put(key, new TreeType(name, color, texture));
            System.out.println("Creating new TreeType: " + name + ", " + color + ", " + texture);
        } else {
            System.out.println("Reusing existing TreeType: " + name + ", " + color + ", " + texture);
        }
        return treeTypeMap.get(key);
    }
}

// Step 3: Define the Context (Tree) that uses the Flyweight
class Tree {
    private int x; // Extrinsic state (unique for each tree)
    private int y; // Extrinsic state (unique for each tree)
    private TreeType type; // Intrinsic state (shared)

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}

// Step 4: Testing the Flyweight Pattern
public class Flyweight {
    public static void main(String[] args) {
        // Creating a forest of trees with shared types
        TreeType oakType = TreeFactory.getTreeType("Oak", "Green", "Rough");
        TreeType pineType = TreeFactory.getTreeType("Pine", "Dark Green", "Smooth");
        TreeType birchType = TreeFactory.getTreeType("Birch", "White", "Striped");

        // Creating trees with the same type but different positions
        Tree tree1 = new Tree(10, 20, oakType);
        Tree tree2 = new Tree(15, 25, oakType);  // Reuses oakType
        Tree tree3 = new Tree(30, 40, pineType);
        Tree tree4 = new Tree(50, 60, birchType);
        Tree tree5 = new Tree(35, 45, birchType);  // Reuses birchType

        // Drawing trees in the forest
        tree1.draw();
        tree2.draw();
        tree3.draw();
        tree4.draw();
        tree5.draw();
    }
}
