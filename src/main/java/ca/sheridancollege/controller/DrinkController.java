package ca.sheridancollege.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.Drink;
//import ca.sheridancollege.database.Database;
import ca.sheridancollege.database.DatabaseAccess;

@Controller
public class DrinkController {

	@Autowired
	private DatabaseAccess da;
	
	@GetMapping("/")
	public String goHome() {
		//for each is just to check the data here
		return "AddDrinks.html";
	}
	
	
	@GetMapping("/add")
	public String goAdd(@RequestParam String name,
			             @RequestParam String main,
			             @RequestParam double amount1,
			             @RequestParam String second,
			             @RequestParam double amount2,
			             @RequestParam String description,
			             Model model) {
	
		Drink drink2 = new Drink(name, main, amount1, second, amount2, description);
		da.addDrink(drink2);
	 
	    
	    List<Drink> drink = da.getDrink();
		

		model.addAttribute("drinks", drink);
		return "getData.html";
	}
	
	
}
