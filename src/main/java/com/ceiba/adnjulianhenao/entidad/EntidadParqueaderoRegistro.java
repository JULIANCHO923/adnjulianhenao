package com.ceiba.adnjulianhenao.entidad;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Serializable ayuda a la conversión de Hibernate y jpa
 * 
 * @author julian.henao
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "registro")
public class EntidadParqueaderoRegistro implements Serializable {

	@GeneratedValue
	@Id
	@Column(name = "id_registro")
	private int id;

	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vehiculo")
	private EntidadVehiculo vehiculo;
	
	@Column(name = "fecha_entrada")
	private Calendar fechaEntrada;

	@Column(name = "fecha_salida")
	private Calendar fechaSalida;
	
	@Column(name = "dias_parqueadero")
	private int diasParqueadero;
	
	@Column(name = "horas_parqueadero")
	private int horasParqueadero;
	
	@Column(name = "costo_total")
	private int costoTotal;

	public EntidadParqueaderoRegistro(){}
	
	public EntidadParqueaderoRegistro(int id, EntidadVehiculo vehiculo, Calendar fechaEntrada, Calendar fechaSalida,  int diasParqueadero,
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

	public EntidadVehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(EntidadVehiculo vehiculo) {
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
