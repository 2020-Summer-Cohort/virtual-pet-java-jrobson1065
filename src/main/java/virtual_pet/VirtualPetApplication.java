package virtual_pet;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VirtualPetApplication {

    static VirtualPet myPet = new VirtualPet();
    static Scanner input = new Scanner(System.in);
    static String name;

    public static void main(String[] args) {

        name = introAndPetSetup();
        int response;
        while (true) {
            try {
                response = input.nextInt();
                input.nextLine();
                if (response == 1 || response == 0) {
                    break;
                } else {
                    invalidEntry();
                    System.out.println("Enter 0 to ask how I feel or 1 to get started.");
                }
            } catch (InputMismatchException exception) {
                invalidEntry();
                System.out.println("Enter 0 to ask how I feel or 1 to get started.");
                input.nextLine();
            }
        }

        if (response == 0) {
            getStats();
        }

        gameLoop();
    }

    public static String introAndPetSetup() {
        System.out.println("Hi! I'm your new pet Cactus! Before we get started, please give me a name:");
        name = input.nextLine();
        System.out.println(name + "? Hmm, I like that name. Ok my name is " + name + ".");
        System.out.println("Press enter to continue.");
        input.nextLine();
        System.out.println(name + " gets 1 day older with every action you do. You want to make " +
                name + " happy. When " + name + " reaches 30 days old, \n" +
                "the game will be over. If " + name + " isn't happy, you lose. Also, if " + name +
                " isn't taken care of, then you will lose. Press enter to continue.");
        input.nextLine();
        System.out.println("Let's see how " + name + " feels today! Enter 0 to see how " +
                name + " feels or enter 1 to begin.");
        return name;
    }

    public static void invalidEntry() {
        System.out.println("Invalid input. Please try again.");
    }

    public static void getStats() {
        System.out.println("State: " + myPet.getState());
        System.out.println("Thirst: " + myPet.getThirst());
        System.out.println("Happiness: " + myPet.getHappiness());
        System.out.println("Health: " + myPet.getHealth());
        System.out.println("Age: " + myPet.getAge());
        System.out.println("Press enter to continue:");
        input.nextLine();
    }

    public static void whatToDo() {
        System.out.println("What would you like to do now?");
        System.out.println("     1 - Water " + name);
        System.out.println("     2 - Talk to " + name);
        System.out.println("     3 - Give " + name + " light");
        System.out.println("     4 - Surprise " + name);
        System.out.println("     0 - Ask " + name + " how he feels?");

        try {
            int action = input.nextInt();
            input.nextLine();

            switch (action) {
                case 1:
                    waterMeOptions();
                    break;
                case 2:
                    talkToMeOptions();
                    break;
                case 3:
                    giveMeLightOptions();
                    break;
                case 4:
                    myPet.surpriseMe();
                    System.out.println("You surprise " + name + myPet.surprise());
                    break;
                default:
                    getStats();
                    myPet.removeTick();
            }
            myPet.tick();
        } catch (InputMismatchException exception) {
            System.out.println("Entry not valid. Please try again.");
            input.nextLine();
        }

    }

    public static void giveMeLightOptions() {

        System.out.println("What kind of light?");
        System.out.println("     1 - Ambient light");
        System.out.println("     2 - Desk light");
        System.out.println("     3 - Sunlight");

        try {
            int action = input.nextInt();
            input.nextLine();

            switch (action) {
                case 1:
                    myPet.giveMeLightAmbient();
                    break;
                case 2:
                    myPet.giveMeLightDeskLight();
                    break;
                case 3:
                    myPet.giveMeLightSun();
                    break;
                default:
                    getStats();
                    break;
            }
            myPet.tick();
        } catch (InputMismatchException exception) {
            System.out.println("Entry not valid. Please try again.");
            input.nextLine();
        }

    }

    public static void talkToMeOptions() {

        System.out.println("What kind of talk?");
        System.out.println("     1 - Casual talk");
        System.out.println("     2 - Encouraging talk");
        System.out.println("     3 - Enthusiastic talk");

        try {
            int action = input.nextInt();
            input.nextLine();

            switch (action) {
                case 1:
                    myPet.talkToMeCasual();
                    break;
                case 2:
                    myPet.talkToMeEncouraging();
                    break;
                case 3:
                    myPet.talkToMeEnthusiastic();
                    break;
                default:
                    getStats();
                    break;
            }
            myPet.tick();
        } catch (InputMismatchException exception) {
            System.out.println("Entry not valid. Please try again.");
            input.nextLine();
        }

    }

    public static void waterMeOptions() {

        System.out.println("What kind of water?");
        System.out.println("     1 - Filtered water");
        System.out.println("     2 - High nutrient water");
        System.out.println("     3 - Tap water");

        try {
            int action = input.nextInt();
            input.nextLine();

            switch (action) {
                case 1:
                    myPet.waterMeFiltered();
                    break;
                case 2:
                    myPet.waterMeNutrient();
                    break;
                case 3:
                    myPet.waterMeTap();
                    break;
                default:
                    getStats();
                    break;
            }
            myPet.tick();
        } catch (InputMismatchException exception) {
            System.out.println("Entry not valid. Please try again.");
            input.nextLine();
        }

    }

    public static void gameLoop() {
        int thirst = myPet.getThirst();
        int happiness = myPet.getHappiness();
        int health = myPet.getHealth();
        int age = myPet.getAge();

        while (thirst < 10 && health > 0 && happiness > 0 && age < 30) {
            whatToDo();
            thirst = myPet.getThirst();
            happiness = myPet.getHappiness();
            health = myPet.getHealth();
            age = myPet.getAge();
        }

        if (thirst > 9) {
            System.out.println(name + " wasn't watered enough. You lose.");
        } else if (health < 1) {
            System.out.println(name + " was not taken care of. You lose.");
        } else if (happiness < 1) {
            System.out.println(name + " wasn't happy enough. You lose.");
        } else if (age >= 29 && happiness > 3 && health > 3 && thirst < 7) {
            System.out.println(name + " lived a long comfortable life. You win.");
        } else {
            System.out.println(name + " lived a long life but was malnourished. You lose.");
        }

    }

}
