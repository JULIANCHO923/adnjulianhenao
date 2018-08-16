package com.ceiba.adnjulianhenao.validacion.entrada;


import com.ceiba.adnjulianhenao.excepcion.ExcepcionParametroInvalido;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;

public class ReglaCilindrajeMoto implements ValidacionesEntrada{

	@Override
	public void validar(ModeloVehiculo modelVehiculo) {
		if(modelVehiculo.getTipoVehiculo().getDescripcion().equals("Moto") && modelVehiculo.getCilindraje() <= 0){
			throw new ExcepcionParametroInvalido("Valor de cilindraje invalido para la Moto");
		}		
	}

}
