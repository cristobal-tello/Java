package com.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.AbstractSqlParameterSource;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("foodGroupDAO")
public class FoodGroupDAO 
{
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public FoodGroup getFoodGroup(int id)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		return jdbcTemplate.queryForObject("SELECT * FROM foodgroups where id=:id", 
				params,
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
	
	public Boolean addFoodGroup(String name, String description)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", name);
		params.addValue("description", description);
		
		return insertData(params, true);
		
		/*int rowsAffected = jdbcTemplate.update("INSERT INTO foodgroups (name, description) VALUES (:name, :description)", params);
		
		System.out.println("Rows affected: " + rowsAffected);
		
		return rowsAffected > 0;*/
	}
	
	public Boolean addFoodGroup2(FoodGroup foodGroup)
	{
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(foodGroup);
		return insertData(params, true);
		
		/*int rowsAffected = jdbcTemplate.update("INSERT INTO foodgroups (name, description) VALUES (:name, :description)", params);
		
		System.out.println("Rows affected: " + rowsAffected);
		
		return rowsAffected > 0;*/
	}
	
	private Boolean insertData(AbstractSqlParameterSource params, Boolean isInsert)
	{
		int rowsAffected = 0;
		
		if (isInsert) {
			rowsAffected = jdbcTemplate.update("INSERT INTO foodgroups (name, description) VALUES (:name, :description)", params);	
		}
		else {
			rowsAffected = jdbcTemplate.update("UPDATE foodgroups SET name=:name, description=:description WHERE id=:id", params);
		}
		
		System.out.println("Rows affected: " + rowsAffected);
		
		return rowsAffected > 0;
	}
	
	public Boolean updateFoodGroup(FoodGroup foodGroup)
	{
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(foodGroup);
		return insertData(params, false);
	}
	
	public Boolean delete(int id)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		int rowsAffected = jdbcTemplate.update("DELETE FROM foodgroups WHERE id=:id", params);
		
		System.out.println("Rows removed: " + rowsAffected);
		
		return rowsAffected > 0;
	}

	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired	// Autowired need it!!!!!
	public void setJdbcTemplate(DataSource ds) {
		System.out.println("setJbdcTemplate...");
		this.jdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}
}
