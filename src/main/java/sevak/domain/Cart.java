package sevak.domain;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.math.BigDecimal;

public class Cart {

    private Map<Integer, CartItem> items = new HashMap<Integer, CartItem>();

    public Collection<CartItem> getItems() {
        return items.values();
    }

    public void addCartItem(CartItem item) {
        if (items.containsKey(item.getProduct().getId())) {
            CartItem cartItem = items.get(item.getProduct().getId());
            cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
        } else {
            items.put(item.getProduct().getId(), item);
        }
    }

    public void removeCartItem(CartItem item) {
        items.remove(item.getProduct().getId());
    }

    public BigDecimal getTotalPrice() {
        BigDecimal total = new BigDecimal(0);
        for (CartItem item : items.values()) {
            total = total.add(item.getTotalPrice()); 
        }
        return total;
    }
}
