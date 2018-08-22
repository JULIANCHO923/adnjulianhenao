package com.ceiba.adnjulianhenao.testIntegracionSalidaVehiculo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.adnjulianhenao.dominioparqueadero.Calendario;
import com.ceiba.adnjulianhenao.excepcion.ExcepcionSobreCosto;
import com.ceiba.adnjulianhenao.modelo.ModeloParqueaderoRegistro;
import com.ceiba.adnjulianhenao.servicio.ServicioParqueaderoRegistro;
import com.ceiba.adnjulianhenao.servicio.ServicioVehiculo;

/**
 * Con base a las reglas de salida propuestas en la descripci�n del problema: (Ambos con cilindraje mayor a 500)
 * Si el carro permaneci� un d�a y 3 horas se debe cobrar 11.000 : 'ABC123' A LA FECHA ENTRADA SUMARLE 27 HRS -> 1 DIA 3 HRS
 * Adem�s Moto con cilindraje menor o igual a 500 -> 'POI654' --> 5.500
 * *********************
 * Si la moto permaneci� un 10 horas y es de 650CC se cobra 6.000 :  'JKL925' A LA FECHA ENTRADA SUMARLE 10 HRS    
 * Adem�s Automovil con cilindraje Mayor a 500 'QWE098' --> Cobro 8.000
 * 
 * @author julian.henao
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSalidaVehiculo {

	@Autowired
	ServicioVehiculo servicioVehiculo;
	
	@MockBean
	Calendario calendario;
	
	@Autowired
	ServicioParqueaderoRegistro servicioParqueaderoRegistro;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	String placaAuto27Horas;
	int idRegistroAuto27Horas;
	long costoAuto27;
	
	String placaMoto27Horas;
	int idRegistroMoto27Horas;
	long costoMoto27;
	
	String placaAuto10Horas;
	int idRegistroAuto10Horas;
	long costoAuto10;
	
	String placaMoto10Horas;
	int idRegistroMoto10Horas;	
	long costoMoto10;
	
	int horas10ACalcular;
	int horas27ACalcular;
	
	@Before
	public void datosPrueba(){
		
	horas10ACalcular = 10;
	horas27ACalcular = 27;
		
	placaAuto27Horas = "ABC123";
	idRegistroAuto27Horas = 1;
	costoAuto27 = 11000;
	
	placaMoto27Horas = "POI654";
	idRegistroMoto27Horas = 3;
	costoMoto27 = 5500;
	
	placaAuto10Horas = "QWE098";
	idRegistroAuto10Horas = 2;
	costoAuto10 = 8000;
	
	placaMoto10Horas = "JKL925";
	idRegistroMoto10Horas = 4;	
	costoMoto10 = 6000;
	}
	ModeloParqueaderoRegistro registro;
	
	/**
	 * Se espera que la moto con cilindraje mayor a 500 genere una excepci�n, 
	 * Esperamos que el resultado del calculo coincida con lo esperado
	 *   
	 */
	@Test
	@SqlGroup(@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:preparandoBD.sql"))
	public void ReglaConCilindrajeMayor500Moto() {				
				
		exceptionRule.expect(ExcepcionSobreCosto.class);
		exceptionRule.expectMessage("Valor de cilindraje supera los 500 CC, esto genera un sobre costo de 2000 sobre el valor total");
		
		when(calendario.obtenerFechaActual()).thenReturn(LocalDateTime.of(2018, 8, 21, 10, 20).plusHours(horas10ACalcular));
		servicioVehiculo.generarSalidaVehiculo(idRegistroMoto10Horas, placaMoto10Horas);		
		assertEquals(costoMoto10,servicioParqueaderoRegistro.obtenerRegistroPorId(idRegistroMoto10Horas).getCostoTotal());					
	
	}
	
	@Test
	public void ReglaConCilindrajeMENOR500Moto() {							
		when(calendario.obtenerFechaActual()).thenReturn(LocalDateTime.of(2018, 8, 21, 10, 20).plusHours(horas27ACalcular));
		servicioVehiculo.generarSalidaVehiculo(idRegistroMoto27Horas, placaMoto27Horas);
		assertEquals(costoMoto27,servicioParqueaderoRegistro.obtenerRegistroPorId(idRegistroMoto27Horas).getCostoTotal());			
	}

	
	/**
	 * Con esto confirmamos que as� el automovil tenga un cilindraje mayor a 500
	 * a est�, no se le aplica el sobre costo
	 */
	@Test
	public void ReglaConCilindrajeMAYOR500Automovil() {				
		when(calendario.obtenerFechaActual()).thenReturn(LocalDateTime.of(2018, 8, 21, 10, 20).plusHours(horas10ACalcular));
		servicioVehiculo.generarSalidaVehiculo(idRegistroAuto10Horas, placaAuto10Horas);		
		assertEquals(costoAuto10,servicioParqueaderoRegistro.obtenerRegistroPorId(idRegistroAuto10Horas).getCostoTotal());			
	}
	
	@Test
	public void ReglaConCilindrajeMENOR500Automovil() {				
		when(calendario.obtenerFechaActual()).thenReturn(LocalDateTime.of(2018, 8, 21, 10, 20).plusHours(horas27ACalcular));
		servicioVehiculo.generarSalidaVehiculo(idRegistroAuto27Horas, placaAuto27Horas);		
		assertEquals(costoAuto27,servicioParqueaderoRegistro.obtenerRegistroPorId(idRegistroAuto27Horas).getCostoTotal()); 		
	}

	@After
	@SqlGroup(@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:eliminandoDatosBD.sql"))
	public void eliminadoDatosBD(){	}
}
