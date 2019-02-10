package my.examples.hr.repository;


import my.examples.hr.domain.Department;
import my.examples.hr.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;


    @Test
    public void initTest() {
        // 아무런 코드가 없음. 에러가 안난다면 설정은 잘되어 있다는 뜻.
    }

//    @Test
//    public void getDepartments() throws Exception {
//        List<Employee> all = employeeRepository.getEmployees();
//        for (Employee employee : all) {
//            System.out.println(employee.getFirstName() + ", " + employee.getLastName() + ", " + employee.getEmail());
//        }
//        System.out.println("----------------------------------------------------------");
//    }

//

//    @Test
//    public void getEmployeesByDepartmentOrderByFirName() throws Exception {
//        List<Employee> all = employeeRepository.getEmployeesByDepartment("IT");
//        for (Employee employee : all) {
//            System.out.println(employee.getFirstName() + ", " + employee.getLastName() + ", " + employee.getEmail());
//        }
//        System.out.println("----------------------------------------------------------");
//    }

//    @Test
//    public void getDepartmentsByName() throws Exception{
//        Pageable pageable = PageRequest.of(1, 3);
//        Page<Employee> employeePage = employeeRepository.getEmployeeByDepartmentName("Sales", pageable);
//
//        System.out.println(employeePage.getTotalElements());
//        System.out.println(employeePage.getTotalPages());
//        for(Employee e : employeePage.getContent()){
//            System.out.println(e.getFirstName() + " " + e.getLastName() + " : " + e.getEmail());
//        }
//    }

    @Test
    public void getEmployeeByFirstName() throws Exception{
        Pageable pageable = PageRequest.of(1, 5);
        Page<Employee> employeePage = employeeRepository.getEmployeeByFirstName("a", pageable);

        System.out.println(employeePage.getTotalElements());
        System.out.println(employeePage.getTotalPages());
        for(Employee e : employeePage.getContent()){
            System.out.println(e.getFirstName() + " " + e.getLastName() + " : " + e.getEmail());
        }
    }


}
