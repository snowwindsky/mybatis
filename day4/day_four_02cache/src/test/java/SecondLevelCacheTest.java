import com.sn.dao.UserDao;
import com.sn.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class SecondLevelCacheTest {
    private InputStream in;
    SqlSessionFactory factory;

    @Before//测试方法之前执行
    public void init()throws Throwable{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
    }
    @After//测试方法之后执行
    public void destroy() throws Exception{
        in.close();
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void findUserById(){
        SqlSession session1 = factory.openSession();
        UserDao dao1 = session1.getMapper(UserDao.class);
        User user = dao1.findById(73);
        System.out.println(user);
        session1.close();//清空一级缓存
        SqlSession session2 = factory.openSession();
        UserDao dao2 = session2.getMapper(UserDao.class);
        User user1 = dao2.findById(73);
        System.out.println(user1);
        session2.close();
        System.out.println(user1 == user);
    }
}
