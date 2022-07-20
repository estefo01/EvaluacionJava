package cl.ejercicio.microservicios.repositorio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TelefonoUsuario {
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column(name= "telefonousuario_id")
	private int ID;
	
	@NotNull(message="El campo number es obligatorio")
	private int number;
	@NotNull(message="El campo citycode es obligatorio")
	private int citycode;
	@NotNull(message="El campo contrycode es obligatorio")
	private int contrycode;

	public TelefonoUsuario(int iD, @NotNull(message = "El campo number es obligatorio") int number,
			@NotNull(message = "El campo citycode es obligatorio") int citycode,
			@NotNull(message = "El campo contrycode es obligatorio") int contrycode) {
		super();
		ID = iD;
		this.number = number;
		this.citycode = citycode;
		this.contrycode = contrycode;
		
	}


	public TelefonoUsuario() {
		super();		
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getCitycode() {
		return citycode;
	}
	public void setCitycode(int citycode) {
		this.citycode = citycode;
	}
	public int getContrycode() {
		return contrycode;
	}
	public void setContrycode(int contrycode) {
		this.contrycode = contrycode;
	}
		
}
