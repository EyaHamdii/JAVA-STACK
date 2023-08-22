public class Gorilla extends Mammal {
    public void throwSomething() {
        System.out.println("Gorilla has thrown something!");
        energyLevel -= 5;
    }

    public void eatBananas() {
        System.out.println("Gorilla is satisfied after eating bananas!");
        energyLevel += 10;
    }

    public void climb() {
        System.out.println("Gorilla has climbed a tree!");
        energyLevel -= 10;
    }
}

