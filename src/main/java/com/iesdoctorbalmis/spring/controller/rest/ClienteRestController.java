package com.iesdoctorbalmis.spring.controller.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iesdoctorbalmis.spring.entity.Cliente;
import com.iesdoctorbalmis.spring.repository.ClienteRepository;

// @RestController = @Controller + @ResponseBody
// Cada método devuelve JSON directamente, no un nombre de plantilla
@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {

    private final ClienteRepository clienteRepository;

    public ClienteRestController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // GET /api/clientes → lista JSON de todos los clientes
    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    // GET /api/clientes/{id} → JSON del cliente o 404 si no existe
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
