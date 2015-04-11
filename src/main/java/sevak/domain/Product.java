package sevak.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product implements Serializable {
    
    private int id;
    private String name;
    private double price;
    private String description;

    public Product() {
    } 

    public Product(int id, String name,
                   double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description; 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   public double getPrice() {
       return price;
   } 

   public void setPrice(double price) {
       this.price = price;
   }

   public String getDescription() {
       return description;
   }

   public void setDescription(String description) {
       this.description = description;
   }     

   @Override
   public boolean equals(Object other) {
       if (this == other) {
           return true;
       } 

       if (!(other instanceof Product)) {
           return false;
       }

       Product product = (Product) other;

      return id == product.id; 
   }

   @Override
   public int hashCode() {
       int hash = 7;
       hash = hash * 17 + id;
       hash = hash * 17 + name.hashCode();
       hash = hash * 17 + new Double(price).hashCode();
       hash = hash * 17 + description.hashCode();	 
       return hash;
   }

   @Override
   public String toString() {
        return String.format("product[id:%d,name:%s,price:%f]", id, name, price);
   }
}
