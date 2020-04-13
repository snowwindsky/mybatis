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

public class UserTest {
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
//        for(User user:userList){
//            System.out.println(user);
//        }
    }
    /**
     * 测试查找一个用户
     */
    @Test
    public void findUserById(){
        User user = userDao.findById(73);
        System.out.print(user);
    }
}
