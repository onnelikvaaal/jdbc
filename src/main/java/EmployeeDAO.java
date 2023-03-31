import javax.persistence.EntityManager;
import java.util.List;

public interface EmployeeDAO {

    void createEmployee(EntityManager entityManager, Employee employee);

    Employee getEmployeeById(EntityManager entityManager, int id);

    List<Employee> getAllEmployees(EntityManager entityManager);

    void updateEmployee(EntityManager entityManager, Employee employee);

    void deleteEmployee(EntityManager entityManager, Employee employee);
}
