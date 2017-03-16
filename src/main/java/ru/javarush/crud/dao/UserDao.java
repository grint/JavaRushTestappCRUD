package ru.javarush.crud.dao;

import ru.javarush.crud.model.User;

import java.util.List;

public interface UserDao extends GenericDao<User, Integer> {
        public List<User> findByName(String name);
        public List<User> getPageList(Integer offset, Integer maxResults);
        public Long count();
}
