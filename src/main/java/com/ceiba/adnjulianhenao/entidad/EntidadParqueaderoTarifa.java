package com.ceiba.adnjulianhenao.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ceiba.adnjulianhenao.entidad.EntidadTipoVehiculo;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
@Entity
@Table(name="tarifa")
public class EntidadParqueaderoTarifa implements Serializable {

	@Id
	@Column(name = "id_tarifa")
	private int id;
	
	@JsonManagedReference
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_vehiculo")
	private EntidadTipoVehiculo tipoVehiculo;
	
	//, referencedColumnName="id_tipo_vehiculo"
	
	@Column(name="costo_hora")
	private long costoHora;
	
	@Column(name="costo_dia")
	private long costoDia;
	
	@Column(name="horas_cobro_dia")
	private int horasCobroDia;
		
	public EntidadParqueaderoTarifa(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public EntidadTipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(EntidadTipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	public long getCostoHora() {
		return costoHora;
	}
	public void setCostoHora(long costoHora) {
		this.costoHora = costoHora;
	}
	public long getCostoDia() {
		return costoDia;
	}
	public void setCostoDia(long costoDia) {
		this.costoDia = costoDia;
	}
	public int getHorasCobroDia() {
		return horasCobroDia;
	}
	public void setHorasCobroDia(int horasCobroDia) {
		this.horasCobroDia = horasCobroDia;
	}	
}
