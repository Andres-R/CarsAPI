package andrezoski.industries.CarsAPI.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM Car c WHERE c.id = ?1")
    Optional<Car> findCarById(Long id);

    @Query("SELECT c FROM Car c WHERE c.year = ?1 AND c.model = ?2 AND c.description = ?3")
    Optional<Car> findCarByYearAndModelAndDescription(Integer year, String model, String description);

    @Query("SELECT c FROM Car c WHERE c.year = ?1 AND c.make = ?2 AND c.model = ?3")
    Optional<Car> findCarByYearAndMakeAndModel(Integer year, String make, String model);

    @Query("SELECT c FROM Car c WHERE c.year = ?1")
    List<Car> findCarsByYear(Integer year);

    @Query("SELECT c FROM Car c WHERE c.cylinders = :cylinders")
    List<Car> findCarsByCylinderCount(Integer cylinders);

    @Query("SELECT c FROM Car c WHERE c.cityMpg = ?1")
    List<Car> findCarsByCityMpg(Integer cityMpg);

    @Query("SELECT c FROM Car c WHERE c.highwayMpg = ?1")
    List<Car> findCarsByHighwayMpg(Integer highwayMpg);

    @Query("SELECT c FROM Car c WHERE c.hp > ?1")
    List<Car> findCarsByHorsePowerGreaterThan(Integer hp);

    @Query("SELECT c FROM Car c WHERE c.hp < ?1")
    List<Car> findCarsByHorsePowerLessThan(Integer hp);

    @Transactional
    @Modifying
    @Query("DELETE FROM Car c WHERE c.id = ?1")
    Integer deleteCarById(Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Car c WHERE c.year = ?1 AND c.model = ?2 AND c.description = ?3")
    Integer deleteCarByYearAndModelAndDescription(Integer year, String model, String description);


}
