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

import LinkedInventoryManagement.Product.*;
import LinkedInventoryManagement.Security.*;

public class DisplayInventoryCommand extends Command{

    //Super constructor
    public DisplayInventoryCommand(ProductCatalog productCatalog, User loggedOnUser){
        super(productCatalog, loggedOnUser);
    }

    @Override
    public void Execute() {


        //Prints out Inventory, if empty, empty message displayed, otherwise prints info
        System.out.println("\nDisplaying Inventory\n");

        String info = super.getProductCatalog().PrintInventoryList();

        //Checks if empty
        if(info.length() == 0){
            System.out.println("Error: Inventory is empty...\n");
        }
        else{
            System.out.println("Id : Name : Cost : Quantity : Retail");
            System.out.println("----------------------------------------------");
            System.out.println(info);
        }
    }
    
}
