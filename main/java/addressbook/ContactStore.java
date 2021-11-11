package addressbook;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ContactStore extends AddressBook {
    Scanner scanner = new Scanner(System.in);

    public void setContactDetails() {
        System.out.println("enter the First Name");
        setFirstName(scanner.nextLine());
        System.out.println("enter the Last Name");
        setLastName(scanner.nextLine());
        System.out.println("enter the Address Name");
        setAddress(scanner.nextLine());
        System.out.println("Enter city");
        setCity(scanner.nextLine());
        System.out.println("enter the State Name");
        setState(scanner.nextLine());
        System.out.println("enter the Phone Number");
        setPhoneNumber(scanner.nextLine());
        System.out.println("enter the ZipCode");
        setZip(scanner.nextLine());
        System.out.println("enter the Email");
        setEmail(scanner.nextLine());
    }

    public void editDetails(ArrayList<ContactStore> contact) {
        System.out.println("Enter the name to edit");
        String name = scanner.nextLine();
        for (ContactStore contactStore : contact) {
            if (contactStore.getFirstName().equals(name)) {
                boolean check = true;
                while (check) {
                    System.out.printf("enter 1.First Name\n 2.Last Name\n 3.Address\n 4.City\n 5.State\n 6.PhoneNumber\n 7.PinCode\n 8.Email\n 9.Exit");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1 -> {
                            System.out.println("enter new first name");
                            String firstName = scanner.nextLine();
                            contactStore.setFirstName(firstName);
                        }
                        case 2 -> {
                            System.out.println("enter the new Last name");
                            String lastName = scanner.nextLine();
                            contactStore.setLastName(lastName);
                        }
                        case 3 -> {
                            System.out.println("enter new Address");
                            String address = scanner.nextLine();
                            contactStore.setAddress(address);
                        }
                        case 4 -> {
                            System.out.println("enter new City");
                            String city = scanner.nextLine();
                            contactStore.setCity(city);
                        }
                        case 5 -> {
                            System.out.println("enter new State");
                            String state = scanner.nextLine();
                            contactStore.setState(state);
                        }
                        case 6 -> {
                            System.out.println("enter new PhoneNumber");
                            String phoneNumber = scanner.nextLine();
                            contactStore.setPhoneNumber(phoneNumber);
                        }
                        case 7 -> {
                            System.out.println("enter new PinCode");
                            String pin = scanner.nextLine();
                            contactStore.setZip(pin);
                        }
                        case 8 -> {
                            System.out.println("enter new Email");
                            String email = scanner.nextLine();
                            contactStore.setEmail(email);
                        }
                        case 9 -> check = false;
                    }
                }

            } else
                System.out.println("Your name is not matched");
        }
    }

    public void deleteDetails(ArrayList<ContactStore> contact) {
        System.out.println("enter the name");
        String name = scanner.nextLine();
        for (int i = 0; i < contact.size(); i++) {
            if (contact.get(i).getFirstName().equals(name)) {
                contact.remove(i);
            }
        }
    }

    public boolean searchForDuplication(ArrayList<ContactStore> contactStores, ContactStore contact) {
        boolean check = false;
        for (ContactStore contactStore : contactStores) {
            if (contact.getFirstName().equalsIgnoreCase(contactStore.getFirstName()))
                check = true;
        }
        return check;
    }

    public static void search(Hashtable<Integer, ArrayList<ContactStore>> dictionary){
        System.out.println("Enter state name");
        Scanner scanner = new Scanner(System.in);
        String state = scanner.nextLine();
        System.out.println("Enter city name");
        String city = scanner.nextLine();
        long count1 = 0;
        long count2 = 0;
        System.out.println("Persons with State name :" + state);
        for (int i = 1; i <= dictionary.size(); i++) {
            List<ContactStore> personWithState = dictionary.get(i).stream().filter(s -> s.getState().equalsIgnoreCase(state)).collect(Collectors.toList());
            System.out.println(personWithState);
            long count = dictionary.get(i).stream().filter(s -> s.getState().equalsIgnoreCase(state)).count();
            count1 = count1 + count;
        }
        System.out.println("No.of Persons in State " + state + " are " + count1);
        System.out.println("Persons with City name :" + city);
        for (int i = 1; i <= dictionary.size(); i++){
            List<ContactStore> personWithCity = dictionary.get(i).stream().filter(c -> c.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
            System.out.println(personWithCity);
            long count = dictionary.get(i).stream().filter(c -> c.getCity().equalsIgnoreCase(city)).count();
            count2 = count2 + count;
        }
        System.out.println("No.of persons in City " + city + " are " + count2);
    }

    public static void sortByFirstName(Hashtable<Integer,ArrayList<ContactStore>> dictionary){
        for (int i = 1; i <= dictionary.size(); i++){
            List<ContactStore> list = dictionary.get(i).stream().sorted(Comparator.comparing(AddressBook::getFirstName)).collect(Collectors.toList());
            System.out.println(list);
        }
    }

    public static void sortByCity(Hashtable<Integer, ArrayList<ContactStore>> dictionary){
        for (int i = 1; i <= dictionary.size(); i++){
            List<ContactStore> list = dictionary.get(i).stream().sorted(Comparator.comparing(AddressBook::getCity)).collect(Collectors.toList());
            System.out.println(list);
        }
    }

    public static void sortByState(Hashtable<Integer, ArrayList<ContactStore>> dictionary){
        for (int i = 1; i <= dictionary.size(); i++){
            List<ContactStore> list = dictionary.get(i).stream().sorted(Comparator.comparing(AddressBook::getState)).collect(Collectors.toList());
            System.out.println(list);
        }
    }

    public static void writeToFile(Hashtable<Integer, ArrayList<ContactStore>> addressBook) {
        try{
            FileWriter fileWriter = new FileWriter("AddressBook.txt");
            String stream = String.valueOf(addressBook);
            fileWriter.write(stream);
            fileWriter.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void readFromFile(){
        try{
            FileReader fileReader = new FileReader("AddressBook.txt");
            int i;
            while ((i = fileReader.read()) != -1){
                System.out.print((char)i);}
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void writeToFileInOpenCsv(ArrayList<ContactStore> addressBook){
        try{
            FileWriter fileWriter = new FileWriter("AddressBook.csv");
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            String[] array = new String[addressBook.size()];
            for (int i = 0; i < array.length; i++){
                array[i] = String.valueOf(addressBook.get(i));
            }
            csvWriter.writeNext(array);
            csvWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void readFromFileInOpenCsv(){
        try{
            FileReader fileReader = new FileReader("AddressBook.csv");
            CSVReader csvReader = new CSVReader(fileReader);
            String[] strings;
            while ((strings = csvReader.readNext()) != null){
                for (String token : strings)
                    System.out.print(token);
            }
            csvReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void writeToFileInJson(ArrayList<ContactStore> addressBook){
        try {
            Gson gson = new Gson();
            String stream = gson.toJson(addressBook);
            FileWriter fileWriter = new FileWriter("AddressBook.json");
            fileWriter.write(stream);
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void readFromFileInJson(){
        try {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader("AddressBook.json"));
            ArrayList<ContactStore> addressBook = gson.fromJson(br, ArrayList.class);
            System.out.println(addressBook);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
