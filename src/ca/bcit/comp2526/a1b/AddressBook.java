package ca.bcit.comp2526.a1b;

/**
 * AddressBook.
 * 
 * @author Deric
 * @version 1.0
 */
public class AddressBook {
    private final Database database;
    private final UserInterface userInterface;

    /**
     * Constructor for objects of type AddressBook.
     * 
     * @param userInterface
     *            The user interface
     */
    public AddressBook(final UserInterface userInterface) {
        this.userInterface = userInterface;
        database = new Database();
    }
    
    
    /** 
     * reads a person from the user interface and adds them to the database.
     */
    public void addPerson() {
        database.add(userInterface.readPerson());
    }

    /**
     * Reads a persons name from the user interface and tries to delete them from the database.
     * If not successful, this method displays an error on the user interface.
     * If successful, this this method displays the name of the person deleted and the words
     *   "was deleted successfully"on the user interface.
     */
    public void deletePerson() {
        String name = userInterface.readName();
        
        if (remove(name)) {
            userInterface.displayMsg(name + " was deleted sucessfully.");
        } else {
            userInterface.displayErrorMsg("Name not found.");
        }
    }

    /**
     * Reads a persons name from the user interface and tries to find them in the database.
     * If not found, the error message "No such person" is displayed.
     * 
     */
    public void findPerson() {
        Person person = search(userInterface.readName());
        if (person != null) {
            display(person);
        } else {
            userInterface.displayErrorMsg("Name not found.");
        }
    }


    private boolean remove(final String name) {
        return (database.removeByName(name) != null);
    }

    private Person search(final String name) {
        return (database.findByName(name));
    }

    public void displayAll() {
        userInterface.displayAll(database.getAll());
    }

    private void display(final Person person) {
        userInterface.display(person);
    }
}
