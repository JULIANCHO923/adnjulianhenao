package com.ceiba.adnjulianhenao.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="tipovehiculo")
public class EntidadTipoVehiculo implements Serializable {
	
	@Id    
    @Column(name="id_tipo_vehiculo")
	private int id;
	
	@Column(name="descripcion")
	private String descripcion;
	
	public EntidadTipoVehiculo(){
		
	}
	
	public EntidadTipoVehiculo(int id, String descripcion){
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
