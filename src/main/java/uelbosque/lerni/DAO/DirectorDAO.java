package uelbosque.lerni.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uelbosque.lerni.model.Director;
import uelbosque.lerni.repository.DirectorRepository;

@Service
public class DirectorDAO {
	
	@Autowired
	DirectorRepository directorRepository;
	
	/* guardar director */
	public Director save(Director dir){
		return  directorRepository.save(dir);
	}
	/* Buscar director */
	public List<Director> findAll(){
		return directorRepository.findAll();
	}
	/* Buscar director por ID */
	public Director finOne(Long empid){
		return directorRepository.findOne(empid);
	}
	/* borrar director por ID*/
	
	public void delete(Director emp){
		directorRepository.delete(emp);
	}
	
}
