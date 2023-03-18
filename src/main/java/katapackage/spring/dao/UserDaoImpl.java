package katapackage.spring.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import katapackage.spring.model.User;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private final EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> getUserList() {
        return entityManager.createQuery("From User", User.class).getResultList();
    }

    public User show(int id) {
        return entityManager.createQuery("from User where id=:i", User.class)
                .setParameter("i", id).getSingleResult();
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(int id, User user) {
        User UpdUser = show(id);
        UpdUser.setName(user.getName());
        UpdUser.setLastname(user.getLastname());
        entityManager.merge(user);
    }

    public void delete(int id) {
        try {
            entityManager.remove(show(id));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
