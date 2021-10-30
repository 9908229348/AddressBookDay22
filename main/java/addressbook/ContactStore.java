package addressbook;

import java.util.ArrayList;

public class ContactStore {
    private ArrayList<AddressBook> contactList = new ArrayList<AddressBook>();

    public ArrayList<AddressBook> getContactList() {
        return contactList;
    }

    public void add(AddressBook contact) {
        contactList.add(contact);
    }
}
