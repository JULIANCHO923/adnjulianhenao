package com.ceiba.adnjulianhenao.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ceiba.adnjulianhenao.convertidor.ConvertidorTipoVehiculo;
import com.ceiba.adnjulianhenao.convertidor.ConvertidorVehiculo;
import com.ceiba.adnjulianhenao.dominioparqueadero.Vigilante;
import com.ceiba.adnjulianhenao.entidad.EntidadVehiculo;
import com.ceiba.adnjulianhenao.modelo.ModeloVehiculo;
import com.ceiba.adnjulianhenao.repositorio.IRepositorioVehiculo;

@Service("servicioVehiculo")
public class ServicioVehiculo {

	@Autowired
	@Qualifier("repositorioVehiculo")
	private IRepositorioVehiculo iRepositorioVehiculo;

	@Autowired
	@Qualifier("convertidorVehiculo") 
	private ConvertidorVehiculo convertidorVehiculo;

	@Autowired
	@Qualifier("convertidorTipoVehiculo")
	private ConvertidorTipoVehiculo convertidorTipoVehiculo;

	@Autowired
	@Qualifier("vigilante")
	private Vigilante vigilante;

	public void crear(ModeloVehiculo modeloVehiculo) {
		vigilante.registrarEntrada(modeloVehiculo);
	}

	public void insertar(ModeloVehiculo modeloVehiculo) {
		iRepositorioVehiculo.save(convertidorVehiculo.convertirModeloAEntidad(modeloVehiculo));
	}

	public void actualizar(ModeloVehiculo modeloVehiculo) {		
		if (iRepositorioVehiculo.findByPlaca(modeloVehiculo.getPlaca()) != null) {
			iRepositorioVehiculo.save(convertidorVehiculo.convertirModeloAEntidad(modeloVehiculo));
		}
	}

	public void generarSalidaVehiculo(int idRegistro, String placa) {
		vigilante.registrarSalida(idRegistro, placa);
	}

	public List<ModeloVehiculo> obtenerVehiculos() {
		return convertidorVehiculo.convertirLista(iRepositorioVehiculo.findAll());
	}

	public ModeloVehiculo obtenerporId(int idVehiculo) {
		EntidadVehiculo entidadVehiculo = iRepositorioVehiculo.findById(idVehiculo);
		if (entidadVehiculo == null) {
			return null;
		} else {
			return convertidorVehiculo.convertirEntidadAModelo(entidadVehiculo);
		}
	}

	public ModeloVehiculo obtenerPorPlaca(String placa) {
		EntidadVehiculo entidadVehiculo = iRepositorioVehiculo.findByPlaca(placa);
		if (entidadVehiculo == null) {
			return null;
		} else {
			return convertidorVehiculo.convertirEntidadAModelo(entidadVehiculo);
		}
	}

}
