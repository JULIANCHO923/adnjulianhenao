package com.ceiba.adnjulianhenao.vehiculo.unitarias;

import static org.junit.Assert.assertEquals;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.adnjulianhenao.dominioparqueadero.Calendario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class calcularHoras {

	@Autowired
	Calendario calendario;
	
	/**
	 * Prueba que el dia de la semana, conincida con el que devuelve el sistema
	 */
	@Test
	public void test() {		
		assertEquals(1, calendario.obtenerDiaActual());
	}

}
