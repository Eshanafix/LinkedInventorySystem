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

/**
 * AddCommand
 */
public class AddProductCommand extends Command{

    //Super constructor
    public AddProductCommand(ProductCatalog productCatalog, User loggedOnUser){
        super(productCatalog, loggedOnUser);
    }

    @Override
    public void Execute(){

        //Requests input
        System.out.print("\nEnter product ID: ");
        int id = ScannerFactory.GetScannerInstance().nextInt();

        ScannerFactory.GetScannerInstance().nextLine();
        
        System.out.print("Enter product name: ");
        String name = ScannerFactory.GetScannerInstance().nextLine();

        System.out.print("Enter product cost(decimal): ");
        double cost = ScannerFactory.GetScannerInstance().nextDouble();
        System.out.print("Enter product quantity: ");
        int quantity = ScannerFactory.GetScannerInstance().nextInt();
        System.out.print("Enter product margin(percentage as integer): ");
        int margin = ScannerFactory.GetScannerInstance().nextInt();
        System.out.println("Adding product...\n");

        //Creates product
        Product addProduct = new Product(id, name, cost, quantity, margin);

        //Checks to see if adding correctley, error message for failiure
        boolean success = super.getProductCatalog().AddUpdateProduct(addProduct);

        if(!success){
            System.out.println("Error Adding Product");
        }

        ScannerFactory.GetScannerInstance().nextLine();
    }
}