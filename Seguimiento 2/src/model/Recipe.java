package model;

import exception.*;
import java.util.ArrayList;
import java.util.List;

public class Recipe {
	private List<Ingredient> ingredients;
	public Recipe() {
		ingredients = new ArrayList<Ingredient>();
	}
	
	public void addIngredient(String n, double w) {
		
		Ingredient searched = null;
		for (int i = 0; i < ingredients.size() && searched==null; i++) {
			Ingredient current = ingredients.get(i);
			if(current.getName().equals(n)) {
				searched = current;
			}
		}
		
		if(searched!=null) {
			try{
				searched.addWeight(w);
				System.out.println("Ingredient already exists, weight added");
			}catch(NegativeNumberException e) {
				
			}
		}else {
			Ingredient newIngredient = new Ingredient(n, w);
			ingredients.add(newIngredient);
			System.out.println("New ingredient added");
		}		
	}
	
	public void removeIngredient(String n) {
		
		Ingredient toRemove = null;
		for(int i =0; i< ingredients.size() && toRemove==null; i++) {
			Ingredient current = ingredients.get(i);
			if(current.getName().equals(n)) {
				ingredients.remove(i);
				toRemove = current;
				System.out.println("Ingredient removed successfully");
			}
		}if(toRemove ==null) {
			System.out.println("Ingredient not found");
		}
	}
	
	public List<Ingredient> getIngredients(){
		return ingredients;
	}
	public String toString() {
		String message ="";
		for(int i = 0; i<ingredients.size(); i++) {
			message += ingredients.get(i).getName();
			message += " " + ingredients.get(i).getWeight();
		}
		return message;
	}
	
}