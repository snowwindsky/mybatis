import com.sn.dao.RoleDao;
import com.sn.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class RoleTest {
    private RoleDao roleDao;
    SqlSessionFactory factory;
    private SqlSession session;
    private InputStream in;

    @Before//测试方法之前执行
    public void init()throws Throwable{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession();//设置自动提交
        roleDao =session.getMapper(RoleDao.class);
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
        List<Role> roles = roleDao.findAll();
        for(Role role : roles){
            System.out.println(role);
        }
    }
    /**
     * 测试查找一个用户
     */
    @Test
    public void findUserById(){
//        Role role = roleDao.findById(73);
//        System.out.print(role);
    }
}
