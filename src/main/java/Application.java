import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Employee employee = new Employee("Foma", "Kinyaev", "male", 28, 4);
        employeeDAO.createEmployee(entityManager, employee);

        List<Employee> employeeList = employeeDAO.getAllEmployees(entityManager);
        employeeList.forEach(System.out::println);

        for (Employee e : employeeList) {
            if (e.getFirstName().equals("Ivan") && e.getLastName().equals("Ivanov")) {
                e.setAge(30);
                e.setCityId(1);
                employeeDAO.updateEmployee(entityManager, e);
            }
        }

        System.out.println("-----");

        System.out.println(employeeDAO.getEmployeeById(entityManager, 1));

        for (Employee e : employeeList) {
            if (e.getId() == 12) {
                employeeDAO.deleteEmployee(entityManager, e);
            }
        }

        System.out.println("-----");

        List<Employee> employeeList1 = employeeDAO.getAllEmployees(entityManager);
        employeeList1.forEach(System.out::println);

        entityManager.close();
        entityManagerFactory.close();


    }
}
