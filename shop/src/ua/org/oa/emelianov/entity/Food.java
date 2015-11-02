package ua.org.oa.emelianov.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="food")
@XmlRootElement(name = "food")
public class Food {
	
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	@XmlElement
	@Column(name="food_name")
	private String food_name;
	@XmlElement
	@Column(name="food_origin")
	private String food_origin;
	@XmlElement
	@Column(name="food_price")
	private int food_price;
	@XmlElement
	@Column(name="animals_id")
	private int animals_id;
	

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public String getFood_origin() {
		return food_origin;
	}
	public void setFood_origin(String food_origin) {
		this.food_origin = food_origin;
	}
	public int getFood_price() {
		return food_price;
	}
	public void setFood_price(int food_price) {
		this.food_price = food_price;
	}
	public int getAnimals_id() {
		return animals_id;
	}
	public void setAnimals_id(int animals_id) {
		this.animals_id = animals_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + animals_id;
		result = prime * result + ((food_name == null) ? 0 : food_name.hashCode());
		result = prime * result + ((food_origin == null) ? 0 : food_origin.hashCode());
		result = prime * result + food_price;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		if (animals_id != other.animals_id)
			return false;
		if (food_name == null) {
			if (other.food_name != null)
				return false;
		} else if (!food_name.equals(other.food_name))
			return false;
		if (food_origin == null) {
			if (other.food_origin != null)
				return false;
		} else if (!food_origin.equals(other.food_origin))
			return false;
		if (food_price != other.food_price)
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", food_name=" + food_name + ", food_origin=" + food_origin + ", food_price="
				+ food_price + ", animals_id=" + animals_id + "]";
	}
	
	

}
