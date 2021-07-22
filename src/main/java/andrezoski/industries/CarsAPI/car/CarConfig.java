package andrezoski.industries.CarsAPI.car;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CarConfig {

    @Bean(name = "car_bean")
    CommandLineRunner commandLineRunner (CarRepository carRepository) {
        return args -> {

            Car a = new Car(2015, "Hyundai", "Tucson", "", 23, 29, 23700.00, 4, 173);
            Car aa = new Car(2014, "Dodge", "Durango", "", 18, 25, 29995.00, 6, 290);
            Car aaa = new Car(2011, "Dodge", "Challenger", "", 18, 27, 25500.00, 6, 305);
            Car b = new Car(2018, "Lexus", "IS 350", "F SPORT 004", 19, 28, 45025.00, 6, 311);

            carRepository.saveAll(
                    List.of(a, aa, aaa, b)
            );
        };
    }

}
