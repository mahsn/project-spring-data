package project_spring_data.project_spring_data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project_spring_data.project_spring_data.model.SpringDataUsers;

@Repository
public interface SpringDataUserInterface extends CrudRepository<SpringDataUsers, Long> {
	
	@Transactional(readOnly = true)
	@Query(value = "select p from SpringDataUsers p where p.name like %?1%")
	public List<SpringDataUsers> searchByName(String name);
	
	@Transactional(readOnly = true)
	@Query(value = "select p from SpringDataUsers p where p.name = :paramname")
	public  SpringDataUsers searchByParameter(@Param("paramname") String paramname);
	
	default < S extends SpringDataUsers> S saveAtual(S entity) {
		return save(entity);
	}
	
	@Modifying
	@Transactional
	@Query(value = "delete from  SpringDataUsers u where u.name = ?1")
	public void deleteByName(String name);
	
	
}
