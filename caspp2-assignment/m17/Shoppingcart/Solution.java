import java.util.Scanner;
import java.util.Arrays;
class Item {
    public String productname;
    public int quantity;
    public float price;
    Item(String pn, int qnt) {
        productname = pn;
        quantity = qnt;
    }
    Item(String pn, int qnt, float prc) {
        productname = pn;
        quantity = qnt;
        price = prc;
    }
    String getItem() {
        return productname;
    }
    int getQuantity() {
        return quantity;
    }
    Float getPrice() {
        return price;
   }
   void setItem(String prodnm) {
        productname = prodnm;
    }
    void setQuantity(int qtty) {
        quantity = qtty;
    }
    void setPrice(float prc) {
        price = prc;
    }
}
class ShopppingCart {
    Item[] shoppingitem = new Item[10];
    int itmsize = 0;
    Item[] cartitem = new Item[10];
    int cartsize = 0;

    void addToCatalog(Item item) {
        shoppingitem[itmsize++] = item;
    }

    void addToCart(Item crtitem) {
        cartitem[cartsize++] = crtitem;
    }

    void removeFromCart(Item remitem) {
        for (Item crtitem: cartitem) {
            if (crtitem.getItem().equals(remitem.getItem())) {

            }
        }
    }

    void showCart() {
        if (cartsize == 0) {
            System.out.println("null");

        }
        for (int i = 0; i < itmsize; i++) {
            System.out.println(cartitem[i].getItem() + cartitem[i].getQuantity());
        }
    }

    void showCatalog() {
        if (itmsize == 0) {
            System.out.println("null");

        }
        for (int i = 0; i < itmsize; i++) {
            System.out.println(shoppingitem[i].getItem() + shoppingitem[i].getQuantity() + shoppingitem[i].getPrice());
        }
    }

    void getTotalAmount() {
        Double totalamnt = 0.0;
        for (Item crtitm: cartitem) {
            for (Item shopitm: shoppingitem) {
                if ((shopitm.getItem()).equals(crtitm.getItem())) {
                    totalamnt += crtitm.getQuantity() * shopitm.getPrice();
                }
            }
        }
        System.out.println("totalAmount:"+totalamnt);
    }

    /*float getPayableAmount() {

    }

    void applyCoupon() {

    }

    String prntlnvoice() {

    }*/
}

class Solution {
    public static void main(String[] args) {
        ShopppingCart shopcart = new ShopppingCart();
        Scanner scan  = new Scanner(System.in);
        int testcase = scan.nextInt();
        for (int i = 0; i < testcase; i++) {
            String[] tokens = scan.nextLine().split(" ");
            String[] itemdtl = tokens[1].split(",");
            switch (tokens[0]) {
            case "Item":
            if (itemdtl.length == 3) {
                Item itm = new Item(itemdtl[0], Integer.parseInt(itemdtl[1]), Float.parseFloat(itemdtl[2]));
                shopcart.addToCatalog(itm);                
            }
                break;
            case "catalog":
                shopcart.showCatalog();
                break;
            case "Add":
            if (itemdtl.length == 2) {
                Item itm1 = new Item(itemdtl[0], Integer.parseInt(itemdtl[1]));
                shopcart.addToCart(itm1);
                }
                break;
            case "Show":
                shopcart.showCart();
                break;
            case "totalAmount":
                shopcart.getTotalAmount();
                break;
            case "Remove":
                if (itemdtl.length == 3) {
                    Item itm2 = new Item(itemdtl[0], Integer.parseInt(itemdtl[1]));
                    shopcart.removeFromCart(itm2);
                }
                break;
            /*case "Coupon":

                break;*/
            /*case "Print":

                break;*/
            default:
            }
        }
    }

}