package sa.com.cloudsolutions.antikythera.testhelper.refactoring;

/**
 * Test class with duplicates that differ in variable names.
 * This tests Bertie's ability to recognize semantic equivalence despite naming
 * differences.
 */
public class UserValidatorDup {

    public boolean validateAdmin(String name, String email) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        if (email == null || !email.contains("@")) {
            return false;
        }
        return true;
    }

    public boolean validateUser(String username, String emailAddr) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        if (emailAddr == null || !emailAddr.contains("@")) {
            return false;
        }
        return true;
    }

    public boolean validateGuest(String guestName, String guestEmail) {
        if (guestName == null || guestName.isEmpty()) {
            return false;
        }
        if (guestEmail == null || !guestEmail.contains("@")) {
            return false;
        }
        return true;
    }
}
