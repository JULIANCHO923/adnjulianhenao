package com.ceiba.adnjulianhenao.builderstest;

import com.ceiba.adnjulianhenao.modelo.ModeloTipoVehiculo;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;

public class VehiculoBuilder {

	private String placa;
	private ModeloTipoVehiculo tipoVehiculo;
	private long cilindraje;
	
	
	public VehiculoBuilder() {
		this.placa = "ABC123";
		this.tipoVehiculo = new ModeloTipoVehiculo(1, "Automovil");
		this.cilindraje = 0;
	}
	
	public ModeloVehiculo build() {
		return new ModeloVehiculo(placa, tipoVehiculo, cilindraje);
	}
	
	public VehiculoBuilder conTipoVehiculo(ModeloTipoVehiculo tipo) {
		this.tipoVehiculo = tipo;
		return this;
	}
	
	public VehiculoBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public VehiculoBuilder conCilindraje(long cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	
}
