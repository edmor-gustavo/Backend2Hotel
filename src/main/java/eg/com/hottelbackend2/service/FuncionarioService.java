package eg.com.hottelbackend2.service;

import eg.com.hottelbackend2.dto.FuncionarioDto;

import java.util.List;

public interface FuncionarioService {
    FuncionarioDto createFuncionario(FuncionarioDto funcionarioDto);

    FuncionarioDto getFuncionarioById(Long funcionarioId);

    List<FuncionarioDto> getAllFuncionario();

    FuncionarioDto updateFuncionario(Long funcionario, FuncionarioDto updateFuncionario);

    void deleteFuncionario(Long funcionarioId);
}
