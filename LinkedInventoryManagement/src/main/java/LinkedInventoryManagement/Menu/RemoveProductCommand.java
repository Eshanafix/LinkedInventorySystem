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

public class RemoveProductCommand extends Command{

    //Super constructor
    public RemoveProductCommand(ProductCatalog productCatalog, User loggedOnUser){
        super(productCatalog, loggedOnUser);
    }

    @Override
    public void Execute() {

        //Takes input, asks for id and removes
        
        System.out.print("\nEnter id of product to remove: ");
        int id = ScannerFactory.GetScannerInstance().nextInt();
        System.out.println("Removing product...\n");

        Boolean success = super.getProductCatalog().RemoveProduct(id);

        //If false error output
        if(!success){
            System.out.println("Error: Product not in Inventory...\n");
        }

        ScannerFactory.GetScannerInstance().nextLine();
    }
    
}
