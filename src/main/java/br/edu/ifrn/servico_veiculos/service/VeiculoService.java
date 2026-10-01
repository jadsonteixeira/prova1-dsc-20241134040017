package br.edu.ifrn.servico_veiculos.service;

import br.edu.ifrn.servico_veiculos.dto.request.VeiculoRequestDTO;
import br.edu.ifrn.servico_veiculos.dto.response.VeiculoResponseDTO;
import br.edu.ifrn.servico_veiculos.model.Veiculo;
import br.edu.ifrn.servico_veiculos.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoResponseDTO adicionar(VeiculoRequestDTO dto) {

        return toResponseDTO(veiculoRepository.save(toEntity(dto)));
    }

    public List<VeiculoResponseDTO> listar() {

        return veiculoRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    private Veiculo toEntity(VeiculoRequestDTO dto) {

        return new Veiculo(
                null,
                dto.getPlaca(),
                dto.getModelo(),
                dto.getAnoFabricacao(),
                dto.getTipo(),
                dto.getNomeProprietario()
        );
    }

    private VeiculoResponseDTO toResponseDTO(Veiculo entity) {

        return new VeiculoResponseDTO(
                entity.getId(),
                entity.getPlaca(),
                entity.getModelo(),
                entity.getAnoFabricacao(),
                entity.getTipo(),
                entity.getNomeProprietario()
        );
    }
}
