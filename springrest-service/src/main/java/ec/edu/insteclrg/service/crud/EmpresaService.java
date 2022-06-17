package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.common.exception.ResourceNotFoundException;
import ec.edu.insteclrg.domain.Empresa;
import ec.edu.insteclrg.dto.EmpresaDTO;
import ec.edu.insteclrg.persistence.EmpresaRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class EmpresaService extends GenericCrudServiceImpl<Empresa, EmpresaDTO>{

	@Autowired
	private EmpresaRepository repository;

	@Override
	public Optional<Empresa> find(EmpresaDTO dto) {
		return repository.findByRuc(dto.getRuc());
	}

	@Override
	public EmpresaDTO mapToDto(Empresa domain) {
		EmpresaDTO empresaDTO = new EmpresaDTO();
		empresaDTO.setId(domain.getId());
		empresaDTO.setName(domain.getName());
		empresaDTO.setRuc(domain.getRuc());
		empresaDTO.setDirection(domain.getDirection());
		empresaDTO.setCellphone(domain.getCellphone());
		empresaDTO.setEmail(domain.getEmail());
		empresaDTO.setWebSite(domain.getWebSite());
		empresaDTO.setLogo(domain.getLogo());
		return empresaDTO;
	}

	@Override
	public Empresa mapToDomain(EmpresaDTO dto) {
		Empresa empresa = new Empresa();
		empresa.setId(dto.getId());
		empresa.setName(dto.getName());
		empresa.setRuc(dto.getRuc());
		empresa.setDirection(dto.getDirection());
		empresa.setCellphone(dto.getCellphone());
		empresa.setEmail(dto.getEmail());
		empresa.setWebSite(dto.getWebSite());
		empresa.setLogo(dto.getLogo());
		return empresa;
	}

	public void update(String ruc, EmpresaDTO dto) {
		EmpresaDTO empresaDto = new EmpresaDTO();
		empresaDto.setRuc(ruc);
		Optional<Empresa> optionalTest = repository.findByRuc(empresaDto.getRuc());
		if (!optionalTest.isPresent()) {
			throw new ResourceNotFoundException(String.format("El ruc %s no se encuentra registrado", ruc));
		}
		Empresa empresa = optionalTest.get();
		empresa.setName(dto.getName());
		repository.save(empresa);
	}
}
