package com.ceiba.adnjulianhenao.repository;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.adnjulianhenao.entity.EntityParqueaderoRegistro;

/**
 * Se encarga de las peticiones en la base de datos
 * @author julian.henao
 *
 */
@Repository("repositorioParqueaderoRegistro")
public interface IRepositoryParqueaderoRegistro extends JpaRepository<EntityParqueaderoRegistro, Serializable>, PagingAndSortingRepository<EntityParqueaderoRegistro, Serializable>{ 
	
	public abstract EntityParqueaderoRegistro findById(int id);
	public abstract List<EntityParqueaderoRegistro> findByVehiculoId(int id);
	public abstract List<EntityParqueaderoRegistro> findByFechaEntradaAndFechaSalidaIsNull(Date fechaEntrada);		
	public abstract Page<EntityParqueaderoRegistro> findAll(Pageable pageable);
	public abstract Page<EntityParqueaderoRegistro> findByFechaEntradaAndFechaSalidaIsNull(Date fechaEntrada, Pageable pageable);
}
