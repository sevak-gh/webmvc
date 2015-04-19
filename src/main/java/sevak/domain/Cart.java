package sevak.domain;

import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

public class Cart {

    private Map<Integer, CartItem> items = new HashMap<Integer, CartItem>();

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(HashMap<Integer, CartItem> items) {
        this.items = items;
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
            total.add(item.getTotalPrice()); 
        }
        return total;
    }
}
