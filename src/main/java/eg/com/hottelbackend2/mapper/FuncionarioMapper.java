package eg.com.hottelbackend2.mapper;

import eg.com.hottelbackend2.dto.FuncionarioDto;
import eg.com.hottelbackend2.entity.Funcionario;

public class FuncionarioMapper {
    public static FuncionarioDto mapFuncionarioDto(Funcionario funcionario){
        return new FuncionarioDto(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getEmail()

        );

    }

    public static Funcionario mapFuncionario(FuncionarioDto funcionarioDto) {
        return new Funcionario(
                funcionarioDto.getId(),
                funcionarioDto.getNome(),
                funcionarioDto.getEmail()
        );

    }
}

