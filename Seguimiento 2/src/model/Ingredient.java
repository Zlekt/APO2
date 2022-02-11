package model;
import exception.*;
public class Ingredient {
	private String name;
	private double weight;
	
	public Ingredient(String n, double w) {
		name = n;
		weight = w;
	}
	
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void addWeight(double additionalW) throws NegativeNumberException {
		if(additionalW<0) {
			throw new NegativeNumberException(additionalW);
		}else {
			weight = weight + additionalW;
		}
		
	}
	public void removeWeight(double inputWeight) throws NegativeNumberException{
		if(inputWeight<0) {
			throw new NegativeNumberException(inputWeight);
		}
		weight = weight - inputWeight;
	}
	public String toString() {
		String message = name;
		message+= " " + weight;
		return message;
	}

}