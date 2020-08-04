//David Hogan
//email:davhogan@pdx.edu

//The purpose of this class is to represent an avl tree of restaurants.
//The tree will be sorted by the name of the restaurants in the tree.
//Every AVL Tree only has a root.
//Each node in the tree has a left and a right as well as a restaurant.
//This class can insert a restaurant into an AVL tree keeping it sorted and balanced.
//It can also display the menu for a restaurant of a given name.
//Or display all of the menus for a given type of cuisine.
//The class also can clear out the tree if needed by removing all.
//The use of the AVL tree will be to allow the user to see all of the restaurants available to them.
//Then place an order based on which restaurants they want to select from.

import java.util.Scanner;

public class avl_tree {

    protected t_node root = null;

    //Constructors
    avl_tree()
    {
        this.root = null;
    }

    avl_tree(t_node a_root)
    {
        this.root = a_root;
    }

    //Getter's and setters
    public t_node getRoot() {
        return this.root;
    }

    public void setRoot(t_node root) {
        this.root = root;
    }

    //Helper function to set a node's parent as it's left
    //This function takes in the node that needs to be rotated up left
    public t_node rotateLeft(t_node to_rotate)
    {
        t_node rotated = to_rotate.getRight();//Get the right child of the parent
        t_node left = rotated.getLeft();//Get the left of parent's right child

        int l_height = left.getHeight();//height of the left
        int lrgst = rotated.getLargest(l_height);//get the largest of the two heights

        rotated.setLeft(to_rotate);//Set the right child's left to its parent making the child the parent
        to_rotate.setRight(left);//Set the orginal parent's right to be the left of its right child.

        left.setHeight(lrgst+1);//Set the height of rotated node

        return rotated;//return the rotated node
    }

    //Helper function to set a node's parent as it's right
    //This function takes in the node that needs to be rotated up right
    public t_node rotateRight(t_node to_rotate)
    {
        t_node rotated = to_rotate.getLeft();//Get the left child of the parent
        t_node right = rotated.getRight();//Get the right of parent's left child

        int r_height = right.getHeight();//height of the right
        int lrgst = rotated.getLargest(r_height);//get the largest of the two heights

        rotated.setRight(to_rotate);//Set the left child's right to its parent making the child the parent
        to_rotate.setLeft(right);//Set the orginal parent's left to be the right of its left child.

        rotated.setHeight(lrgst+1);//Set the height of rotated node

        return rotated;//return the rotated node
    }

    //This function is used to insert a restaurant into the AVL by its name.
    //The function expects to take in a root of an AVL tree and the restaurant to add.
    //First the function performs a BST insert.
    //The function then checks the difference in height of the left and right sub tree.
    //If it is greater than 1 or less than -1 then the AVL tree is unbalnced.
    //The function goes through and recursively fixes all unbalnced sub trees.
    //If the balance is greater than 1 then it is unbalnced to the left and is either a Left-Left case or a Left-Right case.
    //If the balance is less than -1 then it is unbalnced to the right and is either a Right-Right case or a Right-Left case.
    //To check for the left left or right right cases the function compares the given restaurant's name with the left or right subtree respectively.
    //The function then returns the new root of the tree.
    public t_node insertRestaurant(t_node a_root, restaurant to_add)
    {
        t_node temp = null;
        t_node left = null;//Left child
        t_node right = null;//Right child
        int l_height = 0;//left height
        int r_height = 0;//right height
        int lrgst_height = 0;//largest height
        int balance = 0;//balance between nodes
        String name = null;//Name of restaurant to add
        String r_name = null;//Name of current node's restaurant
        int compare = 0;//Compares the two names.

        //Nothing to add
        if(to_add == null)
            return a_root;
        //Bottom of BST or root is null
        if(a_root == null)
        {
            temp = new t_node(to_add);
            return temp;
        }

        name = to_add.getName();//Get the name of the restaurant to add
        r_name = a_root.getName();//Get the name of the current node's restaurant
        compare = name.compareToIgnoreCase(r_name);//Compare the names

        left = a_root.getLeft();//Get the left child
        right = a_root.getRight();//Get the right child

        //Do a BST insert
        if(compare < 0)
        {
            a_root.setLeft(insertRestaurant(left,to_add));//set the left child by going left
        }
        else
        {
            a_root.setRight(insertRestaurant(right,to_add));//set the right child by going right
        }

        //Check and rebalance the AVL tree

        //Get the largest height
        if(left == null && right == null)//No children so no difference in height
        {
            lrgst_height = 0;
        }
        else if(left == null && right != null)//No left child largest height is the rights's height
        {
            lrgst_height = right.getHeight();
        }
        else if(left != null && right == null)//No right child largest height is the left's height
        {
            lrgst_height = left.getHeight();
        }
        else//Two Children find the larger of the two heights
        {
            r_height = right.getHeight();
            lrgst_height = left.getLargest(r_height);
        }

        a_root.setHeight(1+lrgst_height);//Set the height of the child node

        balance = l_height - r_height;//Find out if the balance is off

        //Rotate right
        //Unbalanced on the left
        if(balance > 1 && compare < 0)
        {
            return  rotateRight(a_root);
        }
        //Rotate left
        //Unbalance on the right
        else if(balance < -1 && compare > 0)
        {
            return rotateLeft(a_root);
        }
        //Rotate left then Right
        //Unbalanced on the left
        else if(balance > 1 && compare > 0)
        {
           a_root.setLeft(rotateLeft(left));//
           return rotateRight(a_root);//
        }
        //Rotate right then left
        //Unbalnced on the right
        else if(balance < -1 && compare < 0)
        {
            a_root.setRight(rotateRight(right));//
            return rotateLeft(a_root);//
        }

        return a_root;
    }

