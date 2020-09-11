package by.softclub.model;


import org.wildfly.common.annotation.NotNull;

public class CafeProduct implements Comparable{
    private String title;
    private double price;
    private String description;
    private boolean canEdit;

    public CafeProduct(String title, double price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;
        canEdit = false;
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

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }


    @Override
    public int compareTo(@NotNull Object o) {
        CafeProduct product = (CafeProduct) o;
        return price >= product.getPrice() ? -1 : 0;
    }

}
