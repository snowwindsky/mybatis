package com.sn.mybatis.sqlsession.defaults;

import com.sn.mybatis.cfg.Configuration;
import com.sn.mybatis.sqlsession.SqlSession;
import com.sn.mybatis.sqlsession.SqlSessionFactory;

/**
 * sqlSessionFactory接口的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory{
    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }

    public SqlSession openSession(){
        return  new DefaultSqlSession(cfg);
    }
}
