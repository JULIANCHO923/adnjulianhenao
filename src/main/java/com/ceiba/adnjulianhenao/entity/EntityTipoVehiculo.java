package com.ceiba.adnjulianhenao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="tipovehiculo")
public class EntityTipoVehiculo implements Serializable {
	
	@Id    
    @Column(name="idtipovehiculo")
	private int id;
	
	@Column(name="descripcion")
	private String descripcion;
	
	public EntityTipoVehiculo(){
		
	}
	
/*
	 * localhost:8080/v2/tipovehiculo
	{	
		"id":2,
		"descripcion": "Moto"
	},
	{	
		"id":1,
		"descripcion": "Automovil"
	}
*/
	
	public EntityTipoVehiculo(int id, String descripcion){
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
