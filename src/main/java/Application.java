import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        /*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Employee employee = new Employee("Alen", "Delon", "male", 55, 4);
        employeeDAO.createEmployee(entityManager, employee);

        List<Employee> employeeList = employeeDAO.getAllEmployees(entityManager);
        employeeList.forEach(System.out::println);

        for (Employee e : employeeList) {
            if (e.getFirstName().equals("Ivan") && e.getLastName().equals("Ivanov")) {
                e.setAge(31);
                e.setCityId(2);
                employeeDAO.updateEmployee(entityManager, e);
            }
        }

        System.out.println("-----");

        System.out.println(employeeDAO.getEmployeeById(entityManager, 1));

        for (Employee e : employeeList) {
            if (e.getId() == 1) {
                employeeDAO.deleteEmployee(entityManager, e);
            }
        }

        System.out.println("-----");

        List<Employee> employeeList1 = employeeDAO.getAllEmployees(entityManager);
        employeeList1.forEach(System.out::println);

        entityManager.close();
        entityManagerFactory.close();*/


        CityDAO cityDAO = new CityDAOImpl();
        cityDAO.getSessionFactory().openSession();

        /*City city = new City("Tbilisi");
        Employee kot = new Employee("Kot", "Narkot", "male", 2, city);
        Employee utka = new Employee("Gospodin", "Utka", "male", 5, city);
        city.getEmployeeList().add(kot);
        city.getEmployeeList().add(utka);

        cityDAO.createCity(city);*/

        /*City city = cityDAO.getCityById(6);
        for (Employee e : city.getEmployeeList()) {
            if (e.getFirstName().equals("Kot")) {
                e.setLastName("Begemot");
            }
        }
        cityDAO.updateCity(city);*/

        City city = cityDAO.getCityById(1);
        cityDAO.deleteCity(city);

        cityDAO.getSessionFactory().close();


    }
}
