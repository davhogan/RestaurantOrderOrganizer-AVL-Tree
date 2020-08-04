//David Hogan
//email:davhogan@pdx.edu

//The purpose of this class is to represent an item in a restaurant's menu
//The menu will be repsented as a LLL so an m_node is a linear linked list node.
//An m_node has a menuItem and a pointer to the next item in the menu.

public class m_node {

    protected menuItems a_menuItem = null;//A single menu item.
    protected m_node next = null;//Pointer to the next m_node in the LLL.
    //Default Constructor
    m_node()
    {
        this.a_menuItem = null;
        this.next = null;
    }
    //Constructor given a menu_item
    m_node(menuItems an_menuItem)
    {
        this.a_menuItem = an_menuItem;
        this.next = null;
    }
    //Constructor given a menu item and the next pointer
    m_node(m_node a_next, menuItems an_menuItem)
    {
        this.a_menuItem = an_menuItem;
        this.next = a_next;
    }

    //Getters and setters
    public m_node getNext()
    {
        return this.next;
    }

    public menuItems getA_menuItem() {
        return a_menuItem;
    }

    public void setNext(m_node next)
    {
        this.next = next;
    }

    //Compares the a gven name to the name of the m_node's menu item.
    //Calls the menu item's cmpName function
    //returns true if they match else returns false
    public boolean cmpName(String a_name)
    {
        return (a_menuItem.cmpName(a_name));
    }

    //Display the menu items info.
    //Calls the menu item's display
    public void display()
    {
        a_menuItem.display();
    }
}
