package br.com.emersonmorgado.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emersonmorgado.spring.data.orm.Funcionario;
import br.com.emersonmorgado.spring.data.repository.FuncionarioRepository;

@Service
public class CrudFuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	private Boolean system = true;
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("Qual ação de funcionarios deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			int action = scanner.nextInt();
			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(scanner);
				break;
			default:
				system=false;
				break;
			}
		}
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		funcionarioRepository.deleteById(id);
		System.out.println("Deletado!");		
	}

	private void salvar(Scanner scanner) {
		System.out.println("Nome");
		String nome = scanner.next();
		System.out.println("CPF");
		String cpf = scanner.next();
		System.out.println("Salário");
		Double salario = scanner.nextDouble();
		System.out.println("Data da Contratação dd/mm/aaaa");
		String data = scanner.next();
		
		Funcionario funcionario= new Funcionario();
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setSalario(salario);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");		
		LocalDate dataFormatada = LocalDate.parse(data,formatter);
		funcionario.setDataContratacao(dataFormatada);
		funcionarioRepository.save(funcionario);
		System.out.println("Funcionário Salvo.");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		System.out.println("Atualizado... " + id);
	}
	
	private void visualizar() {
		Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
		funcionarios.forEach(funcionario -> System.out.println(funcionario));
	}
}
