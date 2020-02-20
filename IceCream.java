/* Lionel Quintanilla and Nathanael Gastelum
   February 19, 2020
   Purpose: This class is the IceCream object. It has a cost and calories, and has functions to get and set
   all of these variables. It can also provide information about the IceCream.
   Input: No user input
   Output: Can output the cost, calories, and a toString
 */

public class IceCream extends DessertItem {

    // Has two unique instance variables
    private double iceCreamCost;
    private int iceCreamCalories;

    // Default constructor. Inherited from DessertItem.
    /**
     * Default IceCream constructor
     */
    public IceCream() {
        super();
    }

    // Constructor. Takes String parameter. Sets name to String, plus type of item.
    /**
     * IceCream constructor
     * @param newName Name of new IceCream item
     */
    public IceCream(String newName) {
        super(newName + "(IceCream)");
    }

    // setCost(): Method sets cost of IceCream. Takes double parameter. Returns Void.
    /**
     * Sets cost of IceCream item
     * @param newCost Cost of IceCream item
     */
    public void setCost(double newCost) {
        iceCreamCost = newCost;
    }

    // getCost(): Method gets cost of IceCream item. Takes no parameters. Returns Double.
    /**
     * Gets cost of IceCream item
     * @return Cost of IceCream item
     */
    public double getCost() {
        // Rounds Double to two decimal places before returning.
        return Math.round(iceCreamCost * 100.0) / 100.0;
    }

    // setCalories(): Method sets calorie count of IceCream item. Takes Int parameter. Returns Void.
    /**
     * Sets calorie count of IceCream item
     * @param newCalories Calorie count of IceCream item
     */
    public void setCalories(int newCalories) {
        iceCreamCalories = newCalories;
    }

    // getCalories(): Method gets calories count of IceCream item. Takes no parameters. Returns Int.
    /**
     * Gets calorie count of IceCream item
     * @return Calorie count of IceCream item
     */
    public int getCalories() {
        return iceCreamCalories;
    }

    // receiptItem(): Method returns item values formatted as a receipt. Takes no parameters. Returns String.
    /**
     * Gets IceCream item values for receipt
     * @return IceCream item values formatted for receipt
     */
    public String receiptItem() {

        // Same as toString(), but does not include calorie count

        String message = "";
        String cost = String.format("%.2f", getCost());

        message += "\n" + "Ice Cream" + name + "\n                               " + cost + "\n";

        return message;
    }

    // receiptItem(): Method returns item values formatted as a receipt. Takes no parameters. Returns String.
    /**
     * Gets IceCream item values as a String
     * @return IceCream item values as a String
     */
    @Override
    public String toString() {

        String message = "";

        // Gets cost and rounds to two decimal places
        String cost = String.format("%.2f", getCost());

        // If item is default, it adds cost
        if (name == "") {
            message += "                               " + cost + "\n";
        }

        // If the item has a unique name, it adds name and calories
        else {
            message += "\n" + "Ice Cream" + name + "\n                               " + cost +
            "\n\n" + name + " Calories: " + getCalories() + "\n";
        }

        return message;
    }

}

