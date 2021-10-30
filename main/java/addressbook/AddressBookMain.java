package addressbook;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to AddressBook Program");

        AddressBook contact = new AddressBook();
        UserInterface userInterface = new UserInterface();
        userInterface.enterDetails(contact);

        ContactStore contactStore = new ContactStore();
        contactStore.add(contact);
        userInterface.print(contactStore.getContactList());
    }
}