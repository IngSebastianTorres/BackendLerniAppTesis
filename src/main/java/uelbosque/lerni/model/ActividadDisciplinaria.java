package uelbosque.lerni.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="actividad_disciplinaria")
public class ActividadDisciplinaria {
	
	@Id
	@GeneratedValue
	private Long cod_actividad;
	private String nombre;
	private String descripcion_actividad;
	private String recompensa_por_cumplimiento_actividad;
	
	
	public Long getCod_actividad() {
		return cod_actividad;
	}
	public void setCod_actividad(Long cod_actividad) {
		this.cod_actividad = cod_actividad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion_actividad() {
		return descripcion_actividad;
	}
	public void setDescripcion_actividad(String descripcion_actividad) {
		this.descripcion_actividad = descripcion_actividad;
	}
	public String getRecompensa_por_cumplimiento_actividad() {
		return recompensa_por_cumplimiento_actividad;
	}
	public void setRecompensa_por_cumplimiento_actividad(String recompensa_por_cumplimiento_actividad) {
		this.recompensa_por_cumplimiento_actividad = recompensa_por_cumplimiento_actividad;
	}
	

	
	
	
	
	
}
