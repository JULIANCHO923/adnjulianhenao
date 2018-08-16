package com.ceiba.adnjulianhenao.modelo;

import com.ceiba.adnjulianhenao.entidad.EntidadTipoVehiculo;


public class ModeloTipoVehiculo {

	private int id;
	private String descripcion;
	
	public ModeloTipoVehiculo(){
		
	}
	
	public ModeloTipoVehiculo(EntidadTipoVehiculo tipoVehiculo){
    	this.id = tipoVehiculo.getId();
    	this.descripcion = tipoVehiculo.getDescripcion();
        }
	
	public ModeloTipoVehiculo(int id, String descripcion){
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
