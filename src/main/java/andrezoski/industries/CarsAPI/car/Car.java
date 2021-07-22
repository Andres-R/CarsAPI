package andrezoski.industries.CarsAPI.car;

import javax.persistence.*;

@Entity
@Table
public class Car {

    @Id
    @SequenceGenerator(
            name = "car_sequence",
            sequenceName = "car_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "car_sequence"
    )
    private Long id;
    private Integer year;
    private String make;
    private String model;
    private String description;
    //private String colors;
    private Integer cityMpg;
    private Integer highwayMpg;
    private Double msrp;
    private Integer cylinders;
    private Integer hp;

    public Car() {

    }

    public Car(Integer year, String make, String model, String description,
               Integer cityMpg, Integer highwayMpg, Double msrp, Integer cylinders, Integer hp) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.description = description;
        this.cityMpg = cityMpg;
        this.highwayMpg = highwayMpg;
        this.msrp = msrp;
        this.cylinders = cylinders;
        this.hp = hp;
    }

    public Long getId() {
        return id;
    }

    public Integer getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCityMpg() {
        return cityMpg;
    }

    public Integer getHighwayMpg() {
        return highwayMpg;
    }

    public Integer getCylinders() {
        return cylinders;
    }

    public Double getMsrp() {
        return msrp;
    }

    public Integer getHp() {
        return hp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCityMpg(Integer cityMpg) {
        this.cityMpg = cityMpg;
    }

    public void setHighwayMpg(Integer highwayMpg) {
        this.highwayMpg = highwayMpg;
    }

    public void setCylinders(Integer cylinders) {
        this.cylinders = cylinders;
    }

    public void setMsrp(Double msrp) {
        this.msrp = msrp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }
}
