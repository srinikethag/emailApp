import java.util.Scanner;

public class Email {
    private final String firstName;
    private final String lastName;
    private final String department;
    private final String email;
    private String password;
    private int mailboxCapacity;
    private String alternateEmail;

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        // get the department
        this.department = setDepartment();

        // generate email
        this.email = generateEmail();

        // generate password
        this.password = generatePassword();

        // provide password to user
        displayInfo();
    }

    private String setDepartment(){
        System.out.println("Enter the department code as below:\n1 for sales\n2 for Development\n3 for accounting\n0 for none");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1) return "sales";
        else if (depChoice == 2) return "development";
        else if (depChoice == 3) return "accounting";
        return "none";
    }

    public String generateEmail(){
        System.out.println("Generating email...");
        return firstName + "." + lastName + "@" + department + ".company.com";
    }

    private String generatePassword(){
        System.out.println("Generating password...");
        String passwordDataSet = "ABHDFJWEOIIJVNDSFEWFUHDSLFJJ3445349gjafjljjvtj3459434v4i4rjg4tj3o4ivgh4t3o4";
        char[] password = new char[8];
        for(int i=0; i<8; i++) {
            int randLength = (int) (Math.random() * passwordDataSet.length());
            password[i] = passwordDataSet.charAt(randLength);
        }
        return new String(password);
    }

    public void changePassword(String password){
        this.password = password;
    }

    public void setMailboxCapacity(int capacity){
        System.out.println("mailbox capacity is set to "+ capacity);
        this.mailboxCapacity = capacity;
    }

    public void defineAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }

    private void displayInfo(){
        System.out.println("Your information is as below,");
        System.out.println("Name : " + this.firstName + " " + this.lastName);
        System.out.println("Email : "+ this.email);
        System.out.println("Password : " + this.password);
        System.out.println("Mailbox capacity : " + this.mailboxCapacity);
        System.out.println("Alternate email : " + this.alternateEmail);

    }

    public int getMailboxCapacity(){ return mailboxCapacity;}

    public String getAlternateEmail(){ return alternateEmail;}




}
