package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private CarService carService;
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping()
    public String printCars(@RequestParam(name = "count", defaultValue = "5") int count, ModelMap model) {
        model.addAttribute("cars", carService.limitCars(carService.getCars(), count));
        return "cars";
    }
    /*@GetMapping("/{count}")
    public String printCarsLimit(@PathVariable("count") int count, ModelMap model) {
        model.addAttribute("cars", carService.limitCars(carService.getCars(), count));
        return "cars";
    }*/
}
