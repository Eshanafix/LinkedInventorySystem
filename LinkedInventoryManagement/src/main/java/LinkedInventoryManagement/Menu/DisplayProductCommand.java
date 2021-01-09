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

public class DisplayProductCommand extends Command{

    //Super Constructor
    public DisplayProductCommand(ProductCatalog productCatalog, User loggedOnUser){
        super(productCatalog, loggedOnUser);
    }

    @Override
    public void Execute() {
        
        //Takes in input and displays product info

        System.out.print("\nEnter product name for display: ");
        String name = ScannerFactory.GetScannerInstance().nextLine();
        System.out.println("Displaying product...");

        System.out.println();

        Product returned = null;

        //finds product that has input name and uses it as a parameter
        for(int i = 0; i < super.getProductCatalog().getProductList().GetLength(); i++){
            if(super.getProductCatalog().getProductList().GetElement(i).getName().equals(name)){
                returned = super.getProductCatalog().getProductList().GetElement(i);
            }
        }

        if(returned == null){
            System.out.println("Error product not in list...\n");
        }
        else{
            String info = super.getProductCatalog().PrintProductInformation(returned);
        }
    }
    
}
