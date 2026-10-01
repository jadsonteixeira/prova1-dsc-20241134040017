package br.edu.ifrn.servico_veiculos.controller;

import br.edu.ifrn.servico_veiculos.dto.request.VeiculoRequestDTO;
import br.edu.ifrn.servico_veiculos.dto.response.VeiculoResponseDTO;
import br.edu.ifrn.servico_veiculos.service.VeiculoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

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
}
