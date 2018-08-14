package com.ceiba.adnjulianhenao.model;

import com.ceiba.adnjulianhenao.entity.EntityVehiculo;

public class Vehiculo {
    
	private int  id;   
    private String placa;    
    private int tipoVehiculo;   
    private int cilindraje;
    
    public Vehiculo(EntityVehiculo vehiculo){
    	this.id = vehiculo.getId();
    	this.placa = vehiculo.getPlaca();
        this.tipoVehiculo = vehiculo.getTipoVehiculo();
        this.cilindraje = vehiculo.getCilindraje();
    }
    
    public Vehiculo(){
    	
    }

    public Vehiculo(int id, String placa, int tipoVehiculo, int cilindraje) {
        this.id = id;
    	this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.cilindraje = cilindraje;
    }
                
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(int tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
}
