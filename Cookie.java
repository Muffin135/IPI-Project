/* Lionel Quintanilla and Nathanael Gastelum
   February 19, 2020
   Purpose: This class is the Cookie object. It has a cost per dozen cookies, number of cookie in a batch, calories,
   and has functions to get and set all of these variables. It can also provide information about the Cookie.
   Input: No user input
   Output: Can output the cost, calories, number of cookies in the batch, and a toString
 */

public class Cookie extends DessertItem {

    // Has three unique instance variables
    private double cookieCostPerDozen;
    private int numCookies;
    private int cookieCalories;

    // Default constructor. Inherited from DessertItem.
    /**
     * Default Cookie constructor
     */
    public Cookie() {
        super();
    }

    // Constructor. Takes String parameter. Sets name to String, plus type of item.
    /**
     * Cookie constructor
     * @param newName Name of new Cookie item
     */
    public Cookie(String newName) {
        super(newName + "(Cookie)");
    }

    // setCost(): Method sets cost per dozen Cookies. Takes double parameter. Returns Void.
    /**
     * Sets cost of Cookie item
     * @param newCost Cost of Cookie item
     */
    public void setCost(double newCost) {
        cookieCostPerDozen = newCost;
    }

    // getCost(): Method gets cost of Cookie item. Takes no parameters. Returns Double.
    /**
     * Gets cost of Cookie item
     * @return Cost of Cookie item
     */
    public double getCost() {
        // Calculates cost by multiplying cost per dozen by number of cookies (grouped by the dozen)
        // Rounds Double to two decimal places before returning.
        return Math.round((cookieCostPerDozen * (numCookies/12.0)) * 100.0) / 100.0;
    }

    // setNumCookies(): Method sets number of Cookies. Takes Int parameter. Returns Void.
    /**
     * Sets number of Cookies in the Cookie item
     * @param newNum Number of Cookies
     */
    public void setNumCookies(int newNum) {
        numCookies = newNum;
    }

    // getNumCookies(): Method gets number of Cookies. Takes no parameters. Returns Int.
    /**
     * Gets number of Cookies in the Cookie item
     * @return Number of Cookies
     */
    public int getNumCookies() {
        return numCookies;
    }

    // setCalories(): Method sets calorie count of Cookie item. Takes Int parameter. Returns Void.
    /**
     * Sets calorie count of Cookie
     * @param newCalories Calorie count of Cookie
     */
    public void setCalories(int newCalories) {
        cookieCalories = newCalories;
    }

    // getCalories(): Method gets calories count of Cookie item. Takes no parameters. Returns Int.
    /**
     * Gets calorie count of Cookie
     * @return Calorie count of Cookie
     */
    public int getCalories() {
        return cookieCalories;
    }

    // receiptItem(): Method returns item values formatted as a receipt. Takes no parameters. Returns String.
    /**
     * Gets Cookie item values for receipt
     * @return Cookie item values formatted for receipt
     */
    public String receiptItem() {

        // Same as toString(), but does not include calorie count

        String message = "\n" + getNumCookies() + " @ " + cookieCostPerDozen + " /dz.";

        String finalCost = String.format("%.2f", getCost());

        message += "\n" + name + "\n                               " + finalCost + "\n";

        return message;
    }

    // toString(): Method returns item values. Takes no parameters. Returns String. Overridden from Object class.
    /**
     * Gets Cookie item values as a String
     * @return Cookie item values as a String
     */
    @Override
    public String toString() {

        // Always include number of cookies and cost per dozen
        String message = "\n" + getNumCookies() + " @ " + cookieCostPerDozen + " /dz.";

        // Gets cost and rounds to two decimal places
        String finalCost = String.format("%.2f", getCost());

        // If item is default, it adds cost
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
