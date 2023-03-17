package katapackage.spring.service;


import katapackage.spring.dao.UserDao;
import katapackage.spring.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    public UserServiceImpl(UserDao dao){
        userDao=dao;
    }


    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }



    @Override
    @Transactional
    public void update(int id, User user) {
        userDao.update(id, user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUserList();
    }

    @Override
    public User show(int id) {
        return userDao.show(id);
    }



}