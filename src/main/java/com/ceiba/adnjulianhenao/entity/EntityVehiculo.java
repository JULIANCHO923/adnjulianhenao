package com.ceiba.adnjulianhenao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Serializable ayuda a la conversión de Hibernate y jpa
 * @author julian.henao
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="vehiculo")
public class EntityVehiculo implements Serializable {

	@GeneratedValue
    @Id    
    @Column(name="idvehiculo")
    private int id;
    
    @Column(name="placa")
    private String placa;
    
    @Column(name="tipovehiculo")
    private int tipoVehiculo;
    
    @Column(name="cilindraje")
    private int cilindraje;
    
        protected EntityVehiculo() {}

    public EntityVehiculo(int id, String placa, int tipoVehiculo, int cilindraje) {
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

	public int getTipoVehiculo() {
		return this.tipoVehiculo;
	}

	public void setTipoVehiculo(int tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	
	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

}
