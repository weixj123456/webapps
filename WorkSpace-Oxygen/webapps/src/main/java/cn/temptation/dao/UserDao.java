package cn.temptation.dao;

import java.util.List;

import cn.temptation.domain.User;

public interface UserDao {
    public abstract User findByUsername(String username);
    
    public User findUserById(int id) throws Exception ;
    public List<User> findAllUsers() throws Exception;
    public void insertUser(User user) throws Exception;
    public void deleteUserById(int id) throws Exception;
    public void updateUserPassword(User user) throws Exception;

}
