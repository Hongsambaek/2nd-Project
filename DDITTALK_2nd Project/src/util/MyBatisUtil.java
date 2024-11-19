package util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            // 1-1. XML설정 파일
            Charset charset = Charset.forName("UTF-8"); //설정파일의 인코딩정보 설정(한글처리를 위해서)
            Resources.setCharset(charset);

            Reader rd = Resources.getResourceAsReader("config/mybatis-config.xml");

            // 1-2. 위에서 읽어온 Reader객체를 이용하여 SqlSessionFactory 객체 생성
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);
            rd.close();    

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
    public static SqlSession getSqlSession(boolean autoCommit){
    	return sqlSessionFactory.openSession(autoCommit);
    }
	
}
