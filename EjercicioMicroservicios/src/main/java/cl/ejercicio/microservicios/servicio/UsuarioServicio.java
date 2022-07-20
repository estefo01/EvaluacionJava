package cl.ejercicio.microservicios.servicio;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.ejercicio.microservicios.repositorio.Usuario;
import cl.ejercicio.microservicios.repositorio.UsuarioRepositorio;

//
@Service
public class UsuarioServicio 
{
	//
	@Autowired
	UsuarioRepositorio usuarioDao;
	
	//funcion que guardara los datos del usuario
	public Usuario save(Usuario usuario)
	{
		
		usuario.setCreated(new Date());
		usuario.setModified(new Date());
		usuario.setLast_login(new Date());
		usuario.setIsactive(true);
		
		return usuarioDao.save(usuario);
	}


	public List<Usuario> findAll() {		
		return usuarioDao.findAll();
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
	
	public Optional<Usuario> findbyID(Integer id) {		
		return usuarioDao.findById(id);
	}


}
