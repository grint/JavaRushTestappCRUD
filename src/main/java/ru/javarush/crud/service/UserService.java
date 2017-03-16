package ru.javarush.crud.service;

import ru.javarush.crud.model.User;

import java.util.List;

public interface UserService {
    public List<User> getByName(String name);
    public List<User> getPageList(Integer offset, Integer maxResults);
    public Long count();
    public List<User> getAll();
    public User get(Integer id);
    public void add(User entity);
    public void update(User entity);
    public void delete(User entity);
}
