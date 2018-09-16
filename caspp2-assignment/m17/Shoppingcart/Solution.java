import java.util.Scanner;
import java.io.BufferedInputStream;
/**
 * @author:gangadharsingh
 */

/**
 * Class for item.
 */
class Item {
    /**
     * { var_description }.
     */
    private String prodnm;
    /**
     * { var_description }.
     */
    private int quant;
    /**
     * { var_description }.
     */
    private float prodprice;

    /**
     * Gets the product name.
     *
     * @return     The product name.
     */
    public String getprodnm() {
        return prodnm;
    }
    /**
     * Gets the quant.
     *
     * @return     The quant.
     */
    public int getquant() {
        return quant;
    }
    /**
     * Gets the unit price.
     *
     * @return     The unit price.
     */
    public float getprodprice() {
        return prodprice;
    }
    /**
     * Sets the product name.
     * @param      prodnm1  The product name
     */
    public void setprodnm(final String prodnm1) {
        this.prodnm = prodnm1;
    }
    /**
     * Sets the quanity.
     * @param      quant1  The quant
     */
    public void setQuanity(final int quant1) {
        this.quant = quant1;

    }
    /**
     * Constructs the object.
     * @param      prodnm1  The product name
     * @param      quant1     The quant
     * @param      prodprice1    The unit price
     */
    Item(final String prodnm1,
        final int quant1, final  float prodprice1) {
        this.prodnm = prodnm1;
        this.quant = quant1;
        this.prodprice = prodprice1;
    }

    /**
     * Returns a string representation of the object.
     * @return     String representation of the object.
     */
    public String toString() {
        return this.getprodnm() + " "
               + this.getquant() + " " + this.getprodprice();

    }
}

/**
 * Class for shopping cartesian.
 */
class ShoppingCart {
    /**
     * { var_description }.
     */
    private final int temp = 100;
    /**
     *  catalog size.
     */
    private int catalogSize;
    /**
     * cart size.
     */
    private int cartSize;
    /**
     * { var_description }.
     */
    private Item[] catalog;
    /**
     * { var_description }.
     */
    private Item[] cart;
    /**
     * { var_description }.
     */
    private boolean flag;
    /**
     * { var_description }.
     */
    private float couponcode;

    /**
     * Constructs the object.
     */
    ShoppingCart() {
        catalog = new Item[temp];
        cart = new Item[temp];
        catalogSize = 0;
        cartSize = 0;
        flag = false;
        couponcode = 0.0f;
    }

    /**
     * Adds to catalog.
     * @param      item  The item
     */
    public void addToCatalog(final Item item) {
        catalog[catalogSize++] = item;
    }

    /**
     * Adds to cartesian.
     * @param      item  The item
     */
    public void addToCart(final Item item) {
        for (int i = 0; i < cartSize; i++) {
            if (cart[i].getprodnm().
                    equals(item.getprodnm())) {
                cart[i].setQuanity(cart[i].getquant()
                                   + item.getquant());
                return;
            }
        }
        cart[cartSize++] = item;
    }

    /**
     * Shows the catalog.
     */
    public void showCatalog() {
        for (int i = 0; i < catalogSize; i++) {
            System.out.println(
                catalog[i].getprodnm()
                + " " + catalog[i].getquant()
                + " " + catalog[i].getprodprice());
        }
    }

    /**
     * Shows the cartesian.
     */
    public void showCart() {
        for (int i = 0; i < cartSize; i++) {
            System.out.println(cart[i].getprodnm()
                               + " " + cart[i].getquant());
        }
    }

