package com.Backend.jai.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "StdTab")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sid")
	private Integer stdId;
	
	@Column(name = "sname")
	private String stdName;
	
	
	
	@Column(name = "sgen")
	private String stdGen;
	
	 
	@Column(name = "scourse")
	private String stdCourse;
	
	@NotBlank(message = "Address must Be Filled")
	@Column(name = "saddr")
	private String stdAddr;


}
