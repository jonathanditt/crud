package com.app.web.servicio;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.web.convertir.EstudianteConvert;
import com.app.web.dto.EstudianteDto;
import com.app.web.entidad.Estudiante;
import com.app.web.repositorio.EstudianteRepositorio;

@Service
public class EstudianteServicioImpl implements EstudianteServicio {

	@Autowired
	private EstudianteRepositorio repositorio;

	@Autowired
	@Qualifier("estudianteConvert")
	private EstudianteConvert estudianteConvert;

	@Override
	public List<EstudianteDto> listarTodosLosEstudiantes() {
		
		List<Estudiante> estudiante = repositorio.findAll();
		
		return estudianteConvert.dtoAEstudianteList(estudiante);
	}

	@Override
	public EstudianteDto guardarEstudiante(EstudianteDto estudiante) {
		
		Estudiante entity = estudianteConvert.estudianteADto(estudiante);
		entity = repositorio.save(entity);
		
		return estudianteConvert.dtoAEstudiante(entity);
	}

	@Override
	public EstudianteDto obtenerEstudiantePorId(long id) {

		Estudiante entity = repositorio.findById(id).get();

		return estudianteConvert.dtoAEstudiante(entity);
	}

	@Override
	public EstudianteDto actualizarEstudiante(EstudianteDto estudiante) {
		Estudiante entity = estudianteConvert.estudianteADto(estudiante);
		entity = repositorio.save(entity);

		return estudianteConvert.dtoAEstudiante(entity);
	}

	@Override
	public void eliminarEstudiante(long id) {
		repositorio.deleteById(id);
	}

}
