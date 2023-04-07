import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    /*JDBC version
    @Override
    public void createEmployee(Employee employee) {
        String query = "INSERT INTO employee (first_name, last_name, gender, age, city_id) " +
                "VALUES ((?), (?), (?), (?), (?))";
        try (final Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement(query)) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCityId());
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    public void createEmployee(EntityManager entityManager, Employee employee) {
        entityManager.getTransaction().begin();

        entityManager.persist(employee);

        entityManager.getTransaction().commit();
    }

    /* JDBC version
    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        try (final Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int employeeId = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int cityId = resultSet.getInt("city_id");

             employee = new Employee(employeeId, firstName, lastName, gender, age, cityId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }*/

    @Override
    public Employee getEmployeeById(EntityManager entityManager, int id) {
        entityManager.getTransaction().begin();

        String jpqlQuery = "SELECT e FROM Employee e WHERE e.id = :id";
        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);
        query.setParameter("id", id);
        Employee employee = query.getSingleResult();

        entityManager.getTransaction().commit();

        return employee;
    }

    /* JDBC version
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (final Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int cityId = resultSet.getInt("city_id");

                employees.add(new Employee(id, firstName, lastName, gender, age, cityId));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }*/

    @Override
    public List<Employee> getAllEmployees(EntityManager entityManager) {
        entityManager.getTransaction().begin();

        String jpqlQuery = "SELECT e FROM Employee e";
        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);

        List<Employee> employee = query.getResultList();

        entityManager.getTransaction().commit();

        return employee;
    }

    /*JDBC version
    @Override
    public void updateEmployee(Employee employee) {
        String query = "UPDATE employee SET first_name = (?), last_name = (?), gender = (?), age = (?), city_id = (?) " +
                "WHERE id = (?)";
        try (final Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement(query)) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCityId());
            statement.setInt(6, employee.getId());
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    public void updateEmployee(EntityManager entityManager, Employee employee) {
        entityManager.getTransaction().begin();

        entityManager.merge(employee);

        entityManager.getTransaction().commit();
    }

    /*JDBC version
    @Override
    public void deleteEmployee(int id) {
        try (final Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement("DELETE FROM employee WHERE id = (?)")) {
            statement.setInt(1, id);
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    public void deleteEmployee(EntityManager entityManager, Employee employee) {
        entityManager.getTransaction().begin();

        entityManager.remove(employee);

        entityManager.getTransaction().commit();
    }
}
