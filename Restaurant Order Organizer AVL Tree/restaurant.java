//David Hogan
//email:davhogan@pdx.edu

//The purpose of this class is to represent a restaurant.
//A restaurant has a name and a type of cuisine.
//A restaurant also has a menu which is a LLL of menuItems.
//The menu is not sorted upon insertion at the moment.

public class restaurant {

    protected String name = null;//Name of the restaurant
    protected String cuisine = null;//type of cuisine
    protected m_node head = null;//head of the LLL of the menu of the resteraunt

    //Default Constructor
    restaurant()
    {
        this.name = null;
        this.cuisine = null;
        this.head = null;
    }
    //Constructor for a restaurant given a name, a type of cuisine and a head of a menu list
    restaurant(String a_name, String a_cuisine, m_node a_head)
    {
        this.name = a_name;
        this.cuisine = a_cuisine;
        this.head = a_head;
    }

    //Get head of the menu(LLL)
    public m_node getHead() {
        return head;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getName() {
        return name;
    }

    //Inserts a menu item to the front of the menu.
    //Expected to take in the head of the list and the menu item to add.
    //Returns the head of the new list.
    public m_node insert(m_node curr, m_node to_add)
    {
        m_node next = null;
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
        else if(curr != null)
        {
            to_add.setNext(head);
            head = to_add;
            return head;
         }

        next = curr.getNext();
        head = insert(next,to_add);//Recursive step

        return head;
    }

    //Goes through the menu and finds a menu item that matches a given name.
    //Expects to take in the head of the list and the name of the menu item search for.
    //If there is a match the function returns the matching node
    //Else it returns null
    public m_node find_name(m_node a_head, String a_name)
    {
        int a_num = 0;
        m_node next = null;
        //Base case
        if(a_head == null)
            return null;
         //Compare the current menu item's name with the given name
        if(a_head.cmpName(a_name))
        {
           return a_head;
        }

        next = a_head.getNext();
        return find_name(next,a_name);//recursive step
    }

    //This function displays the restaurant's menu
    //Expects to take in the head of the list.
    //Recursively go through the menu and display in reverse order
    public void displayMenu(m_node a_head)
    {
        m_node next = null;

        //base case
       if(a_head == null)
            return;

       else

        a_head.display();//Display the menu item's info
        System.out.println();
        next=a_head.getNext();
        displayMenu(next);//Recursive step

      return;
    }

    public void display()
    {
        System.out.println("Name: " + this.name);
        System.out.println("Cuisine type: " + this.cuisine);
        System.out.println();
    }

}
