package addressbook;

import java.util.ArrayList;

public class UserInterface {
	ArrayList<AddressBook> contactList;

	void print(ArrayList<AddressBook> arrayList) {
		for (AddressBook s : arrayList) {
			System.out.println(s);
		}
	}
}