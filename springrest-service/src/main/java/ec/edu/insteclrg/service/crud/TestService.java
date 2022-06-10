package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.Test;
import ec.edu.insteclrg.dto.TestDTO;
import ec.edu.insteclrg.persistence.TestRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class TestService extends GenericCrudServiceImpl<Test, TestDTO> {

	@Autowired
	private TestRepository repository;

	@Override
	public Optional<Test> find(TestDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public TestDTO mapToDto(Test domain) {
		TestDTO testDTO = new TestDTO();
		testDTO.setId(domain.getId());
		testDTO.setName(domain.getName());
		return testDTO;
	}

	@Override
	public Test mapToDomain(TestDTO dto) {
		Test test = new Test();
		test.setId(dto.getId());
		test.setName(dto.getName());
		return null;
	}

}
