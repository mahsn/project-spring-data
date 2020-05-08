package project_spring_data.project_spring_data.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SpringDataUsers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String login;
	private String password;
	private String name;
	private String email;

	@OneToMany(mappedBy = "users",orphanRemoval = true, fetch = FetchType.EAGER) // object of spring users created in  Telephone Class
	private List<Telephone> listTelephones;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setListTelephones(List<Telephone> listTelephones) {
		this.listTelephones = listTelephones;
	}
	
	public List<Telephone> getListTelephones() {
		return listTelephones;
	}
	

}
