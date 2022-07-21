package cl.ejercicio.microservicios.servicio;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;  
import cl.ejercicio.microservicios.dto.UsuarioDTO;
import cl.ejercicio.microservicios.repositorio.Usuario;
import cl.ejercicio.microservicios.repositorio.UsuarioRepositorio;
import cl.ejercicio.microservicios.util.ResponseMicroservicio;


//
@Service
public class UsuarioServicio 
{
	//
	@Autowired
	UsuarioRepositorio usuarioDao;
	
	@Autowired
    ModelMapper modelMapper;
	
	//funcion que guardara los datos del usuario
	/*public Usuario save(Usuario usuario)
	{
		
		usuario.setCreated(new Date());
		usuario.setModified(new Date());
		usuario.setLast_login(new Date());
		usuario.setIsactive(true);
		
		return usuarioDao.save(usuario);
	}*/
	
	
	public ResponseEntity<Object> crearUsuario(UsuarioDTO usuariodto)
	{
		if(!this.existeUsuario(usuariodto.getEmail()))
		{
			usuariodto.setCreated(new Date());
			usuariodto.setModified(new Date());
			usuariodto.setLast_login(new Date());
			usuariodto.setIsactive(true);
			
			Usuario usuario = generarEntityDTO(usuariodto);
			usuario = usuarioDao.save(usuario);
					
			return ResponseMicroservicio.generateResponse("Registro Guardado exitosamente!", HttpStatus.OK, generarDtoEntity(usuario));
		
		}
		else
		{
			return ResponseMicroservicio.generateResponse("Usuario existe", HttpStatus.BAD_REQUEST,null);
		}
			
	}


	public List<UsuarioDTO> buscarTodosUsuarios() 
	{		
		return usuarioDao.findAll().stream().map(post -> modelMapper.map(post, UsuarioDTO.class)).collect(Collectors.toList());
	}
	
	
	
	@SuppressWarnings("static-access")
	public ResponseEntity<Object> buscarUsuarioxID(Integer id) 
	{		
		//return 
		Optional<Usuario> usuario = usuarioDao.findById(id);
		
		if(usuario.isPresent()) {
			return ResponseMicroservicio.generateResponse("",HttpStatus.OK, usuario);
		}else {
			return ResponseMicroservicio.generateResponse("Usuario no Existe", HttpStatus.NOT_FOUND,"");
		
		}
	
	}
	
	
	//funcion para validar si existe un usuario por correo
	public boolean existeUsuario(String email) 
	{
		List <Usuario> emailUsuario = usuarioDao.findEmail(email);			
		
		if(emailUsuario.isEmpty())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	
	 private Usuario generarEntityDTO(UsuarioDTO usuariodto) {
        Usuario usuario = modelMapper.map(usuariodto, Usuario.class);
        return usuario;
	  }
	
	 private UsuarioDTO generarDtoEntity(Usuario usuario){
		 UsuarioDTO usuariodto = modelMapper.map(usuario,UsuarioDTO.class);
	     return usuariodto;
	  }
	

}
