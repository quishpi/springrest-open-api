package ec.edu.insteclrg.app.api.v1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.insteclrg.common.dto.ApiResponseDTO;
import ec.edu.insteclrg.domain.Empresa;
import ec.edu.insteclrg.dto.EmpresaDTO;
import ec.edu.insteclrg.service.crud.EmpresaService;

@RestController
@RequestMapping(value = "/api/v1.0/empresa")
public class EmpresaController {
	
	@Autowired
	EmpresaService service;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody EmpresaDTO dto) {
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@PutMapping(path = "/{ruc}")
	public ResponseEntity<Object> update(@PathVariable String ruc, @RequestBody EmpresaDTO dto) {
		service.update(ruc, dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Object> findAll() {
		List<EmpresaDTO> list = service.findAll(new EmpresaDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<EmpresaDTO>> response = new ApiResponseDTO<>(true, list);
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{ruc}")
	public ResponseEntity<Object> find(@PathVariable String ruc) {
		EmpresaDTO dto = new EmpresaDTO();
		dto.setRuc(ruc);
		Optional<Empresa> empresa = service.find(dto);
		if (empresa.isPresent()) {
			ApiResponseDTO<Empresa> response = new ApiResponseDTO<>(true, empresa.get());
			return (new ResponseEntity<Object>(response, HttpStatus.OK));
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
}
