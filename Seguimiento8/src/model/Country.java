package model;

public class Country implements Comparable<Country> {

	private String name;
	private int mGold;
	private int mSilver;
	private int mBronze;
	private int wGold;
	private int wSilver;
	private int wBronze;
	private int totalGold;
	private int totalSilver;
	private int totalBronze;
	
	public Country(String n, int mg, int ms, int mb, int wg, int ws, int wb) {
		this.name=n;
		this.mGold=mg;
		this.mSilver=ms;
		this.mBronze=mb;
		this.wGold=wg;
		this.wSilver=ws;
		this.wBronze=wb;
		this.totalGold = this.mGold + this.wGold;
		this.totalSilver = this.mSilver + this.wSilver;
		this.totalBronze = this.mBronze + this.wBronze;
	}
	
	public String GeneralToString() {
		String object = this.name+" "+this.totalGold+" "+this.totalSilver+" "+this.totalBronze;
		return object;
	}
	
	public String menToString() {
		String object = this.name+" "+this.mGold+" "+this.mSilver+" "+this.mBronze;
		return object;
	}
	
	public String womenToString() {
		String object = this.name+" "+this.wGold+" "+this.wSilver+" "+this.wBronze;
		return object;
	}

	//Getters
	public String getName() {
		return name;
	}

	public int getmGold() {
		return mGold;
	}

	public int getmSilver() {
		return mSilver;
	}

	public int getmBronze() {
		return mBronze;
	}

	public int getwGold() {
		return wGold;
	}

	public int getwSilver() {
		return wSilver;
	}

	public int getwBronze() {
		return wBronze;
	}
	
	public int getTotalGold() {
		return totalGold;
	}

	public int getTotalSilver() {
		return totalSilver;
	}
	
	public int getTotalBronze() {
		return totalBronze;
	}
	
	public int compareByTotalMedals(Country o) {
		
		int result = 0;
		
		if(this.totalGold<o.totalGold) {
			result=-1;
		}
		else if(this.totalGold>o.totalGold) {
			result=1;
		}
		if(result==0) {
			if(this.totalSilver<o.totalSilver) {
				result=-1;
			}
			else if(this.totalSilver>o.totalSilver) {
				result=1;
			}
		}
		if(result==0) {
			if(this.totalBronze<o.totalBronze) {
				result=-1;
			}
			else if(this.totalBronze>o.totalBronze) {
				result=1;
			}
		}
		if(result==0) {
			result = this.name.compareTo(o.name);
		}
		
		
		return result;
	}

	@Override
	public int compareTo(Country o) {
		
		int result = 0;
		result = Integer.valueOf(o.wGold).compareTo(Integer.valueOf(this.wGold));
		
		if(result==0) {
			result = Integer.valueOf(o.wSilver).compareTo(Integer.valueOf(this.wSilver));
		}
		
		if(result==0) {
			result = Integer.valueOf(o.wBronze).compareTo(Integer.valueOf(this.wBronze));
		}
		
		if(result==0) {
			result = o.name.compareTo(this.name);
		}
		return result;
	}
	
	
	
	
	
}
