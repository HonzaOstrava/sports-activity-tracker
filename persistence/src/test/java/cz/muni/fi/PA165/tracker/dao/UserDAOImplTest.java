package cz.muni.fi.PA165.tracker.dao;

import cz.muni.fi.PA165.tracker.entities.User;
import cz.muni.fi.PA165.tracker.enums.Gender;
import org.testng.Assert;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import javax.inject.Inject;



/**
 * Tests for UserDAOImpl class.
 * @author pmikova 4333454
 */

//@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class UserDAOImplTest {

    @Inject
    private UserDAO userDAO;
    @PersistenceContext
    private EntityManager entityManager;

    private User user1;
    private User user2;
    private User user3;
    private User user4;

    @BeforeMethod
    public void setUp() {
        //user1 setup
        user1 = new User();
        user1.setEmail("johnd@email.com");
        user1.setGender(Gender.MALE);
        user1.setName("John");
        user1.setSurname("Doe");
        user1.setWeight(90);
        user1.setPasswordHash("password");
        LocalDate bdate = LocalDate.of(1950,10,13);
        user1.setBirthdate(bdate);

        //user2 setup
        user2 = new User();
        user2.setEmail("lucy@email.com");
        user2.setGender(Gender.FEMALE);
        user2.setName("Lucy");
        user2.setSurname("Doe");
        user2.setWeight(55);
        user2.setPasswordHash("password2");
        LocalDate bdate2 = LocalDate.of(1991, 8, 16);
        user2.setBirthdate(bdate2);

        //user3 setup
        user3 = new User();
        user3.setEmail("john@email.com");
        user3.setGender(Gender.MALE);
        user3.setName("John");
        user3.setSurname("Snow");
        user3.setWeight(110);
        user3.setPasswordHash("password3");
        LocalDate bdate3 = LocalDate.of(1980, 5, 21);
        user3.setBirthdate(bdate3);

        //user4 setup
        user4 = new User();
        user4.setEmail("kira@email.com");
        user4.setGender(Gender.FEMALE);
        user4.setName("Kira");
        user4.setSurname("Stewart");
        user4.setWeight(74);
        user4.setPasswordHash("password4");
        LocalDate bdate4 = LocalDate.of(1975, 11, 11);
        user4.setBirthdate(bdate4);
    }
    @Test
    public void testCreate(){
        userDAO.create(user1);
        Assert.assertEquals(this.userDAO.getById(user1.getId()), user1);
    }
    @Test
    public void testGetById(){


    }
    @Test
    public void testGetByEmail(){


    }
    @Test
    public void testGetAll(){
        entityManager.persist(user3);
        entityManager.persist(user4);
        entityManager.persist(user1);
        entityManager.flush();
        Assert.assertEquals(userDAO.getAll().size(), 3);
    }
    @Test
    public void testUpdate(){
        entityManager.persist(user2);
        entityManager.flush();
        user2.setName("Susan");
        user2.setWeight(50);
        user2.setPasswordHash("greatPassword");
        userDAO.update(user2);
        Assert.assertEquals(userDAO.getById(user2.getId()), user2);
    }

    @Test
    public void testDelete(){
        entityManager.persist(user3);
        entityManager.flush();
        userDAO.delete(user3);
        Assert.assertNull(userDAO.getById(user3.getId()));
    }



}