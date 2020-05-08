package project_spring_data.project_spring_data;

import java.util.List;
import java.util.Optional;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import project_spring_data.project_spring_data.dao.SpringDataUserInterface;
import project_spring_data.project_spring_data.dao.TelephoneInterface;
import project_spring_data.project_spring_data.model.SpringDataUsers;
import project_spring_data.project_spring_data.model.Telephone;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class SpringDataTest {
	
	@Autowired
	private SpringDataUserInterface userInterface;
	
	@Autowired
	private TelephoneInterface telephoneInterface;
	
	@org.junit.Test
	public void insertTest() {
		SpringDataUsers springDataUsers = new SpringDataUsers();
		springDataUsers.setLogin("mhsn");
		springDataUsers.setEmail("mhsn@test.com");
		springDataUsers.setName("mhsn");
		springDataUsers.setPassword("mhsn123");
		userInterface.save(springDataUsers);
		System.out.println("Insert initiated successfully");
	}
	
	@org.junit.Test
	public void search() {
		Optional<SpringDataUsers> springDataUsers = userInterface.findById(3L);
		
		System.out.println(springDataUsers.get().getId());
		System.out.println(springDataUsers.get().getName());
		System.out.println(springDataUsers.get().getLogin());
		System.out.println(springDataUsers.get().getPassword());
		System.out.println(springDataUsers.get().getEmail());
		
		for (Telephone telephone : springDataUsers.get().getListTelephones()) {
			System.out.println(telephone.getTelephoneType());
			System.out.println(telephone.getTelephoneNumber());
		}
	}
	
	@org.junit.Test
	public void searchAll() {
		Iterable<SpringDataUsers> springDataUsers = userInterface.findAll();
		for (SpringDataUsers springDataUsers2 : springDataUsers) {
			System.out.print(springDataUsers2.getId() + " ");
			System.out.print(springDataUsers2.getName() + " ");
			System.out.println(springDataUsers2.getEmail() + " ");
			System.out.print(springDataUsers2.getLogin() + " ");
			System.out.print(springDataUsers2.getPassword() + " ");
			System.out.println();
		}
	}
	
	@org.junit.Test
	public void updateUser() {
		Optional<SpringDataUsers> springDataUsers = userInterface.findById(2L);
		SpringDataUsers data = springDataUsers.get();
		data.setEmail("mhsn@mhsnyy.com");
		userInterface.save(data);
	}
	
	@org.junit.Test
	public void deleteUser() {
		Optional<SpringDataUsers> springDataUsers = userInterface.findById(2L);
		userInterface.delete(springDataUsers.get());
		
	}
	
	@org.junit.Test
	public void searchUserByName() {
		List<SpringDataUsers>  list = userInterface.searchByName("test");
		for (SpringDataUsers springDataUsers : list) {
			System.out.println(springDataUsers.getId());
			System.out.println(springDataUsers.getName());
			System.out.println(springDataUsers.getEmail());
		}
		
	}
	
	@org.junit.Test
	public void searchUserByParameter() {
		SpringDataUsers  dataUserst = userInterface.searchByParameter("test");
		System.out.println(dataUserst.getId());
		System.out.println(dataUserst.getName());
		System.out.println(dataUserst.getEmail());
		
	}
	
	@org.junit.Test
	public void deleteUserByName() {
		userInterface.deleteByName("test");
		
	}
	
	@org.junit.Test
	public void insertTelephone() {
	
		Optional<SpringDataUsers> springDataUsers = userInterface.findById(3L);
		Telephone telephone = new Telephone();
		telephone.setUsers(springDataUsers.get());
		telephone.setTelephoneType("celular");
		telephone.setTelephoneNumber("2243-4431");
		telephoneInterface.save(telephone);
		
	}
}
