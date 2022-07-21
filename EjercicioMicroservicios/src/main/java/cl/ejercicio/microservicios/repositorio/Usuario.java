package cl.ejercicio.microservicios.repositorio;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario 
{
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column (name="usuario_id")
	private int ID;
	
	@NotNull(message="El campo name es obligatorio")
	private String name;
	
	@NotNull(message="El campo email es obligatorio")
	@Email (message="El campo email no tiene el formato correcto")
	@Column(unique = true)
	private String email;
	@NotNull(message="El campo password es obligatorio")
	@Pattern(regexp ="^[a-zA-Z0-9]{8}" , message= "El campo password, debe contener 1 letra mayúscula, 1 letra minúscula, 1 dígito y debe ser de un largo de 8 caracteres")
	private String password;
		
	@OneToMany(cascade = CascadeType.ALL)
	private List <TelefonoUsuario> phones;		

	private Date created;
	private Date modified;
	private Date last_login;
	
	private boolean isactive;
	


	public Usuario() {
		super();
	}



	public Usuario(int iD, @NotNull(message = "El campo name es obligatorio") String name,
			@NotNull(message = "El campo email es obligatorio") @Email(message = "El campo email no tiene el formato correcto") String email,
			@NotNull(message = "El campo password es obligatorio") @Pattern(regexp = "^[a-zA-Z0-9]{8}", message = "El campo password, debe contener 1 letra mayúscula, 1 letra minúscula, 1 dígito y debe ser de un largo de 8 caracteres") String password,
			List<TelefonoUsuario> phones, Date created, Date modified, Date last_login, boolean isactive) {
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

}
