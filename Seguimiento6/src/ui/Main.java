package ui;
import java.util.Scanner;

import model.*;

public class Main {

	private static MobilitySecretary secretary=new MobilitySecretary();
	private static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
		
		boolean execute = true;
		int decission=0;
		
		while(execute) {
			System.out.println("(1) Importar datos"
					+ "\n (2) Agregar valla publicitaria"
					+ "\n (3) Mostrar vallas publicitarias"
					+ "\n (4) Reporte de peligrosidad");
			
			decission = reader.nextInt();
			switch(decission) {
				case 1: loadData();
				break;
				case 2: addBillboard();
				break;
				case 3: showBillboard();
				break;
				case 4: dangerousnessReport();
				break;
			}
		}

	}
	public static void loadData() {
		System.out.println("Enter the route");
		String route = reader.nextLine();
		secretary.loadData(route);
	}
	public static void addBillboard() {
		System.out.println("Ingrese los parametros de su valla");
		reader.nextLine();
		String billboard = reader.nextLine();
		secretary.addBillboard(billboard);
	}
	public static void showBillboard() {
		System.out.println(secretary.showBillboardList());
	}
	public static void dangerousnessReport() {
		System.out.println(secretary.dangerousnessReport());
	}

}
