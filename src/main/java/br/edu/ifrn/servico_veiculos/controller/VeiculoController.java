package br.edu.ifrn.servico_veiculos.controller;

import br.edu.ifrn.servico_veiculos.dto.request.VeiculoRequestDTO;
import br.edu.ifrn.servico_veiculos.dto.response.VeiculoResponseDTO;
import br.edu.ifrn.servico_veiculos.service.VeiculoService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
@RequiredArgsConstructor
public class VeiculoController {

    private final VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> adicionar(@Valid @RequestBody VeiculoRequestDTO dto) {

        VeiculoResponseDTO responseDTO = veiculoService.adicionar(dto);

        URI uri = URI.create("veiculos/" + responseDTO.getId());

        return ResponseEntity.created(uri).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoResponseDTO>> listar(){

        return ResponseEntity.ok(veiculoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(veiculoService.buscarPorId(id));
    }

    @GetMapping("/por-tipo")
    public ResponseEntity<List<VeiculoResponseDTO>> listarPorTipo(@RequestParam String tipo) {

        return ResponseEntity.ok(veiculoService.buscarPorTipo(tipo));
    }
}
