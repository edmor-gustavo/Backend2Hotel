package eg.com.hottelbackend2.service.Impl;

import eg.com.hottelbackend2.dto.FuncionarioDto;
import eg.com.hottelbackend2.entity.Funcionario;
import eg.com.hottelbackend2.exception.ResourceNotFoundException;
import eg.com.hottelbackend2.mapper.FuncionarioMapper;
import eg.com.hottelbackend2.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FuncionarioService  implements eg.com.hottelbackend2.service.FuncionarioService {

    private FuncionarioRepository funcionarioRepository;


    @Override
    public FuncionarioDto createFuncionario(FuncionarioDto funcionarioDto) {
        Funcionario funcionario = FuncionarioMapper.mapFuncionario(funcionarioDto);
        Funcionario savedFuncionario = funcionarioRepository.save(funcionario);
        return FuncionarioMapper.mapFuncionarioDto(savedFuncionario);
    }

    @Override
    public FuncionarioDto getFuncionarioById(Long funcionarioId) {
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("O Id do funcionario não existe" + funcionarioId));
        return FuncionarioMapper.mapFuncionarioDto(funcionario);
    }

    @Override
    public List<FuncionarioDto> getAllFuncionario() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream().map(FuncionarioMapper::mapFuncionarioDto)
                .collect(Collectors.toList());
    }

    @Override
    public FuncionarioDto updateFuncionario(Long funcionario, FuncionarioDto updateFuncionario) {
        Funcionario funcionario1 = funcionarioRepository.findById(funcionario).orElseThrow(
                () -> new ResourceNotFoundException("O Id do cliente não existe: " + funcionario)
        );
        funcionario1.setNome(updateFuncionario.getNome());
        funcionario1.setEmail(updateFuncionario.getEmail());

        Funcionario updatedFuncionarioObj = funcionarioRepository.save(funcionario1);
        return FuncionarioMapper.mapFuncionarioDto(updatedFuncionarioObj);
    }

    @Override
    public void deleteFuncionario(Long funcionarioId) {
        Funcionario funcionario = funcionarioRepository.findById (funcionarioId).orElseThrow(
                () -> new ResourceNotFoundException("O Id do cliente não existe")
        );
        funcionarioRepository.deleteById (funcionarioId);
    }

}