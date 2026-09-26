package encapsulation.assigment_problems;

/**
 * Problem 5: The Shopping Cart
 *
 * prices is a private array with no getter. getTotal() and getItemCount()
 * are computed on request by looping the private array, rather than being
 * tracked in a separate stored field. cartId is final.
 */
public class Cart {
    private final double[] prices;
    private int itemCount;
    private final String cartId;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (itemCount >= prices.length) {
            System.out.println("Cart full: cannot add item priced " + price);
            return;
        }
        prices[itemCount] = price;
        itemCount++;
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}
