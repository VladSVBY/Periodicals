package by.htp.periodicals.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "publications")
public class Publication extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name", length = 150)
	private String name;
	
	@Column(name = "description", length = 2000)
	private String description;
	
	@Column(name = "peripdicity")
	private int periodicity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "themeID")
	private Theme theme;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typeID")
	private Type type;
	
	@Column(name = "price")
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

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

}
