package com.ceiba.adnjulianhenao.modelo;

import com.ceiba.adnjulianhenao.entidad.EntidadParqueaderoTarifa;

public class ModeloParqueaderoTarifa {

	private int id;
	private ModeloTipoVehiculo tipovehiculo;
	private double costoHora;
	private double costoDia;
	private int horasCobroDia;
		
	public ModeloParqueaderoTarifa(){}
	
	public ModeloParqueaderoTarifa(EntidadParqueaderoTarifa tarifa) {	
		this.id = tarifa.getId();
		this.tipovehiculo = new ModeloTipoVehiculo(tarifa.getTipoVehiculo());
		this.costoHora = tarifa.getCostoHora();
		this.costoDia = tarifa.getCostoDia();
		this.horasCobroDia = tarifa.getHorasCobroDia();
	}
	
	public ModeloParqueaderoTarifa(int id, ModeloTipoVehiculo tipoVehiculo, double costoHora, double costoDia, int horasCobroDia) {	
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
	public ModeloTipoVehiculo getTipoVehiculo() {
		return tipovehiculo;
	}
	public void setTipoVehiculo(ModeloTipoVehiculo tipoVehiculo) {
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
