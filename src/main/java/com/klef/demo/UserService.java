package com.klef.demo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class UserService 
{
	@Autowired
	UserRepository userrepo;
	@Autowired NamedParameterJdbcTemplate temp;
	public void adduser(Users u)
	{
		userrepo.save(u);
	}
	public Object getUserobject(String emailid)
	{
		System.out.println(userrepo.findById(emailid));
		return userrepo.findById(emailid);
	}
	public Users validateUser(String emailid, String password)
	{
		System.out.println(emailid + " " + password);
		try {
			MapSqlParameterSource map = new MapSqlParameterSource();
			map.addValue("emailid", emailid);
			map.addValue("password", password);
			System.out.println("came");
			System.out.println("1" + temp.queryForObject("select * from users where emailid=:emailid and password=:password", map, new UserRowMapper()));
			return temp.queryForObject("select * from users where emailid=:emailid and password=:password", map, new UserRowMapper());
		}
		catch(Exception e)
		{
			return null;
		}
	}
	private class UserRowMapper implements RowMapper<Users>{

		@Override
		public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
			Users user = new Users();
			user.setEmailid(rs.getString("emailid"));
			user.setUsername(rs.getString("username"));
			user.setCountry(rs.getString("country"));
			user.setCity(rs.getString("city"));
			user.setPassword(rs.getString("password"));
			return user;
		}
		
	}
}