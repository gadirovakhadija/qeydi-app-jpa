package org.example.dao.inter;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDao {
    private static EntityManagerFactory emf = null;

    public EntityManager em() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("qeydiPU");
        }
        EntityManager entityManager = emf.createEntityManager();
        return entityManager;
    }

    public static void closeEmf() {
        emf.close();
    }

    public AbstractDao() {
    }
}
