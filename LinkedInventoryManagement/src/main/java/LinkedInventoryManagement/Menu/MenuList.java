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

import LinkedInventoryManagement.Common.InventoryLinkedList;
import LinkedInventoryManagement.Security.User;
import LinkedInventoryManagement.Common.*;
/**
 * MenuList
 */
public class MenuList {

    //Fields with accessor and modifers
    private String menuHeader;
    private InventoryLinkedList<MenuItem> menu;


    public MenuList(String menuHeader){
        this.menuHeader = menuHeader;
    }

    public void AddMenuItem(MenuItem menuItem){
        menu.Add(menuItem);
    }

    public void setMenu(InventoryLinkedList<MenuItem> menu){
        this.menu = menu;
    }

    public InventoryLinkedList<MenuItem> getMenuList(){
        return menu;
    }

    //Starts menu
    public void StartMenu(User user){

        //Infinite loop
        while(true){
            System.out.println(menuHeader + "\n");
        
            int j = 0;

            //Modified user choice is user is not manager
            if(!user.getIsManager()){
                j = 3;
            }

            //prints info based on manager
            for(int i = j; i < menu.GetLength(); i++){
                System.out.println(menu.GetElement(i).getOptionNumber() + "- " + menu.GetElement(i).getDescription());
            }

            System.out.println("9- Exit\n");

            System.out.print("Enter your selection: ");
            String choice = ScannerFactory.GetScannerInstance().nextLine();

            //If input is not within this list the code goes back to the start of the loop
            String verifiableInput = "123456789";
            
            if(verifiableInput.indexOf(choice) == -1){
                System.out.println("Error: Invalid Input");
                System.out.println();
                continue;
            }

            int numberChoice = Integer.parseInt(choice);

            if(numberChoice == 9){
                System.out.println("Exiting...\n");
                System.exit(0);
            }

            menu.GetElement(numberChoice - 1).getCommand().Execute();

        }
    }
}