package com.project.event.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")

public class Role {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;



		@Column(name = "name", nullable = false)
	    private String Name;

		
public Role()
{
	
}
	    public Role(Long id, String name) 
	    
	   {
	    	
		this.id = id;
		Name = name;
	}



		public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}



		public String getName() {
			return Name;
		}



		public void setName(String name) {
			Name = name;
		}

}
