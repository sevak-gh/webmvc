package sevak.controller;

import sevak.service.ProductService;
import sevak.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }


    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("newproduct", productService.findById(id));
        model.addAttribute("numbre", 56);
        //     model.addAttribute("readonly", true);
        return "product";
    }

    @RequestMapping(value="/{id}", method = RequestMethod.POST)
    public String get(@ModelAttribute("product") Product product, BindingResult result) {
        // TODO validation later

        productService.save(product);        
    
        return "redirect:/products";
    }

    @RequestMapping(value="/{id}/dataxml", method = RequestMethod.GET, produces = "application/xml")
    @ResponseBody
    public Product getDataXml(@PathVariable("id") int id) {
        return productService.findById(id);
    }

    @RequestMapping(value="/{id}/datajson", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Product getDataJson(@PathVariable("id") int id) {
        return productService.findById(id);
    }
}
