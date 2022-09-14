package br.com.emendes.forum.config.validacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.emendes.forum.controller.AlgumaException;

@RestControllerAdvice
public class AlgumaExceptionHandler {
  
  @ExceptionHandler(AlgumaException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public String handler(AlgumaException exception){
    return "minha mensagem";
  }

}
