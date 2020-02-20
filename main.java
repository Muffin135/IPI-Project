/* Lionel Quintanilla and Nathanael Gastelum
   February 19, 2020
   Purpose: This program calculates cost and calories from a shopping cart of desserts and prints a sorted receipt
   Input: No user input
   Output: Test results for every dessert class and receipt for all checkout items
 */

import java.util.ArrayList;
import java.util.Collections;

public class main {

    public static void main(String[] args) {

        System.out.println("\n-----------------------------------------");
        System.out.print("CANDY TEST");

        Candy emptyCandy = new Candy();
        System.out.print(emptyCandy.toString());

        Candy corn = new Candy("Corn");
        corn.setCost(7.25);
        corn.setWeight(1.5);
        corn.setCalories(500);
        System.out.print(corn.toString());

        Candy lolipop = new Candy("Lolipop");
        lolipop.setCost(8.25);
        lolipop.setWeight(2.5);
        lolipop.setCalories(640);
        System.out.print(lolipop.toString());

        System.out.println("\n-----------------------------------------");
        System.out.println("COOKIE TEST");

        Cookie emptyCookie = new Cookie();
        System.out.print(emptyCookie.toString());

        Cookie chocChip = new Cookie("ChocChip");
        chocChip.setCost(4.99);
        chocChip.setNumCookies(17);
        chocChip.setCalories(250);
        System.out.print(chocChip.toString());

        Cookie oatmeal = new Cookie("Oatmeal");
        oatmeal.setCost(3.99);
        oatmeal.setNumCookies(15);
        oatmeal.setCalories(240);
        System.out.print(oatmeal.toString());

        System.out.println("\n-----------------------------------------");
        System.out.println("ICE CREAM TEST");

        IceCream emptyIceCream = new IceCream();
        System.out.print(emptyIceCream.toString());

        IceCream vanilla = new IceCream("Vanilla");
        vanilla.setCost(10.05);
        vanilla.setCalories(500);
        System.out.print(vanilla.toString());

        IceCream chocolate = new IceCream("Chocolate");
        chocolate.setCost(9.99);
        chocolate.setCalories(500);
        System.out.print(chocolate.toString());

        System.out.println("\n-----------------------------------------");
        System.out.println("SUNDAE TEST");

        Sundae emptySundae = new Sundae();
        System.out.print(emptySundae.toString());

        Sundae caramel = new Sundae("Caramel");
        caramel.setCost(7.70);
        caramel.setCalories(600);
        caramel.setTopping("HotFudge");
        System.out.print(caramel.toString());

        Sundae bananaSplit = new Sundae("BananaSplit");
        bananaSplit.setCost(6.90);
        bananaSplit.setCalories(560);
        bananaSplit.setTopping("Strawberries");
        System.out.print(bananaSplit.toString());

        System.out.println("\n-----------------------------------------");
        System.out.println("Output Receipt:\n");

        Checkout newRegister = new Checkout();

        newRegister.enterItem(corn);
        newRegister.enterItem(lolipop);
        newRegister.enterItem(chocChip);
        newRegister.enterItem(oatmeal);
        newRegister.enterItem(vanilla);
        newRegister.enterItem(chocolate);
        newRegister.enterItem(caramel);
        newRegister.enterItem(bananaSplit);

        System.out.println("Number of items: " + newRegister.numberOfItems());
        System.out.println("Total Cost: " + newRegister.totalCost());
        System.out.println("Total Tax: " + newRegister.totalTax());

        String total = String.format("%.2f", (newRegister.totalCost() + newRegister.totalTax()));
        System.out.println("Cost + Tax: " + total);

        String receipt = newRegister.toString();

        System.out.println("\n");
        System.out.println(receipt);

        System.out.println("\n-----------------------------------------");
        System.out.println("Max Test - Same Item:\n");

        DessertItem sameCandy = max(corn, lolipop);
        DessertItem sameCookie = max(chocChip, oatmeal);
        DessertItem sameIceCream = max(vanilla, chocolate);
        DessertItem sameSundae = max(caramel, bananaSplit);

        System.out.println("\n-----------------------------------------");
        System.out.println("SORT:\n");

        ArrayList<DessertItem> deserts = new ArrayList<>();

        deserts.add(corn);
        deserts.add(lolipop);
        deserts.add(chocChip);
        deserts.add(oatmeal);
        deserts.add(vanilla);
        deserts.add(chocolate);
        deserts.add(caramel);
        deserts.add(bananaSplit);

        System.out.println("Unsorted:\n");
        for (DessertItem currItem : deserts) {
            System.out.println(currItem.name + ", Calories " + currItem.getCalories());
        }

        Collections.sort(deserts);

        System.out.println("\nSorted:\n");
        for (DessertItem currItem : deserts) {
            System.out.println(currItem.name + ", Calories " + currItem.getCalories());
        }


    }

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
}
