package by.softclub.view;

import by.softclub.model.Car;
import by.softclub.model.CarService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
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

    public void setService(CarService service) {
        this.service = service;
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
}
