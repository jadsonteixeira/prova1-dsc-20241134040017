package br.edu.ifrn.servico_veiculos.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeiculoRequestDTO {

    @NotBlank(message = "Placa é obrigatório")
    private String placa;

    @NotBlank(message = "Modelo é obrigatório")
    private String modelo;

    @NotNull(message = "Ano de fabricação é obrigatório")
    private Integer anoFabricacao;

    @NotBlank(message = "Tipo é obrigatório. Ex: CARRO, MOTO, CAMINHÃO")
    private String tipo;

    @NotBlank(message = "Nome do proprietário é obrigatório")
    private String nomeProprietario;
}
