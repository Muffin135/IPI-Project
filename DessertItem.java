/* Lionel Quintanilla and Nathanael Gastelum
   February 19, 2020
   Purpose: This class is the DessertItem object. It is the template for the other DessertItems, and has only a name.
   It also has functions for its children to use, such as getCost, getCalories, and toString. It also uses the
   Comparable interface to use the compareTo and max methods.
   Input: No user input
   Output: Can output the cost, calories, and a toString
 */

public abstract class DessertItem implements java.lang.Comparable<DessertItem> {

    // Variable representing the name of the DessertItem
    protected String name;

    // Default constructor for DessertItem. Sets name instance variable to empty string.
    /**
     * Null constructor for DessertItem class
     */
    public DessertItem() {
        this("");
    }

    // Constructor for DessertItem. Takes String as parameter. Sets name instance variable to String.

    /**
     * DessertItem constructor
     * @param name Name of new DessertItem
     */
    public DessertItem(String name) {
        this.name = name;
    }

    // getName(): Gets name of current item. Takes no parameters. Returns String.
    /**
     * Returns name of DessertItem
     * @return name of DessertItem
     */
    public final String getName() {
        return name;
    }

    // getCost(): Gets cost of current item. Takes no parameters. Returns Double.
    /**
     * Returns cost of DessertItem
     * @return cost of DessertItem
     */
    public abstract double getCost();

    // getCalories(): Method gets the calorie count of current item. Takes no parameters. Returns Int.
    /**
     * Gets DessertItem calorie count
     * @return calorie count of DessertItem
     */
    public abstract int getCalories();

    // receiptItem(): Method returns item values formatted as a receipt. Takes no parameters. Returns String.
    /**
     * Gets DessertItem values formatted for receipt
     * @return String of DessertItem values
     */
    public abstract String receiptItem();

    // compareTo(): Method overrides the Comparable interface; compares calorie count of current item to other item.
    // Takes other DessertItem as parameter. Returns Int of 1, -1, or 0 if item is larger, smaller,
    // or equal to other item.
    /**
     * Compares calorie counts of current DessertItem to other DessertItem
     * @param otherItem DessertItem for comparison
     * @return Comparison result
     */
    public int compareTo(DessertItem otherItem) {

        // Uses getCalories() method from DessertItem to compare different Child objects
        if (this.getCalories() > otherItem.getCalories()) {
            return 1;
        }
        else if (this.getCalories() < otherItem.getCalories()) {
            return -1;
        }
        else {
            return 0;
        }
    }

    // max(): Method finds item with larger calorie count, given two items. Uses compareTo() for comparison logic.
    // Takes two DessertItem as parameter. Returns larger DessertItem.
    /**
     * Finds DessertItem with largest calorie count
     * @param item1 First DessertItem
     * @param item2 Second DessertItem
     * @return DessertItem with largest calorie count
     */
    public static DessertItem max(DessertItem item1, DessertItem item2) {

            int largerItem = item1.compareTo(item2);

            if (largerItem == 1) {
                return item1;
            }
            else if (largerItem == -1) {
                return item2;
            }
            else {
                return null;
            }
    }

    // printLarger(): Method uses logic to print item with larger calorie count, given two items and comparison result.
    // Takes three DessertItem as parameter: two DessertItem and DessertItem from max() of other two DessertItem.
    // Returns Void.

    /**
     * Prints DessertItem with largest calorie count
     * @param max Result of max() comparison between item1 and item2
     * @param item1 First DessertItem
     * @param item2 Second DessertItem
     */
    public static void printLarger(DessertItem max, DessertItem item1, DessertItem item2) {

        // Checks if one of two items equals the max() result

        // If one item equal max(), then it prints statement signalling larger item
        if (max == item1) {
            System.out.println(item1.getName() + " Calories: " + item1.getCalories() + " is larger than "
                    + item2.getName() + " Calories: " + item2.getCalories());
        }
        else if (max == item2) {
            System.out.println(item2.getName() + " Calories: " + item2.getCalories() + " is larger than "
                    + item1.getName() + " Calories: " + item1.getCalories());
        }
        // If neither item equals max(), then it prints a statement signalling equal
        else {
            System.out.println(item1.getName() + " Calories: " + item1.getCalories() + " is equal to "
                    + item2.getName() + " Calories: " + item2.getCalories());
        }
    }
}

