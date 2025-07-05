package Employee.Management.System.Asgard.Security.repository;

import Employee.Management.System.Asgard.Security.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttendanceRepository  extends JpaRepository<Attendance,Long> {
    //List<Attendance> findByemployeeId(Long employeeId);
    //List<Attendance> findByAttendance_Employee_employee_id(Long employeeId);
    //List<Attendance> findByEmployeeId(Long employeeId);
    @Query("SELECT a FROM Attendance a WHERE a.employee.employee_id = :employeeId")
    List<Attendance> findAttendanceByEmployeeId(@Param("employeeId") Long employeeId);

}
