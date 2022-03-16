package model;

import java.io.Serializable;

public class Billboard implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3278446337765156918L;
	private int width;
	private int height;
	private boolean inUse;
	private String brand;
	
	public Billboard(int w, int h, boolean inUse, String brand) {
		this.width=w;
		this.height=h;
		this.inUse=inUse;
		this.brand=brand;
	}
	public boolean isDangerous() {
		boolean result=false;
		if(this.width*this.height>=200000) {
			result=true;
		}
		return result;
	}
	public int area() {
		return this.height*this.width;
	}
	public String getBrand() {
		return this.brand;
	}
	public String toString() {
		String str="";
		str+=width+" "+height+" "+inUse+" "+brand;
		return str;
	}
}
