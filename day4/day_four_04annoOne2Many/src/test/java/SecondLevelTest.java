import com.sn.dao.AccountDao;
import com.sn.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class SecondLevelTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private AccountDao accountDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        accountDao =session.getMapper(AccountDao.class);
    }
    @After
    public void close() throws Exception{

        in.close();
    }
    @Test
    public void testFindById(){
        Account account = accountDao.findAccountByAId(1);
        System.out.println(account);
        session.close();
        SqlSession session2 = factory.openSession();
        AccountDao accountDao2 = session2.getMapper(AccountDao.class);
        Account account2 = accountDao2.findAccountByAId(1);
        System.out.println(account2);
    }
}
