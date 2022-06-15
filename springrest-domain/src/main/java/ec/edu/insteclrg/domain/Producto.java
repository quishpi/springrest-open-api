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
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long id;
	
	@Column (unique = true, nullable = false)
	private String code;
	
	@Column (nullable = false)
	private String name;
	

	@Column (nullable = false)
	private String description;
	

	@Column (nullable = false)
	private int price;


	@Column (nullable = false)
	private int stockmin;
	

	@Column (nullable = false)
	private int stockmax;
	

	/*@Column (updatable = false, unique = true, nullable = false)
	private long idimpuesto;
	
	@Column (updatable = false, unique = true, nullable = false)
	private long idtarifaiva;
	
	@Column (updatable = false, unique = true, nullable = false)
	private long idtarifaice;*/
}
