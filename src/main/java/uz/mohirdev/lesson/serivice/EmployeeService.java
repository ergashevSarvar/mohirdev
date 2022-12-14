package uz.mohirdev.lesson.serivice;

import org.springframework.stereotype.Service;
import uz.mohirdev.lesson.entity.Employee;
import uz.mohirdev.lesson.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public void delete(Long id){
        employeeRepository.deleteById(id);
    }

    public Employee findById(Long id){
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }
    public List<Employee> findAll(){
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }
    public List<Employee> findByQueryParam(String name){
        return employeeRepository.findAllByNameStartingWithOrderByIdDesc(name);
    }

}
