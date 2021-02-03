package br.com.liccorp.hello.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.liccorp.hello.model.Usuario;

@RestController
public class UserController {
	
	// quero fazer um login mock
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> fazerLogin(@RequestBody Usuario dadosLogin) {
		//testando se usuário existe
		if (dadosLogin.getRacf().equals("lic")){
			///usuario existe, testando se a senha confere
				if (dadosLogin.getSenha().equals("1234")) {
					
					//usuario existe,retorno 200-Ok + o objeto do usuario preenchido
					Usuario resposta = new Usuario();
					resposta.setId(36854);
					resposta.setNome("Professor Lic Lele");
					resposta.setEmail("lic@lic.com");
					resposta.setRacf("lic");
					resposta.setFuncional("96854712354");
					resposta.setDepartamento("Treinamento");
					return ResponseEntity.ok(resposta);					
					
				}
				// senha não confere, retorno 401 (UnAuthorized)
				return ResponseEntity.status(401).build();
		}
		// senha não existe, retorno código http 404
		return ResponseEntity.status(404).build();
	}
		

}
