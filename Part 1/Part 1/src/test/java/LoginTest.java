import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    // Test to check if the username is correctly formatted
    @Test
    public void testUsernameCorrectlyFormatted() {
        // Create a Login object with a username that is correctly formatted
        Login user = new Login("John", "Doe", "john_", "Password123");
        // Assert that the username meets the requirements (returns true)
        assertTrue(user.checkUserName(), "Username should be correctly formatted.");
    }

    // Test to check if the username is incorrectly formatted
    @Test
    public void testUsernameIncorrectlyFormatted() {
        // Create a Login object with a username that is incorrectly formatted
        Login user = new Login("John", "Doe", "johnDoe", "Password123");
        // Assert that the username does not meet the requirements (returns false)
        assertFalse(user.checkUserName(), "Username should be incorrectly formatted.");
    }

    // Test to check if the password meets the complexity requirements
    @Test
    public void testPasswordMeetsComplexityRequirements() {
        // Create a Login object with a password that meets complexity requirements
        Login user = new Login("John", "Doe", "john_", "Password123");
        // Assert that the password meets the complexity requirements (returns true)
        assertTrue(user.checkPasswordComplexity(), "Password should meet complexity requirements.");
    }

    // Test to check if the password does not meet the complexity requirements
    @Test
    public void testPasswordDoesNotMeetComplexityRequirements() {
        // Create a Login object with a password that does not meet complexity requirements
        Login user = new Login("John", "Doe", "john_", "password");
        // Assert that the password does not meet the complexity requirements (returns false)
        assertFalse(user.checkPasswordComplexity(), "Password should not meet complexity requirements.");
    }

    // Test to check if login is successful with correct username and password
    @Test
    public void testLoginSuccessful() {
        // Create a Login object and register the user
        Login user = new Login("John", "Doe", "john_", "Password123");
        user.registerUser(); // Register the user
        // Assert that login is successful with the correct username and password (returns true)
        assertTrue(user.loginUser("john_", "Password123"), "Login should be successful.");
    }

    // Test to check if login fails with incorrect password
    @Test
    public void testLoginFailed() {
        // Create a Login object and register the user
        Login user = new Login("John", "Doe", "john_", "Password123");
        user.registerUser(); // Register the user
        // Assert that login fails with an incorrect password (returns false)
        assertFalse(user.loginUser("john_", "WrongPassword"), "Login should fail with incorrect password.");
    }
}