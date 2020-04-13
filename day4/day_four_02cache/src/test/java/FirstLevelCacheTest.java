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

public class FirstLevelCacheTest {
    private UserDao userDao;
    SqlSessionFactory factory;
    private SqlSession session;
    private InputStream in;

    @Before//测试方法之前执行
    public void init()throws Throwable{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession();//设置自动提交
        userDao =session.getMapper(UserDao.class);
    }
    @After//测试方法之后执行
    public void destroy() throws Exception{
        session.commit();
        session.close();
        in.close();
    }

    /**
     * 测试获取所有
     */
    @Test
    public void getAllUser() {
        List<User> userList = userDao.getAll();
        for(User user:userList){
            System.out.println(user);
        }
    }
    /**
     * 测试一级缓存
     */
    @Test
    public void findUserById(){
        User user = userDao.findById(73);
        System.out.println(user);
//        session.clearCache();//清空一级缓存
        User user1 = userDao.findById(73);
        System.out.println(user1);
        System.out.println(user1 == user);
    }
    /**
     * 测试更新后对一级缓存的影响
     */
    @Test
    public void update(){
        User user = userDao.findById(73);
        System.out.println(user);
        user.setUsername("sssss");
        userDao.update(user);
        User user1 = userDao.findById(73);
        System.out.println(user1);
        System.out.println(user1 == user);
    }
}
