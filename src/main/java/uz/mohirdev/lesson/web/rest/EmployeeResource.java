package uz.mohirdev.lesson.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.mohirdev.lesson.entity.Employee;
import uz.mohirdev.lesson.serivice.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity create(@RequestBody Employee employee) {
        Employee result = employeeService.save(employee);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/employees")
    public ResponseEntity update(@RequestBody Employee employee) {
        if (employee.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        Employee result = employeeService.save(employee);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getOne(@PathVariable Long id){
        Employee employee = employeeService.findById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/employees/search")
    public ResponseEntity getAllByQuery(@RequestParam String name){
        List<Employee> result = employeeService.findByQueryParam(name);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/employees")
    public ResponseEntity getAll(){
        List<Employee> employees = employeeService.findAll();
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.ok("DELETED");
    }

}
