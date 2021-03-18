package kinoxp.com.demo.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "products", schema = "kinoxp")
public class ProductsEntity {
    private int productId;
    private String productName;
    private double price;
    private byte[] productImg;

    @Id
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "product_img")
    public byte[] getProductImg() {
        return productImg;
    }

    public void setProductImg(byte[] productImg) {
        this.productImg = productImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsEntity that = (ProductsEntity) o;
        return productId == that.productId &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(productName, that.productName) &&
                Arrays.equals(productImg, that.productImg);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productId, productName, price);
        result = 31 * result + Arrays.hashCode(productImg);
        return result;
    }
}
