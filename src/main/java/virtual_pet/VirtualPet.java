package virtual_pet;

import java.util.Random;

public class VirtualPet {
    Random rand = new Random();
    int hunger = rand.nextInt(5) + 3;
    int thirst = rand.nextInt(5) + 3;
    int happiness = rand.nextInt(5) + 3;
    int health = rand.nextInt(5) + 3;
    int age = rand.nextInt(5) + 3;


    private void tick() {
        hunger = hunger + 1;
        thirst = thirst + 1;
        happiness = happiness - 1;
        health = health - 1;
        age = age + 1;
    }

    private int getAge() {
        return age;
    }

    private int getHunger() {
        return hunger;
    }

    private int getThirst() {
        return thirst;
    }

    private int getHappiness() {
        return happiness;
    }

    private int getHealth() {
        return health;
    }

    private void feedMe() {
        hunger = hunger - 2;
        health = health + 1;
    }

    private void waterMe() {
        thirst = thirst - 2;
        health = health + 1;

    }

    private void talkToMe() {
        happiness = happiness + 2;
        health = health + 1;

    }

    private void giveMeLight() {
        happiness = happiness + 1;
        health = health + 2;

    }

    private void surpriseMe() {
        int random = rand.nextInt(9) + 1;
        switch (random) {
            case 1:
                feedMe();
                break;
            case 2:
                waterMe();
                break;
            case 3:
                talkToMe();
                break;
            case 4:
                giveMeLight();
                break;
            case 5:
                surpriseMe();
                break;
            case 6:
                forgetToFeedMe();
                break;
            case 7:
                forgetToWaterMe();
                break;
            case 8:
                ignoreMe();
                break;
            case 9:
                leaveMeInTheCorner();
                break;
        }

    }

    private void forgetToFeedMe() {
        hunger = hunger + 1;
        health = health - 1;

    }

    private void forgetToWaterMe() {
        thirst = thirst + 1;
        health = health - 1;

    }

    private void ignoreMe() {
        happiness = happiness - 1;
        health = health - 1;

    }

    private void leaveMeInTheCorner() {
        happiness = happiness - 1;
        health = health - 1;

    }


}
