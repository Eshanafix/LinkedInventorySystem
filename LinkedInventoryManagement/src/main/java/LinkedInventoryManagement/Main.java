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

package LinkedInventoryManagement;

import LinkedInventoryManagement.Menu.*;
import LinkedInventoryManagement.PersistentStorage.InventoryOperations;
import LinkedInventoryManagement.PersistentStorage.MenuListOperations;
import LinkedInventoryManagement.PersistentStorage.UsersOperations;
import LinkedInventoryManagement.Common.*;
import LinkedInventoryManagement.Product.*;
import LinkedInventoryManagement.Security.*;


/**
 * Hello world!
 */
public class Main 
{
    public static void main( String[] args )
    {
        
        //Creating objects that will be used throughout the code
        User loggedOnUser;
        MenuList menu = new MenuList("Inventory Management List");
        ProductCatalog productCatalog = new ProductCatalog();
        
        createFiles();

        loggedOnUser = promptLogin();

        loadMenu(menu,loggedOnUser,productCatalog);

        menu.StartMenu(loggedOnUser);

        ScannerFactory.CloseScannerInstance();

    }

    public static void createFiles(){

        //Puts initial values into file
        UsersOperations.instantiateUserList();
        MenuListOperations.instantiateMenuList();
        InventoryOperations.instantiateInventoryList();
    }

    public static User promptLogin(){

        //Asks for username and password, then authenticates user
        System.out.print("Enter Username: ");
        String username = ScannerFactory.GetScannerInstance().nextLine();

        System.out.print("Enter Password: ");
        String password = ScannerFactory.GetScannerInstance().nextLine();

        User loggedOnUser = SecurityOperations.AuthenticateUser(username, password);
        
        //If user is not present code exits
        if(loggedOnUser == null){
            System.out.println("\nError: Invalid Username/Password or User does not exist\nExiting Program...\n");
            System.exit(0);
        }

        System.out.println("\nWelcome " + loggedOnUser.getFirstName() + " " + loggedOnUser.getLasName() + "!\n");

        return loggedOnUser;
    }

    public static void loadMenu(MenuList menu, User loggedOnUser, ProductCatalog productCatalog){

        //Loads the menu into the linked list
        MenuListOperations.readLoadMenu(menu, loggedOnUser, productCatalog);

    }
}
