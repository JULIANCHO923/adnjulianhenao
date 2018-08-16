package com.ceiba.adnjulianhenao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
@Entity
@Table(name="disponibilidad")
public class EntityParqueaderoEspacioDisponible implements Serializable{

	@Id
	@Column(name = "id_disponibilidad")
	private int id;
	
	@JsonManagedReference
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_vehiculo")
	private EntityTipoVehiculo tipoVehiculo;	
	
	@Column(name = "espacio_disponible")
	private int cantidadEspacio;
	
	public EntityParqueaderoEspacioDisponible(){}
	
	public EntityParqueaderoEspacioDisponible(int id, EntityTipoVehiculo tipoVehiculo, int cantidadEspacio) {	
		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.cantidadEspacio = cantidadEspacio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EntityTipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(EntityTipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public int getCantidadEspacio() {
		return cantidadEspacio;
	}

	public void setCantidadEspacio(int cantidadEspacio) {
		this.cantidadEspacio = cantidadEspacio;
	}
	
}
