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

package LinkedInventoryManagement.Security; 

/**
 * User
 */

 //Maybe comparable

public class User {

    //Initial values
    private String username;
    private String hashedPassword;
    private boolean isManager;
    private String firstName = "";
    private String lastName = "";

    //Constructor with accessors and modifiers
    public User(String username, String hashedPassword, boolean isManager){        
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.isManager = isManager;
    }

    public String getUsername(){
        return this.username;
    }

    public String getHashedPassword(){
        return this.hashedPassword;
    }

    public boolean getIsManager(){
        return this.isManager;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLasName(){
        return this.lastName;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setHashedPassword(String hashedPassword){
        this.hashedPassword = hashedPassword;
    }

    public void setIsManager(boolean isManager){
        this.isManager = isManager;
    }

    public void setFirtsName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

}