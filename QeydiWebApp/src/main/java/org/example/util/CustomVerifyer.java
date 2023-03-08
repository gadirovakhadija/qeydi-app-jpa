package org.example.util;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.example.dao.inter.UserDaoInter;
import org.example.entity.User;
import org.example.main.Context;

public interface CustomVerifyer {

     UserDaoInter userDao = Context.instanceUserDao();
    static BCrypt.Verifyer verifyer = BCrypt.verifyer();

    public static void passwordVerifyer(String email, String password){
        User user = userDao.getByEmail(email);

        if (user == null) {
            throw new IllegalArgumentException("Istifadeci tapilmadi");
        }

        BCrypt.Result rs = verifyer.verify(password.toCharArray(), user.getPassword().toCharArray());
        if (!rs.verified) {
            throw new IllegalArgumentException("Parol yanlishdir");
        }
    }
}
