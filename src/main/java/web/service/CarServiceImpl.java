package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private List<Car> cars;
    {
        cars = new ArrayList<>();

        cars.add(new Car("1", "A", "A1"));
        cars.add(new Car("2", "B", "B2"));
        cars.add(new Car("3", "C", "C3"));
        cars.add(new Car("4", "D", "D4"));
        cars.add(new Car("5", "E", "E5"));
    }
    public List<Car> getCars() {
        return cars;
    }
    @Override
    public List<Car> limitCars(List<Car> cars, int limit) {
        if (limit > 5) {
            return cars;
        }
        return cars.subList(0, limit);
    }
}
