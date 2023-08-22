import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item();
        item1.name = "Raviolli";
        item1.price = 22;

        Item item2 = new Item();
        item2.name = "Burger";
        item2.price = 32;

        Item item3 = new Item();
        item3.name = "Pasta";
        item3.price = 15;

        Item item4 = new Item();
        item4.name = "Pizza";
        item4.price = 22;
        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        order1.name = "Cindhuri";
        order1.total = 22;
        order1.ready = true;

        Order order2 = new Order();
        order2.name = "Jimmy";
        order2.total = 22;
        order2.ready = true;

        Order order3 = new Order();
        order3.name = "Noah";
        order3.total = 22;
        order3.ready = true;

        Order order4 = new Order();
        order4.name = "Sam";
        order4.total = 22;
        order4.ready = true;

        // Application Simulations
        // Use this example code to test various orders' updates
        // System.out.printf("Name: %s\n", order1);
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
    }
}
