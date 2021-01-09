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

import java.lang.reflect.Constructor;

import LinkedInventoryManagement.Product.ProductCatalog;
import LinkedInventoryManagement.Security.User;

/**
 * Command
 */
public abstract class Command 
{
    //TODO: add necessary fields/constructors to this class

    private ProductCatalog productCatalog;
    private User loggedOnUser;
   
    public Command(ProductCatalog productCatalog, User loggedOnUser){
        this.productCatalog = productCatalog;
        this.loggedOnUser = loggedOnUser;
    }

    public static Command CreateCommandDynamically(ProductCatalog productCatalog, User user, String commandClassName)
    {
        Class<?>    concreteCommandClass    = null;
        Command     command                 = null;
        String      packageName             = "LinkedInventoryManagement.Menu"; 

        try 
        {
            concreteCommandClass = Class.forName(packageName + "." + commandClassName);
            Constructor<?> con = concreteCommandClass.getConstructor(ProductCatalog.class, User.class);
            command = (Command)con.newInstance(productCatalog, user);
        } 
        catch (final Exception e) 
        {
            e.printStackTrace();
        }

        return command;
    }

    //Returns productCatalog object
    public ProductCatalog getProductCatalog(){
        return productCatalog;
    }

    //returns current user
    public User getUser(){
        return loggedOnUser;
    }

    //An abstract method that must be overriden in subclasses of class Command
    public abstract void Execute(); 


}