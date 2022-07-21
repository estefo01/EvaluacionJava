package cl.ejercicio.microservicios.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelefonoUsuarioDTO 
{
	private int ID;
	private int number;
	private int citycode;
	private int contrycode;
	
	
	public TelefonoUsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TelefonoUsuarioDTO(int iD, int number, int citycode, int contrycode) {
		super();
		ID = iD;
		this.number = number;
		this.citycode = citycode;
		this.contrycode = contrycode;
	}




}
