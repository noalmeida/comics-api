# Projetando uma API em Spring 

<img src="https://img.shields.io/badge/Buy_Me_A_Coffee-FFDD00?style=for-the-badge&logo=buy-me-a-coffee&logoColor=black">

:coffee:

<details class="details-reset details-overlay details-overlay-dark" id="jumpto-line-details-dialog" style="box-sizing: border-box; display: block;"><summary data-hotkey="l" aria-label="Jump to line" role="button" style="box-sizing: border-box; display: list-item; cursor: pointer; list-style: none;"></summary></details>

## Qual linguagem e quais as tecnologias do mundo Spring usadas?

- Para Linguagem de programação o Java, e framework o Sprint Boot, que é o parent dos outros Springs, Spring JPA para persistência dos dados em banco de dados,  Spring Web para ajudar com as configurações necessárias para desenvolvimento web , Spring devtools para 'startar' o projeto e dar 'reload' automático.

- A tecnologia Spring, e estas mencionadas, são tecnologias já bem usadas para criação de microsserviços e serviços em geral, vem facilitando muito a integração com banco de dados, do que como era feito manualmente por muitos anos atrás.

- Sobre o Java, é uma linguagem compilada, multithread, trabalha bem com muitos volumes de dados, tem uma integração mais fácil com banco de dados relacionais e há muitos anos vem sendo usada por grandes sistemas no backend.

- Usando padrão REST de forma de organizar a API, através do protocolo HTTP e as regras de arquitetura para REST, pois é bem difundido, o padrão é de claro entendimento, rapidez, é flexível e uniforme.

  ## Classes criadas para este processo

Para separar e ficar mais claro a composição do projeto, é interessante separar em pacotes com nome do grupo daquelas classes, criei um pacote para Models, que é onde ficam as classes que tem dados, Config, onde ficam as classes de beans e configurações no geral, Controller que é onde ficam as classes que recebem as requisições para mapear para algum objeto dentro do código, e os Services que gerenciam a parte das conexões com os serviços.



- As classes criadas são as que estão em itálico a seguir;

  

  - classe **Comics**

```
package com.challenge.crm.model;


import java.util.ArrayList;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class **Comics** {
	@JsonProperty("id")
	private Long id_comics;
	@JsonProperty("title")
	private String titulo;
	@JsonProperty("preços")
	private ArrayList<Precos> precos;
	@JsonProperty("criadores ")
	private String autores;
	@JsonProperty("descrição")
	private String descricao;
	@JsonProperty("isbn") 
	private String isbn;
```

- Classe **Precos**

```
package com.challenge.crm.model;
public class Precos {

	private double precos;
}

```

- Classe **Usuario**

  ```
  package com.challenge.crm.model;
  
  import java.util.Objects;
  import javax.persistence.Column;
  import javax.persistence.Entity;
  import javax.persistence.GeneratedValue;
  import javax.persistence.GenerationType;
  import javax.persistence.Id;
  
  @Entity
  public class Usuario {
  	@Id
  	@GeneratedValue(strategy = GenerationType.IDENTITY)	
  	private Long id_user;
  	@Column(nullable = false)
  	private String nome;
  	@Column(nullable = false)
  	private String email;
  	@Column(nullable = false)
  	private String cpf;
  	@Column(nullable = false)
  	private String dataNasc;
  ```

  

- Classe **ComicsService**

  ```
  package com.challenge.crm.service;
  
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Service;
  import org.springframework.web.client.RestTemplate;
  import com.challenge.crm.model.Comics;
  
  @Service
  public class ComicsService {
  	
  	@Autowired
  	RestTemplate restTemplate;
  	
  	
  	public Comics getComics() {
  		return restTemplate.getForObject("developer.marvel.com/v1/public/comics?ts=070720210259&apikey=bd00b34395e84e87a3099d69866399b9&hash=070720210259a85175d0f8b1c2c813e647b6a1ac708295dd63aebd00b34395e84e87a3099d69866399b9", Comics.class);
  	}
  	
  		
  }
  ```

  

- Classe **UsuarioController**

  ```
  package com.challenge.crm.controller;
  
  import java.util.List;
  import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RestController;
  import com.challenge.crm.model.Usuario;
  
  
  
  @RestController
  @RequestMapping("/usuarios")
  public class UsuarioController {
  
  	@GetMapping
  	public List<Usuario> listar(List<Usuario> Usuario) {
  		return Usuario;
  		  
  	}
  }
  ```

  - Classe **ComicsController**

```
package com.challenge.crm.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.challenge.crm.model.Comics;
import com.challenge.crm.service.ComicsService;


@RestController
@RequestMapping("/comics")
public class ComicsController {
	
	ComicsService comicsService;
	
	@GetMapping
	public Comics getComics() {
		return comicsService.getComics();
	}	 	
}
```

- Classe ConfigBean

  ```
  package com.challenge.crm.controller;
  
  import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RestController;
  import com.challenge.crm.model.Comics;
  import com.challenge.crm.service.ComicsService;
  
  
  @RestController
  @RequestMapping("/comics")
  public class ComicsController {
  	
  	ComicsService comicsService;
  	
  	@GetMapping
  	public Comics getComics() {
  		return comicsService.getComics();
  	}		 	
  }
  ```

  

e por ultimo a classe main **ComicsApiApplication** 

```
package com.challenge.crm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.challenge.crm.model.Comics;
import com.challenge.crm.service.ComicsService;


@RestController
@RequestMapping("/comics")
public class ComicsController {
	
	ComicsService comicsService;
	
	@GetMapping
	public Comics getComics() {
		return comicsService.getComics();
	}	  
}
```

- Classe **ResourceNotFoundException**

```
package com.challenge.crm.exception;

public class ResourceNotFoundException extends RuntimeException  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6699290383240040071L;
	public ResourceNotFoundException() {
        super();
    }
	
	public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
	
	public ResourceNotFoundException(String message) {
        super(message);
    }
    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}

```

Usando o método GET no endpoint da Marvell, retornaríamos o objeto JSON e mapiaríamos para dentro das classes de  através dos controllers.

Os cadastros de clientes seriam feitos um POST para ser salvo em um banco de dados configurável nos prospeteis do projeto, através das anotações de JPA @Entity. 

Lançar os erros, com uso do try/catch e throw para os statusHTTPcode =! de 200, direcionado para a Classe ResourceNotFoundException que herda RuntimeException.





E é isso ai!​ :beginner: 



Não consegui completar todo, mas bem.... :baby_chick:

Gratidão pela oportunidade de me desafiar.  :baby_chick:



Noan Almeida.:sunrise_over_mountains:
