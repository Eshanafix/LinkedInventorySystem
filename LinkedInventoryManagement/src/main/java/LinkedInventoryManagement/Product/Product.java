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

/**
 * This class represent a line in Inventory.dat file
 */
public class Product implements Comparable<Product>
{
    //fields

    private int id;
    private String name;
    private double cost;
    private int quantity;
    private int margin;
    String comma = ", ";

    //Constructor with modifiers and accessors 
    public Product(int id, String name, double cost, int quantity, int margin){
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
        this.margin = margin;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setMargin(int margin){
        this.margin = margin;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public double getCost(){
        return this.cost;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public int getMargin(){
        return this.margin;
    }

    //Retail price, print description, and print inventory handled in product class 
    public double getRetailPrice(){
        return (cost + (margin * (cost / 100)));
    }

    public String toString(){
        StringBuilder productString = new StringBuilder();
        productString.append(id + comma + name + comma + cost + comma + quantity + comma + margin);
        return productString.toString();
    }

    //returned formatted info
    public String printInformation(){
        StringBuilder productString = new StringBuilder();
        productString.append(id + " " + name + " " + " $" + cost + " " + quantity + " $" + getRetailPrice());
        return productString.toString();
    }

    //Override compareTo from comparable interface, compares if names are equal
    @Override
    public int compareTo(Product productToCompare) {
        // TODO compare the parameter object to the current instance of product
        if(name.equals(productToCompare.getName())){
            return 0;
        }
        return 1;
    }

    
}