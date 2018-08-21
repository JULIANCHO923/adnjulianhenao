package com.ceiba.adnjulianhenao.testUnitarioEntradaVehiculo;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.adnjulianhenao.builderstest.ParqueaderoRegistroBuilder;
import com.ceiba.adnjulianhenao.builderstest.TipoVehiculoBuilder;
import com.ceiba.adnjulianhenao.builderstest.VehiculoBuilder;
import com.ceiba.adnjulianhenao.excepcion.ExcepcionConflicto;
import com.ceiba.adnjulianhenao.modelo.ModeloParqueaderoRegistro;
import com.ceiba.adnjulianhenao.modelo.ModeloTipoVehiculo;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;
import com.ceiba.adnjulianhenao.servicio.ServicioParqueaderoRegistro;
import com.ceiba.adnjulianhenao.servicio.ServicioVehiculo;
import com.ceiba.adnjulianhenao.validacion.entrada.ReglaVehiculoSinSalirVuelveAEntrar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestReglaVehiculoSinSalirVuelveAEntrar {

	
	@MockBean
	ServicioVehiculo servicioVehiculo;

	@MockBean
	ServicioParqueaderoRegistro servicioParqueaderoRegistro;

	@Autowired
	ReglaVehiculoSinSalirVuelveAEntrar reglaVehiculoSinSalirVuelveAEntrar;
	
	ModeloVehiculo vehiculo;
	ModeloParqueaderoRegistro registro;
	
	
	
	@Before
	public void vehiculoEnSistema(){
		ModeloTipoVehiculo tipoVehiculoMoto = new TipoVehiculoBuilder().conId(2).conDescripcion("Moto").build();			
		vehiculo = new VehiculoBuilder().conPlaca("ABC123").conTipoVehiculo(tipoVehiculoMoto).conCilindraje(100).build();
		LocalDateTime fechaEntrada = LocalDateTime.now();
		registro = new ParqueaderoRegistroBuilder().conVehiculo(vehiculo).conFechaEntrada(fechaEntrada).build();
		
	}
	
	
	@Test(expected = ExcepcionConflicto.class)
	public void ReglaVehiculoRegistradoNoPuedeVolverAEntrar() {
			
			when(servicioVehiculo.obtenerPorPlaca(vehiculo.getPlaca())).thenReturn(vehiculo);
			when(servicioParqueaderoRegistro
					.obtenerRegistrosPorVehiculosPorIdSinSalir(vehiculo.getId())).thenReturn(registro);
			
			reglaVehiculoSinSalirVuelveAEntrar.validar(vehiculo);		
			
	}
	
	@Test(expected = Test.None.class)
	public void ReglaVehiculoSINRegistrarPuedeEntrar() {
			
			when(servicioVehiculo.obtenerPorPlaca(vehiculo.getPlaca())).thenReturn(vehiculo);
			when(servicioParqueaderoRegistro
					.obtenerRegistrosPorVehiculosPorIdSinSalir(vehiculo.getId())).thenReturn(registro);
			
			ModeloTipoVehiculo tipoVehiculoMoto = new TipoVehiculoBuilder().conId(2).conDescripcion("Moto").build();			
			ModeloVehiculo vehiculoNuevo = new VehiculoBuilder().conPlaca("JKL654").conTipoVehiculo(tipoVehiculoMoto).conCilindraje(100).build();
			
			reglaVehiculoSinSalirVuelveAEntrar.validar(vehiculoNuevo);		
			
	}
	

}
