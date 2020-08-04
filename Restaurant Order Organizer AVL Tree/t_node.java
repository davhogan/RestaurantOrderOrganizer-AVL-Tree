//David Hogan
//email:davhogan@pdx.edu

//The purpose of this class is to represent a node in an AVL tree.
//A t_node has a restaurant object and it's height in the tree.
//It also has a left and right child.

public class t_node {

    protected restaurant a_restaurant = null;//A restaurant object
    protected int height = 1;//height of the node
    protected t_node right = null;//Left child
    protected t_node left = null;//right child

    //Constructors
    protected t_node()
    {
       this.a_restaurant = null;
       this.height = 1;
       this.right = null;
       this.left = null;

    }

    //Construtor given a restaurant
    protected t_node(restaurant to_copy) {
        this.a_restaurant = to_copy;
        this.height = 1;
        this.right = null;
        this.left = null;

    }

    //Getters and Setters
    public int getHeight() {
        return height;
    }

    public t_node getLeft() {
        return left;
    }

    public t_node getRight() {
        return right;
    }

    public restaurant get_restaurant() {
        return a_restaurant;
    }

    public String getName()
    {
        return this.a_restaurant.getName();
    }

    public String getCuisine()
    {
        return this.a_restaurant.getCuisine();
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLeft(t_node left) {
        this.left = left;
    }

    public void setRight(t_node right) {
        this.right = right;
    }

    public void set_restaurant(restaurant a_restaurant) {
        this.a_restaurant = a_restaurant;
    }

    //Function to compare the height of the t_node that called it to the given height.
    //Returns the large of the two heights.
    public int getLargest(int cmp_height)
    {
        if(this.height >= cmp_height)
            return this.height;
        else
            return cmp_height;
    }
    //Display the restaurant information
    public void display()
    {
       this.a_restaurant.display();
    }

    //Displays the menu of the t_node's restaurant
    public void displayMenu()
    {
        m_node head = this.a_restaurant.getHead();
        this.a_restaurant.displayMenu(head);
    }
}
