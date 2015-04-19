package sevak.controller;

import sevak.service.ProductService;
import sevak.domain.Product;
import sevak.domain.Cart;
import sevak.domain.CartItem;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {
    
    private final ProductService productService;

    @Autowired
    public CartController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value="/add/{productId}", method=RequestMethod.POST)
    public String add(@PathVariable("productId") int id, @ModelAttribute("cart") Cart cart) {
        Product product = productService.findById(id);
        CartItem item = new CartItem();
        item.setProduct(product);
        item.setQuantity(1);
        cart.addCartItem(item);
        return "cart";
    }
}
