package como.diego.springboot.manejo.excepciones.springboot_manejo_excepciones.Controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import como.diego.springboot.manejo.excepciones.springboot_manejo_excepciones.models.Error;

@RestControllerAdvice
public class HadlerExceptionController {

    @ExceptionHandler({ ArithmeticException.class })
    public ResponseEntity<Error> divisionByZero(Exception ex) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error division por cero");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        // return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);

    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundEx(NoHandlerFoundException ex) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Api Rest no Encontrada");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(Exception e) {
        Map<String, Object> error = new HashMap<>();

        error.put("Date", new Date());
        error.put("Error", "Numero invalido o incorrecto, no tiene formato de digito");
        error.put("Message", e.getMessage());
        error.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return error;

    }

}
