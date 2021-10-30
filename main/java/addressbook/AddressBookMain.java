package addressbook;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to AddressBook Program");

        AddressBook contact = new AddressBook();
        contact.setFirstName("Kallavai");
        contact.setLastName("Sravanthi");
        contact.setAddress("11/11 abcd colony,efgh nagar");
        contact.setCity("Hyderabad");
        contact.setState("ABCD");
        contact.setZip("344576");
        contact.setPhoneNumber("7846837489");
        contact.setEmail("nhydn@yahoo.com");

        ContactStore contactStore = new ContactStore();
        contactStore.add(contact);

        UserInterface userInterface = new UserInterface();
        userInterface.print(contactStore.getContactList());
    }
}