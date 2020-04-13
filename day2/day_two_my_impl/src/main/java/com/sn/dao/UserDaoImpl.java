package com.sn.dao;

import com.sn.domain.QueryVo;
import com.sn.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao{
    private SqlSessionFactory factory;
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }
    public List<User> getAll() {
        SqlSession session = factory.openSession();
        List<User> userList= session.selectList("com.sn.dao.UserDao.getAll");
        session.commit();
        session.close();
        return userList;
    }

    public void saveUser(User user) {
        SqlSession session = factory.openSession();
        session.insert("com.sn.dao.UserDao.saveUser",user);
        session.commit();
        session.close();
    }

    public void updateUser(User user) {
        SqlSession session = factory.openSession();
        session.update("com.sn.dao.UserDao.updateUser",user);
        session.commit();
        session.close();
    }

    public void deleteUser(Integer id) {
        SqlSession session = factory.openSession();
        session.update("com.sn.dao.UserDao.deleteUser",id);
        session.commit();
        session.close();
    }

    public User findById(Integer id) {
        SqlSession session = factory.openSession();
        User user = session.selectOne("com.sn.dao.UserDao.findById",id);
        session.commit();
        session.close();
        return user;
    }

    public List<User> findUserByName(String name) {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.sn.dao.UserDao.findByName",name);
        session.commit();
        session.close();
        return users;
    }

    public Integer getCount() {
        SqlSession session = factory.openSession();
        int count = session.selectOne("com.sn.dao.UserDao.getCount");
        session.commit();
        session.close();
        return count;
    }

    public List<User> findByName(QueryVo queryVo) {
        return null;
    }
}
