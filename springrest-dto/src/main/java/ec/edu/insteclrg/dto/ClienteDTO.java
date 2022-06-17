package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class ClienteDTO {
	
	private long id;
	
	/*private String code;*/

	private String name;
	
	private String surname;
	
	private String address;
	
	private String email;
	
	private String cellPhone;
	
	private String updateDate;
	
	private String creationDate;
}
