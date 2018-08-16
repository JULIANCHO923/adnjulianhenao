package com.ceiba.adnjulianhenao.model;

public class ModelParqueaderoEspacioDisponible {

	private int id;
	private ModelTipoVehiculo tipoVehiculo;	
	private int cantidadEspacio;
	
	public ModelParqueaderoEspacioDisponible(){}
	
	public ModelParqueaderoEspacioDisponible(int id, ModelTipoVehiculo tipoVehiculo, int cantidadEspacio) {	
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

	public ModelTipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(ModelTipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public int getCantidadEspacio() {
		return cantidadEspacio;
	}

	public void setCantidadEspacio(int cantidadEspacio) {
		this.cantidadEspacio = cantidadEspacio;
	}		
	
}
