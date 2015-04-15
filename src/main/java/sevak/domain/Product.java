package sevak.domain;

import sevak.validator.Even;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@XmlRootElement
public class Product implements Serializable {
    
    private int id;
    private String name;
    private double price;
    private String description;
    private String imageFileName;

    public Product() {
    } 

    public Product(int id, String name,
                   double price, String description,
                    String imageFileName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageFileName = imageFileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Size(min=2, max=10, message="{Size.product.name}")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   @Min(value=0, message="{Min.product.price}") 
   @Max(value=5000, message="{Max.product.price}")
   @Even 
   public double getPrice() {
       return price;
   } 

   public void setPrice(double price) {
       this.price = price;
   }

   @NotEmpty(message="desc may not be null") 
   public String getDescription() {
       return description;
   }

   public void setDescription(String description) {
       this.description = description;
   }     

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
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
