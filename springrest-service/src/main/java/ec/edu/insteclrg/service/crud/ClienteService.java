package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Cliente;
import ec.edu.insteclrg.dto.ClienteDTO;
import ec.edu.insteclrg.persistence.ClienteRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class ClienteService extends GenericCrudServiceImpl<Cliente, ClienteDTO>{
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public Optional<Cliente> find(ClienteDTO dto) {
		/*return repository.findByCode(dto.getCode());*/
		return repository.findById(dto.getId());
	}

	@Override
	public ClienteDTO mapToDto(Cliente domain) {
		ClienteDTO ClienteDTO = new ClienteDTO();
		ClienteDTO.setId(domain.getId());
		/*ClienteDTO.setCode(domain.getCode());*/
		ClienteDTO.setName(domain.getName());
		return ClienteDTO;
	}

	@Override
	public Cliente mapToDomain(ClienteDTO dto) {
		Cliente Cliente = new Cliente();
		Cliente.setId(dto.getId());
		/*Cliente.setCode(dto.getCode());*/
		Cliente.setName(dto.getName());
		return Cliente;
	}

	/*public void update(String code, ClienteDTO dto) {
		ClienteDTO ClienteDTO = new ClienteDTO();
		ClienteDTO.setCode(code);
		Optional<Cliente> optionalCliente = repository.findByCode(ClienteDTO.getCode());
		if (!optionalCliente.isPresent()) {
			throw new ResourceNotFoundException(String.format("El código %s no se encuentra registrado", code));
		}
		Cliente Cliente = optionalCliente.get();
		Cliente.setName(dto.getName());
		repository.save(Cliente);
	}*/
	
	public void update(Long id, ClienteDTO dto) {
		ClienteDTO ClienteDTO = new ClienteDTO();
		ClienteDTO.setId(id);;
		Optional<Cliente> optionalCliente = repository.findById(ClienteDTO.getId());
		if (!optionalCliente.isPresent()) {
			throw new ResourceNotFoundException(String.format("El ID %s no se encuentra registrado", id));
		}
		Cliente Cliente = optionalCliente.get();
		Cliente.setName(dto.getName());
		repository.save(Cliente);
	}
}
