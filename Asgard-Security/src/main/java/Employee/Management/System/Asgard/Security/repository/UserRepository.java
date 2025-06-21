package Employee.Management.System.Asgard.Security.repository;
import Employee.Management.System.Asgard.Security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
