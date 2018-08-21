package com.ceiba.adnjulianhenao.builderstest;

import java.time.LocalDateTime;

import com.ceiba.adnjulianhenao.modelo.ModeloParqueaderoRegistro;
import com.ceiba.adnjulianhenao.modelo.ModeloTipoVehiculo;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;

public class ParqueaderoRegistroBuilder {

	private ModeloVehiculo vehiculo;
	private LocalDateTime fechaEntrada;
	private LocalDateTime fechaSalida;
	private int horasParqueo;
	private int diasParqueadero;
	private int horasParqueadero;
	private long costoTotal;
	
	public ParqueaderoRegistroBuilder() {
		this.vehiculo = new ModeloVehiculo("ABC123", new ModeloTipoVehiculo(1, "Automovil"), 0);
		this.fechaEntrada = LocalDateTime.now();
		this.fechaSalida = null;
		this.horasParqueo = 0;
		this.diasParqueadero = 0;
		this.horasParqueadero = 0;
		this.costoTotal = 0;
	
	}
	
	public ModeloParqueaderoRegistro build() {
		return new ModeloParqueaderoRegistro(vehiculo, fechaEntrada);
	}
	
	public ParqueaderoRegistroBuilder conVehiculo(ModeloVehiculo vehiculo) {
		this.vehiculo = vehiculo;
		return this;
	}
	
	public ParqueaderoRegistroBuilder conFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
		return this;
	}
	
	public ParqueaderoRegistroBuilder conFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}
	public ParqueaderoRegistroBuilder conHorasParqueo(int horasParqueo) {
		this.horasParqueo = horasParqueo;
		return this;
	}
	
	public ParqueaderoRegistroBuilder conDiasParqueadero(int diasParqueadero) {
		this.diasParqueadero= diasParqueadero;
		return this;
	}
	
	public ParqueaderoRegistroBuilder conHorasParqueadero(int horasParqueadero) {
		this.horasParqueadero = horasParqueadero;
		return this;
	}
	
	public ParqueaderoRegistroBuilder conCostoTotal(long costoTotal) {
		this.costoTotal = costoTotal;
		return this;
	}
	
}
