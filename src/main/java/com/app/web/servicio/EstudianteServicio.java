package com.app.web.servicio;

import java.util.List;

import com.app.web.dto.EstudianteDto;



public interface EstudianteServicio {
	
	public List<EstudianteDto> listarTodosLosEstudiantes();

	public EstudianteDto guardarEstudiante(EstudianteDto estudiante);
	
	public EstudianteDto obtenerEstudiantePorId(long id);
	
	public EstudianteDto actualizarEstudiante(EstudianteDto estudiante);
	
	public void eliminarEstudiante(long id);
}
