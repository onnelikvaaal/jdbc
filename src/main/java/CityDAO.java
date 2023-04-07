import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public interface CityDAO {

    SessionFactory getSessionFactory();

    void createCity(City city);

    City getCityById(int id);

    List<City> getAllCities();

    void updateCity(City city);

    void deleteCity(City city);
}
