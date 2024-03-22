package eg.com.hottelbackend2.service.Impl;

import eg.com.hottelbackend2.dto.PacoteDto;
import eg.com.hottelbackend2.entity.Pacote;
import eg.com.hottelbackend2.exception.ResourceNotFoundException;
import eg.com.hottelbackend2.mapper.PacoteMapper;
import eg.com.hottelbackend2.repository.PacoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PacoteService implements eg.com.hottelbackend2.service.PacoteService {

    private final PacoteRepository pacoteRepository;
    @Override
    public PacoteDto createPacote(PacoteDto pacoteDto) {
        Pacote pacote = PacoteMapper.mapPacote(pacoteDto);
        Pacote savedPacote = pacoteRepository.save(pacote);
        return PacoteMapper.mapPacoteDto(savedPacote);
    }
    @Override
    public PacoteDto getPacoteById(Long pacoteId) {
        Pacote pacote = pacoteRepository.findById(pacoteId)
                .orElseThrow(() -> new ResourceNotFoundException("Pacote not found with id: " + pacoteId));
        return PacoteMapper.mapPacoteDto(pacote);
    }
    @Override
    public List<PacoteDto> getAllPacotes() {
        List<Pacote> pacotes = pacoteRepository.findAll();
        return pacotes.stream().map(PacoteMapper::mapPacoteDto).collect(Collectors.toList());
    }
    @Override
    public PacoteDto updatePacote(Long pacoteId, PacoteDto pacoteDto) {
        Pacote pacote = pacoteRepository.findById(pacoteId)
                .orElseThrow(() -> new ResourceNotFoundException("Pacote not found with id: " + pacoteId));

        pacote.setNome(pacoteDto.getNome());
        pacote.setPreco(pacoteDto.getPreco());
        // Atualize outros atributos conforme necessário

        Pacote updatedPacote = pacoteRepository.save(pacote);
        return PacoteMapper.mapPacoteDto(updatedPacote);
    }
    @Override
    public void deletePacote(Long pacoteId) {
        Pacote pacote = pacoteRepository.findById(pacoteId)
                .orElseThrow(() -> new ResourceNotFoundException("Pacote not found with id: " + pacoteId));
        pacoteRepository.delete(pacote);
    }
}
