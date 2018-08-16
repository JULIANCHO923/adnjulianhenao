package com.ceiba.adnjulianhenao.model;

import com.ceiba.adnjulianhenao.entity.EntityTipoVehiculo;


public class ModelTipoVehiculo {

	private int id;
	private String descripcion;
	
	public ModelTipoVehiculo(){
		
	}
	
	public ModelTipoVehiculo(EntityTipoVehiculo tipoVehiculo){
    	this.id = tipoVehiculo.getId();
    	this.descripcion = tipoVehiculo.getDescripcion();
        }
	
	public ModelTipoVehiculo(int id, String descripcion){
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
