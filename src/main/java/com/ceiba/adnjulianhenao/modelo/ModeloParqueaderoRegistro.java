package com.ceiba.adnjulianhenao.modelo;

import java.util.Calendar;

public class ModeloParqueaderoRegistro {

	private int id;
	private ModeloVehiculo vehiculo;
	private Calendar fechaEntrada;
	private Calendar fechaSalida;
	private int horasParqueo;
	private int diasParqueadero;
	private int horasParqueadero;
	private long costoTotal;
	
	public ModeloParqueaderoRegistro(){}		
	
	public ModeloParqueaderoRegistro(ModeloVehiculo vehiculo, Calendar fechaEntrada, Calendar fechaSalida,
			int horasParqueo, int diasParqueadero, int horasParqueadero, long costoTotal) {		
		this.vehiculo = vehiculo;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.horasParqueo = horasParqueo;
		this.diasParqueadero = diasParqueadero;
		this.horasParqueadero = horasParqueadero;
		this.costoTotal = costoTotal;
	}

	public ModeloParqueaderoRegistro(ModeloVehiculo vehiculo, Calendar fechaEntrada) {				
		this.vehiculo = vehiculo;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = null;		
		this.horasParqueo = 0;
		this.diasParqueadero = 0;
		this.horasParqueadero = 0;
		this.costoTotal = 0;
	}


		public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ModeloVehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(ModeloVehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Calendar getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Calendar fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Calendar getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}		

	public int getHorasParqueo() {
		return horasParqueo;
	}

	public void setHorasParqueo(int horasParqueo) {
		this.horasParqueo = horasParqueo;
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

	public long getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(long costoTotal) {
		this.costoTotal = costoTotal;
	}
	

}
