package Employee.Management.System.Asgard.Security.repository;

import Employee.Management.System.Asgard.Security.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository  extends JpaRepository<Attendance,Long> {
    //List<Attendance> findByemployeeId(Long employeeId);
    //List<Attendance> findByEmployee_employee_id(Long employeeId);
    List<Attendance> findByEmployeeId(Long employeeId);

}
