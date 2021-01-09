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
 * Listnode
 */
public class listNode<E>{

    //Generic class with accessors and modifiers
    private listNode<E> front;
    private E e;
    private listNode<E> back;
    
    public listNode(listNode<E> front, E e, listNode<E> back){
        this.front = front;
        this.e = e;
        this.back = back;
    }

    public E getValue(){
        return this.e;
    }

    public listNode<E> getFront(){
        return this.front;
    }

    public listNode<E> getBack(){
        return this.back;
    }

    public void setValue(E e){
        this.e = e;
    }

    public void setFront(listNode<E> front){
        this.front = front;
    }

    public void setBack(listNode<E> back){
        this.back = back;
    }

}