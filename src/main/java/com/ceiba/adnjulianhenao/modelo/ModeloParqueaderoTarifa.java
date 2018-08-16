package com.ceiba.adnjulianhenao.modelo;

public class ModeloParqueaderoTarifa {

	private int id;
	private ModeloTipoVehiculo tipovehiculo;
	private long costoHora;
	private long costoDia;
	private int horasCobroDia;
		
	public ModeloParqueaderoTarifa(){}
		
	public ModeloParqueaderoTarifa(int id, ModeloTipoVehiculo tipoVehiculo, long costoHora, long costoDia, int horasCobroDia) {	
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
	public long getCostoHora() {
		return costoHora;
	}
	public void setCostoHora(long costoHora) {
		this.costoHora = costoHora;
	}
	public long getCostoDia() {
		return costoDia;
	}
	public void setCostoDia(long costoDia) {
		this.costoDia = costoDia;
	}
	public int getHorasCobroDia() {
		return horasCobroDia;
	}
	public void setHorasCobroDia(int horasCobroDia) {
		this.horasCobroDia = horasCobroDia;
	}	
	
}
