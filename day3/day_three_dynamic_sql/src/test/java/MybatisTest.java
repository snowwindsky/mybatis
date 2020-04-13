import com.sn.dao.UserDao;
import com.sn.domain.QueryVo;
import com.sn.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private UserDao userDao;
    SqlSessionFactory factory;
    private SqlSession session;
    private InputStream in;

    @Before//测试方法之前执行
    public void init()throws Throwable{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession(true);//设置自动提交
        userDao =session.getMapper(UserDao.class);
    }
    @After//测试方法之后执行
    public void destroy() throws Exception{
//        session.commit();
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
     * 测试查找一个用户
     */
    @Test
    public void findUserById(){
        User user = userDao.findById(73);
        System.out.print(user);
    }
    /**
     * 测试模糊查询
     */
    @Test
    public void  findUserByName(){
        List<User> users = userDao.findUserByName("%王%");
//        List<User> users = userDao.findUserByName("王");字符串拼接方式
        for(User user: users){
            System.out.println(user);
        }
    }

    @Test
    public void testQueryVo(){
        User user =new User();
        user.setUserName("%王%");
        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user);
        List<User> users = userDao.findByName(queryVo);
        for(User user1:users){
            System.out.println(user1);
        }
    }

    /**
     * 根据条件查询
     */
    @Test
    public void testByCondition(){
        User user =new User();
        user.setUserName("王天");
        user.setUserSex("女");
        List<User> users = userDao.findUserByCondition(user);
        for(User user1: users){
            System.out.println(user1);
        }
    }
    @Test
    public void getUsersByIds(){
        QueryVo queryVo = new QueryVo();
        List<Integer> ids =new ArrayList<Integer>();
        ids.add(74);
        ids.add(75);
        queryVo.setIds(ids);
        List<User> users = userDao.findUserByIds(queryVo);
        for(User user: users){
            System.out.println(user);
        }
    }
}
