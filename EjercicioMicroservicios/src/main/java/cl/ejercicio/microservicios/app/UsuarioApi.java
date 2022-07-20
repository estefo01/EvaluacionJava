package cl.ejercicio.microservicios.app;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.ejercicio.microservicios.repositorio.Usuario;
import cl.ejercicio.microservicios.servicio.UsuarioServicio;
import cl.ejercicio.microservicios.util.ResponseMicroservicio;

@RestController
public class UsuarioApi 
{
	
	@Autowired
	UsuarioServicio usuarioServicio;
		
	@PostMapping(value="/guardarUsuario" , produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> guardar(@Valid @RequestBody Usuario usuario)	
	{
		if(!usuarioServicio.existeUsuario(usuario.getEmail()))
		{
			Usuario createdUser = usuarioServicio.save(usuario);
			
			return ResponseMicroservicio.generateResponse("Registro Guardado exitosamente!", HttpStatus.OK, createdUser);
		
		}
		else
		{
			return ResponseMicroservicio.generateResponse("Usuario existe", HttpStatus.BAD_REQUEST,null);
		}
	}
	
	
	@GetMapping(value="/listarUsuarios")	
	//consultar un contacto por ID	
	public List<Usuario> listar() 
	{
		return usuarioServicio.findAll();
	}
	
	@GetMapping(value="/listarXUsuario/{idUsuario}")	
	//consultar un contacto por ID	
	public Optional<Usuario> listarXusuario(@PathVariable int idUsuario) 
	{
		Optional<Usuario> consultarUsuario = usuarioServicio.findbyID(idUsuario);
		
		if(consultarUsuario.empty() != null)
		{
			return usuarioServicio.findbyID(idUsuario);
		}
		
		return null;
			
	}
}
