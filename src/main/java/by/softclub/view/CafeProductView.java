package by.softclub.view;

import by.softclub.model.CafeProduct;
import by.softclub.model.Price;
import by.softclub.service.CafeProductService;
import lombok.Data;
import org.primefaces.event.RowEditEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
    private List<CafeProduct> products;
    private CafeProduct selectedProduct;
    private CafeProduct newProduct;

    @EJB
    CafeProductService service;

    private boolean sortAscending = true;

    @PostConstruct
    public void init() {
        products = service.getProducts();
        newProduct = new CafeProduct();
        price = new Price();
    }

    public void save() {
        service.save(newProduct);
        products = service.getProducts();
        newProduct = new CafeProduct();
    }

    public void edit() {
        service.update(new CafeProduct(title, price, description));
    }

    public void delete(CafeProduct product) {
        service.delete(product);
        products = service.getProducts();
    }

    public void onRowEdit(RowEditEvent<CafeProduct> event) {
        FacesMessage msg = new FacesMessage("Product edited", "id = " + String.valueOf(event.getObject().getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<CafeProduct> event) {
        FacesMessage msg = new FacesMessage("Edit cancelled", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowDelete() {
        FacesMessage msg = new FacesMessage("Product deleted", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowAdd() {
        FacesMessage msg = new FacesMessage("New product added", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
