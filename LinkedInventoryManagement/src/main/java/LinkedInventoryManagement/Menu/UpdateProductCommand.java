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

public class UpdateProductCommand extends Command{
    
    //Super constructor
    public UpdateProductCommand(ProductCatalog productCatalog, User loggedOnUser){
        super(productCatalog, loggedOnUser);
    }

    @Override
    public void Execute() {

        //Takes input
        System.out.print("\nEnter id of product to update: ");
        int id = ScannerFactory.GetScannerInstance().nextInt();

        ScannerFactory.GetScannerInstance().nextLine();

        System.out.println("\nEnter new information for updates, otherwise enter the original data per input...\n");

        System.out.print("Enter product name: ");
        String name = ScannerFactory.GetScannerInstance().nextLine();
        System.out.print("Enter product cost(decimal): ");
        double cost = ScannerFactory.GetScannerInstance().nextDouble();
        System.out.print("Enter product quantity: ");
        int quantity = ScannerFactory.GetScannerInstance().nextInt();
        System.out.print("Enter product margin(percentage as integer): ");
        int margin = ScannerFactory.GetScannerInstance().nextInt();
        System.out.println("Updating product...\n");

        Product addProduct = new Product(id, name, cost, quantity, margin);

        //adds product
        boolean success = super.getProductCatalog().AddUpdateProduct(addProduct);

        //If false error output
        if(!success){
            System.out.println("Error updating product");
        }

        ScannerFactory.GetScannerInstance().nextLine();

    }

}
