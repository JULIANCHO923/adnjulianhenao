package com.ceiba.adnjulianhenao.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExcepcionConflicto extends RuntimeException{

	public ExcepcionConflicto(){}
	
	public ExcepcionConflicto(String mensaje){
		super(mensaje);		
	}
	
}
