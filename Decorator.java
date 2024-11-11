interface Pizza {
    String getDescription();
    double getCost();
}

class PlainPizza implements Pizza {

    public String getDescription() {
        return "Plain Pizza";
    }

    public double getCost() {
        return 5.00; 
    }
}

abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return pizza.getDescription();
    }

    public double getCost() {
        return pizza.getCost();
    }
}

class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    public double getCost() {
        return pizza.getCost() + 1.50; 
    }
}

class PepperoniDecorator extends PizzaDecorator {
    public PepperoniDecorator(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", Pepperoni";
    }

    public double getCost() {
        return pizza.getCost() + 2.00; 
    }
}

class OliveDecorator extends PizzaDecorator {
    public OliveDecorator(Pizza pizza) {
        super(pizza);
    }

    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    public double getCost() {
        return pizza.getCost() + 1.00; 
    }
}

public class Decorator {
    public static void main(String[] args) {

        Pizza myPizza = new PlainPizza();
        System.out.println(myPizza.getDescription() + " : Cost = " + myPizza.getCost());

        myPizza = new CheeseDecorator(myPizza);
        System.out.println(myPizza.getDescription() + " : Cost = " + myPizza.getCost());

        myPizza = new PepperoniDecorator(myPizza);
        System.out.println(myPizza.getDescription() + " : Cost = " + myPizza.getCost());

        myPizza = new OliveDecorator(myPizza);
        System.out.println(myPizza.getDescription() + " : Cost = " + myPizza.getCost());
    }
}
