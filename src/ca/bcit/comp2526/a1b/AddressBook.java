package ca.bcit.comp2526.a1b;

/**
 * AddressBook.
 * 
 * @author your name here
 * @version
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

    public void addPerson() {
        database.add(userInterface.readPerson());
    }

    public void deletePerson() {
        database.removeByName(userInterface.readName());
    }

    public void findPerson() {
        
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
