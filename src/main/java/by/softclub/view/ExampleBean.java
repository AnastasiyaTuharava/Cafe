package by.softclub.view;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ExampleBean {

    private String name = "Anastasia";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
