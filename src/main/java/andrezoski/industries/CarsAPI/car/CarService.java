package andrezoski.industries.CarsAPI.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> getCarByYearAndMakeAndModel(String year, String make, String model) {
        for (Character c : year.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalStateException("Year must be a number!");
            }
        }
        Integer yearMade = Integer.parseInt(year);
        Optional<Car> car = carRepository.findCarByYearAndMakeAndModel(yearMade, make, model);
        if (!car.isPresent()) {
            throw new IllegalStateException(year + " " + make + " " + model + " not found!");
        }
        return List.of(car.get());
    }

    public List<Car> getAllCarsByYear(String year) {
        for (Character c : year.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalStateException("Year must be a number!");
            }
        }
        Integer yearMade = Integer.parseInt(year);
        List<Car> list = carRepository.findCarsByYear(yearMade);
        if (list.size() == 0) {
            throw new IllegalStateException("No cars found for year " + yearMade + "!");
        }
        return list;
    }

    public List<Car> getAllCarsByCylinderCount(String cylinders) {
        for (Character c : cylinders.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalStateException("Cylinder count must be a number!");
            }
        }
        Integer cylinderCount = Integer.parseInt(cylinders);
        List<Car> list = carRepository.findCarsByCylinderCount(cylinderCount);
        if (list.size() == 0) {
            throw new IllegalStateException("No cars found with " + cylinderCount + " cylinders!");
        }
        return list;
    }

    public List<Car> getAllCarsByCityMpg(String cityMpg) {
        for (Character c : cityMpg.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalStateException("City MPG must be a number!");
            }
        }
        Integer actualCityMpg = Integer.parseInt(cityMpg);
        List<Car> list = carRepository.findCarsByCityMpg(actualCityMpg);
        if (list.size() == 0) {
            throw new IllegalStateException("No cars found with " + cityMpg + " city MPG!");
        }
        return list;
    }

    public List<Car> getAllCarsByHighwayMpg(String highwayMpg) {
        for (Character c : highwayMpg.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalStateException("Highway MPG must be a number!");
            }
        }
        Integer actualHighwayMpg = Integer.parseInt(highwayMpg);
        List<Car> list = carRepository.findCarsByHighwayMpg(actualHighwayMpg);
        if (list.size() == 0) {
            throw new IllegalStateException("No cars found with " + highwayMpg + " highway MPG!");
        }
        return list;
    }

    public List<Car> getAllCarsByHorsePowerGreaterThan(String hp) {
        for (Character c : hp.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalStateException("Horse power must be a number!");
            }
        }
        Integer actualHp = Integer.parseInt(hp);
        List<Car> list = carRepository.findCarsByHorsePowerGreaterThan(actualHp);
        if (list.size() == 0) {
            throw new IllegalStateException("No cars found with horse power greater than " + hp + "!");
        }
        return list;
    }

    public List<Car> getAllCarsByHorsePowerLessThan(String hp) {
        for (Character c : hp.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalStateException("Horse power must be a number!");
            }
        }
        Integer actualHp = Integer.parseInt(hp);
        List<Car> list = carRepository.findCarsByHorsePowerLessThan(actualHp);
        if (list.size() == 0) {
            throw new IllegalStateException("No cars found with horse power less than " + hp + "!");
        }
        return list;
    }




    public void addCar(Car car) {
        Optional<Car> optional = carRepository.findCarByYearAndModelAndDescription(car.getYear(), car.getModel(), car.getDescription());
        if (optional.isPresent()) {
            throw new IllegalStateException("Cannot add car, " + car.getYear() + " " + car.getModel() + " " +
                    (car.getDescription().equals("") ? "" : car.getDescription() + " ") + "already saved!");
        }
        carRepository.save(car);
    }

    public void deleteCarById(String id) {
        for (Character c : id.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalStateException("Id must be a number!");
            }
        }
        Long actualId = Long.parseLong(id);
        Optional<Car> optional = carRepository.findCarById(actualId);
        if (!optional.isPresent()) {
            throw new IllegalStateException("No car found with id " + id + "!");
        }
        carRepository.deleteCarById(actualId);
    }

    public void deleteCarByYearAndModelAndDescription(String year, String model, String description) {
        for (Character c : year.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalStateException("Year must be a number!");
            }
        }
        Integer actualYear = Integer.parseInt(year);
        Optional<Car> optional = carRepository.findCarByYearAndModelAndDescription(actualYear, model, description);
        if (!optional.isPresent()) {
            throw new IllegalStateException(year + " " + model + " " + (description.equals("") ? "" : description + " ") + " not found!");
        }
        carRepository.deleteCarByYearAndModelAndDescription(actualYear, model, description);
    }

}
