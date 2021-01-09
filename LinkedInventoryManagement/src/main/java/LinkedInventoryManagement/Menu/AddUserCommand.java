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
public class AddUserCommand extends Command{
    
    //Super Constructor
    public AddUserCommand(ProductCatalog productCatalog, User loggedOnUser){
        super(productCatalog, loggedOnUser);
    }

    @Override
    public void Execute() {
        
        //Takes input, stores it and adds user

        System.out.print("\nEnter new user first name: ");
        String firstname = ScannerFactory.GetScannerInstance().nextLine();
        System.out.print("Enter new user last name: ");
        String lastname = ScannerFactory.GetScannerInstance().nextLine();
        System.out.print("Enter new user username: ");
        String username = ScannerFactory.GetScannerInstance().nextLine();
        System.out.print("Enter new user password: ");
        String password = ScannerFactory.GetScannerInstance().nextLine();
        System.out.print("Is the new user a manager(yes/no): ");
        String temp = ScannerFactory.GetScannerInstance().nextLine();
        System.out.println("Creating new user...\n");

        //Converts string to boolean
        temp = (temp.equals("yes")) ? "true" : "false";
        Boolean isManager = Boolean.parseBoolean(temp);

        //Creates user with appropriate fields
        User addedUser = new User(username, SecurityOperations.GetPasswordHash(password), isManager);
        addedUser.setFirtsName(firstname);
        addedUser.setLastName(lastname);

        SecurityOperations.AddNewUser(addedUser);
    }

}
