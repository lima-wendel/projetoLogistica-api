package logisticaapi.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice //tratar exceções de forma global em todos os controladores
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	

}
