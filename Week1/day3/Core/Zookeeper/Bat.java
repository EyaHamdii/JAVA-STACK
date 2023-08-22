public class Bat extends Mammal {
    public Bat() {
        energyLevel = 300;
    }

    public void fly() {
        System.out.println("Bat takes off!");
        energyLevel -= 50;
    }

    public void eatHumans() {
        System.out.println("Bat is feasting on humans!");
        energyLevel += 25;
    }

    public void attackTown() {
        System.out.println("Town is on fire!");
        energyLevel -= 100;
    }
}

