package ua.org.oa.emelianov.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "animals")
@XmlRootElement(name = "animal")
public class Animal {
	
	
	@Id
    @XmlElement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	@XmlElement
	@Column(name = "animal_name")
	private String animal_name;
	@XmlElement
	@Column(name = "animal_price")
	private int animal_price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnimal_name() {
		return animal_name;
	}
	public void setAnimal_name(String animal_name) {
		this.animal_name = animal_name;
	}
	public int getAnimal_price() {
		return animal_price;
	}
	public void setAnimal_price(int animal_price) {
		this.animal_price = animal_price;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", animal_name=" + animal_name + ", animal_price=" + animal_price + "]";
	}
	
	

}
