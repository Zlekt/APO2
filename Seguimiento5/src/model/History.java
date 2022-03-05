package model;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class History {
	private LocalDate date;
	private String reason;
	private String amount;
	private int movement;
	
	public History(LocalDate date, String reason, String amount, int toRemove) {
		this.date=date;
		this.reason=reason;
		this.amount=amount;
		this.movement=toRemove;
	}
	public LocalDate getDate() {
		return date;
	}
	public String getReason() {
		return reason;
	}
	public String getAmount() {
		return amount;
	}
	public Integer getMovement() {
		return movement;
	}


	
}
