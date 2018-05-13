package collections.set.jointable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class ShowroomJoinTableTest {

    @Test
    public void shouldPersistShowroom() {
        SessionFactory sessionFactory = new Configuration().
                configure().
                addAnnotatedClass(Showroom2.class).
                addAnnotatedClass(Car2.class).
                buildSessionFactory();

        Showroom2 showroom = new Showroom2();
        showroom.setManager("manager2");
        Set<Car2> cars = new HashSet<>();
        cars.add(new Car2("name1", "color1"));
        cars.add(new Car2("name2", "color2"));
        showroom.setCar2s(cars);
        try (Session session = sessionFactory.openSession()) {
            //save object
            Transaction transaction = session.beginTransaction();
            session.save(showroom);
            transaction.commit();

            //check object
            Showroom2 persistedShowroom = (Showroom2) session.createQuery("from Showroom2").list().get(0);
            assertThat(persistedShowroom.getManager()).isEqualTo("manager2");
            assertThat(persistedShowroom.getCar2s()).hasSize(2);
            Car2 persistedCar1 = persistedShowroom.getCar2s().iterator().next();
            Car2 persistedCar2 = persistedShowroom.getCar2s().iterator().next();
            assertThat(persistedCar1.getColor()).containsPattern("color[12]");
            assertThat(persistedCar1.getName()).containsPattern("name[12]");
            assertThat(persistedCar2.getColor()).containsPattern("color[12]");
            assertThat(persistedCar2.getName()).containsPattern("name[12]");


            transaction = session.beginTransaction();
            session.delete(persistedShowroom);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            fail("Fail!");
        }
    }

}