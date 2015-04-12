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
            put(1, new Product(1, "guitar", 157.56, "stratocatser fender style", "guitar.jpeg"));
            put(2, new Product(2, "piano", 1200.99, "electric piano", "piano.jpeg"));
            put(3, new Product(3, "violin", 256.5, "wood style", "violin.jpeg"));
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
        if (product.getId() == 0) {
            int id = products.size() + 1;
            product.setId(id);
            products.put(id, product);
        } else {
            products.get(product.getId()).setName(product.getName());
            products.get(product.getId()).setPrice(product.getPrice());
            products.get(product.getId()).setDescription(product.getDescription());
        }
        return product;
    }        
    
    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByPrice(double price) {
        List<Product> lst = new ArrayList<Product>();
        for (Product product : products.values()) {
            if (Double.compare(product.getPrice(), price) <= 0) {
                lst.add(product);
            }
        }
        return lst;
    }
}
