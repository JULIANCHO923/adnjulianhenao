package com.ceiba.adnjulianhenao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ceiba.adnjulianhenao.entity.EntityTipoVehiculo;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
@Entity
@Table(name="tarifa")
public class EntityParqueaderoTarifa implements Serializable {

	@Id
	@Column(name = "id_tarifa")
	private int id;
	
	@JsonManagedReference
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_vehiculo")
	private EntityTipoVehiculo tipoVehiculo;
	
	//, referencedColumnName="id_tipo_vehiculo"
	
	@Column(name="costo_hora")
	private double costoHora;
	
	@Column(name="costo_dia")
	private double costoDia;
	
	@Column(name="horas_cobro_dia")
	private int horasCobroDia;
		
	public EntityParqueaderoTarifa(){}
	
	public EntityParqueaderoTarifa(int id, EntityTipoVehiculo tipoVehiculo, double costoHora, double costoDia, int horasCobroDia) {	
		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
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
	
	public EntityTipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(EntityTipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
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
