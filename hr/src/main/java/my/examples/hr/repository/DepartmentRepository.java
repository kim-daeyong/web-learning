package my.examples.hr.repository;

import my.examples.hr.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;


//JpaRepository<엔티티 클래스명, id타입> 를 상속받는 interface를 정의 한다.
public interface DepartmentRepository extends JpaRepository<Department, Long>{
}
