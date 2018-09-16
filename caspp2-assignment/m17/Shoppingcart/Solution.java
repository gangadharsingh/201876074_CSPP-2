import java.util.Scanner;
import java.io.BufferedInputStream;
/**
 * @author: gangadharsingh
 * Class for item.
 */
class Item {
    /**
     * { var_description }.
     */
    private String producttype;
    /**
     * { var_description }.
     */
    private int quant;
    /**
     * { var_description }.
     */
    private float productprice;

    /**
     * Gets the product name.
     *
     * @return     The product name.
     */
    public String getProductName() {
        return producttype;
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
    public float getproductprice() {
        return productprice;
    }
    /**
     * Sets the product name.
     * @param      productName1  The product name
     */
    public void setProductName(final String productName1) {
        this.producttype = productName1;
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
     * @param      productName1  The product name
     * @param      quant1     The quant
     * @param      productprice1    The unit price
     */
    Item(final String productName1,
         final int quant1, final  float productprice1) {
        this.producttype = productName1;
        this.quant = quant1;
        this.productprice = productprice1;
    }

    /**
     * Returns a string representation of the object.
     * @return     String representation of the object.
     */
    public String toString() {
        return this.getProductName() + " "
               + this.getquant() + " " + this.getproductprice();

    }
}
/**
 * Class for shopping cartesian.
 */
class ShoppingCart {
    /**
     * { var_description }.
     */
    private final int initialen = 100;
    /**
     *  catalog size.
     */
    private int catsize;
    /**
     * cart size.
     */
    private int cartsize;
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
    private boolean check;
    /**
     * { var_description }.
     */
    private float coupcode;

    /**
     * Constructs the object.
     */
    ShoppingCart() {
        catalog = new Item[initialen];
        cart = new Item[initialen];
        catsize = 0;
        cartsize = 0;
        check = false;
        coupcode = 0.0f;
    }

    /**
     * Adds to catalog.
     * @param      item  The item
     */
    public void addToCatalog(final Item item) {
        catalog[catsize++] = item;
    }

    /**
     * Adds to cartesian.
     * @param      item  The item
     */
    public void addToCart(final Item item) {
        for (int i = 0; i < cartsize; i++) {
            if (cart[i].getProductName().
                    equals(item.getProductName())) {
                cart[i].setQuanity(cart[i].getquant()
                                   + item.getquant());
                return;
            }
        }
        cart[cartsize++] = item;
    }

    /**
     * Shows the catalog.
     */
    public void showCatalog() {
        for (int i = 0; i < catsize; i++) {
            System.out.println(
                catalog[i].getProductName()
                + " " + catalog[i].getquant()
                + " " + catalog[i].getproductprice());
        }
    }

    /**
     * Shows the cartesian.
     */
    public void showCart() {
        for (int i = 0; i < cartsize; i++) {
            System.out.println(cart[i].getProductName()
                               + " " + cart[i].getquant());
        }
    }

    /**
     * Removes a from cartesian.
     *
     * @param      item  The item
     */
    public void removeFromCart( final Item item) {
        for (int i = 0; i < cartsize; i++) {
            if (cart[i].getProductName().equals(item.getProductName())) {
                if (cart[i].getquant() == item.getquant()) {
                    for (int j = i; j < cartsize; j++) {
                        cart[j] = cart[j + 1];
                    }
                    cartsize--;
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
    public float totalAmnt() {
        float sum = 0.0f;
        for (int i = 0; i < cartsize; i++) {
            for (int j = 0; j < catsize; j++) {
                if (cart[i].getProductName().equals(catalog[j]
                                                    .getProductName())) {
                    sum = sum + (cart[i].getquant()
                                 * catalog[j].getproductprice());
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
        final int hundred = 100;
        final int fifth = 15;
        float totalAmnt = totalAmnt();
        float disc = totalAmnt * coupcode;
        float finalAmount = totalAmnt - disc;
        float payableAmount = finalAmount + (finalAmount * fifth / hundred);
        return payableAmount;
    }

    /**
     * { function_description }.
     *
     * @param      coupon  The coupon
     */
    public void applyCoupon(final String coupon) {
        final float onef = 0.1f;
        final float twof  = 0.2f;
        final float thref = 0.3f;
        final float fivf = 0.5f;
        if (!check) {
            if (coupon.equals("IND10")) {
                coupcode = onef ;
            } else if (coupon.equals("IND20")) {
                coupcode = twof;
            } else if (coupon.equals("IND30")) {
                coupcode = thref;
            } else if (coupon.equals("IND50")) {
                coupcode = fivf;
            } else {
                System.out.println("Invalid coupon");
                return;
            }
            check = true;
        }
    }
    /**
     * { function_description }.
     */
    public void printInvoice() {
        final int hundred = 100;
        final int fifth = 15;
        System.out.println("Name   quant   Price");
        for (int i = 0; i < cartsize; i++) {
            for (int j = 0; j < catsize; j++) {
                if (cart[i].getProductName().
                        equals(catalog[j].getProductName())) {
                    System.out.println(cart[i].getProductName()
                                       + " " + cart[i].getquant()
                                       + " " + catalog[j].getproductprice());
                }
            }
        }
        //System.out.println("totalAmnt: " + totalAmnt());
        System.out.println("Total:" + totalAmnt());
        float disc = totalAmnt() * coupcode;
        System.out.println("Disc%:" + disc);
        float finalAmount = totalAmnt() - disc;
        System.out.println("Tax:" + (finalAmount * fifth / hundred));
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
                s.addToCatalog(new Item( check[0],
                                         Integer.parseInt(check[1]),
                                         Float.parseFloat(check[2])));
                break;
            case "catalog":
                s.showCatalog();
                break;
            case "add":
                String[] check1 = tokens[1].split(",") ;
                s.addToCart(new Item(check1[0],
                                     Integer.parseInt(check1[1]), 0.0f));
                break;
            case "show":
                s.showCart();
                break;
            case "totalAmnt":
                System.out.println("totalAmnt: " + s.totalAmnt());
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
