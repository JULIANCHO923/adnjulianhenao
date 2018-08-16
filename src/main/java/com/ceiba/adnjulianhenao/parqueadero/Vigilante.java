package com.ceiba.adnjulianhenao.parqueadero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.excepcion.ExcepcionSobreCosto;
import com.ceiba.adnjulianhenao.modelo.ModeloParqueaderoRegistro;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;
import com.ceiba.adnjulianhenao.validacion.Validaciones;
import com.ceiba.adnjulianhenao.validacion.ValidacionesEntrada;
import com.ceiba.adnjulianhenao.validacion.ValidacionesSalida;

@Component
public class Vigilante {
	

	/**
	 *  Valida la entrada de vehiculo
	 *  Registra la entrada
	 *  Registra la salida
	 *  Genera Factura
	 */
	@Autowired
	ValidacionesEntrada validacionesEntrada;	
	
	@Autowired
	ValidacionesSalida validacionesSalida;	
	
	
	public void registrarEntrada(ModeloVehiculo vehiculo){
		for(Validaciones validacion: validacionesEntrada.validacionesEntrada()){
			validacion.validar(vehiculo);
		}				
		
	}
	
	public void registrarSalida(ModeloParqueaderoRegistro modeloParqueaderoRegistro){
		
		double costoTotal = 0.0; 		
		
		try{			
			for(Validaciones validacion: validacionesSalida.validacionesSalida()){
				validacion.validar(modeloParqueaderoRegistro.getVehiculo());
			}	
		}catch(ExcepcionSobreCosto esc){
			costoTotal += 2000;
		}finally{
		 // Registrar Salida y descontar vehiculo	
		}		
		
		
	}
	

}
