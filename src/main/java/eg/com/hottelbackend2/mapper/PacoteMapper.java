package eg.com.hottelbackend2.mapper;

import eg.com.hottelbackend2.dto.PacoteDto;
import eg.com.hottelbackend2.entity.Pacote;

public class PacoteMapper {
    public static PacoteDto mapPacoteDto(Pacote pacote) {
        return new PacoteDto(
                pacote.getId(),
                pacote.getNome(),
                pacote.getPreco(),
                pacote.getDescricao()
                // Mapear outros atributos conforme necessário
        );
    }

    public static Pacote mapPacote(PacoteDto pacoteDto) {
        return new Pacote(
                pacoteDto.getId(),
                pacoteDto.getNome(),
                pacoteDto.getPreco(),
                pacoteDto.getDescricao()
                // Mapear outros atributos conforme necessário
        );
    }
}
