//David Hogan
//email:davhogan@pdx.edu

//The purpose of this class is represent an entree.
//An appetizer is a menuItem
//It has the added data of a suggested serving size
public class appetizer extends menuItems {

    protected int serveSize = 0;//suggested serving size of the app
    //Default Constructor
    public appetizer()
    {
        this.type = 'a';
        this.name = null;
        this.price = 0.0;
        this.serveSize = 0;
    }


    //Constructor given a name a price and serving size
    public appetizer(String a_name, double a_price, int a_size)
    {
        this.type = 'a';
        this.name = a_name;
        this.price = a_price;
        this.serveSize = a_size;
    }

    //Display the menu item's name, price and suggested serving size
    public void display()
    {
        System.out.println("Appetizer: "+name);
        System.out.println("Price: $"+price);
        System.out.println("Suggested Serving Size: "+serveSize);
    }
}
