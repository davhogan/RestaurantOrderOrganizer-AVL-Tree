//David Hogan
//email:davhogan@pdx.edu

/*The purpose of this program is to reprsent a program that represent a food delivery  service app similar to Uber eats or grubhub.
  These delivery services allow for the user to order food from multiple different restaurants in a single order.
  While this gives the user more freedom it does make ordering a meal much more complicated. We can’t assume a meal will be ordered all from one place.
  The delivery driver now needs to know all of the restaurants the user ordered from, instead of just getting the entire order from a single restaurant.
  Which is what program aims to do, to consolidate the items selected to a single order for each user.Then diplay those orders to the driver.*/

        import java.io.*;
import java.util.Scanner;
//The purpose of this class is to represent a menu item.
// A menu item can either be an appetizer, an entree or a desert.
//Every menu item has a type, 'a' for appetizer, 'e' for entree, 'd' for dessert.\
//Every menu item also has a name and a price.
public class menuItems {

	protected char type = '\0';//Type of menu item
	protected String name = null;//Name of menu item
	protected double price = 0.0;//Price of menu item

	//default constructor
	public menuItems() {
		this.type = '\0';
		this.name = null;
		this.price = 0;
	}

	//returns the type of menu item it is
	public char getType() {
		return this.type;
	}


	//This Function takes in a name and compares it to the menu item's name.
	//Returns true if they match else it returns false.
	public boolean cmpName(String a_name) {
		if (this.name.equals(a_name))
			return true;
		else
			return false;
	}

	//Display the menu item's name and price
	public void display() {
		System.out.println("Menu Item: " + name);
		System.out.println("Price: $" + price);
	}

	//Main
	//This is where the user and the program interact.
	//The user will be able to continue to input orders selecting from menus from 5 different restaurants.

	//I'm very sorry for howlong this is. The first large chuck of the code is used to create restaurants
	// and menu items for that restaurant. The other large chunk of code is the while loop for while the user
	// wants to continue ordering or displaying orders

