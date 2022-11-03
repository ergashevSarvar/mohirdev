package uz.mohirdev.lesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.mohirdev.lesson.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByNameAndLastName(String name, String lastname);

    @Query(value = "SELECT * from employees", nativeQuery = true)
    List<Employee> findAll(@Param("name") String name);

    List<Employee> findAllByNameStartingWithOrderByIdDesc(String name);

    @Query("select e from Employee e where lower(e.name) like lower(concat(:name, '%')) order by e.id desc ")
    List<Employee> findAllByNameLikeJPQL(@Param("name") String name);

    @Query(value = "select * from employee e where e.name like %:name%", nativeQuery = true)
    List<Employee> findAllByNameLikeNative(@Param("name") String name);

}
