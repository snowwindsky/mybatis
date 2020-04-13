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
     * 测试保存用户
     */
    @Test
    public void saveUser(){
        User user = new User();
        user.setUsername("userdaoImpl_save");
        user.setUserAddress("龙湾");
        user.setUserBirthday(new Date());
        user.setUserSex("男");
        System.out.println(user);
        userDao.saveUser(user);
        System.out.println(user);
    }

    /**
     * 测试更新用户
     */
    @Test
    public void updateUser(){
        User user = new User();
        user.setUserId(73);
        user.setUsername("mybatis");
        user.setUserAddress("金王府");
        user.setUserBirthday(new Date());
        user.setUserSex("女");
        userDao.updateUser(user);
    }
    /**
     * 测试删除用户
     */
    @Test
    public void deleteUser(){
        userDao.deleteUser(78);
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

    /**
     * 测试获取总数
     */
    @Test
    public void getCount(){
        System.out.println(userDao.getCount());
    }

    @Test
    public void testQueryVo(){
        User user =new User();
        user.setUsername("%王%");
        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user);
        List<User> users = userDao.findByName(queryVo);
        for(User user1:users){
            System.out.println(user1);
        }
    }
}
