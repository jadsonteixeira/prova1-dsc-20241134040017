package br.edu.ifrn.servico_veiculos.repository;

import br.edu.ifrn.servico_veiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    boolean existsByPlaca(String placa);

    List<Veiculo> findByTipoContainingIgnoreCase(String tipo);

    boolean existsByPlacaAndIdNot(String placa, Long id);
}
