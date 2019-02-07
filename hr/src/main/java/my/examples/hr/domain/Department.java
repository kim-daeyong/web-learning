package my.examples.hr.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "departments")
@Getter
@Setter
public class Department {

    @Id // Pk
    private Long departmentId;
    private  String departmentName;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee employee;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Department(){
        employees = new HashSet<>();
    }
}