    /**
     * Removes a from cartesian.
     *
     * @param      item  The item
     */
    public void removeFromCart(final Item item) {
        for (int i = 0; i < cartSize; i++) {
            if (cart[i].getprodnm().equals(item.getprodnm())) {
                if (cart[i].getquant() == item.getquant()) {
                    for (int j = i; j < cartSize; j++) {
                        cart[j] = cart[j + 1];
                    }
                    cartSize--;
                    return;
                }
                cart[i].setQuanity(cart[i].getquant() - item.getquant());
            }
        }
    }

    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public float totalAmount() {
        float sum = 0.0f;
        for (int i = 0; i < cartSize; i++) {
            for (int j = 0; j < catalogSize; j++) {
                if (cart[i].getprodnm().equals(catalog[j]
                    .getprodnm())) {
                    sum = sum + (cart[i].getquant()
                     * catalog[j].getprodprice());
                }
            }
        }
        return sum;
    }

    /**
     * Gets the payable amount.
     *
     * @return     The payable amount.
     */
    public float getPayableAmount() {
        final int cent = 100;
        final int fift = 15;
        float totalAmount = totalAmount();
        float discount = totalAmount * couponcode;
        float finalAmount = totalAmount - discount;
        float payableAmount = finalAmount + (finalAmount * fift / cent);
        return payableAmount;
    }

    /**
     * { function_description }.
     *
     * @param      coupon  The coupon
     */
    public void applyCoupon(final String coupon) {
        final float onef = 0.1f;
        final float twof = 0.2f;
        final float thref = 0.3f;
        final float fivf = 0.5f;
        if (!flag) {
            if (coupon.equals("IND10")) {
                couponcode = onef;
            } else if (coupon.equals("IND20")) {
                couponcode = twof;
            } else if (coupon.equals("IND30")) {
                couponcode = thref;
            } else if (coupon.equals("IND50")) {
                couponcode = fivf;
            } else {
                System.out.println("Invalid coupon");
                return;
            }
            flag = true;
        }
    }
    /**
     * { function_description }.
     */
    public void printInvoice() {
        final int cent = 100;
        final int fift = 15;
        System.out.println("Name   quant   Price");
        for (int i = 0; i < cartSize; i++) {
            for (int j = 0; j < catalogSize; j++) {
                if (cart[i].getprodnm().
                        equals(catalog[j].getprodnm())) {
                    System.out.println(cart[i].getprodnm()
                                       + " " + cart[i].getquant()
                                       + " " + catalog[j].getprodprice());
                }
            }
        }
        //System.out.println("totalAmount: " + totalAmount());
        System.out.println("Total:" + totalAmount());
        float discount = totalAmount() * couponcode;
        System.out.println("Disc%:" + discount);
        float finalAmount = totalAmount() - discount;
        System.out.println("Tax:" + (finalAmount * fift / cent));
        System.out.println("Payable amount: " + getPayableAmount());
    }

}

/**
 * Class for solution.
 */
final class Solution {
    /**.
     * Constructs the object.
     */

    private Solution() {
        /**.
         * { item_description }
         */

    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        ShoppingCart s = new ShoppingCart();
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        int testCases = Integer.parseInt(stdin.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = stdin.nextLine().split(" ");
            switch (tokens[0]) {
            case "Item":
                String[] check = tokens[1].split(",");
                s.addToCatalog(new Item(check[0],
                                        Integer.parseInt(check[1]),
                                        Float.parseFloat(check[2])));
                break;
            case "catalog":
                s.showCatalog();
                break;
            case "add":
                String[] check1 = tokens[1].split(",");
                s.addToCart(new Item(check1[0],
                                     Integer.parseInt(check1[1]), 0.0f));
                break;
            case "show":
                s.showCart();
                break;
            case "totalAmount":
                System.out.println("totalAmount: " + s.totalAmount());
                break;
            case "payableAmount":
                System.out.println("Payable amount: " + s.getPayableAmount());

                break;
            case "remove":
                String[] check2 = tokens[1].split(",");
                s.removeFromCart(new Item(check2[0],
                                          Integer.parseInt(check2[1]), 0.0f));
                break;
            case "coupon":
                s.applyCoupon(tokens[1]);
                break;
            case "print":
                s.printInvoice();
                break;
            default:
                break;
            }
        }
    }
}
