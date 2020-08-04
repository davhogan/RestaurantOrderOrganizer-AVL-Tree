//David Hogan
//email:davhogan@pdx.edu

//The purpose of this class is represent an entree.
//An entree is a menuItem
//It has the added data of being breakfast('b') or dinner('d')
public class entree extends menuItems {

    protected char meal_type = '\0';//Either breakfast('b') or dinner ('d')
    //Default Constructor
    public entree()
    {
        this.type = 'e';
        this.name = null;
        this.price = 0.0;
        this.meal_type = '\0';
    }
    //Constructor given a name , a price and meal type
    public entree(String a_name, double a_price, char a_meal_type)
    {
        this.type = 'e';
        this.name = a_name;
        this.price = a_price;
        this.meal_type = a_meal_type;
    }

    //Display the menu item's name, price and type of meal(breakfast,lunch or dinner)
    public void display()
    {
        if(this.meal_type == 'b')
           System.out.println("Breakfast Item: "+name);

        if(this.meal_type == 'd')
            System.out.println("Dinner Item: "+name);

        System.out.println("Price: $"+price);
    }
}
