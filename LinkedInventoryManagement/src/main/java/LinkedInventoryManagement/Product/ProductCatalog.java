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

package LinkedInventoryManagement.Product;

import LinkedInventoryManagement.Common.InventoryLinkedList;
import LinkedInventoryManagement.PersistentStorage.InventoryOperations;
import LinkedInventoryManagement.Common.*;

/**
 * ProductCatalog
 */
public class ProductCatalog {

    //Created linked list with inital hardcoded value, in file as well
    Product[] temp = new Product[]{new Product(3424, "Smart Watch", 20.45, 23, 80)};
    InventoryLinkedList<Product> productList = new InventoryLinkedList<Product>(temp);

    //empty constructor
    public ProductCatalog(){

    }

    public InventoryLinkedList<Product> getProductList(){
        return productList;
    }

    //Add or update a product if already exists
    public boolean AddUpdateProduct(Product product){
        boolean isSuccess = false;
        
        isSuccess = InventoryOperations.readWriteAddUpdateProduct(product, productList);

        return isSuccess;
    }

    //removes product by ID
    public boolean RemoveProduct(int productId){
        boolean isSuccess = false; 

        isSuccess = InventoryOperations.readWriteRemoveProduct(productId, productList);

        return isSuccess;
    }

    //Confirms if product is present
    public boolean FindProduct(int productId){
        boolean isSuccess = false;
        
        isSuccess = InventoryOperations.readFindProduct(productId, productList);

        return isSuccess;
    }


    //Print information about a product including retail price (cost + (margin*cost/100))
    public String PrintProductInformation(Product product){
        String productInformation = null;

        //Gets listnode, so I can acess front and back
        listNode<Product> header;
        header = productList.getHeader();

        //sets header = listnode that contains parameter product
        while(header != null){
            if(header.getValue().getName().equals(product.getName())){
                break;
            }

            header = header.getFront();
        }

        String input = "sampleText";
        boolean correctChoice = false;

        //continues until user presses only enter
        while(!input.equals("")){

            correctChoice = false;

            System.out.println("ID : NAME : COST : QUANTITY : RETAIL");
            System.out.println("------------------------------------");
            System.out.println(header.getValue().printInformation() + "\n");

            //repeats until a valid next,previous,or exit move is made
            while(!correctChoice){
                System.out.print("Type \"Next\" or \"Previous\" to display next/previous product, press enter to return: ");
                input = ScannerFactory.GetScannerInstance().nextLine();

                //Checks if next is allowed, if it is inner loop is exited
                if(input.toLowerCase().equals("next")){
                    if(header.getFront() == null){
                        System.out.println("\nAlready at end of list...\n");
                    }
                    else{
                        header = header.getFront();
                        correctChoice = true;
                    }
                }

                //Checks if previous is allowed, if it is inner loop is exited
                if(input.toLowerCase().equals("previous")){
                    if(header.getBack() == null){
                        System.out.println("\nAlready at beginning of list...\n");
                    }
                    else{
                        header = header.getBack();
                        correctChoice = true;
                    }
                }

                //Checks if user is attempting to exit
                if(input.equals("")){
                    break;
                }
            }
        }

        //Empty return
        return productInformation;
    }

    //Print all product information in the inventory
    public String PrintInventoryList(){
        
        StringBuilder inventoryInformation = new StringBuilder(); 

        //Loops through list and outputs everything
        for(int i = 0; i < productList.GetLength(); i++){
            inventoryInformation.append(productList.GetElement(i).printInformation() + "\n");
        }

        return inventoryInformation.toString(); 
    }
}