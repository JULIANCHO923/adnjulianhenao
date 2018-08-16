package com.ceiba.adnjulianhenao.parqueadero;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;
import com.ceiba.adnjulianhenao.validacion.entrada.ReglaDiaHabil;
import com.ceiba.adnjulianhenao.validacion.entrada.ValidacionesEntrada;
import com.ceiba.adnjulianhenao.validacion.salida.ValidacionesSalida;

@Component
public class Vigilante {
	
	
		
	@Autowired
	List<ValidacionesSalida> validacionesSalida = new ArrayList<>();
	
	@Autowired
	List<ValidacionesEntrada> validacionesEntrada = new ArrayList<>();
	
	
	public void inicializarValidaciones(){
		validacionesEntrada.add();
		listaValidaciones.add(diaHabilregla);		
	}
	
	public void registrar(ModeloVehiculo vehiculo){
		for(ValidacionesEntrada v: listaValidaciones){
			v.validar(vehiculo);
		}
	}
	
	
	

}
