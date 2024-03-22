package eg.com.hottelbackend2.service;

import eg.com.hottelbackend2.dto.QuartoDto;

import java.util.List;

public interface QuartoService {
    QuartoDto createQuarto(QuartoDto quartoDto);

    QuartoDto getQuartoById(Long quartoId);

    List<QuartoDto> getAllQuartos();

    QuartoDto updateQuarto(Long quartoId, QuartoDto quartoDto);

    void deleteQuarto(Long quartoId);

    void marcarComoOcupado(Long quartoId); // Nova funcionalidade

    void marcarComoDisponivel(Long quartoId); // Nova funcionalidade
}

