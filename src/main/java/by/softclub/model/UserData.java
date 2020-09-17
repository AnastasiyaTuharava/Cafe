package by.softclub.model;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named("userData")
@ManagedBean(name = "userData")
@ViewScoped
public class UserData implements Serializable {
    private String title;
    private double price;
    private String description;
    private CafeProduct cafeProduct;
    private List<CafeProduct> products;

    private boolean sortAscending = true;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new CafeProduct("Coffee", 3.55, "Black"),
                new CafeProduct("Coffee", 4, "With milk"),
                new CafeProduct("Tea", 2, "Green"),
                new CafeProduct("Tea", 1, "Black"),
                new CafeProduct("Tea", 5, "Red"),
                new CafeProduct("Tea", 6, "White")
        ));
    }


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

    public String deleteProduct() {
        products.remove(cafeProduct);
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

    public String sortByPrice() {
        if(sortAscending){
            //ascending order
            Collections.sort(products, (o1, o2) -> o1.getPrice() >= o2.getPrice() ? -1 : 0);
            sortAscending = false;
        }else{
            //descending order
            Collections.sort(products, (o1, o2) -> o2.getPrice() >= o1.getPrice() ? -1 : 0);
            sortAscending = true;
        }
        return null;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public CafeProduct getCafeProduct() {
        return cafeProduct;
    }

    public void setCafeProduct(CafeProduct cafeProduct) {
        this.cafeProduct = cafeProduct;
    }
}
