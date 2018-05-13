package singleTable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class UserTest {

    @Test
    public void shouldPersistUser() {
        SessionFactory sessionFactory = new Configuration().
                configure().
                addAnnotatedClass(User.class).
                buildSessionFactory();

        User user = new User();
        user.setName("exampleName");
        user.setId(0);
        try (Session session = sessionFactory.openSession()) {
            //save object
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();

            //check object
            User persistedUser = session.get(User.class, 0);
            assertThat(persistedUser.getName()).isEqualTo("exampleName");
        } catch (HibernateException e) {
            e.printStackTrace();
            fail("Fail!");
        }
    }

}