package my.examples.hr.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "locations")
@Getter
@Setter
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoIncrement
    private Long locationId;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private  Country country;
}
