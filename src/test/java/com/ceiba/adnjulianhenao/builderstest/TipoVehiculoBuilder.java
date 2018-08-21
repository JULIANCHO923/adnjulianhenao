package com.ceiba.adnjulianhenao.builderstest;

import com.ceiba.adnjulianhenao.modelo.ModeloTipoVehiculo;

public class TipoVehiculoBuilder {

	private int id;
	private String descripcion;
	
	
	public TipoVehiculoBuilder() {
		this.id = 1;
		this.descripcion = "Automovil";
	}
	
	public ModeloTipoVehiculo build() {
		return new ModeloTipoVehiculo(id, descripcion);
	}
	
	
	public TipoVehiculoBuilder conDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}
	
	public TipoVehiculoBuilder conId(int id) {
		this.id = id;
		return this;
	}
	
}
