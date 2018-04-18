package com.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("foodGroupDAO")
public class FoodGroupDAO 
{
	private JdbcTemplate jdbcTemplate;
	
	public List<FoodGroup> getFoodGroups()
	{
		System.out.println("getFoodGroups...");
		return jdbcTemplate.query("SELECT * FROM foodgroups", 
				new RowMapper<FoodGroup>()
				{
					public FoodGroup mapRow(ResultSet rs, int rowNum) throws SQLException
					{
						FoodGroup fg = new FoodGroup();
						
						fg.setId(rs.getInt("id"));
						fg.setName(rs.getString("name"));
						fg.setDescription(rs.getString("description"));
						
						return fg;
					}
					
				});
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired	// Autowired need it!!!!!
	public void setJdbcTemplate(DataSource ds) {
		System.out.println("setJbdcTemplate...");
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
}
