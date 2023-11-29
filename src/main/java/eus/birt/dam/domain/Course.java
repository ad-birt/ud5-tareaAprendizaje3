package eus.birt.dam.domain;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
@Table (name="course")
public class Course extends BaseEntity{
	
	@Column (name= "name")
	private String name;
	
	@Column (name= "credits")
	private int credits;
	
	@ManyToMany (mappedBy="courses")
	private Set<Student> students = new HashSet<>();

	public Course(String name, int credits) {
		super();
		this.name = name;
		this.credits = credits;
	}
}
