package org.example.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.dao.inter.AbstractDao;
import org.example.dao.inter.UserDaoInter;
import org.example.entity.User;

import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    @Override
    public List<User> getAll(String name, String surname, String email, String password) {

        EntityManager em = em();

        String jpql = "SELECT u from User u where 1=1";

        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name ";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname ";
        }
        if (email != null && !email.trim().isEmpty()) {
            jpql += " and u.email=:email ";
        }
        if (password != null && !password.trim().isEmpty()) {
            jpql += " and u.password=:password ";
        }

        Query query = em.createQuery(jpql, User.class);

        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }
        if (email != null && !email.trim().isEmpty()) {
            query.setParameter("email", email);
        }
        if (password != null && !password.trim().isEmpty()) {
            query.setParameter("password", password);
        }

        return query.getResultList();
    }

    @Override
    public User getById(int userId) {
        EntityManager em = em();

        User u = em.find(User.class, userId);
        em.close();

        return u;
    }

    @Override
    public Integer getIdByEmailAndPassword(String email, String password) {
        EntityManager em = em();

        String jpql = "SELECT u.id from User u where u.email=:email and u.password=:password";
        Query query = em.createQuery(jpql, User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);

        List<Integer> i = query.getResultList();

        if (i.size() == 1) {
            return i.get(0);
        }
        return null;
    }

    @Override
    public Integer getIdByEmail(String email) {
        EntityManager em = em();

        String jpql = "SELECT u.id from User u where u.email=:email ";
        Query query = em.createQuery(jpql, User.class);
        query.setParameter("email", email);

        List<Integer> i = query.getResultList();
        if (i.size() == 1) {
            return i.get(0);

        }
        return null;
    }

    @Override
    public User getByEmail(String email) {
        EntityManager em = em();

        String jpql = "SELECT u from User u where u.email=:email ";
        Query query = em.createQuery(jpql, User.class);
        query.setParameter("email", email);

        List<User> user = query.getResultList();
        if (user.size() == 1) {
            return user.get(0);
        }
        return null;
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        EntityManager em = em();

        String jpql = "SELECT u from User u where u.email=:email and u.password=:password";
        Query query = em.createQuery(jpql, User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);

        List<User> user = query.getResultList();
        if (user.size() == 1) {
            return user.get(0);
        }
        return null;
    }

    @Override
    public boolean removeUser(int userId) {
        EntityManager em = em();

        User u = em.find(User.class, userId);

        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    //
    private static BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public boolean updateUser(User u) {
        EntityManager em = em();
        User user = em.find(User.class, u.getId());

        user.setId(u.getId());
        user.setName(u.getName());
        user.setSurname(u.getSurname());
        user.setAge(u.getAge());
        user.setUniversity(u.getUniversity());
        user.setPoint(u.getPoint());
        user.setExperience(u.getExperience());
        user.setTeachwayId(u.getTeachwayId());
        user.setSubjectId(u.getSubjectId());
        user.setCode(u.getCode());
        user.setCost(u.getCost());

        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();

        em.close();
        return true;
    }

    @Override
    public boolean updatePassword(User u) {
        EntityManager em = em();
        User f = em.find(User.class, u.getId());

        f.setPassword(crypt.hashToString(4, f.getPassword().toCharArray()));

        em.getTransaction().begin();
        em.merge(f);
        em.getTransaction().commit();

        em.close();
        return true;
    }

    @Override
    public boolean addUser(User u) {

        EntityManager em = em();

        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();

        em.close();
        return true;
    }

    //    Criteria Builder
    @Override
    public User findByEmail(String email) {
        EntityManager em = em();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> q1 = cb.createQuery(User.class);
        Root<User> postRoot = q1.from(User.class);
        CriteriaQuery<User> q2 = q1
                .where(cb.equal(postRoot.get("email"), email));


        Query query = em.createQuery(q2);

        List<User> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }

        return null;

    }
}
