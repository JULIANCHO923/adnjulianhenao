package com.ceiba.adnjulianhenao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name="tarifa")
public class EntityTarifa implements Serializable {

	@Id
	@Column(name = "idtarifa")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tipovehiculo_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private EntityTipoVehiculo tipovehiculo;
	
	@Column(name="costohora")
	private double costoHora;
	
	@Column(name="costodia")
	private double costoDia;
	
	@Column(name="horascobrodia")
	private int horasCobroDia;
		
	public EntityTarifa(){}
	
	public EntityTarifa(int id, EntityTipoVehiculo tipoVehiculo, double costoHora, double costoDia, int horasCobroDia) {	
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
	public EntityTipoVehiculo getTipoVehiculo() {
		return tipovehiculo;
	}
	public void setTipoVehiculo(EntityTipoVehiculo tipoVehiculo) {
		this.tipovehiculo = tipoVehiculo;
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
