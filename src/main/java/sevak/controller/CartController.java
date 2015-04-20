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
import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {

    private static final Logger LOG = LoggerFactory.getLogger(CartController.class);  

    private final ProductService productService;

    @Autowired
    public CartController(ProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("cart")
    public Cart initCart() {
        return new Cart();
    }

    @RequestMapping(method=RequestMethod.GET)
    public String get(Model model) {
        return "cart";
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
