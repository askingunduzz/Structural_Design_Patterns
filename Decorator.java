// Step 1: Define the Component Interface (Pizza)
interface Pizza {
    String getDescription();
    double getCost();
}

// Step 2: Implement a Concrete Component (Plain Pizza)
class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 5.00; // Base cost for a plain pizza
    }
}

// Step 3: Create the Decorator Base Class
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}

// Step 4: Implement Concrete Decorators

// Cheese Topping
class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.50; // Cost of adding cheese
    }
}

// Pepperoni Topping
class PepperoniDecorator extends PizzaDecorator {
    public PepperoniDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Pepperoni";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 2.00; // Cost of adding pepperoni
    }
}

// Olive Topping
class OliveDecorator extends PizzaDecorator {
    public OliveDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.00; // Cost of adding olives
    }
}

// Step 5: Testing the Decorator Pattern
public class Decorator {
    public static void main(String[] args) {
        // Create a plain pizza
        Pizza myPizza = new PlainPizza();
        System.out.println(myPizza.getDescription() + " -> Cost: $" + myPizza.getCost());

        // Add cheese topping
        myPizza = new CheeseDecorator(myPizza);
        System.out.println(myPizza.getDescription() + " -> Cost: $" + myPizza.getCost());

        // Add pepperoni topping
        myPizza = new PepperoniDecorator(myPizza);
        System.out.println(myPizza.getDescription() + " -> Cost: $" + myPizza.getCost());

        // Add olive topping
        myPizza = new OliveDecorator(myPizza);
        System.out.println(myPizza.getDescription() + " -> Cost: $" + myPizza.getCost());
    }
}
