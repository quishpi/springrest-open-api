package ec.edu.insteclrg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String ruc;
	
	@Column(nullable = false)
	private String direction;
	
	@Column(nullable = false)
	private String cellphone;
	
	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String WebSite;
	
	@Column(nullable = false)
	private String logo;
}
