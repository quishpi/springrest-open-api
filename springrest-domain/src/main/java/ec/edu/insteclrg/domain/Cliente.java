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
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;
	
	@Column(unique = true, nullable = false)
	private String identificationNumber;
	
	/*@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "identification_id")
	private tipoDocumento identification;*/
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String surname;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String cellPhone;
	
	@Column(nullable = false)
	private String updateDate;
	
	@Column(nullable = false)
	private String creationDate;
}
