package org.example.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.dao.inter.AbstractDao;
import org.example.dao.inter.TeachwayDaoInter;
import org.example.entity.Teachway;

import java.util.List;

public class TeachwayDaoImpl extends AbstractDao implements TeachwayDaoInter {


    @Override
    public List<Teachway> getAll() {
        EntityManager em=em();

        String jpql = "SELECT t from Teachway t";
        Query query = em.createQuery(jpql, Teachway.class);

        return query.getResultList();

    }

    @Override
    public Teachway getById(int teachwayId) {
        EntityManager em=em();
        Teachway t = em.find(Teachway.class,teachwayId);
        em.close();

        return t;
    }

    @Override
    public boolean updateTeachway(Teachway tw) {

        EntityManager em = em();

        em.getTransaction().begin();
        em.merge(tw);
        em.getTransaction().commit();

        em.close();
        return true;
    }

    @Override
    public boolean removeTeachway(int teachwayId) {

        EntityManager em= em();
        Teachway t = em.find(Teachway.class,teachwayId);

        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
        em.close();
        return true;
    }
}
