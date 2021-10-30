package addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
	void print(ArrayList<AddressBook> arrayList) {
		for (AddressBook s : arrayList) {
			System.out.println(s);
		}
	}

	void enterDetails(AddressBook contactThree) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter firstName");
		contactThree.setFirstName(sc.nextLine());
		System.out.println("Enter lastName");
		contactThree.setLastName(sc.nextLine());
		System.out.println("Enter Address");
		contactThree.setAddress(sc.nextLine());
		System.out.println("Enter city");
		contactThree.setCity(sc.nextLine());
		System.out.println("Enter state");
		contactThree.setState(sc.nextLine());
		System.out.println("Enter Zip Code");
		contactThree.setZip(sc.nextLine());
		System.out.println("Enter PhoneNumber");
		contactThree.setPhoneNumber(sc.nextLine());
		System.out.println("Enter Email");
		contactThree.setEmail(sc.nextLine());
	}
}