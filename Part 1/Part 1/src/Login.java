import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
    //Variable declaration
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    //Constructor for the required data
    public Login(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    // Method to check if the username contains an underscore and is no more than 5 characters long
    public Boolean checkUserName() {
        return username.length() <= 5 && username.contains("_");
    }

    // Method to check if the password meets complexity requirements
    public Boolean checkPasswordComplexity() {
        if (password.length() < 8) {
            return false;
        }
        Pattern capitalLetter = Pattern.compile("[A-Z]");
        Pattern smallLetter = Pattern.compile("[a-z]");
        Pattern number = Pattern.compile("[0-9]");
        Matcher hasCapitalLetter = capitalLetter.matcher(password);
        Matcher hasSmallLetter = smallLetter.matcher(password);
        Matcher hasNumber = number.matcher(password);
        return hasCapitalLetter.find() && hasSmallLetter.find() && hasNumber.find();
    }

    // Method to register the user
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a small letter.";
        }
        return "User successfully registered!";
    }

    // Method to verify login details
    public Boolean loginUser(String loginUsername, String loginPassword) {
        return loginUsername.equals(this.username) && loginPassword.equals(this.password);
    }

    // Method to return login status
    public String returnLoginStatus(Boolean loginStatus) {
        if (loginStatus) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    
    public static void main(String[] args) {
        // Example usage
        Login user1 = new Login("John", "Doe", "john_", "Password123");
        
        // Register the user
        System.out.println(user1.registerUser());
        
        // Attempt login
        Boolean loginStatus = user1.loginUser("john_", "Password123");
        System.out.println(user1.returnLoginStatus(loginStatus));
    }
}
