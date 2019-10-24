package ca.sheridancollege.database;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.beans.Drink;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public void addDrink(Drink drink) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO easy_drinks VALUES" +
		"(:name, :main, :amount1, :second, :amount2, :description)";
		
		parameters.addValue("name", drink.getName());
		parameters.addValue("main", drink.getMain());
		parameters.addValue("amount1", drink.getAmount1());
		parameters.addValue("second", drink.getSecond());
		parameters.addValue("amount2", drink.getAmount2());
		parameters.addValue("description", drink.getDescription());
		
		jdbc.update(query, parameters);
		//return drink;
	}
	//GET THE DATA FROM DATABASE
	public ArrayList<Drink> getDrink() {
		String q = "Select * from easy_drinks";
		
		ArrayList<Drink> drinks = new ArrayList<Drink>();
		List<Map<String, Object>> rows = jdbc.queryForList(q, new HashMap<String, Object>());
		
		//for each loop to read from array list
		for(Map<String, Object> row : rows) {
			Drink d = new Drink();
			d.setName ( (String) (row.get ("drink_name")  ));
			d.setMain ( (String) (row.get ("main")        ));
			d.setAmount1(( (BigDecimal)(row.get("amount1"))).doubleValue());
			d.setSecond((String)(row.get("second")));
			d.setAmount2(((BigDecimal)(row.get("amount2"))).doubleValue());
			d.setDescription( (String)(row.get ("description")));
			
			//add all the drinks in the array list
			drinks.add(d);
			
			
		}
		return drinks;
	}
	
	
	
}
