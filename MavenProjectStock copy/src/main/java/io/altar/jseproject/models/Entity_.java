	package io.altar.jseproject.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Id;

//link para documentacao   https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html

@MappedSuperclass
public class Entity_ implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

}
