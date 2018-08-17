package com.ceiba.adnjulianhenao.validacion;

import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.excepcion.ExcepcionSobreCosto;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;

@Component("reglaSobreCostoCilindraje")
public class ReglaSobreCostoCilindraje implements Validaciones{
	
	@Override
	public void validar(ModeloVehiculo modelVehiculo) {
		if(modelVehiculo.getTipoVehiculo().getDescripcion().equals("Moto") && modelVehiculo.getCilindraje() > 500){
			throw new ExcepcionSobreCosto("Valor de cilindraje supera los 500 CC, esto genera un sobreCosto");
		}
	}

}
