package com.ceiba.adnjulianhenao.model;

import com.ceiba.adnjulianhenao.entity.EntityTarifa;

public class Tarifa {

	private int id;
	private TipoVehiculo tipovehiculo;
	private double costoHora;
	private double costoDia;
	private int horasCobroDia;
		
	public Tarifa(){}
	
	public Tarifa(EntityTarifa tarifa) {	
		this.id = tarifa.getId();
		this.tipovehiculo = new TipoVehiculo(tarifa.getTipoVehiculo());
		this.costoHora = tarifa.getCostoHora();
		this.costoDia = tarifa.getCostoDia();
		this.horasCobroDia = tarifa.getHorasCobroDia();
	}
	
	public Tarifa(int id, TipoVehiculo tipoVehiculo, double costoHora, double costoDia, int horasCobroDia) {	
		this.id = id;
		this.tipovehiculo = tipoVehiculo;
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
	public TipoVehiculo getTipoVehiculo() {
		return tipovehiculo;
	}
	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipovehiculo = tipoVehiculo;
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
