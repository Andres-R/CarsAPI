package andrezoski.industries.CarsAPI.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getCars() {
        return carService.getAllCars();
    }

    @GetMapping(path = "search")
    public List<Car> getCarByMakeAndModel(
            @RequestParam(required = true) String make,
            @RequestParam(required = true) String model) {
        return carService.getCarByMakeAndModel(make, model);
    }

    @GetMapping(path = "year={y}")
    public List<Car> getCarsByYear(@PathVariable("y") String year) {
        return carService.getAllCarsByYear(year);
    }


}
