package eg.com.hottelbackend2.service;

import eg.com.hottelbackend2.dto.ClienteDto;


import java.util.List;


public interface ClienteService {
    ClienteDto createCliente(ClienteDto clienteDto);

    ClienteDto getClienteById(Long clienteId);

    List<ClienteDto> getAllCliente();

    ClienteDto updateCliente(Long cliente, ClienteDto updateCliente);


    void deleteCliente(Long clienteId);

}