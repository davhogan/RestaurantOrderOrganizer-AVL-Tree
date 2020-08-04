//David Hogan
//email:davhogan@pdx.edu

import java.lang.reflect.Constructor;

//The purpose of this class is to represent a list of orders.
//An list of orders has a list of orders entered.
//Which is a DLL of orders.
//This class does all the work of inserting and displaying all of the orders entered
public class list_of_orders {

    protected o_node head = null;//head of the DLL of orders

    //Default Constructor
    list_of_orders()
    {
        this.head = null;
    }

    //Constructor given a head of the DLL of orders
    list_of_orders(o_node a_head)
    {
        this.head=a_head;
    }

    //Get head of the list.
    public o_node getHead()
    {
        return head;
    }

    //This Function inserts an order to the front of the list.
    //Expected to take in the head of the list and the order to add.
    //Returns the head of the new list
    public o_node insert(o_node a_head, o_node to_add)
    {
        o_node next = null;
        o_node prev = null;
        //Nothing to add
        if(to_add == null)
            return head;
        //Empty List
        if(head == null)
        {
            head=to_add;
            return head;
        }
        //Add to the front of a non empty list
        else if(a_head != null)
        {
            to_add.setNext(head);
            head = to_add;
            return head;
        }

        next = a_head.getNext();
        insert(next,to_add);//Recursive step

        return head;
    }

    //This function displays the list of orders
    //Expects to take in the head of the list.
    //Recursively go through the menu and display in reverse order
    //Because the orders are inserted at the front upon creation.
    public void display(o_node a_head)
    {
        int a_num = 0;
        o_node next = null;

        if(a_head == null)
            return;
        next = a_head.getNext();

        if(next != null)
        {
            display(next);
        }

        a_num = a_head.getNum();
        System.out.println("Order Number: "+a_num);
        a_head.display();

    }

    //This function displays an order for a given number
    //Expects to take in the head of the list and an order number to find.
    //Recursively go through the menu and compares the order numbers
    //Displays the order if the numbers match.
    public void display_num(o_node a_head, int num)
    {
        int a_num = 0;
        o_node next = null;

        if(a_head == null)
            return;

        a_num = a_head.getNum();//Get the cuurent number
        //Compare given number to current number
        if(num == a_num)
        {    //Display if they are a match
            System.out.println("Order Number: " + a_num);
            a_head.display();
        }

        next = a_head.getNext();
        display_num(next,num);//Recursive Step

    }
}
