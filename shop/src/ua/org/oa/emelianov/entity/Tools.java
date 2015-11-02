package ua.org.oa.emelianov.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tools")
@XmlRootElement(name = "tools")
public class Tools {
	
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	@XmlElement
	@Column(name = "tool_name")
	private String tool_name;
	@XmlElement
	@Column(name = "tool_origin")
	private String tool_origin;
	@XmlElement
	@Column(name = "tool_weight")
	private int tool_weight;
	@XmlElement
	@Column(name = "tool_price")
	private int tool_price;
	@XmlElement
	@Column(name = "animals_id")
	private int animals_id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTool_name() {
		return tool_name;
	}
	public void setTool_name(String tool_name) {
		this.tool_name = tool_name;
	}
	public String getTool_origin() {
		return tool_origin;
	}
	public void setTool_origin(String tool_origin) {
		this.tool_origin = tool_origin;
	}
	public int getTool_weight() {
		return tool_weight;
	}
	public void setTool_weight(int tool_weight) {
		this.tool_weight = tool_weight;
	}
	public int getTool_price() {
		return tool_price;
	}
	public void setTool_price(int tool_price) {
		this.tool_price = tool_price;
	}
	public int getAnimals_id() {
		return animals_id;
	}
	public void setAnimals_id(int animals_id) {
		this.animals_id = animals_id;
	}
	@Override
	public String toString() {
		return "Tools [id=" + id + ", tool_name=" + tool_name + ", tool_origin=" + tool_origin + ", tool_weight="
				+ tool_weight + ", tool_price=" + tool_price + ", animals_id=" + animals_id + "]";
	}
	
	

}
