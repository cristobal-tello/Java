package com.models;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;


// @Component("foodGroupDAO")
public class FoodGroupDAO 
{
	private NamedParameterJdbcTemplate myJdbcTemplate;
	
	public NamedParameterJdbcTemplate getMyJdbcTemplate() {
		return myJdbcTemplate;
	}

	public void setMyJdbcTemplate(DataSource ds) {
		this.myJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	private SimpleJdbcInsert insertFoodGroup;		// Simple insert
	
	private SimpleJdbcCall storeProcFoodGroup;		// Call an stored procedure
	
	private JdbcTemplate jdbcTemplate;
	
	
	// Perform inserts using SimpleJdbc classes, #1
	public int create_simple(FoodGroup foodGroup)
	{
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(foodGroup);	
		return insertFoodGroup.execute(params);
	}
	
	// Perform inserts using SimpleJdbc classes, #2
	public int create_simple_key(FoodGroup foodGroup)
	{
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(foodGroup);	
		Number insertID = insertFoodGroup.executeAndReturnKey(params);
		return insertID.intValue();
	}
	
	// Calling Stored Procedures Using SimpleJdbc Call
	public FoodGroup readFoodGroup(int groupId)
	{
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		params.addValue("in_id", groupId);
		
		Map<String, Object> outValues = storeProcFoodGroup.execute(params);
		
		FoodGroup out = new FoodGroup();
		
		out.setName((String) outValues.get("group_name")); 
		out.setDescription((String) outValues.get("group_description"));
		
		return out;
	}
	
	// Expected Return Types Using queryForObject
	public void demoMethod()
	{
		Integer value = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM foodgroups", Integer.class);
		System.out.println("Integer result: " + value.intValue());
		
		String value2 = jdbcTemplate.queryForObject("SELECT name FROM foodgroups WHERE id='3'", String.class);
		System.out.println("String result: " + value2);
		
		FoodGroup fg = jdbcTemplate.queryForObject("SELECT * FROM foodgroups WHERE id='2'",
				new RowMapper<FoodGroup>()
				{
					public FoodGroup mapRow(ResultSet rs, int rowNum) throws SQLException
					{
						// 	Of course, maybe it would be a good idea that FoodGroup will have a cctor instead to use setXXXXX methods
						FoodGroup fgOut = new FoodGroup();

						fgOut.setId(rs.getInt("id"));
						fgOut.setName(rs.getString("name"));
						fgOut.setDescription(rs.getString("description"));
						
						return fgOut;
					}
				}
				);
		System.out.println("Foodgroup result: " + fg.TalkAboutYourSelf());
	}
	
	// Declaring DAO in an XML Configuration
	public List<FoodGroup> getFoodGroups()
	{
		// Remove/Comment from the top of the class : 
		// @Component("FoodGroupDAO")
		// Also, the 	@Autowired on  setJdbcTemplate
		// In appContext.xml
		// <bean id="FoodGroupDAO" class="com.models.FoodGroupDAO">
		// <property name="myJdbcTemplate" ref="myDataSource"/>
		// </bean>	
		
		System.out.println("getFoodGroups...");
	
		return myJdbcTemplate.query("SELECT * FROM foodgroups",		// Set an invalid table name to check exceptions 
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
	
	
	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return myJdbcTemplate;
	}

	// @Autowired	// Autowired need it!!!!!
	public void setJdbcTemplate(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
		this.myJdbcTemplate = new NamedParameterJdbcTemplate(ds);
		// this.insertFoodGroup = new SimpleJdbcInsert(ds).withTableName("foodGroups");	// It works as well with create_simple
		this.insertFoodGroup = new SimpleJdbcInsert(ds).withTableName("foodGroups").usingGeneratedKeyColumns("id");// It works with simple_key
		this.storeProcFoodGroup = new SimpleJdbcCall(ds).withProcedureName("read_foodgroup_name_desc");
	}
}

