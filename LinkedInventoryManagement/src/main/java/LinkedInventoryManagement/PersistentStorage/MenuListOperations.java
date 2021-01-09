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

package LinkedInventoryManagement.PersistentStorage;

import LinkedInventoryManagement.Menu.*;
import LinkedInventoryManagement.Common.*;
import LinkedInventoryManagement.Product.*;
import LinkedInventoryManagement.Security.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * MenuListOperations: This class should contain all the MenuList.dat file read,
 * write and update operations.
 */
public class MenuListOperations {

    //Adds initial values to menu file
    public static void instantiateMenuList(){
        final String MENU_FILE_NAME = "MenuList.dat";

        File menuFile = new File(MENU_FILE_NAME);

        try{
            PrintWriter printToMenu = new PrintWriter(MENU_FILE_NAME);
            printToMenu.println("Add user, true, AddUserCommand");
            printToMenu.println("Remove user, true, DeleteUserCommand");
            printToMenu.println("Change password, true, ChangePasswordCommand");
            printToMenu.println("Add new product, false, AddProductCommand");
            printToMenu.println("Update product information, false, UpdateProductCommand");
            printToMenu.println("Delete product, false, RemoveProductCommand");
            printToMenu.println("Display product information, false, DisplayProductCommand");
            printToMenu.println("Display inventory, false, DisplayInventoryCommand");

            printToMenu.close();

        }
        catch(FileNotFoundException e){
            System.out.println("Error file not found");
            System.exit(0);
        }
    }

    //loads menuitems
    public static void readLoadMenu(MenuList menu, User loggedOnUser, ProductCatalog productCatalog){


        //Creates menuitems and loads Menu
        int optionNumber = 1;
        int count = 0;

        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("MenuList.dat"));
            String line;
            while((line = reader.readLine()) != null){
                //Take the line and put all the seperate values into an array of Strings
                String[] temp = line.split(", ");
                
                String description = temp[0];
                Boolean isRestricted = Boolean.parseBoolean(temp[1]);
                String commandClassName = temp[2];

                Command command = Command.CreateCommandDynamically(productCatalog, loggedOnUser, commandClassName);
                MenuItem item = new MenuItem(command, optionNumber, description, isRestricted);

                //If it is the first menuItem, linked list is instantiated using it
                if(count == 0){
                    MenuItem[] holdFirstItem = new MenuItem[]{item};
                    menu.setMenu(new InventoryLinkedList<MenuItem>(holdFirstItem));
                    count++;
                }
                else{
                    //Checks for duplicates before adding menuList
                    if(!menu.getMenuList().Contains(item)){
                        menu.AddMenuItem(item);
                    }
                }

                optionNumber++;
            }
        }
        catch(IOException o){
            System.out.println("Error Exiting Program");
            System.exit(0);
        }


    }
}