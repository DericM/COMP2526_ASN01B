package ca.bcit.comp2526.a1b;

import java.util.Scanner;

/**
 * ConsoleUserInterface.
 * 
 * @author Deric
 * @version 1.0
 */
public class ConsoleUserInterface implements UserInterface {
    private final int printSpacing = 20;

    private final Scanner input;
    private AddressBook addressBook;

    /**
     * Constructor for objects of type ConsoleUserInterface.
     */
    public ConsoleUserInterface() {
        input = new Scanner(System.in);
    }

    
    /**
     * displays a single Person's data.
     */
    public void display(Person person) {
        System.out.println(person.getName() 
                + getPadding(person.getName()) 
                + person.getPhoneNumber());
    }
    
    
    /**
     * Returns the correct amount of white space to separate 
     *     the name and number when printing to the screen.
     * @param leading the name which will have its length subtracted from the total padding.
     * @return the correct amount of "padding" or white space.
     */
    private String getPadding(String leading) {
        int spacing = printSpacing;

        String padding = "";
        spacing = spacing - leading.length();

        for (int i = 0; i < spacing; i++) {
            padding += " ";
        }
        return padding;
    }
    
    /**
     * displays all people in the database.
     */
    public void displayAll(Person[] people) {

        for (int i = 0; i < people.length; i++) {
            display(people[i]);
        }
    }

    /**
     * reads in the name of a Person from the console using a Scanner.
     */
    public String readName() {
        System.out.println("Input a name:");
        return input.next();
    }
    
    public String readNumber() {
        System.out.println("Input a phone number:");
        return input.next();
    }

    /**
     * reads in the Person data from the console using a Scanner and returns the new Person.
     */
    public Person readPerson() {
        return new Person(readName(), readNumber());
    }
    
    /** 
     * displays the available menu.
     */
    public void displayMenu() {
        System.out.println("\n\n\n1) Add");
        System.out.println("2) Delete");
        System.out.println("3) Search");
        System.out.println("4) Display All");
        System.out.println("5) Exit\n");
    }
    
    /** 
     * reads the user's choice from the console using a Scanner.
     */
    public int readChoice() {
        int choice = 4;// default
        boolean done = false;
        while (!done) {
            System.out.println("What is your choice?");
            choice = input.nextInt();
            if (choice > 0 && choice <= 5) {
                done = true;
            } else {
                System.out.println("\nYour choice is incorrect, please try again.");
            }
        }
        return choice;
    }
    
    /**
     * performs the address book functions.
     */
    public void run(AddressBook book) {
        addressBook = book;
        int choice = 0;
        do {
            displayMenu();
            choice = readChoice();
            switch (choice) {
              case 1:
                  addressBook.addPerson();
                  break;
              case 2:
                  addressBook.deletePerson();
                  break;
              case 3:
                  addressBook.findPerson();
                  break;
              case 4:
                  addressBook.displayAll();
                  break;
              default:
                  // should not get here
            }

        } while (choice != 5);
    }

    /**
     * displays the String message passed on to the user interface.
     */
    public void displayMsg(String msg) {
        System.out.println(msg);
    }

    /**
     * displays the String message passed on to the user interface.
     */
    public void displayErrorMsg(String msg) {
        System.out.println("Error: " + msg);
    }

}
