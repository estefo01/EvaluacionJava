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

@Entity
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
	
	public Usuario(@NotNull(message = "El campo name es obligatorio") String name,
			@NotNull(message = "El campo email es obligatorio") @Email(message = "El campo email no tiene el formato correcto") String email,
			@NotNull(message = "El campo password es obligatorio") String password, List<TelefonoUsuario> phones,
			Date created, Date modified, Date last_login, boolean isactive) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
		this.created = created;
		this.modified = modified;
		this.last_login = last_login;
		this.isactive = isactive;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<TelefonoUsuario> getPhones() {
		return phones;
	}
	public void setPhones(List<TelefonoUsuario> phones) {
		this.phones = phones;
	}
	
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}
	
	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}


	

}
