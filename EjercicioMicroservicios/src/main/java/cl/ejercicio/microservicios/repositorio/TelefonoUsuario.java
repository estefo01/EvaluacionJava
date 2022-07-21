package cl.ejercicio.microservicios.repositorio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
		// TODO Auto-generated constructor stub
	}
	
	
		
}
