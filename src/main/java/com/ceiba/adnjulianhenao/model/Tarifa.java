package com.ceiba.adnjulianhenao.model;

public class Tarifa {

	private int id;
	private int tipoVehiculo;
	private double costoHora;
	private double costoDia;
	private int horasCobroDia;
	
	
	public Tarifa(){}
	
	public Tarifa(int id, int tipoVehiculo, double costoHora, double costoDia, int horasCobroDia) {	
		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.costoHora = costoHora;
		this.costoDia = costoDia;
		this.horasCobroDia = horasCobroDia;
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
	public double getCostoHora() {
		return costoHora;
	}
	public void setCostoHora(double costoHora) {
		this.costoHora = costoHora;
	}
	public double getCostoDia() {
		return costoDia;
	}
	public void setCostoDia(double costoDia) {
		this.costoDia = costoDia;
	}
	public int getHorasCobroDia() {
		return horasCobroDia;
	}
	public void setHorasCobroDia(int horasCobroDia) {
		this.horasCobroDia = horasCobroDia;
	}	
	
}
