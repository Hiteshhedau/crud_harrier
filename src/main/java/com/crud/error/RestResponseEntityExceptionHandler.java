package com.crud.error;

import com.crud.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;




@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CustomerNotFounException.class)
    public ResponseEntity<ErrorMessage> customerNotFoundException(CustomerNotFounException exception){
        ErrorMessage errorMessage=new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(InvalidCustomerCreatedException.class)
    public ResponseEntity<ErrorMessage> invalidCustomerCreatedException(InvalidCustomerCreatedException exception){
        ErrorMessage errorMessage=new ErrorMessage(HttpStatus.NOT_ACCEPTABLE,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorMessage);
    }




}
