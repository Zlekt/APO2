package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OlympicGames2020 {
	
	private ArrayList<Country> countries;
	public OlympicGames2020() {
		
			countries = new ArrayList<Country>();
	}
	public void loadFile() {
			try {
				FileReader fileReader = new FileReader("src\\paises.txt");
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				int iterations = Integer.parseInt(bufferedReader.readLine());
				for(int i=0;i<iterations;i++) {
					
					String line = bufferedReader.readLine();
					String[] data = line.split(";");
					String country = data[0];
					int mg = Integer.parseInt(data[1]);
					int ms = Integer.parseInt(data[2]);
					int mb = Integer.parseInt(data[3]);
					int wg = Integer.parseInt(data[4]);
					int ws = Integer.parseInt(data[5]);
					int wb = Integer.parseInt(data[6]);
					countries.add(new Country(country,mg,ms,mb,wg,ws,wb));
				}
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public String printOlympicsResult() {
		
		String toPrint="Masculino\n";
		Collections.sort(countries, new CountryComparator());
		for(int i = 0; i<countries.size(); i++) {
			
			toPrint+=countries.get(i).menToString()+"\n";
		}
		
		toPrint+="----------\nFemenino\n";
		Collections.sort(countries);
		for(int i = 0; i<countries.size(); i++) {
			
			toPrint+=countries.get(i).womenToString()+"\n";
		}
		
		toPrint+="----------\nCombinado\n";
		sortByTotalMedals();
		for(int i = 0; i<countries.size(); i++) {
			
			toPrint+=countries.get(i).GeneralToString()+"\n";
		}
		return toPrint;
	}
	
	public void sortCollectionsComparatorByMenMedals() {
		Collections.sort(countries, new Comparator<Country>() {
			@Override
			public int compare(Country o1, Country o2) {
				return Integer.valueOf(o1.getmGold()).compareTo(Integer.valueOf(o2.getmGold()));
			
			}
			
		});
	}

	public void sortCollectionsComparatorByWomenMedals() {
		Collections.sort(countries, new Comparator<Country>() {
			@Override
			public int compare(Country o1, Country o2) {
				return Integer.valueOf(o1.getwGold()).compareTo(Integer.valueOf(o2.getwGold()));
			
			}
			
		});
	}
	
	public void sortByTotalMedals() {
		int n = countries.size();
		boolean inversion = true;
		
		for (int i = 0; i < n && inversion; i++) {
			inversion = false;
	    	for (int j = 1; j < n - i; j++) {
	    		if (countries.get(j).compareByTotalMedals(countries.get(j-1)) > 0) {
	    			Country temp = countries.get(j);
	    			countries.set(j, countries.get(j-1));
	    	        countries.set(j-1, temp);
	    			inversion = true;
	    		}
	    	}
	    }
	}
	
	
	
}
