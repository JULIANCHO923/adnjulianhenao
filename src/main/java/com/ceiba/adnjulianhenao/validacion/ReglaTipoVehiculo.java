package com.ceiba.adnjulianhenao.validacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import com.ceiba.adnjulianhenao.excepcion.ExcepcionParametroInvalido;
import com.ceiba.adnjulianhenao.modelo.ModeloTipoVehiculo;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;
import com.ceiba.adnjulianhenao.servicio.ServicioTipoVehiculo;

@Component
public class ReglaTipoVehiculo implements Validaciones{

	@Autowired
	@Qualifier("servicioTipoVehiculo")
	private ServicioTipoVehiculo servicioTipoVehiculo;
	
	/**
	 *  El metodo recorre la lista de tipo de vehiculos registrados en la BD
	 *  si no encuentra algun vehiculoValido que consisa con el ingresado, lanzar� la excepci�n
	 */
	@Override
	public void validar(ModeloVehiculo modelVehiculo) {
		
		List<ModeloTipoVehiculo> modeloTipoVehiculos = servicioTipoVehiculo.obtenerTipoVehiculos();
		boolean vehiculoValido = false;
		String tiposVehiculos = ""; 
		
		for(ModeloTipoVehiculo modeloTipoVehiculo: modeloTipoVehiculos){
			tiposVehiculos = tiposVehiculos +  " {("+ modeloTipoVehiculo.getId() +")," + modeloTipoVehiculo.getDescripcion() + "}";
			if( modeloTipoVehiculo.getId() == modelVehiculo.getTipoVehiculo().getId()){
				vehiculoValido = true;
				break;
			}
		}
						
		/* Si no encuentra alg�n tipo de vehiculo que coincida con el ingresado vehiculoValido = false */
		if(!vehiculoValido){
			throw new ExcepcionParametroInvalido("El tipo de vehiculo ingresado no es Valido - Los tipos aceptados son: "+ tiposVehiculos );
		}		
		
	}


}
