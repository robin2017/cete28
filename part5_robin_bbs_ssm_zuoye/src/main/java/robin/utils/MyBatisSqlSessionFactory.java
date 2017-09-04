package robin.utils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory;

	public static SqlSessionFactory getSqlSessionFactory() {
		InputStream in=null;
		try {
		in=Resources.getResourceAsStream(
				"mybatis-config.xml");
		sqlSessionFactory=
		new SqlSessionFactoryBuilder().build(in);
		}catch(IOException e) {
		throw new RuntimeException(e.getCause());
		}finally {
		if(in!=null)try{in.close();}catch(Exception e) {}
		}
		return sqlSessionFactory;
		
	}
	public static SqlSession getSqlSession() {
		return getSqlSessionFactory().openSession();
	}
	
}
