package by.htp.periodicals.domain;

public class Publication extends Entity {
	
	private int id;
	private String name;
	private String description;
	private int periodicity;
	private double price;
	
	public Publication() {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPeriodicity() {
		return periodicity;
	}
	
	public void setPeriodicity(int periodicity) {
		this.periodicity = periodicity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

}
