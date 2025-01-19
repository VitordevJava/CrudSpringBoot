package CrudSpringRest.RestApiCrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import CrudSpringRest.RestApiCrud.model.Usuario;
import CrudSpringRest.RestApiCrud.repository.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {

	@Autowired /* IC / CD ou CDI - Essa é a nossa injeção de dependencias */
	private UsuarioRepository usuarioRepository;

	/**
	 *
	 * @param name the name to greet
	 * @return greeting text
	 */
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String greetingText(@PathVariable String name) {
		return "Spring Boot Rest API CRUD " + name + "!";
	}

	@RequestMapping(value = "/ola Mundo/{nome}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String OlaMundo(@PathVariable String nome) {

		Usuario usuario = new Usuario();
		usuario.setNome(nome);

		usuarioRepository.save(usuario); /* Grava no banco de dados */

		return "ola Mundo " + nome + "!";

	}

	@GetMapping(value = "listatodos")  /*Primeiro metodo de API*/
	@ResponseBody /*Retorna os dados para o corpo da resposta*/
	public ResponseEntity<List<Usuario>> listaUsuario() {

		List<Usuario> usuarios = usuarioRepository.findAll(); /*Executa consulta no banco de dados*/
		
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK); /*Retorna todos os usuarios em uma Lista JSON*/
	}
}
