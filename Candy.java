
/* Lionel Quintanilla and Nathanael Gastelum
   February 19, 2020
   Purpose: This class is the Candy object. It has a cost per pound, a weight, and calories, and has functions to get
   and set all of these variables. It can also provide information about the Candy.
   Input: No user input
   Output: Can output the cost, weight, calories, and a toString
 */

public class Candy extends DessertItem {

    // Has three unique instance variables
    private double candyCostPerPound; // Cost per pound of candy
    private double candyWeight; // Weight of Candy item
    private int candyCalories; // Calorie count of Candy item

    // Default constructor. Inherited from DessertItem.
    /**
     * Default Candy constructor
     */
    public Candy() {
        super();
    }

    // Constructor. Takes String parameter. Sets name to String, plus type of item.
    /**
     * Candy constructor
     * @param newName Name of new Candy item
     */
    public Candy(String newName) {
        super(newName + "(Candy)");
    }

    // setCost(): Method sets cost per pound of Candy. Takes double parameter. Returns Void.
    /**
     * Sets cost per pound of Candy
     * @param newCost Cost per pound of Candy
     */
    public void setCost(double newCost) {
        candyCostPerPound = newCost;
    }

    // getCost(): Method gets cost of Candy item. Takes no parameters. Returns Double.
    /**
     * Gets total cost of Candy
     * @return Total cost of Candy
     */
    public double getCost() {
        // Calculates cost by multiplying weight times cost per pound.
        double cost = getWeight() * candyCostPerPound;
        // Rounds Double to two decimal places before returning.
        return Math.round(cost * 100.0) / 100.0;
    }

    // setWeight(): Method sets weight of Candy item. Takes Double parameter. Returns Void.
    /**
     * Sets weight of Candy
     * @param newWeight Weight of Candy
     */
    public void setWeight(double newWeight) {
        candyWeight = newWeight;
    }

    // getWeight(): Method gets weight of Candy item. Takes no parameters. Returns Double.
    /**
     * Gets weight of Candy
     * @return Weight of Candy
     */
    public double getWeight() {
        // Rounds Double to two decimal places before returning.
        return Math.round((candyWeight) * 100.0) / 100.0;
    }

    // setCalories(): Method sets calorie count of Candy item. Takes Int parameter. Returns Void.
    /**
     * Sets calorie count of Candy
     * @param newCalories Calorie count of Candy
     */
    public void setCalories(int newCalories) {
        candyCalories = newCalories;
    }

    // getCalories(): Method gets calories count of Candy item. Takes no parameters. Returns Int.
    /**
     * Gets calorie count of Candy
     * @return Calorie count of Candy
     */
    public int getCalories() {
        return candyCalories;
    }

    // receiptItem(): Method returns item values formatted as a receipt. Takes no parameters. Returns String.
    /**
     * Gets Candy item values for receipt
     * @return Candy item values formatted for receipt
     */
    public String receiptItem() {

        // Same as toString(), but does not include calorie count

        String message = "\n" + getWeight() + " lbs. @ " + candyCostPerPound + " /lb.";

        String finalCost = String.format("%.2f", getCost());

        message += "\n" + name + "\n                               " + finalCost + "\n";

        return message;
    }

    // toString(): Method returns item values. Takes no parameters. Returns String. Overridden from Object class.
    /**
     * Gets Candy item values as a String
     * @return Candy item values as a String
     */
    @Override
    public String toString() {

        // Always includes weight and cost per pound
        String message = "\n" + getWeight() + " lbs. @ " + candyCostPerPound + " /lb.";

        // Gets cost and rounds to two decimal places
        String finalCost = String.format("%.2f", getCost());

        // If the item is default, it adds the cost
        if (name == "") {
            message += "\n                               " + finalCost + "\n";
        }
        // If the item has a unique name, it adds name and calories
        else {
            message += "\n" + name + "\n                               " + finalCost +
                    "\n\n" + name + " Calories: " + getCalories() + "\n";
        }

        return message;
    }

}
