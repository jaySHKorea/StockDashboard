package db;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

// Stock Class에 대한 DB query 정의
public class StockDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public StockDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

}