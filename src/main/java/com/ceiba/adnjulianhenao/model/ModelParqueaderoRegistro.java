package com.ceiba.adnjulianhenao.model;

import java.sql.Date;

public class ModelParqueaderoRegistro {

	private int id;
	private ModelVehiculo vehiculo;
	private Date fechaEntrada;
	private Date fechaSalida;
	private int diasParqueadero;
	private int horasParqueadero;
	private int costoTotal;
	
	public ModelParqueaderoRegistro(){}
	
	public ModelParqueaderoRegistro(int id, ModelVehiculo vehiculo, Date fechaEntrada, Date fechaSalida,  int diasParqueadero,
			int horasParqueadero, int costoTotal) {		
		this.id = id;
		this.vehiculo = vehiculo;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;		
		this.diasParqueadero = diasParqueadero;
		this.horasParqueadero = horasParqueadero;
		this.costoTotal = costoTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ModelVehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(ModelVehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getDiasParqueadero() {
		return diasParqueadero;
	}

	public void setDiasParqueadero(int diasParqueadero) {
		this.diasParqueadero = diasParqueadero;
	}

	public int getHorasParqueadero() {
		return horasParqueadero;
	}

	public void setHorasParqueadero(int horasParqueadero) {
		this.horasParqueadero = horasParqueadero;
	}

	public int getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(int costoTotal) {
		this.costoTotal = costoTotal;
	}
	

}
