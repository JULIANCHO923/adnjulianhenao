package com.ceiba.adnjulianhenao.testUnitarioEntradaVehiculo;

import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.adnjulianhenao.builderstest.ParqueaderoEspacioDisponibleBuilder;
import com.ceiba.adnjulianhenao.builderstest.TipoVehiculoBuilder;
import com.ceiba.adnjulianhenao.builderstest.VehiculoBuilder;
import com.ceiba.adnjulianhenao.excepcion.ExcepcionConflicto;
import com.ceiba.adnjulianhenao.modelo.ModeloParqueaderoEspacioDisponible;
import com.ceiba.adnjulianhenao.modelo.ModeloTipoVehiculo;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;
import com.ceiba.adnjulianhenao.servicio.ServicioParqueaderoEspacioDisponible;
import com.ceiba.adnjulianhenao.validacion.entrada.ReglaDisponibilidadEspacio;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestReglaDisponibilidadEspacio {

	
	@MockBean
	ServicioParqueaderoEspacioDisponible servicioParqueaderoEspacioDisponible;
	
	@Autowired
	ReglaDisponibilidadEspacio ReglaDisponibilidadEspacio; 
	
	
	@Test(expected = Test.None.class)
	public void ReglaSIHayDisponibilidadEspacioParaVehiculo(){
		ModeloTipoVehiculo tipoVehiculoMoto = new TipoVehiculoBuilder().conId(2).conDescripcion("Moto").build();
		ModeloVehiculo vehiculo = new VehiculoBuilder().conPlaca("ABC123").conTipoVehiculo(tipoVehiculoMoto).conCilindraje(100).build();	 
		int espacioActual = 9;
		int limiteEspacio = 10;		
		ModeloParqueaderoEspacioDisponible modeloParqueaderoEspacioDisponible = new ParqueaderoEspacioDisponibleBuilder().conId(1).conTipoVehiculo(tipoVehiculoMoto).conEspacioActual(espacioActual).conLimiteEspacio(limiteEspacio).build();
	
		when(servicioParqueaderoEspacioDisponible.obtenerEspacioDisponiblePorTipoVehiculo(tipoVehiculoMoto.getId())).thenReturn(modeloParqueaderoEspacioDisponible);
		ReglaDisponibilidadEspacio.validar(vehiculo);
	}
	
	
	@Test(expected = ExcepcionConflicto.class)
	public void ReglaNOHayDisponibilidadEspacioParaVehiculo(){
		ModeloTipoVehiculo tipoVehiculoVehiculo = new TipoVehiculoBuilder().conId(1).conDescripcion("Automovil").build();
		
		ModeloVehiculo vehiculo = new VehiculoBuilder().conPlaca("ABC123").conTipoVehiculo(tipoVehiculoVehiculo).conCilindraje(100).build();	 
		int espacioActual = 20;
		int limiteEspacio = 20;
		ModeloParqueaderoEspacioDisponible modeloParqueaderoEspacioDisponible = new ParqueaderoEspacioDisponibleBuilder().conId(1).conTipoVehiculo(tipoVehiculoVehiculo).conEspacioActual(espacioActual).conLimiteEspacio(limiteEspacio).build();	
		
		when(servicioParqueaderoEspacioDisponible.obtenerEspacioDisponiblePorTipoVehiculo(tipoVehiculoVehiculo.getId())).thenReturn(modeloParqueaderoEspacioDisponible);
		ReglaDisponibilidadEspacio.validar(vehiculo);
	}
	
	
	
	
	
}
