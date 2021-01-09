//hello :)

/**
 *  Name: Eshan Kwatra
 *  Date: 11/04/20
 *  School: University of Texas at Dallas
 *  NetID: exk190012
 *  Class: Computer Science II
 *  Section: 2336.503
 *  Professor: David Sims
 */

package LinkedInventoryManagement.Security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import LinkedInventoryManagement.PersistentStorage.UsersOperations;

/**
 * InventoryManagementSecurity
 */
public class SecurityOperations {

    //Checks if user is in user database
    public static User AuthenticateUser(String username, String password){

        User authenticatedUser = null;

        //Hardcode of admin, case insensitive
        if((username.compareToIgnoreCase("admin") == 0) && (GetPasswordHash(password).compareToIgnoreCase("58c536ed8facc2c2a293a18a48e3e120") == 0)){

            authenticatedUser = new User(username, GetPasswordHash(password), true);
            authenticatedUser.setFirtsName("admin"); 
        }
        else{

            //Checks all users other then admin
            authenticatedUser = UsersOperations.readAuthenticateUser(authenticatedUser, username, password);
        }

        return authenticatedUser;
    }

    public static boolean AddNewUser(User newUser){

        //Adds new user

        //PreviousLines list used so I can easily rewrite the file
        StringBuilder userLine = new StringBuilder();
        ArrayList<String> previousLines = new ArrayList<String>();
        String comma = ", ";

        //User stringbuilder to get format for user file
        userLine.append(newUser.getFirstName() + comma);
        userLine.append(newUser.getLasName() + comma);
        userLine.append(newUser.getUsername() + comma);
        userLine.append(newUser.getHashedPassword() + comma);
        userLine.append(String.valueOf(newUser.getIsManager()));

        //Adds user
        UsersOperations.readWriteAddNewUser(newUser, userLine.toString(), previousLines);

        return true;
    }
    
    public static boolean RemoveUser(String userName){

        //removes user by username
        UsersOperations.readWriteRemoveUser(userName);

        return true;
    }

    public static boolean ChangePassword(String username, String currentPassword, String newPassword){

        //changes password of user after authenticating user
        UsersOperations.readWriteChangeUserPassword(username, currentPassword, newPassword);

        return true;
    }

    public static String GetPasswordHash(String password) 
    {        
        String generatedPassword = null;
        
        try 
        {
            byte[] salt = new byte[] {12, -12, 65, 61, 
                                      2, -6, -90, 12, 
                                      4, -7, -87, 2, 
                                      34, -102, 3, 115};

            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Add password bytes to digest
            md.update(salt);
            // Get the hash's bytes
            byte[] bytes = md.digest(password.getBytes());
            // This bytes[] has bytes in decimal format;
            // Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        } 

        return generatedPassword;
    }
}