package br.com.liccorp.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.liccorp.hello.model.Produto;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World! Meu primeiro projeto!";
	}

	@GetMapping("/hellohtml")
	public String sayHtml() {
		return "<html>" + "<body>" + "<h1>Hello world</h1" + "<hr>" + "<p> Lic fala muuuuito</p>"
				+ "<i>Um texto maluco</i>" + "<body>" + "<html>";
	}

	@GetMapping("/produto")
	public Produto exibirProduto() {
		Produto prod = new Produto();
		prod.setId(10012);
		prod.setDescricao("Mesa Gamer que acende luzinha de noite e de dia");
		prod.setPreco(998.56);
		prod.setQtdeEstoque(1);
		return prod;
	}

	@PostMapping("/novoproduto")
	public String cadastrarProduto(@RequestBody Produto novo) {
		System.out.println("Recebi " + novo.getId() + "/" + novo.getDescricao() + "/" + novo.getPreco() + "/"
				+ novo.getQtdeEstoque());
		return "Produto Cadastrado";

	}
}
