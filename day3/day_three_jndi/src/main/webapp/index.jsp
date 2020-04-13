<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.sn.dao.UserDao" %>
<%@ page import="com.sn.domain.User" %>
<%@ page import="java.util.List" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    // 1.读取配置文件
    InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
    // 2.创建sqlSessionFactory工厂对象
    SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(in);
    // 3.使用工厂生产sqlSession对象
    SqlSession sqlSession = factory.openSession();
    // 4.使用sqlSession创建dao接口的代理对象
    UserDao userDao = sqlSession.getMapper(UserDao.class);
    // 5.使用代理对象执行方法
    List<User> userList = userDao.getAll();
    for(User user : userList){
        System.out.println(user);
    }
    // 6.释放资源
    sqlSession.close();
    in.close();
%>
</body>
</html>
