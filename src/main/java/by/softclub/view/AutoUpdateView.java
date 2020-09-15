package by.softclub.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import java.text.SimpleDateFormat;
import java.util.Date;

@ManagedBean(name = "autoUpdateView", eager = true)
@Named
@RequestScoped
public class AutoUpdateView {

    private String time;

    @PostConstruct
    public void init() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        time = sdfDate.format(now);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
