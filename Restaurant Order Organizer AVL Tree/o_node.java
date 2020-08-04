//David Hogan
//email:davhogan@pdx.edu

//The purpose of this class is to represent an order in a list of orders
//The menu will be repsented as a DLL so an o_node is a doubly linked list node.
//An o_node has an order.
// As well as a ref to the next order  and prev order in the list.

public class o_node {

    protected an_order a_order;//An order
    protected o_node next;//Ref to next order in DLL
    protected o_node prev;//Ref to prev order in DLL
    //Default Constructor
    o_node()
    {
        this.a_order = null;
        this.next = null;
        this.prev = null;
    }
    //Constructor given an order
    o_node(an_order to_copy)
    {
        this.a_order = to_copy;
        this.next = null;
        this.prev = null;
    }
    //Constructor given an order, the next ref and the prev ref
    o_node(o_node a_next, o_node a_prev, an_order to_copy)
    {
        this.a_order = to_copy;
        this.next = a_next;
        this.prev = a_prev;
    }

    //Getters and setters
    public o_node getNext()
    {
        return next;
    }

    public o_node getPrev()
    {
        return prev;
    }

    //Gets the order number
    //Returns -1 if the list doesn't exist
    public int getNum()
    {
        if(a_order == null)
            return -1;
        else
           return a_order.getNum();
    }

    public void setNext(o_node next)
    {
        this.next = next;
    }

    public void setPrev(o_node prev)
    {
        this.prev = prev;
    }


    //Display the order's info.
    //Calls the orders display function
    public void display()
    {
        l_node a_head = null;
        //Empty list
        if(a_order == null)
            return;
        else
           a_head = a_order.getHead();
           a_order.display(a_head);
           return;
    }
}
