package my.examples.hr.repository;

import my.examples.hr.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


//JpaRepository<엔티티 클래스명, id타입> 를 상속받는 interface를 정의 한다.
public interface DepartmentRepository extends JpaRepository<Department, Long>{

    @Query("SELECT d FROM Department d")
    public List<Department> getDepartments();

    @Query("SELECT d FROM Department d WHERE d.departmentName = :name")
    public List<Department> getDepartmentsByName(@Param("name") String name);

    @Query("SELECT d FROM Department d WHERE d.departmentName LIKE CONCAT('%',:name,'%')")
    public List<Department> getDepartmentsWithPartOfName(@Param("name") String name);

    @Query("SELECT d FROM Department d WHERE d.location.city = :cityname")
    public List<Department> getDepartmentsByCityname(@Param("cityname") String cityname);

    @Query("SELECT d FROM Department d inner join fetch d.location")
    public List<Department> getDepartments2();

}
