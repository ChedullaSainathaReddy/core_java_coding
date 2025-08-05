package com.vcube.SpringTask;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Person> getAll() {
		return jdbcTemplate.query("SELECT * FROM person", (rs, rowNum) -> new Person(rs.getInt("id"), rs.getInt("age"),
				rs.getString("first_name"), rs.getString("last_name")));
	}
//
//	@Override
//	public Person getById(int id) {
//		return jdbcTemplate.queryForObject("SELECT * FROM person WHERE id = ?", new Object[] { id },
//				(rs, rowNum) -> new Person(rs.getInt("id"), rs.getInt("age"), rs.getString("first_name"),
//						rs.getString("last_name")));
//	}
	@Override
	public Person getById(int id) {
	    try {
	        return jdbcTemplate.queryForObject(
	            "SELECT * FROM person WHERE id = ?",
	            new Object[]{id},
	            (rs, rowNum) -> new Person(
	                rs.getInt("id"),
	                rs.getInt("age"),
	                rs.getString("first_name"),
	                rs.getString("last_name")
	            )
	        );
	    } catch (EmptyResultDataAccessException e) {
	        System.out.println("No person found with ID " + id);
	        return null;
	    }
	}


	@Override
	public void create(Person person) {
		jdbcTemplate.update("INSERT INTO person (age, first_name, last_name) VALUES (?, ?, ?)", person.getAge(),
				person.getFirstName(), person.getLastName());
	}

	@Override
	public void update(Person person) {
		jdbcTemplate.update("UPDATE person SET age=?, first_name=?, last_name=? WHERE id=?", person.getAge(),
				person.getFirstName(), person.getLastName(), person.getId());
	}

	@Override
	public void delete(int id) {
		jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
	}

}
