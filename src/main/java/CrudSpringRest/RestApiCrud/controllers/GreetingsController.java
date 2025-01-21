package CrudSpringRest.RestApiCrud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping(value= "salvar") /*Mapeia a URL*/
	@ResponseBody /*Descrição da resposta*/
	public ResponseEntity<Usuario> salvar (@RequestBody Usuario usuario){
		
		Usuario user = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "atualizar") /*Mapeia a URL*/
	@ResponseBody /*Descrição da resposta*/
	public ResponseEntity<?> atualizar(@RequestBody Usuario usuario) {
		
		
	    /* Verifica se o ID não foi informado*/
	    if (usuario.getId() == null) {
	        return new ResponseEntity<String>("ID não informado", HttpStatus.OK);
	    }
	    
	    // Atualiza os dados no banco
	    Usuario user = usuarioRepository.saveAndFlush(usuario);
	    
	    return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}
	
	@DeleteMapping(value= "delete") /*Mapeia a URL*/
	@ResponseBody /*Descrição da resposta*/
	public ResponseEntity<String> delete (@RequestParam Long iduser){ /*Recebe por ID o Usuario a ser deletado do banco de dados*/
		
		usuarioRepository.deleteById(iduser);
		
		return new ResponseEntity<String>("User Deletado com sucesso", HttpStatus.OK);
	}
	
	@GetMapping(value= "buscarUserid") /*Mapeia a URL*/
	@ResponseBody /*Descrição da resposta*/
	public ResponseEntity<Usuario> buscarUserid (@RequestParam(name = "iduser") Long iduser){ /*Recebe os dados para consultar*/
		
	Usuario usuario =usuarioRepository.findById(iduser).get();
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@GetMapping(value= "buscarPorNome") /*Mapeia a URL*/
	@ResponseBody /*Descrição da resposta*/
	public ResponseEntity<List<Usuario>> buscarPorNome (@RequestParam(name = "name") String name){ /*Recebe os dados para consultar*/
		
	List<Usuario> usuario = usuarioRepository.buscarPorNome(name.trim().toUpperCase());
		
		return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
