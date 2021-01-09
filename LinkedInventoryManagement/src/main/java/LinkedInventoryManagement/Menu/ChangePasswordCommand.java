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

package LinkedInventoryManagement.Menu;

import LinkedInventoryManagement.Common.*;
import LinkedInventoryManagement.Product.*;
import LinkedInventoryManagement.Security.*;

public class ChangePasswordCommand extends Command{

    //Super Constructor
    public ChangePasswordCommand(ProductCatalog productCatalog, User loggedOnUser){
        super(productCatalog, loggedOnUser);
    }

    @Override
    public void Execute() {

        //Takes input and analyzes it
        System.out.print("\nEnter username: ");
        String username = ScannerFactory.GetScannerInstance().nextLine();
        System.out.print("Enter old password: ");
        String oldPassword = ScannerFactory.GetScannerInstance().nextLine();
        System.out.println("\nVerifying...");

        User authenticatedUser = SecurityOperations.AuthenticateUser(username, oldPassword);
        
        //After authenticating user, error message if null and run code for not null
        if(authenticatedUser != null){
            System.out.println("Credentials Verified!\n");
            System.out.print("Enter new password: ");
            String newPassword = ScannerFactory.GetScannerInstance().nextLine();
            System.out.println("Changing password...\n");

            //After verifying the password is changed
            SecurityOperations.ChangePassword(username, oldPassword, newPassword);
        }
        else{
            System.out.println("Error: User does not exist...\n");
        }
    }
    
}
