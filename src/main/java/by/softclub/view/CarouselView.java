package by.softclub.view;

import by.softclub.model.Car;
import by.softclub.model.CarService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class CarouselView implements Serializable {

    private List<Car> cars;

    private Car selectedCar;

    @Inject
    private CarService service;

    @PostConstruct
    public void init() {
        cars = service.createCars(9);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
}
