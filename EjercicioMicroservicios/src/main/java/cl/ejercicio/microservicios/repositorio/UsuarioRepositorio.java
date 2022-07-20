package cl.ejercicio.microservicios.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>
{
	
	@Query(value = "SELECT * FROM usuario WHERE email = :email", nativeQuery = true)
    public List<Usuario> findEmail(String email);
	
}
