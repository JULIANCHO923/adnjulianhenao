package com.ceiba.adnjulianhenao.parqueadero;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceiba.adnjulianhenao.model.ModelVehiculo;
import com.ceiba.adnjulianhenao.validacion.DiaHabilRegla;
import com.ceiba.adnjulianhenao.validacion.ValidacionesEntrada;

public class Vigilante {
	
	@Autowired
	ValidacionesEntrada validaciones;
	
	@Autowired
	DiaHabilRegla diaHabilregla;
	
	List<ValidacionesEntrada> listaValidaciones = new ArrayList<>();
	
	public void inicializarValidaciones(){
		listaValidaciones.add(diaHabilregla);		
	}
	
	public void registrar(ModelVehiculo vehiculo){
		for(ValidacionesEntrada v: listaValidaciones){
			v.validar(vehiculo);
		}
	}
	
	
	

}
