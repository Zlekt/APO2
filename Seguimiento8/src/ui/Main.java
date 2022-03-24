package ui;

import model.OlympicGames2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	
	public  static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		OlympicGames2020 og20 = new OlympicGames2020();
		og20.loadFile();
		System.out.println(og20.printOlympicsResult());
		
		/*System.out.println("Enter the number of countries");
		int countriesNumber = reader.nextInt();
		for(int i=0;i<countriesNumber;i++) {
			reader.nextLine();
			System.out.println("Enter the country");
			String countryName = reader.nextLine();
			System.out.println("Enter the men's golden medals");
			int mGold = reader.nextInt();
			System.out.println("Enter the men's silver medals");
			int mSilver = reader.nextInt();
			System.out.println("Enter the men's bronze medals");
			int mBronze = reader.nextInt();
			System.out.println("Enter the women's golden medals");
			int wGold = reader.nextInt();
			System.out.println("Enter the women's silver medals");
			int wSilver = reader.nextInt();
			System.out.println("Enter the women's bronze medals");
			int wBronze = reader.nextInt();
			
			og20.addCountry();
		}*/
	}

}
