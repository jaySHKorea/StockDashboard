package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import db.AuthService;
import db.ChangePasswordService;
import db.MemberDao;
import db.MemberRegisterService;
import db.StockDao;
import db.StockService;

@Configuration
@EnableTransactionManagement
public class DbConfig {

	// DB 연결
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		// 해결 방법 localhost아니고 %로 된 계정 생성 후 mysql cmd에서 데이터베이스 자체에
		//ALTER USER '아이디'@'localhost' IDENTIFIED WITH mysql_native_password BY '비밀번호'
		ds.setUrl("jdbc:mysql://localhost:3306/stockDashboard?characterEncoding=utf8&useSSL=false");
		ds.setUsername("seunghye");
		ds.setPassword("password");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(60000*3);
		ds.setTimeBetweenEvictionRunsMillis(1000*10);
		return ds;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}
	
	// database 관련 데이터, 쿼리 class
	@Bean
	public StockDao stockDao() {
		return new StockDao(dataSource());
	}
	
	//memberDao를 관리/regist하는 class
	@Bean
	public StockService stockService() {
		return new StockService(stockDao());
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	
	@Bean
	public AuthService authService() {
		AuthService authService = new AuthService();
		authService.setMemberDao(memberDao());
		return authService;
	}
}
