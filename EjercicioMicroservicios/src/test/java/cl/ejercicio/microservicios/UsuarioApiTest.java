package cl.ejercicio.microservicios;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import cl.ejercicio.microservicios.app.UsuarioApi;
import cl.ejercicio.microservicios.dto.TelefonoUsuarioDTO;
import cl.ejercicio.microservicios.dto.UsuarioDTO;
import cl.ejercicio.microservicios.repositorio.TelefonoUsuario;
import cl.ejercicio.microservicios.repositorio.Usuario;
import cl.ejercicio.microservicios.repositorio.UsuarioRepositorio;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@WebMvcTest(UsuarioApi.class)

public class UsuarioApiTest 
{
	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper mapper;
	
	@MockBean
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	@Test	
	public void guardarUsuariosTest() throws Exception {
	{
		TelefonoUsuarioDTO telefono1=new TelefonoUsuarioDTO(1, 11111, 1, 58);
		List<TelefonoUsuario> list= new ArrayList<>();
		
		list.addAll((Collection<? extends TelefonoUsuario>) telefono1);
		
		Usuario usuario1= new Usuario(1, "Estefanie", "eencalada@gmail.com", "Q01qqqqq", list, new Date(),new Date(),new Date(),true );
		
		 List<Usuario> records = new ArrayList<>(Arrays.asList(usuario1));
		    
		    Mockito.when(usuarioRepositorio.findAll()).thenReturn(records);
		    
		    mockMvc.perform(MockMvcRequestBuilders
		            .get("/listarUsuarios")
		            .contentType(MediaType.APPLICATION_JSON_VALUE))
		            .andExpect(status().isOk())
		            .andExpect(jsonPath("$", hasSize(3)))
		            .andExpect(jsonPath("$[2].name", is("Jane Doe")));
		}
	}
}