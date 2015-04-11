package sevak.service;

import sevak.domain.Product;
import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product findById(int id);
    public Product save(Product product);
}
