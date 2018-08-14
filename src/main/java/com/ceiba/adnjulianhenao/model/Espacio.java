package com.ceiba.adnjulianhenao.model;

public class Espacio {

	private int id;
	private int tipoVehiculo;	
	private int cantidadEspacio;
	
	public Espacio(){}
	
	public Espacio(int id, int tipoVehiculo, int cantidadEspacio) {	
		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.cantidadEspacio = cantidadEspacio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(int tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public int getCantidadEspacio() {
		return cantidadEspacio;
	}

	public void setCantidadEspacio(int cantidadEspacio) {
		this.cantidadEspacio = cantidadEspacio;
	}		
	
}
