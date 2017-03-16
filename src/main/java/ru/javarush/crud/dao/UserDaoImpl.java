package ru.javarush.crud.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javarush.crud.model.User;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {

    @Override
    public List<User>  findByName(String name) {
        List<User>  users = null;
        Criteria criteria = currentSession().createCriteria(User.class, "user");
        criteria.add(Restrictions.eq("user.name", name));
        users = (List<User> )criteria.list();
        return users;
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<User> getPageList(Integer offset, Integer maxResults){
        return currentSession()
                .createCriteria(User.class)
                .setFirstResult(offset!=null?offset:0)
                .setMaxResults(maxResults!=null?maxResults:10)
                .list();
    }

    public Long count(){
        return (Long)currentSession()
                .createCriteria(User.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }
}
