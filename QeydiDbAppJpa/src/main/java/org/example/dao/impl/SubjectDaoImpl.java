package org.example.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.dao.inter.AbstractDao;
import org.example.dao.inter.SubjectDaoInter;
import org.example.entity.Subject;

import java.util.List;

public class SubjectDaoImpl extends AbstractDao implements SubjectDaoInter {


    @Override
    public List<Subject> getAll() {
        EntityManager em=em();

        String jpql = "SELECT s from Subject s";
        Query query = em.createQuery(jpql, Subject.class);

        return query.getResultList();
    }

    @Override
    public Subject getById(int subjectId) {
        EntityManager em=em();
        Subject s = em.find(Subject.class,subjectId);
        em.close();

        return s;
    }

    @Override
    public boolean updateSubject(Subject sb) {

        EntityManager em = em();

        em.getTransaction().begin();
        em.merge(sb);
        em.getTransaction().commit();

        em.close();
        return true;
    }

    @Override
    public boolean removeSubject(int subjectId) {

        EntityManager em= em();
        Subject s = em.find(Subject.class,subjectId);

        em.getTransaction().begin();
        em.remove(s);
        em.getTransaction().commit();
        em.close();
        return true;
    }

}
