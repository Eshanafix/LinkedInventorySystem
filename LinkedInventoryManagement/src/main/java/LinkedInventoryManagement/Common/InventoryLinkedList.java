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

package LinkedInventoryManagement.Common;

/**
 * InventoryLinkedList
 */

//Generic linked list class that extends comparable
 public class InventoryLinkedList<E extends Comparable<E>> {
    
    private E[] elements;
    private listNode<E> header;

    //Constructor
    public InventoryLinkedList(E[] elements){
        this.elements = elements;
        createLinkedList();
    }

    //takes input of array and creates a linked list
    public void createLinkedList(){
        
        //if only one value, just header is established
        header = new listNode<E>(null, elements[0], null);

        if(elements.length > 1){
            listNode<E> current = header;

            for(int i = 1; i < elements.length; i++){
                current.setFront(new listNode<E>(null, elements[i], current));
                current = current.getFront();
            }

        }
    }

    public listNode<E> getHeader(){
        return header;
    }

    //returns first value
    public E GetFirst(){
        return header.getValue();
    }

    //goes to end of link list and returns last value
    public E GetLast(){
        
        listNode<E> temp = header;
        while(temp.getFront() != null){
            temp = temp.getFront();
        }

        return temp.getValue();
    }

    //inserts value
    public void Insert(int index, E element){
        int count = 0;
        listNode<E> temp = header;
        boolean isFirst = false;
        
        //if inserting at first position
        if(index == 0){
            listNode<E> newHeader = new listNode<E>(header, element, null);
            header = newHeader;
            isFirst = true;
        }

        //if inserting in the middle
        while((temp != null) && !isFirst){
            if(count == index){
                listNode<E> insert = new listNode<E>(temp, element, temp.getBack());
                temp.getBack().setFront(insert);
                temp.setBack(insert);
            }
            
            count++;
            //if inserting at very end
            if(temp.getFront() == null && count == index){
                temp.setFront(new listNode<E>(null, element, temp));
                break;
            }
            
            temp = temp.getFront();
        }
    }

    //adds value at end of linked list
    public void Add(E element){
        listNode<E> temp = header;

        while(temp.getFront() != null){
            temp = temp.getFront();
        }

        temp.setFront(new listNode<E>(null, element, temp));
    }

    //removes value
    public E Remove(int index){
        listNode<E> temp = header;
        E removed = null;
        int count = 0;

        //if removing first value
        if(index == 0){
            removed = header.getValue();
            header = header.getFront();
            header.setBack(null);
            return removed;
        }
        else{
            while(temp != null){
                //if removing in the middle
                if(count == index  && temp.getFront() != null){
                    temp.getBack().setFront(temp.getFront());
                    temp.getFront().setBack(temp.getBack());
                    removed = temp.getValue();
                }
                count++;

                //if removing last value
                if(temp.getFront() == null && count == (index + 1)){
                    removed = temp.getValue();
                    temp.getBack().setFront(null);
                    return removed;
                }

                temp = temp.getFront();

                
            }
        }

        return removed;
    }

    //uses compareTo to check if element is present in list
    public boolean Contains(E element){
        listNode<E> temp = header;
        while(temp != null){
            if(temp.getValue().compareTo(element) == 0){
                return true;
            }
            temp = temp.getFront();
        }
        return false;
    }

    //Goes to index and changes value
    public E SetElement(int index, E element){
        E sets = null;
        listNode<E> temp = header;
        int count = 0;

        while(temp != null){
            if(count == index){
                temp.setValue(element);
                sets = element;
            }
            count++;
            temp = temp.getFront();
        }

        return sets;

    }

    //goes to index and returns value
    public E GetElement(int index){
        int count = 0;
        E gets = null;
        listNode<E> temp = header;

        while(temp != null){
            if(count == index){
                gets = temp.getValue();
            }
            count++;
            temp = temp.getFront();
        }
        return gets;
    }

    //Uses a count and goes to end, returns length
    public Integer GetLength(){
        int length = 0;
        listNode<E> temp = header;

        while(temp != null){
            length ++;
            temp = temp.getFront();
        }
        return length;
    }

    //prints out values of list
    public void print(){
        listNode<E> temp = header;
        while(temp != null){
            System.out.println(temp.getValue());
            temp = temp.getFront();
        }
    }

    //uses toString of elements and prints
    public String toString(){
        StringBuilder combined = new StringBuilder();
        listNode<E> temp = header;
        while(temp != null){
            combined.append(temp.getValue().toString());
            temp = temp.getFront();
        }
        return combined.toString();
    }

    
}









//Implement a generic linkedlist to support different data types. 
    //Use this class instead of using ArrayList.     
    //Create another class that represents the node of a linkedlist.