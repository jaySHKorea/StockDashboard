// 회원 데이터를 저장하는 곳(클래스)
package db;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.sql.Connection;
import java.sql.PreparedStatement;


import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;



public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	private RowMapper<Member> memRowMapper = 
			new RowMapper<Member>() {
		@Override
		public Member mapRow(ResultSet rs, int rowNum)
				throws SQLException {
				Member member = new Member(
						rs.getString("EMAIL"),
						rs.getString("PASSWORD"),
						rs.getString("Name"),
						rs.getTimestamp("REGDATE").toLocalDateTime());
				member.setId(rs.getLong("ID"));
				return member;
		}
	};
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query(
				"select * from stockDashboard.MEMBER where EMAIL =?",
				memRowMapper,email);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public void insert(final Member member) {
		/*
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(
						"insert into stockDashboard.MEMBER (EMAIL,PASSWORD,NAME,REGDATE) "+
				"values (?,?,?,?)",
				new String[] {"ID"} );
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, 
						Timestamp.valueOf(member.getRegisterDateTime()));
				return pstmt;
			}
		},keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
		*/
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(
						"insert into stockDashboard.MEMBER (EMAIL, PASSWORD, NAME, REGDATE) " +
						"values (?, ?, ?, ?)",
						new String[] { "ID" });
				// 인덱스 파라미터 값 설정
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4,
						Timestamp.valueOf(member.getRegisterDateTime()));
				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
	}
	
	public void update(Member member) {
		
		jdbcTemplate.update(
				"update stockDashboard.MEMBER set NAME =?, PASSWORD =? where EMAIL = ?",
				member.getName(), member.getPassword(), member.getEmail());
		
	}
	
	public List<Member> selectAll(){
		List<Member> results = jdbcTemplate.query(
				"select * from stockDashboard.MEMBER",
				memRowMapper);

		return results;
	}
	
	public int count() {
		/*
		List<Integer> results = jdbcTemplate.query(
				"select count(*) from Member",
				new RowMapper<Integer>() {
					@Override
					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException{
						return rs.getInt(1);
					}
				}); */
		Integer count = jdbcTemplate.queryForObject(
				"select count(*) from stockDashboard.MEMBER", Integer.class);
		return count;
	}
	
	public List<Member> selectByRegdate(
			LocalDateTime from, LocalDateTime to){
		List<Member> results = jdbcTemplate.query(
				"select * from stockDashboard.MEMBER where REGDATE between ? and ? "+
		"order by REGDATE desc",
		memRowMapper,from,to);
		return results;		
	}
	
	public Member selectById(Long memId) {
		List<Member> results = jdbcTemplate.query(
				"select * from stockDashboard.MEMBER where ID = ?", memRowMapper, memId);
		return results.isEmpty() ? null : results.get(0);
	}
}
