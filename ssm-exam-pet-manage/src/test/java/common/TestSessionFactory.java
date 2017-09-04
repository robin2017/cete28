package common;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class TestSessionFactory {

	ClassPathXmlApplicationContext ctx;
	@Before
	public void init() {
		ctx=new ClassPathXmlApplicationContext(
				"applicationContext.xml");
	}
	@Test
	public void testDataSource() {
		DataSource dataSource=(DataSource) 
				ctx.getBean("dataSource");
		Assert.assertNotEquals(null, dataSource);
		System.out.println("dataSource="+dataSource);
	}
	@Test
	public void testSessionFactory() {
		Object sessionFactory=
		ctx.getBean("sessionFactory");
		Assert.assertNotEquals(null, sessionFactory);
		System.out.println(sessionFactory);
	}
	
	
	
	@After
	public void destory() {
		ctx.close();
	}
}
