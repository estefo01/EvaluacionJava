package cl.ejercicio.microservicios.util;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ResponseMicroservicio 
{
	 public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        
            map.put("mensaje", message);
            map.put("codigo HTTP", status.value());
            
            if(status.value()!=400)	            
            	map.put("usuario", responseObj);

            return new ResponseEntity<Object>(map,status);
	 }
}
