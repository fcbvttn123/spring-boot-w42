package ca.sheridancollege.vutran.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ca.sheridancollege.vutran.beans.Student;

public interface StudentRepo extends MongoRepository<Student, String> {
	
	public List<Student> findByNameContainingOrderByName(String namePart);

}
