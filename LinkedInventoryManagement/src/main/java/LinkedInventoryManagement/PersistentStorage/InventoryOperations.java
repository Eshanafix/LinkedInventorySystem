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

import LinkedInventoryManagement.Common.*;
import LinkedInventoryManagement.Product.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.ArrayList;

/**
 * InventoryOperations: This class should contain all the Inventory.dat file
 * read, write and update operations.
 */
public class InventoryOperations {

    //Puts initial values in inventory
    public static void instantiateInventoryList(){
        final String INVENTORY_FILE_NAME = "Inventory.dat";

        File userFile = new File(INVENTORY_FILE_NAME);

        try{
            PrintWriter printToInventory = new PrintWriter(INVENTORY_FILE_NAME);
            printToInventory.println("3424, Smart Watch, 20.45, 23, 80");

            printToInventory.close();

        }
        catch(FileNotFoundException e){
            System.out.println("Error file not found");
            System.exit(0);
        }
    }

    //Adds or updates products
    public static boolean readWriteAddUpdateProduct(Product product, InventoryLinkedList<Product> productList){
        boolean isSuccess = false;
        boolean update = false; 

        //Previous lines so file can easily be rewritten
        ArrayList<String> previousLines = new ArrayList<String>();

        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("Inventory.dat"));
            String line;
            while((line = reader.readLine()) != null){
                //Splits line into an array
                String[] temp = line.split(", ");
                
                //If we find the ID we know we are updating so the file and list are updated and update is true
                if(product.getId() == Integer.parseInt(temp[0])){
                    update = true;

                    //adds new info to previousLines
                    previousLines.add(product.toString());
                    
                    //Updates linked list
                    for(int i = 0; i < productList.GetLength(); i++){
                        if(product.getId() == productList.GetElement(i).getId()){
                            productList.SetElement(i, product);
                            isSuccess = true;
                        }
                    }
                }
                else{
                    previousLines.add(line);
                }
            }

            PrintWriter printToInventory = new PrintWriter("Inventory.dat");

            for(int i = 0; i < previousLines.size(); i++){
                printToInventory.println(previousLines.get(i));
            }

            //if update is not true we know we are adding so the new info is added on to the end
            if(!update){
                //Only adds if there are no duplicates
                if(!productList.Contains(product)){
                    printToInventory.println(product.toString());
                    productList.Add(product);
                    isSuccess = true;
                }
            }

            printToInventory.close();

        }
        catch(IOException o) {
            System.out.println("Error Exiting Program");
            System.exit(0);
        }

        return isSuccess;
    }

    //remove product
    public static boolean readWriteRemoveProduct(int productId, InventoryLinkedList<Product> productList){
        boolean isSuccess = false; 

        //Previous lines so file can easily be rewritten
        ArrayList<String> previousLines = new ArrayList<String>();

        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("Inventory.dat"));
            String line;
            while((line = reader.readLine()) != null){
                //Splits line up into an array
                String[] temp = line.split(", ");

                //If ID matches we remove it from the list and exclude it from the file rewrite
                if(productId == Integer.parseInt(temp[0])){
                    isSuccess = true;
                    for(int i = 0; i < productList.GetLength(); i++){
                        
                        //removes value from linked list
                        if(productId == productList.GetElement(i).getId()){
                            productList.Remove(i);
                        }
                    }
                }
                else{
                    previousLines.add(line);
                }

            }

            //writes new info to file
            PrintWriter printToInventory = new PrintWriter("Inventory.dat");
            for(int i = 0; i < previousLines.size(); i++){
                printToInventory.println(previousLines.get(i));
            }

            printToInventory.close();
        }
        catch(IOException o){
            System.out.println("Error Exiting Program");
            System.exit(0);
        }


        return isSuccess;
    }

    //Chekcs if product exists
    public static boolean readFindProduct(int productId, InventoryLinkedList<Product> productList){
        boolean isSuccess = false;
        boolean inFile = false;
        boolean inCatalog = false;

        BufferedReader reader;
        
        //If id in file we know it exists
        try{
            reader = new BufferedReader(new FileReader("Inventory.dat"));
            String line;
            while((line = reader.readLine()) != null){
                String[] temp = line.split(", ");
                if(productId == Integer.parseInt(temp[0])){
                    inFile = true;
                }
            }
        }
        catch(IOException o){
            System.out.println("Error Exiting Program");
            System.exit(0);
        }

        //Check if value in linkedList
        for(int i = 0; i < productList.GetLength(); i++){
            if(productId == productList.GetElement(i).getId()){
                inCatalog = true;
            }
        }

        isSuccess = inCatalog && inFile;

        return isSuccess; 
    }
    
}