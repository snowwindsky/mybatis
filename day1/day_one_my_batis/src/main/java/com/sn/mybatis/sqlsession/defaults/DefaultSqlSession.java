package com.sn.mybatis.sqlsession.defaults;

import com.sn.mybatis.cfg.Configuration;
import com.sn.mybatis.sqlsession.SqlSession;
import com.sn.mybatis.sqlsession.proxy.MapperProxy;
import com.sn.mybatis.utils.DataSourceUtils;

import java.lang.reflect.Proxy;
import java.sql.Connection;

public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection connection;
    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        connection = DataSourceUtils.getConnection(cfg);
    }
    /**
     * 用于创建代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),connection));
    }

    public void close() {
        if(connection != null)
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
