package eg.com.hottelbackend2.mapper;

import eg.com.hottelbackend2.dto.QuartoDto;
import eg.com.hottelbackend2.entity.Quarto;

public class QuartoMapper {

    public static QuartoDto mapQuartoDto(Quarto quarto) {
        return new QuartoDto(
                quarto.getId(),
                quarto.getNumero(),
                quarto.getTipo(),
                quarto.isDisponivel()
                // Mapear outros atributos conforme necessário
        );
    }

    public static Quarto mapQuarto(QuartoDto quartoDto) {
        return new Quarto(
                quartoDto.getId(),
                quartoDto.getNumero(),
                quartoDto.getTipo(),
                quartoDto.isDisponivel()
                // Mapear outros atributos conforme necessário
        );
    }
}
