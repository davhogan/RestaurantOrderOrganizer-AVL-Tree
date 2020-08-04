//David Hogan
//email:davhogan@pdx.edu

//The purpose of this class is represent an entree.
//An dessert is a menuItem
//It has the added data of coming with ice cream
//As well as a price for the ice cream

public class dessert extends menuItems {

    protected boolean wIceCream = false;//check if it comes with ice cream
    protected double iceCreamPrice = 0.0;//Priceof ice cream

    //Default Constructor
    public dessert()
    {
        this.type = 'd';
        this.name = null;
        this.price = 0.0;
        this.wIceCream = false;
        this.iceCreamPrice=0.0;
    }

    //Constructor given a name and a price
    //No ice cream option
    public dessert(String a_name, double a_price)
    {
        this.type = 'd';
        this.name = a_name;
        this.price = a_price;
        this.wIceCream = false;
        this.iceCreamPrice = 0.0;
    }
    //Constructor given a name, price and a price for the ice cream
    //ice cream option
    public dessert(String a_name, double a_price, double a_iceCreamPrice)
    {
        this.type = 'd';
        this.name = a_name;
        this.price = a_price;
        this.wIceCream = true;
        this.iceCreamPrice = a_iceCreamPrice;
    }

    //Display the menu item's name, price and ice cream option
    public void display()
    {
        System.out.println("Dessert: "+ name);

        if(this.wIceCream)
            System.out.println("Top with ice cream for $"+iceCreamPrice);

        System.out.println("Price: $"+price);

    }
}
