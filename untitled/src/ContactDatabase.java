import java.util.Scanner;
import java.util.ArrayList;


public class ContactDatabase {
    private ArrayList<Contact> contacts;


    private static final int QUIT=0;
    private static final int ADD=1;
    private static final int LISTALL=2;
    private static final int SEARCH=3;
    private static final int DELETE=4;

    ContactDatabase(){
        contacts=new ArrayList<Contact>();
    }


    public void inputContact(){
        Scanner scan=new Scanner(System.in);

        Contact newContact= new Contact();

        System.out.println();
        System.out.println("Enter last name");
        newContact.setLast(scan.next());
        System.out.println("Enter first name");
        newContact.setFirst(scan.next());
        System.out.println("Enter phone number");
        newContact.setPhone(scan.next());
        System.out.println("Enter email");
        newContact.setEmail(scan.next());

        contacts.add(newContact);


    }

    public void displayAll(){
        for (Contact contact:contacts){
            System.out.println(contact.toString());
        }
    }
    public void displayMatch(){
        boolean foundMatch;
        Scanner scan =new Scanner(System.in);

        System.out.println();
        System.out.println("Enter search keyword");
        String keyword=scan.nextLine();

        System.out.println("Matches ");
        foundMatch=false;
        for (Contact contact:contacts){
            if (contact.toString().toLowerCase().contains(keyword.toLowerCase())){
                System.out.println(contact.toString());
                foundMatch=true;
            }

        }
        if (!foundMatch){
            System.out.println("There were no matches");
        }

    }

    public void deleteMatch(){
        boolean foundMatch;
        Scanner scan =new Scanner(System.in);
        System.out.println();
        System.out.println("Enter search keyword");
        String keyword= scan.nextLine();
        foundMatch=false;

        for (Contact contact:contacts){
            if (contact.toString().toLowerCase().contains(keyword.toLowerCase())){
                System.out.println("Delete "+contact.toString()+ "(Y/N)?");
                String s= scan.nextLine();
                s=s.toLowerCase();
                if (s.charAt(0)=='y'){
                    contacts.remove(contact);
                }
                foundMatch=true;

            }

        }

        if (!foundMatch){
            System.out.println("There were no matches.");
        }

    }

    public static void main(String[] args){
        ContactDatabase cdb=new ContactDatabase();
        Scanner scan=new Scanner(System.in);
        int choice=ADD;
        while (choice!=QUIT){
            System.out.println();
            System.out.println("Choose from the following");
            System.out.println("0) quit");
            System.out.println("1)add new contact");
            System.out.println("2)list all contacts");
            System.out.println("3)search all contacts by keyword and display");
            System.out.println("4)search all contacts by keyword and remove");
            choice= scan.nextInt();
            switch (choice){
                case ADD :
                cdb.inputContact();
                break;
                case LISTALL:
                    cdb.displayAll();
                    break;
                case SEARCH:
                    cdb.deleteMatch();
                    break;
                case DELETE:
                    cdb.deleteMatch();
                    break;



            }




        }



    }


}
