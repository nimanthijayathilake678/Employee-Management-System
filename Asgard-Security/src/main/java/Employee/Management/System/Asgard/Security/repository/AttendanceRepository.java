package Employee.Management.System.Asgard.Security.repository;

import Employee.Management.System.Asgard.Security.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository  extends JpaRepository<Attendance,Long> {
}
