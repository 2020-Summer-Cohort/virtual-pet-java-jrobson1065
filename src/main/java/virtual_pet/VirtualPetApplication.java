package virtual_pet;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class VirtualPetApplication {

    static VirtualPet myPet = new VirtualPet();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String name = introAndGetName(input);
        int response;
        while (true) {
            try {
                response = input.nextInt();
                input.nextLine();
                if (response == 1 || response == 0) {
                    break;
                } else {
                    invalidEntry(input);
                }
            } catch (InputMismatchException exception) {
                invalidEntry(input);
                input.nextLine();
            }
        }

        if (response == 0) {
            getStats(input);
        }

        gameLoop(input, name);
    }

    public static String introAndGetName(Scanner input) {
        System.out.println("Hi! I'm your new Cactus pet! Before we get started, please give me a name:");
        String name = input.nextLine();
        System.out.println(name + "? Hmm, I like that name. Ok my name is " + name + ".");
        System.out.println("Press enter to continue.");
        input.nextLine();
        System.out.println(name + " gets 1 day older with every action you do. You want to make " +
                name + " happy. If " + name + "'s happiness reaches 10, you win. \n" +
                "But if " + name + " reaches 30 days old, the game ends. If " + name +
                " isn't happy, you lose. Also, if " + name + " gets too hungry or too thirsty or \n" +
                "if " + name + "'s health is too low, then you will lose. Hit enter to continue.");
        input.nextLine();
        System.out.println("Let's see how " + name + " feels! Enter 0 to see how " +
                name + " feels or enter 1 to begin.");
        return name;
    }

    public static void invalidEntry(Scanner input) {
        System.out.println("Invalid input. Please try again.");
        System.out.println("Enter 0 to ask how I feel or 1 to get started.");
    }

    public static void getStats(Scanner input) {

        System.out.println("Hunger: " + myPet.getHunger());
        System.out.println("Thirst: " + myPet.getThirst());
        System.out.println("Happiness: " + myPet.getHappiness());
        System.out.println("Health: " + myPet.getHealth());
        System.out.println("Age: " + myPet.getAge());
        System.out.println("Press enter to continue:");
        input.nextLine();
    }

    public static void whatToDo(Scanner input, String name) {
        System.out.println("What would you like to do now?");
        System.out.println("     1 - Feed " + name);
        System.out.println("     2 - Water " + name);
        System.out.println("     3 - Talk to " + name);
        System.out.println("     4 - Give " + name + " sunlight");
        System.out.println("     5 - Surprise " + name);
        System.out.println("     6 - Forget to feed " + name);
        System.out.println("     7 - Forget to water " + name);
        System.out.println("     8 - Ignore " + name);
        System.out.println("     9 - Leave " + name + "in the corner");
        System.out.println("     0 - Ask " + name + " how he feels");

        try {
            int action = input.nextInt();
            input.nextLine();

            switch (action) {
                case 1:
                    myPet.feedMe();
                    break;
                case 2:
                    myPet.waterMe();
                    break;
                case 3:
                    myPet.talkToMe();
                    break;
                case 4:
                    myPet.giveMeLight();
                    break;
                case 5:
                    myPet.surpriseMe();
                    break;
                case 6:
                    myPet.forgetToFeedMe();
                    break;
                case 7:
                    myPet.forgetToWaterMe();
                    break;
                case 8:
                    myPet.ignoreMe();
                    break;
                case 9:
                    myPet.leaveMeInTheCorner();
                    break;
                default:
                    getStats(input);
                    break;
            }
            myPet.tick();
        } catch (InputMismatchException exception) {
            System.out.println("Entry not valid. Please try again.");
            input.nextLine();
        }

    }

    public static void gameLoop(Scanner input, String name) {
        int hunger = myPet.getHunger();
        int thirst = myPet.getThirst();
        int happiness = myPet.getHappiness();
        int health = myPet.getHealth();
        int age = myPet.getAge();

        while (happiness < 10 && health >= 0 && hunger < 11 && thirst < 11 && age <= 30) {
            whatToDo(input, name);
        }

        if (happiness >= 9) {
            System.out.println(name + " is completely happy! You win.");
        } else if (health < 0) {
            System.out.println(name + " was not taken care of and died.");
        } else if (hunger > 10) {
            System.out.println(name + " was not feed enough and died.");
        } else if (thirst > 10) {
            System.out.println(name + " did not get enough water and died.");
        } else if (happiness > 6) {
            System.out.println(name + " lived a long life and was moderately happy. You win.");
        } else {
            System.out.println(name + " lived a long life but wasn't completely happy. You lose.");
        }
    }

}
