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

package LinkedInventoryManagement;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import LinkedInventoryManagement.Common.InventoryLinkedList;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void GetFirstTest(){

        //Input array will be converted into a linked list
        Integer[] inputArray = new Integer[]{1,2,3,4,5};
        InventoryLinkedList<Integer> actualLinkedList = new InventoryLinkedList<Integer>(inputArray);

        int actualFirstValue = actualLinkedList.GetFirst();
        int expectedFirstValue = 1;

        //Checking if correct first value is returned
        if(expectedFirstValue != actualFirstValue){
            assertTrue("Incorrect first value", false);
        }
    }

    @Test
    public void GetLastTest(){

        //Input array will be converted into linked list
        Integer[] inputArray = new Integer[]{1,2,3,4,5};
        InventoryLinkedList<Integer> actualLinkedList = new InventoryLinkedList<Integer>(inputArray);

        int actualLastValue = actualLinkedList.GetLast();
        int expectedLastValue = 1;

        //Checking if correct last value is returned
        if(expectedLastValue != actualLastValue){
            assertTrue("Incorrect last value", false);
        }
    }

    @Test
    public void InsertTest(){

        //Input array will be converted into a linked list
        Integer[] inputArray = new Integer[]{1,2,3,4,5};
        InventoryLinkedList<Integer> actualLinkedList = new InventoryLinkedList<Integer>(inputArray);

        int expectedLength = 6;
        int expectedValueAtPosition2 = 77;

        //Inserting value into linked list
        actualLinkedList.Insert(2, 77);

        //Making sure length changed
        if(actualLinkedList.GetLength() != expectedLength){
            assertTrue("Value did not insert properly", false);
        }
        
        //Making sure value was inserted in right position
        if(actualLinkedList.GetElement(2) != expectedValueAtPosition2){
            assertTrue("Value did not insert properly", false);
        }
    }

    @Test
    public void RemoveTest(){

        //Input array will be converted into a linked list
        Integer[] inputArray = new Integer[]{1,2,3,4,5};
        InventoryLinkedList<Integer> actualLinkedList = new InventoryLinkedList<Integer>(inputArray);

        int expectedLength = 4;
        int expectedValueAtPosition2 = 4;

        //Removing value from linked list
        actualLinkedList.Remove(2);

        //Making sure length changed
        if(actualLinkedList.GetLength() != expectedLength){
            assertTrue("Value did not remove properly", false);
        }
        
        //Making sure correct value was removed
        if(actualLinkedList.GetElement(2) != expectedValueAtPosition2){
            assertTrue("Value did not remove properly", false);
        }
    }

    @Test
    public void ContainsTest(){
        
        //Input array will be converted into a linked list
        Integer[] inputArray = new Integer[]{1,2,3,4,5};
        InventoryLinkedList<Integer> actualLinkedList = new InventoryLinkedList<Integer>(inputArray);

        boolean expectedPresent = true;
        boolean expectedNotPresent = false;

        //Making sure present value is true, and not present value is false
        boolean actualPresent = actualLinkedList.Contains(3);
        boolean actualNotPresent = actualLinkedList.Contains(80);

        if(expectedPresent != actualPresent){
            assertTrue("Contains did not find value", false);
        }

        if(expectedNotPresent != actualNotPresent){
            assertTrue("Contains found wrong value", false);
        }

    }

    @Test
    public void SetElementTest(){

        //Input array will be converted into an linked list
        Integer[] inputArray = new Integer[]{1,2,3,4,5};
        InventoryLinkedList<Integer> actualLinkedList = new InventoryLinkedList<Integer>(inputArray);

        int expectedLength = 5;
        int expectedValueAtPosition2 = 80;

        //Changing value at index
        actualLinkedList.SetElement(2, 80);

        int actualLength = actualLinkedList.GetLength();
        int actualValueAtPosition2 = actualLinkedList.GetElement(2);

        //Making sure length did not change
        if(expectedLength != actualLength){
            assertTrue("Method removed or added a value", false);
        }

        //Making sure value was set properly
        if(expectedValueAtPosition2 != actualValueAtPosition2){
            assertTrue("Method did not Set element correctley", false);
        }

    }

    @Test
    public void GetElementTest(){

        //Input array will be converted into a linked list
        Integer[] inputArray = new Integer[]{1,2,3,4,5};
        InventoryLinkedList<Integer> actualLinkedList = new InventoryLinkedList<Integer>(inputArray);

        int expectedLength = 5;
        int expectedValueAtPosition2 = 3;

        int actualLength = actualLinkedList.GetLength();
        int actualValueAtPosition2 = actualLinkedList.GetElement(2);

        //Making sure length did not change
        if(expectedLength != actualLength){
            assertTrue("Method removed or added a value", false);
        }

        //Making sure correct value was retreived
        if(expectedValueAtPosition2 != actualValueAtPosition2){
            assertTrue("Method did not Get element correctley", false);
        }
    }
}
