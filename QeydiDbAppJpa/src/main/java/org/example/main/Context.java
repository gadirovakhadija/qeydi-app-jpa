package org.example.main;

import org.example.dao.impl.SubjectDaoImpl;
import org.example.dao.impl.TeachwayDaoImpl;
import org.example.dao.impl.UserDaoImpl;
import org.example.dao.inter.SubjectDaoInter;
import org.example.dao.inter.TeachwayDaoInter;
import org.example.dao.inter.UserDaoInter;

public class Context {
    public static UserDaoInter instanceUserDao(){
        return new UserDaoImpl();
    }
    public static TeachwayDaoInter instanceTeacwayDao(){
        return new TeachwayDaoImpl();
    }
    public static SubjectDaoInter instanceSubjectDao(){
        return new SubjectDaoImpl();
    }
}
