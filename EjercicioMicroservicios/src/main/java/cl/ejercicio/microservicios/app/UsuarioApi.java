package cl.ejercicio.microservicios.app;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.ejercicio.microservicios.dto.UsuarioDTO;

import cl.ejercicio.microservicios.servicio.UsuarioServicio;


@RestController
public class UsuarioApi 
{
	
	@Autowired
	UsuarioServicio usuarioServicio;
		
	@PostMapping(value="/guardarUsuario" , produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
	
	public ResponseEntity<Object> guardar(@Valid @RequestBody UsuarioDTO usuario)	
	{
		return usuarioServicio.crearUsuario(usuario);
	}
	
	
	@GetMapping(value="/listarUsuarios")	
	public List<UsuarioDTO> listar() 
	{
		return usuarioServicio.buscarTodosUsuarios();
		
	}
	
	@GetMapping(value="/listarXUsuario/{idUsuario}")	
	//consultar un contacto por ID	
	public ResponseEntity<Object> listarXusuario(@PathVariable int idUsuario) 
	{
		return usuarioServicio.buscarUsuarioxID(idUsuario);
		
			
	}
}
