package com.ceiba.adnjulianhenao.repositorio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.adnjulianhenao.entidad.EntidadParqueaderoRegistro;

/**
 * Se encarga de las peticiones en la base de datos
 * @author julian.henao
 *
 */



@Repository("repositorioParqueaderoRegistro")
public interface IRepositorioParqueaderoRegistro extends JpaRepository<EntidadParqueaderoRegistro, Serializable>, PagingAndSortingRepository<EntidadParqueaderoRegistro, Serializable>{ 
	
	public abstract EntidadParqueaderoRegistro findById(int id);
	public abstract List<EntidadParqueaderoRegistro> findByVehiculoId(int id);
	public abstract List<EntidadParqueaderoRegistro> findByFechaEntradaAndFechaSalidaIsNull(Calendar fechaEntrada);		
	public abstract Page<EntidadParqueaderoRegistro> findAll(Pageable pageable);	
	public abstract EntidadParqueaderoRegistro findByVehiculoIdAndFechaSalidaIsNull(int id);
	
}
