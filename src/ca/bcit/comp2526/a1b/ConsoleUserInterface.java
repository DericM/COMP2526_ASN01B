package ca.bcit.comp2526.a1b;

import java.util.Scanner;

/**
 * ConsoleUserInterface.
 * 
 * @author Deric
 * @version
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

    
    
    public void display(Person person) {
        System.out.println(person.getName() 
                + getPadding(person.getName() 
                + person.getPhoneNumber()));
    }
    
    
    
    private String getPadding(String leading) {
        int spacing = printSpacing;

        String padding = "";
        spacing = spacing - leading.length();

        for (int i = 0; i < spacing; i++) {
            padding += " ";
        }
        return padding;
    }
    
    
    

    public void displayAll(Person[] people) {

        for (int i = 0; i < people.length; i++) {
            display(people[i]);
        }
    }

    public String readName() {
        System.out.println("Input a name:");
        return input.next();
    }
    
    public String readNumber() {
        System.out.println("Input a phone number:");
        return input.next();
    }

    public Person readPerson() {
        return new Person(readName(), readNumber());
    }

    public void run(AddressBook book) {
        
    }

    public void displayMsg(String msg) {
        System.out.println("Message: " + msg);
    }

    public void displayErrorMsg(String msg) {
        System.out.println("Error: " + msg);
    }

}
