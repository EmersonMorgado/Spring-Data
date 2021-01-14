package br.com.emersonmorgado.spring.data;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.emersonmorgado.spring.data.service.CrudCargoService;
import br.com.emersonmorgado.spring.data.service.CrudFuncionarioService;
import br.com.emersonmorgado.spring.data.service.CrudUnidadeService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{

	@Autowired
	private CrudFuncionarioService funcionarioService;
	
	@Autowired
	private CrudUnidadeService trabalhoService;

	private final CrudCargoService cargoService;
	private boolean system = true;
	
	public SpringDataApplication(CrudCargoService cargoService) {
		this.cargoService = cargoService;
		
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while(system) {
			System.out.println("Qual ação você quer executar:");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade de Trabalho");
			
			int action = scanner.nextInt();
			if(action == 1) {
				cargoService.inicial(scanner);
			}
			if(action == 2) {
				funcionarioService.inicial(scanner);
			}
			if(action == 3) {
				trabalhoService.inicial(scanner);
			}
			if(action == 0) {
				system = false;
			}
		}
	}
}
