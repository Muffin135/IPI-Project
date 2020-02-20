/* Lionel Quintanilla and Nathanael Gastelum
   February 19, 2020
   Purpose: This class is the Sundae object. It has a cost, calories, and a topping, and has functions to get and set
   all of these variables. It can also provide information about the Sundae.
   Input: No user input
   Output: Can output the cost, calories, the topping, and a toString
 */

// Child of IceCream (from Lineage of DessertItem)
public class Sundae extends IceCream {

    // Has three unique instance variables
    private double sundaeCost;
    private int sundaeCalories;
    private String topping;

    // Default constructor. Inherited from DessertItem.
    /**
     * Default Sundae constructor
     */
    public Sundae() {
        super();
    }

    // Constructor. Takes String parameter. Sets name to String, plus type of item.
    /**
     * Sundae constructor
     * @param newName Name of new Sundae item
     */
    public Sundae(String newName) {
        super(newName + "(Sundae)");
    }

    // setCost(): Method sets cost of Sundae. Takes double parameter. Returns Void.
    /**
     * Sets cost of Sundae item
     * @param newCost Cost of Sundae item
     */
    public void setCost(double newCost) {
        sundaeCost = newCost;
    }

    // getCost(): Method gets cost of Sundae item. Takes no parameters. Returns Double.
    /**
     * Gets cost of Sundae item
     * @return Cost of Sundae item
     */
    public double getCost() {
        // Rounds Double to two decimal places before returning.
        return Math.round(((sundaeCost) * 100.0)) / 100.0;
    }

    // setCalories(): Method sets calorie count of Sundae item. Takes Int parameter. Returns Void.
    /**
     * Sets calorie count of Sundae item
     * @param newCalories Calorie count of Sundae item
     */
    public void setCalories(int newCalories) {
        sundaeCalories = newCalories;
    }

    // getCalories(): Method gets calories count of Sundae item. Takes no parameters. Returns Int.
    /**
     * Gets calorie count of Sundae item
     * @return Calorie count of Sundae item
     */
    public int getCalories() {
        return sundaeCalories;
    }

    // setTopping(): Method sets Topping of Sundae item. Takes String parameter. Returns Void.
    /**
     * Sets Topping of Sundae item
     * @param newTopping Name of Topping
     */
    public void setTopping(String newTopping) {
        // Adds (Topping) label to topping
        topping = newTopping + "(Topping)";
    }

    // getTopping(): Method gets Topping of Sundae item. Takes no parameters. Returns String.
    /**
     * Gets Topping of Sundae item
     * @return Name of Topping
     */
    public String getTopping() {
        return topping;
    }

    // receiptItem(): Method returns item values formatted as a receipt. Takes no parameters. Returns String.
    /**
     * Gets Sundae item values for receipt
     * @return Sundae item values formatted for receipt
     */
    public String receiptItem() {

        // Same as toString(), but does not include calorie count

        String message = "";
        String cost = String.format("%.2f", getCost());

            message += "\n" + name + " with\n" + getTopping() + "\n                               " + cost + "\n";

        return message;
    }

    // toString(): Method returns item values. Takes no parameters. Returns String. Overridden from Object class.
    /**
     * Gets Sundae item values as a String
     * @return Sundae item values as a String
     */
    @Override
    public String toString() {

        String message = "";

        // Gets cost and rounds to two decimal places
        String cost = String.format("%.2f", getCost());

        // If item is default, it adds cost
        if (name == "") {
            message += " with " + "\n                               " + cost + "\n";
        }

        // If the item has a unique name, it adds name and calories
        else {
            message += "\n" + name + " with\n" + getTopping() +
                    "\n                               " + cost + "\n\n" + name + " Calories: "
                    + getCalories() + "\n";
        }

        return message;
    }
}
