package com.ceiba.adnjulianhenao.testIntegracionEntradaVehiculo;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.adnjulianhenao.builderstest.TipoVehiculoBuilder;
import com.ceiba.adnjulianhenao.builderstest.VehiculoBuilder;
import com.ceiba.adnjulianhenao.excepcion.ExcepcionConflicto;
import com.ceiba.adnjulianhenao.modelo.ModeloTipoVehiculo;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;
import com.ceiba.adnjulianhenao.servicio.ServicioTipoVehiculo;
import com.ceiba.adnjulianhenao.servicio.ServicioVehiculo;

/**
 * Se realiza la prueba de ingreso para los siguientes casos: 1. Un vehiculo en la BD con
 * registro Inactivo (Ya salió del parqueadero):'ZXC234' 2. Un vehiculo en la BD
 * con registro Activo (Sin salir del parqueadero):'JKL925'
 * 
 * Cuando se ingresa la placa de un vehiculo matriculado en la base de datos se
 * ignoran los nuevos parametros y se mantienen los anteriores Esto debido a que
 * ese planteamiento no fue señalado en las especificaciones del problema
 * 
 * @author julian.henao
 *
 */

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRegistrarVehiculo {

	@Autowired
	ServicioVehiculo servicioVehiculo;

	
	@MockBean
	ServicioTipoVehiculo servicioTipoVehiculo;
	
	String placaExistenteSinSalir;
	String placaExistenteYaSalio;
	List<ModeloTipoVehiculo> tiposVehiculo ;
	
	@Before
	public void datosPrueba() {
		placaExistenteYaSalio = "ZXC234";
		placaExistenteSinSalir = "JKL925";
		tiposVehiculo = new ArrayList<>(); 
		tiposVehiculo.add(new TipoVehiculoBuilder().conId(1).conDescripcion("Automovil").build());
		tiposVehiculo.add(new TipoVehiculoBuilder().conId(2).conDescripcion("Moto").build());
	}

	/**
	 * Debe lanzarse una excepción de Conflicto, dado que no se ha sacado el
	 * vehiculo y se esta intentando ingresarlo
	 */
	
	@Test(expected = ExcepcionConflicto.class)
	@SqlGroup(@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:preparandoBD.sql"))
	public void InsertarPlacaExistenteSinSalir() {
		ModeloTipoVehiculo tipoVehiculoMoto = new TipoVehiculoBuilder().conId(2).conDescripcion("Moto").build();
		ModeloVehiculo vehiculo = new VehiculoBuilder().conPlaca(placaExistenteSinSalir)
				.conTipoVehiculo(tipoVehiculoMoto).conCilindraje(100).build();
		when(servicioTipoVehiculo.obtenerTipoVehiculos()).thenReturn(tiposVehiculo);
		servicioVehiculo.crear(vehiculo);
	}

		
	/**
	 * Un vehiculo que existe en la BD, pero no tiene registros activos en el
	 * parqueadero puede volver a ingresar, la desventaja es que en este
	 * proyecto no se esta considerando la actualización de los datos ingresados
	 * nuevos. Como se mencionó anteriormente, no hacia parte de las historia de
	 * usuario
	 */
	/*@Test(expected = Test.None.class)

	@SqlGroup(@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:preparandoBD.sql"))
	public void InsertarPlacaExistenteYaSalio() {
		ModeloTipoVehiculo tipoVehiculoAuto = new TipoVehiculoBuilder().conId(1).conDescripcion("Automovil").build();
		ModeloVehiculo vehiculo = new VehiculoBuilder().conPlaca(placaExistenteYaSalio)
				.conTipoVehiculo(tipoVehiculoAuto).conCilindraje(100).build();
		when(servicioTipoVehiculo.obtenerTipoVehiculos()).thenReturn(tiposVehiculo);
		servicioVehiculo.crear(vehiculo);
	}
*/
	@After
	@SqlGroup(@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:eliminandoDatosBD.sql"))
	public void eliminadoDatosBD() {
	}


}

