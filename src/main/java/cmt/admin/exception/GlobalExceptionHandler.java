package cmt.admin.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(EmptyInputException.class)
public ResponseEntity<String> handleEmptyInputException(EmptyInputException emptyInputException){
	
	return new ResponseEntity<String>("EmptyInputException : "+emptyInputException.getErrorCode()+"\\"+emptyInputException.getErrorMessage(),HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(NoSuchElementException.class)
public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException elementException){
	return new ResponseEntity<String>("606,nosuchelement",HttpStatus.NOT_FOUND);
}
@ExceptionHandler(IllegalArgumentException.class)
public ResponseEntity<String> illegalArgumentException(IllegalArgumentException illegal){
	return new ResponseEntity<String>("609,IllegalArgumentException",HttpStatus.NOT_FOUND);
}

@ExceptionHandler(EmptyListException.class)
public ResponseEntity<String> handleEmptyListException(EmptyListException emptylist){
	
	return new ResponseEntity<String>("EmptyListException : "+emptylist.getErrorCode()+"\\"+emptylist.getErrorMessage(),HttpStatus.BAD_REQUEST);
}

}