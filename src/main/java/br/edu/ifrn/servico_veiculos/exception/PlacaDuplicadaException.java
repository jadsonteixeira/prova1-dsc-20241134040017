package br.edu.ifrn.servico_veiculos.exception;

public class PlacaDuplicadaException extends RuntimeException {

    public PlacaDuplicadaException(String placa) {
        super("Já existem um veículo com a placa " + placa);
    }
}
