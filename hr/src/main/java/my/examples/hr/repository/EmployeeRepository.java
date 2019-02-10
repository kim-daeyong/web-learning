package my.examples.hr.repository;

import my.examples.hr.domain.Department;
import my.examples.hr.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {



    @Query("SELECT e FROM Employee e")
    public List<Employee> getEmployees();

    @Query("select e from Employee e where e.department.departmentName = :departmentName")
    public List<Employee> getEmployeesByDepartment(@Param("departmentName") String departmentName);

//    @Query("select d from Employee d where d.department.departmentName = :departmentName ORDER BY d.firstName")
//    public List<Employee> getEmployeesByDepartmentOrderByFirName(@Param("departmentName") String departmentName);

    @Query("SELECT e FROM Employee e WHERE e.department.departmentName = :departmentName ORDER BY e.firstName")
    public Page<Employee> getEmployeeByDepartmentName(@Param("departmentName") String departmentName, Pageable pageable);

    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE CONCAT('%',:firstName,'%') ORDER BY e.firstName")
    public Page<Employee> getEmployeeByFirstName(@Param("firstName") String firstName, Pageable pageable);



}
