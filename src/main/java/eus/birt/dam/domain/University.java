package eus.birt.dam.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="university")
public class University extends BaseEntity{
	
	@Column (name= "name")
	private String name;
		
	@Embedded
	private Address address;
	
	@OneToMany (mappedBy="university", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	//se excluye CascadeType.REMOVE
	List <Student> students = new ArrayList<>();

	public University(String name) {
		super();
		this.name = name;
	}
	
}
