package eus.birt.dam.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter/*Lombok crea los getters y setters...*/
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="student")
public class Student extends BaseEntity{

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Embedded
	private Address address;
	
	@ElementCollection
	@CollectionTable(name= "student_phone", joinColumns=@JoinColumn(name="student_id"))
	@Column(name="student_phone")
	private List<String> phones = new ArrayList<>();
	
	@Column (name="birthdate")
	private LocalDate birthdate;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn (name="tuition_id")
	private Tuition tuition;  
	
	
	@ManyToOne
	@JoinColumn (name = "university_id")
	private University university;
	
	@ManyToMany (cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="student_course", joinColumns=@JoinColumn(name="student_id"), 
			inverseJoinColumns=@JoinColumn(name="course_id"))
	private Set<Course> courses = new HashSet<>();

	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
}
