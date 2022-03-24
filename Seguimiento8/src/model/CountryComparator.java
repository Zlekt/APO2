package model;

import java.util.Comparator;

public class CountryComparator implements Comparator<Country>{

	@Override
	public int compare(Country o1, Country o2) {
		int result = 0;
		result = Integer.valueOf(o2.getmGold()).compareTo(Integer.valueOf(o1.getmGold()));
		
		if(result==0) {
			result = Integer.valueOf(o2.getmSilver()).compareTo(Integer.valueOf(o1.getmSilver()));
		}
		
		if(result==0) {
			result = Integer.valueOf(o2.getmBronze()).compareTo(Integer.valueOf(o1.getmBronze()));
		}
		
		if(result==0) {
			result = o1.getName().compareTo(o2.getName());
		}
		return result;
	}
}
