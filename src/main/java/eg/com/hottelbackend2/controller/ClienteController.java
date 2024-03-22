package eg.com.hottelbackend2.controller;

import eg.com.hottelbackend2.dto.ClienteDto;
import eg.com.hottelbackend2.service.Impl.ClienteService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/cliente" )
public class ClienteController {

    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDto> createCliente(@RequestBody ClienteDto clienteDto){
        ClienteDto saveCliente= clienteService.createCliente (clienteDto);
        return new ResponseEntity<>(saveCliente, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public  ResponseEntity<ClienteDto> getClienteById(@PathVariable("id") Long clienteId){
        ClienteDto clienteDto =  clienteService.getClienteById (clienteId);
        return  ResponseEntity.ok(clienteDto);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAllCliente(){
        List<ClienteDto> cliente = clienteService.getAllCliente();
        return ResponseEntity.ok(cliente);
    }
    @PutMapping({"{id}"})
    public  ResponseEntity<ClienteDto> updateCliente(@PathVariable("id") Long clienteId,
                                                     @RequestBody ClienteDto updateCliente){
        ClienteDto clienteDto = clienteService.updateCliente(clienteId, updateCliente);
        return  ResponseEntity.ok(clienteDto);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable("id") Long clienteId){
        clienteService.deleteCliente (clienteId);
        return ResponseEntity.ok("Cliente excluido com sucesso");
    }
}

