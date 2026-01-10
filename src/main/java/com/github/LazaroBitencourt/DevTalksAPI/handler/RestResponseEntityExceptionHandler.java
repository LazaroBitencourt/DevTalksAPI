package com.github.LazaroBitencourt.DevTalksAPI.handler;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;


@RestControllerAdvice
@Log4j2
public class RestResponseEntityExceptionHandler {
    @ExceptionHandler(APIException.class)
    public ResponseEntity<ErrorApiResponse> handlerGenericException(APIException ex){
        return ex.buildErrorResponseEntity();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<ErrorApiResponse> handlerValidationException(MethodArgumentNotValidException ex){
        log.error("Exception",ex);
        String errorMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorApiResponse.builder().description("VALIDATION ERROR")
                .message(errorMessage).build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorApiResponse> handlerGenericException(Exception ex){
        log.error("Exception",ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorApiResponse.builder()
                .description("INTERNAL SERVER ERROR").message("POR FAVOR INFORME AO ADMINISTRADOR DO SISTEMA").build());
    }
}
