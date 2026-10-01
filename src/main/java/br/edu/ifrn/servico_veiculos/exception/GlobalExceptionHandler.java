package br.edu.ifrn.servico_veiculos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidation(MethodArgumentNotValidException ex) {

        var pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pd.setProperty("errors", extrairErros(ex));

        return pd;
    }

    private Map<String, String> extrairErros(MethodArgumentNotValidException ex) {

        Map<String, String> erros = new HashMap<>();

        for(FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            erros.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return erros;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ProblemDetail handleVeiculoNaoEncontradoException(VeiculoNaoEncontradoException ex) {

        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        pd.setTitle("Veículo não encontrado");

        pd.setDetail(ex.getMessage());

        return pd;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler
    public ProblemDetail handlePlacaDuplicadaException(PlacaDuplicadaException ex) {

        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.CONFLICT);

        pd.setTitle("Placa já cadastrada");

        pd.setDetail(ex.getMessage());

        return pd;
    }
}
