import com.sn.dao.AccountDao;
import com.sn.domain.Account;
import com.sn.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private AccountDao accountDao;
    SqlSessionFactory factory;
    private SqlSession session;
    private InputStream in;

    @Before//测试方法之前执行
    public void init()throws Throwable{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession();
        accountDao = session.getMapper(AccountDao.class);
    }
    @After//测试方法之后执行
    public void destroy() throws Exception{
        session.commit();
        session.close();
        in.close();
    }

    /**
     * 测试获取所有账号信息
     */
    @Test
    public void findAll(){
        List<Account> accounts = accountDao.getAll();
        for(Account account:accounts){
            System.out.println(account);
        }
    }

    /**
     * 查询所有账户，同时包含所有用户名及地址
     */
    @Test
    public void findAllAccountUser(){
        List<AccountUser> accountUsers = accountDao.getAllAccountUser();
        for(AccountUser accountUser:accountUsers){
            System.out.println(accountUser);
        }
    }
}