    //This function does a postorder traversal to remove the all nodes from the AVL
   void remove_all(t_node root)
    {
        t_node left = null;
        t_node right = null;
        if(root == null)
            return;
        else
        {
            left = root.getLeft();
            right = root.getRight();

            remove_all(left);//Go left
            remove_all(right);//Go right
            root = null;//Remove node
        }
       return;
    }

    void display(t_node root)
    {
        t_node left;
        t_node right;

        if(root == null)
            return;

        else
        {
            left = root.getLeft();
            right = root.getRight();
            display(left);
            root.display();
            display(right);
        }
    }

    //This function searches through the AVL tree for the name of the restaurant.
    //The function expects to take in the root of an AVL tree and a name of a restaurant to search for.
    //The fuction compares the name of the current node's restaurant name to the given name.
    //If it is alphabetically less then the tree goes left else it goes right.
    //The function diplays the menu and returns the restraunt with the corresponding name.
    t_node displayName(t_node root, String a_name)
    {
        t_node left = null;
        t_node right = null;
        restaurant temp = null;
        String name = null;
        m_node mn_temp = null;
        int comparer;

        if(root == null)
            return root;

        else
        {
            left = root.getLeft();
            right = root.getRight();
            name = root.getName();
            comparer = name.compareToIgnoreCase(a_name);//compare the names

            if(name.equalsIgnoreCase(a_name))//Found a match for the given restaurant's name
            {
                 System.out.println(name + " Menu:");
                 root.displayMenu();
                 return root;
            }

            //Travesal of the tree
            if(comparer < 0)  //current node's restaurant's name is less than given name
            {
               return displayName(right, a_name);
            }
            else //current node's restaurant's name is greater or equal to the given name
               return displayName(left,a_name);
        }

    }

    //This function searches through the AVL tree for a type of cuisine.
    //The function expects to take in the root of an AVL tree and the type of cuisine to search for.
    //The fuction must do a postorder traversal and check all nodes of the tree because the tree is sorted by restaurant name.
    //The function diplays the menu of any restaurants who have amatching cuisine.
    void displayCuisine(t_node root, String a_cuisine)
    {
        t_node left = null;
        t_node right = null;
        String cuisine = null;

        if(root == null)
            return;

        else
        {
            left = root.getLeft();
            right = root.getRight();
            cuisine = root.getCuisine();

            displayCuisine(left,a_cuisine);//Go left

            if(cuisine.equalsIgnoreCase(a_cuisine)) //Found a match for the cuisine type
            {
                root.display();
                System.out.println("Menu:");
                root.displayMenu();
            }

            displayCuisine(right,a_cuisine);//Go right
        }
    }

}

