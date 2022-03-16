package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.util.ArrayList;

public class MobilitySecretary {

	private ArrayList<Billboard> billboardList;
	
	public MobilitySecretary() {
		
		billboardList=new ArrayList<Billboard>();
	}
	
	public void loadData(String route) {
		
		FileReader fileReader;
		try {
			fileReader = new FileReader(route);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			bufferedReader.readLine();
			
			while(bufferedReader.ready()) {
				
				String line = bufferedReader.readLine();
				String[] data = line.split("\\|");
				
				int width = Integer.parseInt(data[0]);
				int height = Integer.parseInt(data[1]);
				boolean inUse = Boolean.parseBoolean(data[2]);
				String brand = data[3];
				billboardList.add(new Billboard(width,height,inUse,brand));
				
			}
			bufferedReader.close();
			
			FileOutputStream fileOut = new FileOutputStream("src\\Billboards.csv");
			ObjectOutputStream output = new ObjectOutputStream(fileOut);
			
			for(int i = 0; i<billboardList.size();i++) {
				
				output.writeObject(billboardList.get(i));
				
			}
			fileOut.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public void addBillboard(String billboard) {
		String[] billboardDatas = billboard.split("\\++");
		int w = Integer.parseInt(billboardDatas[0]);
		int h = Integer.parseInt(billboardDatas[1]);
		boolean inUse = Boolean.parseBoolean(billboardDatas[2]);
		String b = billboardDatas[3];
		Billboard billboardToAdd=new Billboard(w,h,inUse,b);
		billboardList.add(billboardToAdd);
		try {
			FileOutputStream fileOut = new FileOutputStream("src\\Billboards.csv");
			ObjectOutputStream output = new ObjectOutputStream(fileOut);
			output.writeObject(billboardToAdd);
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String showBillboardList() {
		String message="W H inUse Brand";
		for(int i=0;i<billboardList.size();i++) {
			message+="\n"+billboardList.get(i).toString();
		}
		message+="\n \n TOTAL: "+billboardList.size()+" vallas";
		return message;
	}
	public String dangerousnessReport() {
		String message="";
		for(int i=0; i<billboardList.size();i++) {
			int j=i+1;
			if(billboardList.get(i).isDangerous()){
				message+="\n"+j+". Billboard"+billboardList.get(i).getBrand()+" with area "+billboardList.get(i).area();
			}
				
		}
		return message;
	}
}
