package cl.ejercicio.microservicios.dto;

import java.util.Date;
import java.util.List;
import cl.ejercicio.microservicios.repositorio.TelefonoUsuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO 
{
	private int ID;	
	private String name;
	private String email;
	private String password;
	private List <TelefonoUsuario> phones;	
	private Date created;
	private Date modified;
	private Date last_login;	
	private boolean isactive;
	
	public UsuarioDTO(int iD, String name, String email, String password, List<TelefonoUsuario> phones, Date created,
			Date modified, Date last_login, boolean isactive) {
		super();
		ID = iD;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
		this.created = created;
		this.modified = modified;
		this.last_login = last_login;
		this.isactive = isactive;
	}

	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
