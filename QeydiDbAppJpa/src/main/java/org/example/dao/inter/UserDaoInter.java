package org.example.dao.inter;

import org.example.entity.User;

import java.util.List;

public interface UserDaoInter {
    public List<User> getAll(String name, String surname, String email, String password);

    public User getById(int userId);

    public Object getIdByEmailAndPassword(String email, String password);

    public Integer getIdByEmail(String email);

    public User getByEmailAndPassword(String email, String password);


    public User getByEmail(String email);

    public boolean removeUser(int userId);

    public boolean updateUser(User u);

    public boolean updatePassword(User u);

    public boolean addUser(User u);

    public User findByEmail(String email);

}
