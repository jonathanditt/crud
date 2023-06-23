package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.dto.EstudianteDto;
import com.app.web.servicio.EstudianteServicio;


;

@Controller
public class EstudianteControlador {

	@Autowired
	private EstudianteServicio servicio;

	@GetMapping({ "/estudiantes", "/" }) // le indicamos dos direcciones por las que podemos ingresar
	public String listarEstudiantes(Model modelo) {
		modelo.addAttribute("estudiantes", servicio.listarTodosLosEstudiantes());
		return "estudiantes";// nos retorna al archivo estudiantes
	}

	@GetMapping("/estudiantes/nuevo")
	public String mostrarFormularioDeRegistrarEstudiante(Model modelo) {
		EstudianteDto dto = new EstudianteDto();
		modelo.addAttribute("estudiante", dto);
		return "crear_estudiante";
	}

	@PostMapping("/estudiante")
	public String guardarEstudiante(@ModelAttribute("estudiante") EstudianteDto dto) {
		servicio.guardarEstudiante(dto);
		return "redirect:/estudiantes";
	}

	@GetMapping("/estudiantes/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable long id, Model modelo) {
		modelo.addAttribute("estudiante", servicio.obtenerEstudiantePorId(id));
		return "editar_estudiante";
	}

	@PostMapping("/estudiantes/{id}")
	public String actualizarEstudiante(@PathVariable long id, @ModelAttribute("estudiante") EstudianteDto dto,
			Model modelo) {
		EstudianteDto estudianteExistente = servicio.obtenerEstudiantePorId(id);
		estudianteExistente.setId(id);
		estudianteExistente.setNombre(dto.getNombre());
		estudianteExistente.setApellido(dto.getApellido());
		estudianteExistente.setEmail(dto.getEmail());

		servicio.actualizarEstudiante(estudianteExistente);
		return "redirect:/estudiantes";
	}

	@GetMapping("/estudiantes/{id}")
	public String eliminarEstudiante(@PathVariable long id) {
		servicio.eliminarEstudiante(id);
		return "redirect:/estudiantes";
	}
	
	@GetMapping("/estudiantes/ver/{id}")
	public String verEstudiante(@PathVariable long id, Model modelo) {
		modelo.addAttribute("estudiante", servicio.obtenerEstudiantePorId(id));
		return "ver_estudiante";
	}
	
	@GetMapping("/estudianteVolver")
	public String volverEstudiante() {
		return "redirect:/estudiantes";
	}
	

}
