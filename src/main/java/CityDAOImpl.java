import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.List;

public class CityDAOImpl implements CityDAO {

    private static SessionFactory sessionFactory;

    @Override
    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(City.class);
                configuration.addAnnotatedClass(Employee.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    @Override
    public void createCity(City city) {
        Session session = getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(city);
        transaction.commit();
        //getSessionFactory().close();
    }

    @Override
    public City getCityById(int id) {
        Session session = getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        City city = session.get(City.class, id);
        //getSessionFactory().close();
        transaction.commit();
        return city;
    }

    @Override
    public List<City> getAllCities() {
        Session session = getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<City> cities = session.createQuery("SELECT c FROM City c", City.class).getResultList();
        //getSessionFactory().close();;
        transaction.commit();
        return cities;
    }

    @Override
    public void updateCity(City city) {
        Session session = getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.merge(city);
        transaction.commit();
        //getSessionFactory().close();
    }

    @Override
    public void deleteCity(City city) {
        Session session = getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(city);
        transaction.commit();
        //getSessionFactory().close();
    }
}
