package by.softclub.view;

import by.softclub.model.CafeProduct;
import by.softclub.model.Price;
import by.softclub.service.CafeProductService;
import lombok.Data;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;
import javax.ejb.EJB;

@Data
@Named("userData")
@ManagedBean(name = "cafeProductView")
@ViewScoped
public class CafeProductView implements Serializable {
    private String title;
    private Price price;
    private String description;
    private CafeProduct cafeProduct;
    private List<CafeProduct> products;
    //private CafeProductService service = new CafeProductService();

    @EJB
    CafeProductService service;

    private boolean sortAscending = true;

    @PostConstruct
    public void init() {
        products = service.getProducts();
        price = new Price();
    }

    public void save() {
        service.save(new CafeProduct(title, price, description));
    }


    /*public String sortByPrice() {
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
    }*/
}
