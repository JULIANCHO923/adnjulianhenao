package com.ceiba.adnjulianhenao.entity;

import java.io.Serializable;

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
@Table(name = "vehiculo")
public class EntityVehiculo implements Serializable {

	@GeneratedValue
	@Id
	@Column(name = "id_vehiculo")
	private int id;

	@Column(name = "placa")
	private String placa;

	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_vehiculo")
	private EntityTipoVehiculo tipoVehiculo;

	@Column(name = "cilindraje")
	private int cilindraje;

	public EntityVehiculo() {
		super();
	}

	public EntityVehiculo(int id, String placa, EntityTipoVehiculo tipoVehiculo, int cilindraje) {
		super();
		this.id = id;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public EntityTipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(EntityTipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

}
