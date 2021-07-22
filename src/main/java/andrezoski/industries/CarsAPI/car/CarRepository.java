package andrezoski.industries.CarsAPI.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM Car c WHERE c.id = ?1")
    Optional<Car> findCarById(Long id);

    @Query("SELECT c FROM Car c WHERE c.make = ?1 AND c.model = ?2")
    Optional<Car> findCarByMakeAndModel(String make, String model);

    @Query("SELECT c FROM Car c WHERE c.year = ?1")
    List<Car> findCarsByYear(Integer year);
}
