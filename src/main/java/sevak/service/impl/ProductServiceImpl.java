package sevak.service.impl;

import sevak.domain.Product;
import sevak.service.ProductService;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private static Map<Integer, Product> products = new HashMap<Integer, Product>() {
        {
            put(1, new Product(1, "guitar", 157.56, "stratocatser fender style"));
            put(2, new Product(2, "piano", 1200.99, "electric piano"));
            put(3, new Product(3, "violin", 256.5, "wood style"));
        }
    };

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> findAll() {
        return new ArrayList(products.values());
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public Product save(Product product) {
        products.get(product.getId()).setName(product.getName());
        products.get(product.getId()).setPrice(product.getPrice());
        products.get(product.getId()).setDescription(product.getDescription());
        return product;
    }        
}
