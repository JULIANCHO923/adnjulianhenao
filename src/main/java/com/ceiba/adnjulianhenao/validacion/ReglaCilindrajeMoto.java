package com.ceiba.adnjulianhenao.validacion;


import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.excepcion.ExcepcionParametroInvalido;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;

@Component
public class ReglaCilindrajeMoto implements Validaciones{

	@Override
	public void validar(ModeloVehiculo modelVehiculo) {
		if(modelVehiculo.getTipoVehiculo().getId() == 2 && modelVehiculo.getCilindraje() <= 0){
			throw new ExcepcionParametroInvalido("Valor de cilindraje invalido para la Moto");
		}		
	}

}
