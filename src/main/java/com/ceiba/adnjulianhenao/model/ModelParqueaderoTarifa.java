package com.ceiba.adnjulianhenao.model;

import com.ceiba.adnjulianhenao.entity.EntityParqueaderoTarifa;

public class ModelParqueaderoTarifa {

	private int id;
	private ModelTipoVehiculo tipovehiculo;
	private double costoHora;
	private double costoDia;
	private int horasCobroDia;
		
	public ModelParqueaderoTarifa(){}
	
	public ModelParqueaderoTarifa(EntityParqueaderoTarifa tarifa) {	
		this.id = tarifa.getId();
		this.tipovehiculo = new ModelTipoVehiculo(tarifa.getTipoVehiculo());
		this.costoHora = tarifa.getCostoHora();
		this.costoDia = tarifa.getCostoDia();
		this.horasCobroDia = tarifa.getHorasCobroDia();
	}
	
	public ModelParqueaderoTarifa(int id, ModelTipoVehiculo tipoVehiculo, double costoHora, double costoDia, int horasCobroDia) {	
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
	public ModelTipoVehiculo getTipoVehiculo() {
		return tipovehiculo;
	}
	public void setTipoVehiculo(ModelTipoVehiculo tipoVehiculo) {
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
