package ru.javarush.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.javarush.crud.dao.GenericDao;
import ru.javarush.crud.dao.UserDao;
import ru.javarush.crud.model.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private GenericDao<User, Integer> genericDao;

    public UserServiceImpl() {
    }
    @Autowired
    public UserServiceImpl(@Qualifier("userDaoImpl") GenericDao<User, Integer> genericDao) {
        this.genericDao = genericDao;
        this.userDao = (UserDao)genericDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<User> getByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public List<User> getPageList(Integer offset, Integer maxResults) {
        return userDao.getPageList(offset, maxResults);
    }

    @Override
    public Long count() {
        return userDao.count();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<User> getAll() {
        return genericDao.getAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public User get(Integer id) {
        return genericDao.find(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void add(User entity) {
        genericDao.persist(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(User entity) {
        genericDao.update(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(User entity) {
        genericDao.remove(entity);
    }
}