	public static void main(String[] args) {

		int user_num = 1;//User's response for selecting
		int o_num = 0;//the number of orders

		String user_resp = "yes";//User's response
		String name = null;
		Scanner input = new Scanner(System.in);//Input stream

		String item_name = null;//name of a menu item
		menuItems mi_temp = null;//menu item temp holder.
		an_order ord_temp = null;//order temp holder

		//m_nodes
		m_node temp_head = null;
		m_node mn_temp = null;
		m_node bm_head = null;//head of the menu for Big Mouth's
		m_node st_head = null;//head of the menu for Super Torta
		m_node db_head = null;//head of the menu for Dragonwell Bistro
		m_node og_head = null;//head of the menu for Olive Garden
		m_node den_head = null;//head of the menu for Denny's

		l_node l_head = null;//head of the list of menu items for an order


		o_node o_head = null;//head of the list of orders
		o_node o_temp = null;

		t_node root_rest = null;//The root of the AVL tree
		t_node temp_tnode = null;

		restaurant temp_rest = null;

		list_of_orders ord_list = new list_of_orders(o_head);//list of orders

		//Creating restaurants
		restaurant bigM = new restaurant("Big Mouths", "American", bm_head);
		restaurant superT = new restaurant("Super Torta", "Mexican", st_head);
		restaurant dragonB = new restaurant("Dragonwell Bistro", "Chinese", db_head);
		restaurant oliveG = new restaurant("Olive Garden", "Italian", og_head);
		restaurant denny = new restaurant("Denny's", "American", den_head);

		//Creating appetizers
		menuItems o_rings = new appetizer("Onion Rings Tower", 9.99, 4);
		menuItems cheese_sticks = new appetizer("Mozzarella Cheese Sticks", 3.99, 2);
		menuItems nachos = new appetizer("Nachos", 3.50, 3);
		menuItems soup = new appetizer("Soup of the day", 2.49, 1);
		menuItems e_roll = new appetizer("Egg Roll", 9.99, 4);
		menuItems pot_sticks = new appetizer("Pot Stickers", 9.99, 4);

		//Creating dinner entrees
		menuItems steak = new entree("Steak", 17.99, 'd');
		menuItems burger = new entree("Cheese Burger", 12.50, 'd');
		menuItems lamb = new entree("Baked Lamb", 15.99, 'd');
		menuItems pork_cm = new entree("Pork Chow Mein", 7.95, 'd');
		menuItems chick_cm = new entree("Chicken Chow Mein", 7.95, 'd');
		menuItems v_burr = new entree("Veg Burrito", 5.99, 'd');
		menuItems c_burr = new entree("Chicken Burrito", 6.99, 'd');
		menuItems c_parm = new entree("Chicken Parmesan", 10.95, 'd');
		menuItems spa = new entree("Spaghetti", 7.99, 'd');
		menuItems f_alf = new entree("Fettuccine Alfredo", 8.99, 'd');
		menuItems vf_rice = new entree("Veg Fried Rice", 8.99, 'd');

		//Creating breakfast entrees
		menuItems p_cakes = new entree("Pancakes", 3.99, 'b');
		menuItems eggs = new entree("Scrambled Eggs", 1.99, 'b');
		menuItems b_burr = new entree("Breakfast Burrito", 4.99, 'b');
		menuItems b_and_g = new entree("Biscuits and Gravy", 10.00, 'b');
		menuItems hash = new entree("Hashbrowns", 1.39, 'b');
		menuItems bacon = new entree("Bacon", .99, 'b');

		//Creating desserts
		menuItems a_pie = new dessert("Apple Pie", 2.34, 1.00);
		menuItems r_pie = new dessert("Rasp Pie", 2.34, 1.00);
		menuItems p_pie = new dessert("Pumpkin Pie", 2.34, 1.00);
		menuItems c_cake = new dessert("Cheese Cake", 3.49);
		menuItems r_pud = new dessert("Rice Pudding", 2.99);
		menuItems choc_cake = new dessert("Choclate Cake", 3.49, 1.00);

		//Putting all of the menu items into m_nodes
		//This is so they can be inserted into a restaurant's menu(LLL)
		m_node o_rings_n = new m_node(o_rings);
		m_node cheese_sticks_n = new m_node(cheese_sticks);
		m_node nachos_n = new m_node(nachos);
		m_node soup_n = new m_node(soup);
		m_node e_roll_n = new m_node(e_roll);
		m_node pot_sticks_n = new m_node(pot_sticks);

		m_node steak_n = new m_node(steak);
		m_node burger_n = new m_node(burger);
		m_node lamb_n = new m_node(lamb);
		m_node pork_cm_n = new m_node(pork_cm);
		m_node chick_cm_n = new m_node(chick_cm);
		m_node v_burr_n = new m_node(v_burr);
		m_node c_burr_n = new m_node(c_burr);
		m_node c_parm_n = new m_node(c_parm);
		m_node spa_n = new m_node(spa);
		m_node f_alf_n = new m_node(f_alf);
		m_node vf_rice_n = new m_node(vf_rice);

		m_node p_cakes_n = new m_node(p_cakes);
		m_node eggs_n = new m_node(eggs);
		m_node b_burr_n = new m_node(b_burr);
		m_node b_and_g_n = new m_node(b_and_g);
		m_node hash_n = new m_node(hash);
		m_node bacon_n = new m_node(bacon);

		m_node a_pie_n = new m_node(a_pie);
		m_node r_pie_n = new m_node(r_pie);
		m_node p_pie_n = new m_node(p_pie);
		m_node c_cake_n = new m_node(c_cake);
		m_node r_pud_n = new m_node(r_pud);
		m_node choc_cake_n = new m_node(choc_cake);

		//Create Big Mouth's menu
		bm_head = bigM.insert(bm_head, choc_cake_n);
		bm_head = bigM.insert(bm_head, burger_n);
		bm_head = bigM.insert(bm_head, steak_n);
		bm_head = bigM.insert(bm_head, o_rings_n);

		//Create Super Torta's menu
		st_head = superT.insert(st_head, v_burr_n);
		st_head = superT.insert(st_head, c_burr_n);
		st_head = superT.insert(st_head, b_burr_n);
		st_head = superT.insert(st_head, nachos_n);

		//Create Dragonwell Bistro's menu
		db_head = dragonB.insert(db_head, r_pud_n);
		db_head = dragonB.insert(db_head, vf_rice_n);
		db_head = dragonB.insert(db_head, chick_cm_n);
		db_head = dragonB.insert(db_head, pork_cm_n);
		db_head = dragonB.insert(db_head, e_roll_n);
		db_head = dragonB.insert(db_head, pot_sticks_n);

		//Create Olive Garden's menu
		og_head = oliveG.insert(og_head, c_cake_n);
		og_head = oliveG.insert(og_head, c_parm_n);
		og_head = oliveG.insert(og_head, spa_n);
		og_head = oliveG.insert(og_head, f_alf_n);
		og_head = oliveG.insert(og_head, soup_n);
		og_head = oliveG.insert(og_head, cheese_sticks_n);

		//Create Denny's menu
		den_head = denny.insert(den_head, a_pie_n);
		den_head = denny.insert(den_head, r_pie_n);
		den_head = denny.insert(den_head, p_pie_n);
		den_head = denny.insert(den_head, eggs_n);
		den_head = denny.insert(den_head, hash_n);
		den_head = denny.insert(den_head, bacon_n);
		den_head = denny.insert(den_head, p_cakes_n);
		den_head = denny.insert(den_head, b_and_g_n);

		//An avl tree of restaurants
		avl_tree avl_rest = new avl_tree();
		//Building the AVL tree by inserting the restaurants into it.
		root_rest = avl_rest.insertRestaurant(root_rest,bigM);
		root_rest = avl_rest.insertRestaurant(root_rest,superT);
		root_rest = avl_rest.insertRestaurant(root_rest,denny);
		root_rest = avl_rest.insertRestaurant(root_rest,oliveG);
     	root_rest = avl_rest.insertRestaurant(root_rest,dragonB);

     	//USER INTERFACE
		//This is where the user will continue to interact with the program until they are finished
		while (user_resp.equals("yes")) {
			System.out.println("[1] Place Order an order");
			System.out.println("[2] Display all orders");
			System.out.println("[3] Display order by number");
			System.out.println("[4] Display all restaurants");
			System.out.println("[5] Display restaurant's menu by name");
			System.out.println("[6] Display restaurant's menu by cuisine");
			System.out.println("[7] Remove All");
			System.out.print("Enter number of thing to do: ");

			user_num = input.nextInt();

			//Placing an order
			if (user_num == 1) {
				l_head = null;//Head of the list of items ordered
				ord_temp = new an_order(o_num + 1, l_head);//create a new order

				while (user_resp.equals("yes")) {
					//Display available restaurants
				    System.out.println("Restaurants to choose from:");
					avl_rest.display(root_rest);

					System.out.print("Enter the name of restaurant to display menu and order from: ");
					name = input.nextLine();
					input.nextLine();
					//Display the menu for the name of the restaurant entered
					temp_tnode = avl_rest.displayName(root_rest,name);
					temp_rest = temp_tnode.get_restaurant();//Get the restaurant object for the name entered
					temp_head = temp_rest.getHead();//Get the head of the list for the menu

					while (user_resp.equals("yes")) {
						System.out.print("Enter the name of the item to add to the order from "+name+':');
						item_name = input.nextLine();

						mn_temp = temp_rest.find_name(temp_head, item_name);//Search for the item in the menu
						//Item to order not in the menu
						if (mn_temp == null)
							System.out.println("Item not found in menu.");
							//Add the item to the order
						else {
							mi_temp = mn_temp.getA_menuItem();
							l_node to_add = new l_node(item_name, mi_temp);
							l_head = ord_temp.insert(l_head, to_add);
							System.out.println("Item Added");
						}

						System.out.print("Would you like to order anyhing else from "+name+"? (yes/no): ");
						user_resp = input.nextLine();
					}

					System.out.print("Would you like to select a different restaurant to order from? (yes/no): ");
					user_resp = input.nextLine();
				}

				o_temp = new o_node(ord_temp);
				++o_num;//increment number of orders
				o_head = ord_list.insert(o_head, o_temp);//insert the order to the list of orders
				System.out.println("Order Sent");
			}

		//Display all of the orders in the list
		if (user_num == 2)
		{
			o_head = ord_list.getHead();

			if(o_head == null)
				System.out.println("No orders yet");
			else
			 ord_list.display(o_head);//Display all the orders
		}

		//Display an order by its number
		if (user_num == 3)
		{
			System.out.println("Enter order number to display");
			user_num = input.nextInt();
			input.nextLine();

			if(user_num < 1 || user_num > o_num+1)
				System.out.println("Order Number not available");

			o_head = ord_list.getHead();

			if(o_head == null)
				System.out.println("No orders yet");
			else
			   ord_list.display_num(o_head,user_num);//Display the order with the number
		}

		//Display all restaurants
		if (user_num == 4)
		{
				avl_rest.display(root_rest);
		}

		//Display by restaurant name
		if (user_num == 5)
		{
			System.out.println("Restaurants to choose from:");
			avl_rest.display(root_rest);

			System.out.print("Enter the name of restaurant to display menu: ");
			name = input.nextLine();
			input.nextLine();

			avl_rest.displayName(root_rest,name);//Display the menu for the name of the given restaurant.
		}
         //Display Cuisine
		if (user_num == 6)
		{
			System.out.println("Restaurants to choose from:");
			avl_rest.display(root_rest);

			System.out.print("Enter the type of cuisine to display menu: ");
			name = input.nextLine();
			input.nextLine();

			avl_rest.displayCuisine(root_rest,name);//Display all menus for a given cuisine
		}
		//Remove All
		if (user_num == 7)
		{
           avl_rest.remove_all(root_rest);
           root_rest = avl_rest.getRoot();
		}
			input.nextLine();
			System.out.print("Continue? (yes/no): ");
			user_resp = input.nextLine();

		}

	 }

	}

