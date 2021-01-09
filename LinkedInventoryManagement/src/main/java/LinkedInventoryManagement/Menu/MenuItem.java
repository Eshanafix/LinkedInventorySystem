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

/**
 * MenuItem
 */
public class MenuItem implements Comparable<MenuItem>
{

    private Command command;
    private int optionNumber;
    private String description;
    private boolean isRestricted; 

    //MenuItem class, accessor only becuase modifiers are not necessary
    public MenuItem(Command command, int optionNumber, String description, Boolean isRestricted){
        this.command = command;
        this.optionNumber = optionNumber;
        this.description = description;
        this.isRestricted = isRestricted;
    }

    public Command getCommand(){
        return this.command;
    }

    public int getOptionNumber(){
        return this.optionNumber;
    }

    public String getDescription(){
        return this.description;
    }

    public Boolean getIsRestricted(){
        return this.isRestricted;
    }

    //Override compareTo from comparable, chekcs if descriptions are the same
    @Override
    public int compareTo(MenuItem menuItemToCompare) {
        // TODO Auto-generated method stub
        if(description.equals(menuItemToCompare.getDescription())){
            return 0;
        }
        return 1;
    }

}