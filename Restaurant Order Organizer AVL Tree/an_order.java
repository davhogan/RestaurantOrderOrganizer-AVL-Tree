//David Hogan
//email:davhogan@pdx.edu

//The purpose of this class is to represent a single order.
//An order has a number.
//An order also has a list of items selected which is a LLL of menuItems the restaurant they are from.
//This class does all the work of inserting and displaying all of the selected items for an order
public class an_order {

    protected int num = 0;//Order number
    protected l_node head = null;//Head of the list of items selected

    //Default Constructor
    public an_order()
    {
        this.num = 0;
        this.head = null;

    }
    //Constructor given an order number and the head of the list of items selected
    public an_order(int a_num, l_node a_head)
    {
          this.num = a_num;
          this.head = a_head;
    }

    //Getters and Setters
    public l_node getHead() {
        return head;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    //This Function inserts a selected item to the front of the list.
    //The order doesn't matter because these are just things the driver will see
    //Expected to take in the head of the list and the menu item to add.
    //Returns the head of the new list.
    public l_node insert(l_node a_head, l_node to_add)
    {
           l_node next = null;
           //Nothing to add
           if(to_add == null)
                return head;
           //List is empty
           if(head == null)
           {
               head = to_add;
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
           return insert(next, to_add);//Recursive step

    }

    //This function displays the items selected for the order
    //Expects to take in the head of the list.
    //Recursively go through the menu and display in reverse order
    //Because the orders are inserted at the front upon creation.
    public void display(l_node a_head)
    {
       l_node next = null;
       //Base case
       if(a_head == null)
           return;

       else
          a_head.display();//Displays a selceted items info

       next=a_head.getNext();
       display(next);//Recurssive Step

       return;
    }


}
