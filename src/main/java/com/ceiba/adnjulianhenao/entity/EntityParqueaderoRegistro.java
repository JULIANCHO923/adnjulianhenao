package com.ceiba.adnjulianhenao.entity;

import java.io.Serializable;
import java.sql.Date;

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
public class EntityParqueaderoRegistro implements Serializable {

	@GeneratedValue
	@Id
	@Column(name = "id_registro")
	private int id;

	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vehiculo")
	private EntityVehiculo vehiculo;
	
	@Column(name = "fecha_entrada")
	private Date fechaEntrada;

	@Column(name = "fecha_salida")
	private Date fechaSalida;
	
	@Column(name = "dias_parqueadero")
	private int diasParqueadero;
	
	@Column(name = "horas_parqueadero")
	private int horasParqueadero;
	
	@Column(name = "costo_total")
	private int costoTotal;

	public EntityParqueaderoRegistro(){}
	
	public EntityParqueaderoRegistro(int id, EntityVehiculo vehiculo, Date fechaEntrada, Date fechaSalida,  int diasParqueadero,
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

	public EntityVehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(EntityVehiculo vehiculo) {
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
