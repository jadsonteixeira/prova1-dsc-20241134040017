package br.edu.ifrn.servico_veiculos.exception;

public class VeiculoNaoEncontradoException extends RuntimeException {

    public VeiculoNaoEncontradoException(String message) {
        super(message);
    }
}
