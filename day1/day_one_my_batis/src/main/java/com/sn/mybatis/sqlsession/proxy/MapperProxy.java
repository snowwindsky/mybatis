package com.sn.mybatis.sqlsession.proxy;

import com.sn.mybatis.cfg.Mapper;
import com.sn.mybatis.utils.Executor;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler{
    private Map<String,Mapper> mappers;
    private Connection conn;
    public MapperProxy(Map<String,Mapper> mappers,Connection conn){
        this.mappers = mappers;
        this.conn = conn;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        1.获取方法名
        String methodsName = method.getName();
//        2.获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
//        3.组合key
        String key = className+"."+methodsName;
//        4.获取mappers的Mapper对象
        Mapper mapper = mappers.get(key);
//        5.判断是否有mapper
        if(mapper == null){
            throw new IllegalArgumentException("传入参数有误");
        }
//        6.调用工具类执行查询所有
        return new Executor().selectList(mapper,conn);
    }
}
