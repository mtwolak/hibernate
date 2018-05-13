package collections.list.foreignkey;

import org.assertj.core.util.Lists;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class ShowroomTest {

    @Test
    public void shouldPersistShowroom() {
        SessionFactory sessionFactory = new Configuration().
                configure().
                addAnnotatedClass(Showroom.class).
                addAnnotatedClass(Car.class).
                buildSessionFactory();

        Showroom showroom = new Showroom();
        showroom.setManager("manager1");
        showroom.setCars(Lists.newArrayList(new Car("name1", "color1"), new Car("name2", "color2")));
        try (Session session = sessionFactory.openSession()) {
            //save object
            Transaction transaction = session.beginTransaction();
            session.save(showroom);
            transaction.commit();

            //check object
            Showroom persistedShowroom = (Showroom) session.createQuery("from Showroom").list().get(0);
            assertThat(persistedShowroom.getManager()).isEqualTo("manager1");
            assertThat(persistedShowroom.getCars()).hasSize(2);
            assertThat(persistedShowroom.getCars().get(0).getName()).isEqualTo("name1");
            assertThat(persistedShowroom.getCars().get(0).getColor()).isEqualTo("color1");
            assertThat(persistedShowroom.getCars().get(1).getName()).isEqualTo("name2");
            assertThat(persistedShowroom.getCars().get(1).getColor()).isEqualTo("color2");

            transaction = session.beginTransaction();
            session.delete(persistedShowroom);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            fail("Fail!");
        }
    }


}