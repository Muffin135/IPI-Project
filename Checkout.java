/* Lionel Quintanilla and Nathanael Gastelum
   February 19, 2020
   Purpose: This class is the Checkout object. It uses an ArrayList to store DessertItem objects and can perform
   functions like adding new items, calculating the cost of the items, and printing a receipt.
   Input: No user input
   Output: Can output the number of items, total cost, tax rate, and receipt
 */

import java.util.ArrayList;

public class Checkout {

    // Has two unique instance variables

    // Uses ArrayList of DessertItem to represent the "register"
    private ArrayList<DessertItem> itemRegister;
    private double salesTax;

    // Constructor. Takes no parameters. Generates new array list and sets default tax rate.
    /**
     * Default Checkout constructor
     */
    public Checkout() {
        itemRegister = new ArrayList<>();
        salesTax = .1025;
    }

    // enterItem(): Method adds DessertItem to ArrayList. Takes DessertItem parameter. Returns Void.
    /**
     * Adds DessertItem to register array
     * @param newItem New DessertItem
     */
    public void enterItem(DessertItem newItem) {
        itemRegister.add(newItem);
    }

    // numberOfItems(): Method gets number of DessertItems in ArrayList. Takes no parameters. Returns Int.
    /**
     * Gets number of items in register
     * @return Number of items in register
     */
    public int numberOfItems() {
        return itemRegister.size();
    }

    // clear(): Method clears ArrayList. Takes no parameters. Returns Void.
    /**
     * Clears all items from register
     */
    public void clear() {
        itemRegister.clear();
    }

    // getCost(): Method gets cost of items in register. Takes no parameters. Returns Double.
    /**
     * Gets subtotal of items in register
     * @return Subtotal of items in register
     */
    public double totalCost() {

        // Initializes cost
        double cost = 0.00;

        // Goes through every item in register and adds the item's cost using getCost()
        for (int i = 0; i < itemRegister.size(); i++) {
            cost += itemRegister.get(i).getCost();
        }

        // Rounds Double before returning
        return Math.round(cost * 100.0) / 100.0;
    }

    // getTaxRate(): Method gets current sales tax rate. Takes no parameters. Returns Double.
    /**
     * Gets sales tax rate
     * @return Sales tax rate
     */
    public double getTaxRate() {
        return salesTax;
    }

    // setTaxRate(): Method sets sales tax rate. Takes Double parameter. Returns Void.
    /**
     * Sets sales tax rate
     * @param newTax New sales tax rate
     */
    public void setTaxRate(double newTax) {
        // Divides by 100.0 to turn number to a percentage
        salesTax = newTax/100.0;
    }

    // totalTax(): Method calculates tax on current register. Takes no parameters. Returns Double.
    /**
     * Gets tax on subtotal
     * @return Tax on subtotal
     */
    public double totalTax() {
        // Calculates tax by multiplying subtotal by current tax rate
        // Rounds Double before returning
        return Math.round((totalCost() * getTaxRate()) * 100.0) / 100.0;
    }

    // toString(): Method returns items in register as a receipt. Takes no parameters.
    // Returns String. Overridden from Object class.
    /**
     * Gets items in register as a formatted receipt
     * @return Items in register as a formatted receipt
     */
    @Override
    public String toString() {

        String message =("----------------- 7/11 ------------------\n\n");

        // Iterates through register and adds each item's values to receipt using the getReceipt() method
        for (DessertItem i : itemRegister) {
            message += i.receiptItem();
        }

        // Calculates the subtotal, tax, and final total and rounds the Doubles to two decimal places
        String subTotal = String.format("%.2f", totalCost());
        String tax = String.format("%.2f", totalTax());
        String finalTotal = String.format("%.2f", (totalCost() + totalTax()));

        message += "\n";

        // Adds values to receipt
        message += "SubTotal: " + subTotal + "\n";
        message += "Tax: " + tax + "\n";
        message += "Total: " + finalTotal + "\n";

        return message;
    }
}
