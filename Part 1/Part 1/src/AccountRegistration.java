import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Create a public module that asks for the users details, name, username and password
public class AccountRegistration {
    public static void main(String[] args) {

        String firstName, lastName, username, password;
        String inputUsername, inputPassword;
        //Introduce the scanner to ask for input
        Scanner scanner = new Scanner(System.in);

        //Ask the user for their first and last names
        System.out.print("Please enter your first name: ");
        firstName = scanner.next();
        System.out.print("Please enter your last name: ");
        lastName = scanner.next();

        //Ask for a username that has an underscore and is no more than 5 characters long
        username = "";
        while(true){
            System.out.print("Enter a username (must contain an underscore and be no more than 5 characters long): ");
            username = scanner.next();
            if (validateUsername(username)){
                System.out.println("Username sucessfully captured!");
                break;
            } else {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            }
        }

        //Ask for a password with the requirements
        password = "";
        while(true){
            System.out.print("Enter a password (at least 8 characters long and containing a capital letter, a number, and a special character): ");
            password = scanner.next();
            if(validatePassword(password)){
                System.out.println("Password sucessfully captured!");
                break;
            } else {
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter a number and a special character. ");
            }
        }
        //message to print out their full name and their chosen username
        System.out.println("Name " + firstName + " " + lastName);
        System.out.println("Username " + username);
        //Process to login
        while (true) {
            System.out.println("Enter your username to login: ");
            inputUsername = scanner.next();
            System.out.println("Enter your password to login: ");
            inputPassword = scanner.next();
            if(inputUsername.equals(username) && inputPassword.equals(password)){
                System.out.println("Welcome " + firstName + "" + lastName + ", it is great to see you!");
                break;
            } else {
                System.out.println("Username or password incorrect, please try again.");
            }            
        }
        //Close the scanner
        scanner.close();
    }
    //Create a method that validates the username against the requirements
    private static boolean validateUsername(String username) {
        if(username.length() <= 5 && username.contains("_")) {
            return true;
        }
        return false;
    }
    //Create a method that validates the password against the requirements
    private static boolean validatePassword(String password) {
        if(password.length() < 8) {
            return false;
        }
        Pattern capitalLetter = Pattern.compile("[A-Z]");
        Pattern smallLetter = Pattern.compile("[a-z]");
        Pattern number = Pattern.compile("[0-9]");
        Matcher hasCapitalLetter =  capitalLetter.matcher(password);
        Matcher hasSmallLetter = smallLetter.matcher(password);
        Matcher hasNumber = number.matcher(password);
        return hasCapitalLetter.find() && hasSmallLetter.find() && hasNumber.find();
    }
}
