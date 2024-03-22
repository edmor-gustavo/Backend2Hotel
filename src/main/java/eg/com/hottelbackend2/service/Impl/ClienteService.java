package eg.com.hottelbackend2.service.Impl;

import eg.com.hottelbackend2.dto.ClienteDto;
import eg.com.hottelbackend2.entity.Cliente;
import eg.com.hottelbackend2.exception.ResourceNotFoundException;
import eg.com.hottelbackend2.mapper.ClienteMapper;
import eg.com.hottelbackend2.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteService implements eg.com.hottelbackend2.service.ClienteService {

    private ClienteRepository clienteRepository;

    @Override
    public ClienteDto createCliente(ClienteDto clienteDto) {
        Cliente cliente = ClienteMapper.mapCliente(clienteDto);
        Cliente savedCliente = clienteRepository.save(cliente);
        return ClienteMapper.mapClienteDto(savedCliente);
    }

    @Override
    public ClienteDto getClienteById(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("O Id do cliente não existe"  + clienteId));
        return ClienteMapper.mapClienteDto(cliente);
    }

    @Override
    public List<ClienteDto> getAllCliente() {
        List<Cliente> cliente = clienteRepository.findAll();
        return cliente.stream().map(ClienteMapper::mapClienteDto)
                .collect(Collectors.toList());
    }
    @Override
    public ClienteDto updateCliente(Long cliente, ClienteDto updateCliente) {
        Cliente cliente1 = clienteRepository.findById (cliente).orElseThrow(
                () -> new ResourceNotFoundException("O Id do cliente não existe: "+ cliente)
        );
        cliente1.setNome (updateCliente.getNome());
        cliente1.setIdentidade(updateCliente.getIdentidade());
        cliente1.setContacto(updateCliente.getContacto());
        cliente1.setNumeroQuarto(updateCliente.getNumeroQuarto());

        Cliente updatedClienteObj = clienteRepository.save (cliente1);
        return ClienteMapper.mapClienteDto (updatedClienteObj);
    }
    @Override
    public void deleteCliente(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(
                () -> new ResourceNotFoundException("O Id do cliente não existe")
        );
        clienteRepository.deleteById (clienteId);
    }
}