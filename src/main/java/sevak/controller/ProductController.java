package sevak.controller;

import sevak.service.ProductService;
import sevak.domain.Product;
import sevak.validator.ProductValidator;

import java.io.IOException;
import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductValidator productValidator;

    @Autowired
    public ProductController(ProductService productService, ProductValidator productValidator) {
        this.productService = productService;
        this.productValidator = productValidator;
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
    public String get(@ModelAttribute("product") @Valid Product product, BindingResult result) {

        // apply custom validator
        productValidator.validate(product, result);

        if (result.hasErrors()) {
            return "product";
        }
    
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

    @RequestMapping(value="/create", method = RequestMethod.GET)
    public String getNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product";
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public String create(@RequestParam("image") MultipartFile image, 
                         @ModelAttribute("product") @Valid Product product, BindingResult result, 
                         HttpServletRequest request) {

        // apply custom validator
        productValidator.validate(product, result);

        if (result.hasErrors()) {
            return "product";
        }

        // save image
        if ((image != null) && !image.isEmpty()) {        
            String imageFileName = Long.toString(System.currentTimeMillis());
            product.setImageFileName(imageFileName);
            try {
                String root = request.getSession().getServletContext().getRealPath("/");
                image.transferTo(new File(root + "/images/" + imageFileName));
            } catch (IOException e) {
                throw new RuntimeException("saving image failed", e);
            }
        }

        productService.save(product);
        return "redirect:/products";
    }    

    @RequestMapping(value="/delete/{id}", method = RequestMethod.POST)
    public String create(@PathVariable("id") int id, Model model) {
        productService.delete(id);
        return "redirect:/products";
    }
}
