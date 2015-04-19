package sevak.service;

import sevak.domain.Product;
import java.util.List;
import java.math.BigDecimal;

public interface ProductService {
    public List<Product> findAll();
    public Product findById(int id);
    public List<Product> findByPrice(BigDecimal price);
    public Product save(Product product);
    public void delete(int id);
}
