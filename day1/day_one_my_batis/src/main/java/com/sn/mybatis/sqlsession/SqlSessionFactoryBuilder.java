package com.sn.mybatis.sqlsession;

import com.sn.mybatis.cfg.Configuration;
import com.sn.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.sn.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建一个SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {
    /**
     * 根据参数的字节输入流来构建一个sqlSessionFactory工厂
     * @param in
     * @return
     */
    public SqlSessionFactory build(InputStream in){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);
        return new DefaultSqlSessionFactory(cfg);
    }
}
