import com.sn.dao.UserDao;
import com.sn.domain.User;
import com.sn.mybatis.io.Resources;
import com.sn.mybatis.sqlsession.SqlSession;
import com.sn.mybatis.sqlsession.SqlSessionFactory;
import com.sn.mybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * mybatis的入门案例
 */
public class MybatisTest {
    public static void main(String[] args)throws Exception{
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建sqlSessionFactory工厂对象
        SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 3.使用工厂生产sqlSession对象
        SqlSession session = factory.openSession();
        // 4.使用sqlSession创建dao接口的代理对象
        UserDao userDao = session.getMapper(UserDao.class);
        // 5.使用代理对象执行方法
        List<User> userList = userDao.findAll();
        for(User user : userList){
            System.out.println(user);
        }
        // 6.释放资源
        session.close();
        in.close();
        }

}
