//David Hogan
//email:davhogan@pdx.edu

//The purpose of this class is to represent an item selceted for an order
//The selected items will be repsented as a LLL so a l_node is a linear linked list node.
//An l_node has a menuItem  and the name of the restaurant that item is from.
// It also has and a ref to the next item selected for the order.

public class l_node {

    protected String r_name = null;//Restaurant name
    protected menuItems a_menuItem = null;//menu item selected for order
    protected l_node next = null;//Ref to next item in LLL

    //Default Constructor
    public l_node()
    {
        this.r_name = null;
        this.a_menuItem = null;
        this.next = null;
    }
    //Constructor given a menu_item
    public l_node(String a_rName, menuItems anItem)
    {
        this.r_name = a_rName;
        this.a_menuItem = anItem;
        this.next = null;
    }

    //Getters and setters
    public char getType()
    {
        return a_menuItem.getType();
    }

    public l_node getNext() {
        return next;
    }

    public void setNext(l_node next) {
        this.next = next;
    }

    //Display the menu items info.
    //Calls the menu item's display
    public void display()
    {
        System.out.println("Restaurant: "+this.r_name);
        this.a_menuItem.display();
        System.out.println();
    }
}
