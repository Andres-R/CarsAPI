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
    public List<Car> getCarByYearAndMakeAndModel(
            @RequestParam(required = true) String year,
            @RequestParam(required = true) String make,
            @RequestParam(required = true) String model) {
        return carService.getCarByYearAndMakeAndModel(year, make, model);
    }

    @GetMapping(path = "year={y}")
    public List<Car> getCarsByYear(@PathVariable("y") String year) {
        return carService.getAllCarsByYear(year);
    }

    @GetMapping(path = "cylinders={c}")
    public List<Car> getCarsByCylinderCount(@PathVariable("c") String cylinders) {
        return carService.getAllCarsByCylinderCount(cylinders);
    }

    @GetMapping(path = "mpg/city={m}")
    public List<Car> getCarsByCityMpg(@PathVariable("m") String cityMpg) {
        return carService.getAllCarsByCityMpg(cityMpg);
    }

    @GetMapping(path = "mpg/highway={m}")
    public List<Car> getCarsByHighwayMpg(@PathVariable("m") String highwayMpg) {
        return carService.getAllCarsByHighwayMpg(highwayMpg);
    }

    @GetMapping(path = "hp/>/{h}")
    public List<Car> getCarsByHorsePowerGreaterThan(@PathVariable("h") String hp) {
        return carService.getAllCarsByHorsePowerGreaterThan(hp);
    }

    @GetMapping(path = "hp/</{h}")
    public List<Car> getCarsByHorsePowerLessThan(@PathVariable("h") String hp) {
        return carService.getAllCarsByHorsePowerLessThan(hp);
    }

    @PostMapping(path = "add")
    public void addCar(@RequestBody Car car) {
        carService.addCar(car);
    }

    @DeleteMapping(path = "delete/id={i}")
    public void deleteCarById(@PathVariable("i") String id) {
        carService.deleteCarById(id);
    }

    @DeleteMapping(path = "delete")
    public void deleteCarByYearAndModelAndDescription(String year, String model, String description) {
        carService.deleteCarByYearAndModelAndDescription(year, model, description);
    }


}
