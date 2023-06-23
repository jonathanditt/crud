package com.app.web.convertir;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.app.web.dto.EstudianteDto;
import com.app.web.entidad.Estudiante;

@Component("estudianteConvert")
public class EstudianteConvert {

	public Estudiante estudianteADto(EstudianteDto dto) {
		Estudiante estudiante = new Estudiante();
		estudiante.setId(dto.getId());
		estudiante.setNombre(dto.getNombre());
		estudiante.setApellido(dto.getApellido());
		estudiante.setEmail(dto.getEmail());
		return estudiante;
	}

	public EstudianteDto dtoAEstudiante(Estudiante estudiante) {
		EstudianteDto dto = new EstudianteDto();
		dto.setId(estudiante.getId());
		dto.setNombre(estudiante.getNombre());
		dto.setApellido(estudiante.getApellido());
		dto.setEmail(estudiante.getEmail());
		return dto;
	}

	public List<EstudianteDto> dtoAEstudianteList(List<Estudiante> estudiante) {
		
		List<EstudianteDto> list = new ArrayList<EstudianteDto>();

		for (Estudiante estudiante2 : estudiante) {
			
			EstudianteDto dto = this.dtoAEstudiante(estudiante2);
			
			list.add(dto);
		}

		return list;
	}

}
