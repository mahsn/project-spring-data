package project_spring_data.project_spring_data.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import project_spring_data.project_spring_data.model.Telephone;

@Repository
public interface TelephoneInterface extends CrudRepository<Telephone, Long>{

	
}
