package ca.sheridancollege.beans;
import java.io.Serializable;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Drink implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String main;
	private double amount1;
	private String second;
	private double amount2;
	private String description;
	

}
