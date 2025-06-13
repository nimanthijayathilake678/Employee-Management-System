package Employee.Management.System.Asgard.Security.repository;

import Employee.Management.System.Asgard.Security.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee ,Long> {
}
