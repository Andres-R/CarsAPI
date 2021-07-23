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
            Car bb = new Car(2017, "Honda", "Civic", "", 32, 42, 23900.00, 4, 158);
            Car bbb = new Car(2021, "Nissan", "Sentra", "", 29, 39, 19460.00, 4, 149);
            Car c = new Car(2020, "Nissan", "370z", "", 19, 26, 30090.00, 6, 332);
            Car cc = new Car(2021, "Nissan", "Maxima", "", 20, 30, 37090.00, 6, 300);
            Car ccc = new Car(2021, "Mazda", "CX-30", "", 25, 33, 22050.00, 4, 186);
            Car d = new Car(2021, "Mazda", "CX-3", "", 29, 34, 20790.00, 4, 148);
            Car dd = new Car(2021, "Mazda", "CX-5", "", 25, 31, 25370.00, 4, 187);
            Car ddd = new Car(2021, "Mazda", "CX-9", "", 22, 28, 34160.00, 4, 227);
            Car e = new Car(2021, "Mazda", "3", "", 28, 36, 20650.00, 4, 155);

            carRepository.saveAll(
                    List.of(a, aa, aaa, b, bb, bbb, c, cc, ccc, d, dd, ddd, e)
            );
        };
    }

}
