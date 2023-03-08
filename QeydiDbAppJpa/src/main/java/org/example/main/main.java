package org.example.main;

import jakarta.persistence.EntityManager;
import org.example.dao.impl.TeachwayDaoImpl;
import org.example.dao.impl.UserDaoImpl;
import org.example.dao.inter.UserDaoInter;
import org.example.entity.Subject;
import org.example.entity.Teachway;
import org.example.entity.User;

public class main {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();

//        User u = new User(15, "hadi", "surname", 21, "university", 34, "experience", 3, 4, "code", 53);
//        User u = new User(1,"12345");
        System.out.println(userDao.getIdByEmail("ibrahimlirashad\"gamilşcom"));
//        TeachwayDaoImpl tw = new TeachwayDaoImpl();
//        System.out.println(userDao.newr(u));

//        System.out.println(userDao.getByEmailAndPassword("khadija@gmail",
//                "$2a$04$Jpy6lNDpadWcuWOJ9oi9POHbV1tta7oPcom2HN5oyj.7DEb1pLQOe"));
//        System.out.println((User)userDao.getByEmail("khadija@gmail"));
//        System.out.println(userDao.getByTeachway("Magistratura"));

    }
}
