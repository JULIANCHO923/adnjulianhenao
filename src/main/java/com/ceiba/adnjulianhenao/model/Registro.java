package com.ceiba.adnjulianhenao.model;

import java.sql.Date;

public class Registro {

	private int id;
	private int vehiculo;
	private Date fechaEntrada;
	private Date fechaSalida;
	private int horasReportadas;
	private int diasParqueadero;
	private int horasParqueadero;
	private int costoTotal;
	
	public Registro(){}
	
	public Registro(int id, int vehiculo, Date fechaEntrada, Date fechaSalida, int horasReportadas, int diasParqueadero,
			int horasParqueadero, int costoTotal) {		
		this.id = id;
		this.vehiculo = vehiculo;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.horasReportadas = horasReportadas;
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

	public int getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(int vehiculo) {
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

	public int getHorasReportadas() {
		return horasReportadas;
	}

	public void setHorasReportadas(int horasReportadas) {
		this.horasReportadas = horasReportadas;
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
