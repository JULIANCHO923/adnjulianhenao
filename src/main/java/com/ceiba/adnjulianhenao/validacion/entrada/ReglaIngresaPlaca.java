package com.ceiba.adnjulianhenao.validacion.entrada;


import org.springframework.stereotype.Component;
import com.ceiba.adnjulianhenao.excepcion.ExcepcionParametroInvalido;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;


@Component
public class ReglaIngresaPlaca implements ValidacionEntrada{

	
	@Override
	public void validar(ModeloVehiculo modelVehiculo) {
						
		if(modelVehiculo.getPlaca() == null){
			throw new ExcepcionParametroInvalido("La Placa es obligatoria");
		}		
		
	}


}
