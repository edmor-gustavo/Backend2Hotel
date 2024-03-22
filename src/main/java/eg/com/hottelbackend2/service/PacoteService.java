package eg.com.hottelbackend2.service;

import eg.com.hottelbackend2.dto.PacoteDto;

import java.util.List;

public interface PacoteService {
    PacoteDto createPacote(PacoteDto pacoteDto);

    PacoteDto getPacoteById(Long pacoteId);

    List<PacoteDto> getAllPacotes();

    PacoteDto updatePacote(Long pacoteId, PacoteDto pacoteDto);

    void deletePacote(Long pacoteId);
}
