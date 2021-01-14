package br.com.emersonmorgado.spring.data.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emersonmorgado.spring.data.orm.UnidadeTrabalho;
import br.com.emersonmorgado.spring.data.repository.UnidadeRepository;

@Service
public class CrudUnidadeService {
	
	@Autowired
	private UnidadeRepository unidadeRepository;
	private Boolean system = true;
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("Qual ação de Unidade de traballho deseja executar");
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
		unidadeRepository.deleteById(id);
		System.out.println("Deletado!");		
	}

	private void salvar(Scanner scanner) {
		System.out.println("Descrição");
		String descricao = scanner.next();
		System.out.println("Endereço");
		String endereco = scanner.next();
		
		
		UnidadeTrabalho unidade= new UnidadeTrabalho();
		unidade.setDescricao(descricao);
		unidade.setEndereco(endereco);
		unidadeRepository.save(unidade);
		System.out.println("Unidade Salva.");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		System.out.println("Atualizado... " + id);
	}
	
	private void visualizar() {
		Iterable<UnidadeTrabalho> unidades = unidadeRepository.findAll();
		unidades.forEach(unidade -> System.out.println(unidade));
	}
}
