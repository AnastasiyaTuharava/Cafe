package by.softclub.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@ManagedBean(name = "userData", eager = true)
@ViewScoped
public class UserData implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private int price;
    private String description;
    private CafeProduct cafeProduct;

    private List<CafeProduct> products = new ArrayList<CafeProduct>(Arrays.asList(
            new CafeProduct("Coffee", 3, "Black"),
            new CafeProduct("Coffee", 4, "With milk"),
            new CafeProduct("Tea", 2, "Green"),
            new CafeProduct("Tea", 1, "Black")
    ));

    public List<CafeProduct> getProducts() {
        return products;
    }

    public void setProducts(List<CafeProduct> products) {
        this.products = products;
    }

    public String addProduct() {
        CafeProduct product = new CafeProduct(title, price, description);
        products.add(product);
        return null;
    }

    public String deleteProduct(CafeProduct product) {
        products.remove(product);
        return null;
    }

    public String editCafeProduct() {
        cafeProduct.setCanEdit(true);
        return null;
    }

    public String saveCafeProducts() {

        for (CafeProduct product : products) {
            product.setCanEdit(false);
        }
        return null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CafeProduct getCafeProduct() {
        return cafeProduct;
    }

    public void setCafeProduct(CafeProduct cafeProduct) {
        this.cafeProduct = cafeProduct;
    }
}
