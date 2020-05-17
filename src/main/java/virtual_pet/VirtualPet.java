package virtual_pet;

import java.util.Random;

public class VirtualPet {
    Random rand = new Random();
    private int health = rand.nextInt(5) + 3;
    private int happiness = rand.nextInt(5) + 3;
    private int age = 1;
    private int thirst = rand.nextInt(5) + 3;
    private String surprise = "";

    void tick() {
        happiness = happiness - 1;
        health = health - 1;
        thirst = thirst + 1;
        age = age + 1;
    }

    void removeTick() {
        happiness = happiness + 1;
        health = health + 1;
        thirst = thirst - 1;
        age = age - 1;
    }

    String getState() {
        if (thirst > 6) {
            return "Thirsty";
        } else if (health < 4) {
            return "Unhealthy";
        } else if (happiness < 4) {
            return "Sad";
        } else if (thirst < 4) {
            return "Satisfied";
        } else if (happiness > 6) {
            return "Happy";
        } else if (health > 6) {
            return "Healthy";
        } else if (age > 25) {
            return "Old";
        } else {
            return "Okay";
        }
    }

    int getAge() {
        return age;
    }

    int getHappiness() {
        if (happiness > 10) {
            happiness = 10;
        }
        return happiness;
    }

    int getHealth() {
        if (health > 10) {
            health = 10;
        }
        return health;
    }

    int getThirst() {
        if (thirst < 0) {
            thirst = 0;
        }
        return thirst;
    }

    void waterMeFiltered() {
        thirst = thirst - 3;
        health = health + 2;
    }

    void waterMeNutrient() {
        thirst = thirst - 3;
        health = health + 2;
        happiness = happiness + 1;
    }

    void waterMeTap() {
        thirst = thirst - 2;
        health = health + 1;
    }

    void talkToMeCasual() {
        happiness = happiness + 1;
        health = health + 1;
    }

    void talkToMeEncouraging() {
        happiness = happiness + 2;
        health = health + 1;
    }

    void talkToMeEnthusiastic() {
        happiness = happiness + 2;
        health = health + 2;
    }

    void giveMeLightAmbient() {
        happiness = happiness + 1;
        health = health + 2;
    }

    void giveMeLightDeskLight() {
        happiness = happiness + 2;
        health = health + 2;
    }

    void giveMeLightSun() {
        happiness = happiness + 2;
        health = health + 3;
    }

    void surpriseMe() {
        int random = rand.nextInt(9) + 1;
        switch (random) {
            case 1:
                waterMeTap();
                surprise = " with tap water!";
                break;
            case 2:
                waterMeFiltered();
                surprise = " with filtered water!";
                break;
            case 3:
                waterMeNutrient();
                surprise = " with nutrient water!";
                break;
            case 4:
                talkToMeEnthusiastic();
                surprise = " with an enthusiastic talk!";
                break;
            case 5:
                talkToMeCasual();
                surprise = " with a casual talk!";
                break;
            case 6:
                talkToMeEncouraging();
                surprise = " with encouragement!";
                break;
            case 7:
                giveMeLightAmbient();
                surprise = " with ambient light!";
                break;
            case 8:
                giveMeLightDeskLight();
                surprise = " with desk light!";
                break;
            case 9:
                giveMeLightSun();
                surprise = " with sunlight!";
        }
    }

    String surprise() {
        return surprise;
    }
}
