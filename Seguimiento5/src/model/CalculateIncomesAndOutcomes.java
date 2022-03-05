package model;
import Exception.*;
import java.util.Calendar;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalculateIncomesAndOutcomes {

	private ArrayList<History>list= new ArrayList<History>();
	private int baseAmount;
	public CalculateIncomesAndOutcomes(int baseAmount) {
		this.baseAmount=baseAmount;
	}
	public int calculateIncome(String amountToAdd, String reason) throws NotANumberEntryException{
		for(int i=0;i<amountToAdd.length();i++) {
			if(amountToAdd.charAt(i)!='1'&&amountToAdd.charAt(i)!='2'&&amountToAdd.charAt(i)!='3'&&amountToAdd.charAt(i)!='4'&&amountToAdd.charAt(i)!='5'&&amountToAdd.charAt(i)!='6'&&amountToAdd.charAt(i)!='7'&&amountToAdd.charAt(i)!='8'&&amountToAdd.charAt(i)!='9'&&amountToAdd.charAt(i)!='0') {
				throw new NotANumberEntryException("Entry different to a number"+amountToAdd.charAt(i));
			}
		}
		int toAdd = Integer.parseInt(amountToAdd);
		this.baseAmount+=toAdd;
		int oldBaseAmount=baseAmount-toAdd;
		String stroldBaseAmount=Integer.toString(oldBaseAmount);
		list.add(new History(setDate(),reason,stroldBaseAmount,toAdd));
		return baseAmount;
	}
	public int calculateOutcome(String amountToRemove,String reason) throws NotANumberEntryException {
		for(int i=0;i<amountToRemove.length();i++) {
			if(amountToRemove.charAt(i)!='1'&&amountToRemove.charAt(i)!='2'&&amountToRemove.charAt(i)!='3'&&amountToRemove.charAt(i)!='4'&&amountToRemove.charAt(i)!='5'&&amountToRemove.charAt(i)!='6'&&amountToRemove.charAt(i)!='7'&&amountToRemove.charAt(i)!='8'&&amountToRemove.charAt(i)!='9'&&amountToRemove.charAt(i)!='0') {
				throw new NotANumberEntryException("Entry different to a number"+amountToRemove.charAt(i));
			}
		}
		int toRemove = Integer.parseInt(amountToRemove);
		this.baseAmount-=toRemove;
		int oldBaseAmount=baseAmount+toRemove;
		String stroldBaseAmount=Integer.toString(oldBaseAmount);
		list.add(new History(setDate(),reason,stroldBaseAmount,toRemove));
		return baseAmount;
		
	}
	public void removeOperation(History operation) {
		for(int i=0; i<list.size();i++) {
			if(operation.equals(list.get(i))) {
				list.remove(i);
			}
		}
	}
	public LocalDate setDate() {
		LocalDate today = LocalDate.now();
		return today;
	}
	public String setReason(String str) {
		return str;
	}
	public int getBaseAmount() {
		return baseAmount;
	}
	public String getBaseAmountString() {
		String message=Integer.toString(baseAmount);
		return message;
	}
	public ArrayList<History> returnList(){
		return list;
	}
	
}
