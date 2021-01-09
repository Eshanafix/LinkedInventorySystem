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

public class DeleteUserCommand extends Command{

    //Super constructor
    public DeleteUserCommand(ProductCatalog productCatalog, User loggedOnUser){
        super(productCatalog, loggedOnUser);
    }

    @Override
    public void Execute() {

        //Takes input, nonexistent user handled in method
        System.out.print("\nEnter username of user to be deleted: ");
        String deletedUser = ScannerFactory.GetScannerInstance().nextLine();
        System.out.println("Deleting User...\n");

        SecurityOperations.RemoveUser(deletedUser);
    }
    
}
