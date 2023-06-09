package uelbosque.lerni.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uelbosque.lerni.DAO.ProfesorDAO;

import uelbosque.lerni.model.Profesor;




@RestController
@RequestMapping("/profesor")
public class ProfesorService {
	
	@Autowired
	ProfesorDAO profesorDAO;
	
	@CrossOrigin(origins ="*")
	@PostMapping("/nuevo-profesor")
	public ResponseEntity<Profesor> crearProfesor(@Valid @RequestBody Profesor pro){
		if(!pro.equals(null)){
			profesorDAO.save(pro);
			return ResponseEntity.ok().build();
		}else{
			return ResponseEntity.badRequest().build();
		}
	}
	
	@CrossOrigin(origins ="*")
	/* tomar todas las profesor*/
	@GetMapping("/profesores")
	public ResponseEntity<List<Profesor>> getAllProfesores(){
		if(profesorDAO.findAll().equals(null)|| profesorDAO.findAll().size()==0){
			return ResponseEntity.noContent().build();
		}	
			return ResponseEntity.ok().body(profesorDAO.findAll());
		
	}
	
	@CrossOrigin(origins ="*")
	/* obtener profesor por ID*/
	@GetMapping ("/profesores/{id}")
	public ResponseEntity<Profesor> getProfesorById(@PathVariable(value="id") Long empid){
		
		Profesor pro= profesorDAO.finOne(empid);
		if(pro==null){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(pro);
	}
	
	@CrossOrigin(origins ="*")
	/* actualizar profesor por id*/
	@PutMapping("/profesor/{id}")
	public ResponseEntity<Profesor> updateProfesor(@PathVariable(value="id") Long empid, @Valid @RequestBody Profesor profesorDetalle){
		Profesor pro = profesorDAO.finOne(empid);
		if(pro==null){
			return ResponseEntity.notFound().build();
		}
		pro.setCedula(profesorDetalle.getCedula());
		pro.setNombres(profesorDetalle.getNombres());
		pro.setApellidos(profesorDetalle.getApellidos());
		pro.setTitulo_profesional(profesorDetalle.getTitulo_profesional());
		pro.setId_calificacion(profesorDetalle.getId_calificacion());
		pro.setCodigo_curso(profesorDetalle.getCodigo_curso());
		pro.setCod_actividad_asignada(profesorDetalle.getCod_actividad_asignada());
		pro.setCod_usuario(profesorDetalle.getCod_usuario());
		pro.setUniversidad(profesorDetalle.getUniversidad());
		pro.setCorreo_electronico(profesorDetalle.getCorreo_electronico());
		
		Profesor actualizar= profesorDAO.save(pro);
		return ResponseEntity.ok().body(pro);
		
	}
	@CrossOrigin(origins ="*")
	@DeleteMapping("/profesor/{id}")
	public ResponseEntity<Profesor> deleteProfesor(@PathVariable(value="id") Long empid){
		Profesor ciu=profesorDAO.finOne(empid);
		if (ciu==null){
			return ResponseEntity.noContent().build();
		}
		profesorDAO.delete(ciu);
		return ResponseEntity.ok().build();
	}
}
