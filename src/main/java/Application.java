import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

       /* final String user = "postgres";
        final String password = "makeTeanotwar1";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);//получаем подключение к бд
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee WHERE id = 1")) {//создаём запрос к таблице
            System.out.println("Соединение установлено!");

            ResultSet resultSet = statement.executeQuery();//исполнить запрос

            while (resultSet.next()) {
                int employeeId = resultSet.getInt("id");
                System.out.println("Employee ID: " + employeeId);

                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");

                int age = resultSet.getInt("age");
                int cityId = resultSet.getInt("city_id");

                System.out.println("Name: " + firstName);
                System.out.println("Lastname: " + lastName);
                System.out.println("Gender: " + gender);
                System.out.println("Age: " + age);
                System.out.println("City_id: " + cityId);
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }*/

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        /*Create:*/
        Employee employee = new Employee("Boris", "Britva", "male", 47, 2);
        employeeDAO.createEmployee(employee);

        /*Get by id:*/
        System.out.println(employeeDAO.getEmployeeById(5));
        System.out.println("------");

        /*Get all employees:*/
        List<Employee> employeeList = employeeDAO.getAllEmployees();
        employeeList.forEach(System.out::println);

        /*Update employee:*/
        Employee emloyeeToUpdate = employeeList.get(2);
        emloyeeToUpdate.setAge(100);
        employeeDAO.updateEmployee(emloyeeToUpdate);

        /*Delete employee:*/
        employeeDAO.deleteEmployee(10);

    }
}
