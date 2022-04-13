package br.edu.ifpb.dac.stef.projetojpa2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Projetojpa2Application{
	


	public static void main(String[] args) {
		SpringApplication.run(Projetojpa2Application.class, args);
	}
/*
	@Override
	public void run(String... args) throws Exception {
		Scanner scan = new Scanner(System.in);

		System.out.println("😸ADOÇÃO DE GATINHOS😸\n");
		System.out.println("Painel de gatinhos\n");

		

		boolean cond = true;
		while (cond){
			System.out.println("O que deseja fazer?\n1 - Cadastrar gatinhos\n2 - Ver todos gatinhos cadastrados\n3 - editar informações de um gatinho\n4 - Adicionar possível dono adotivo\n5 - Listar possíveis donos adotivos\n6 - Deletar Possível dono adotivo\n7 - Gerenciar adoção");
			int escolha = Integer.parseInt(scan.nextLine());
			switch (escolha) {
				case 1: //cadastrar gatos
					System.out.print("Qual o nome do(a) gatinho(a)? ");
					String nome = scan.nextLine();
	
					System.out.print("Qual a idade do(a) gatinho(a)? ");
					int idade = Integer.parseInt(scan.nextLine());
	
					System.out.print("Qual o tipo da pelagem dele(a)?\n 1 - Tigrado\n 2 - Frajola\n 3 - Escaminha");
					int opc = Integer.parseInt(scan.nextLine());
					String pelagem = "";
					switch (opc) {
						case 1:
							pelagem = "Tigrado";
							break;
						case 2:
							pelagem = "Frajola";
							break;
						case 3:
							pelagem = "Escaminha";
							break;
					}
					catController.save(nome, idade, pelagem);
					break;

					
				case 2://listar gatos
					System.out.println("Lista de gatinhos:\n");
					List<Cat> gatos = catController.list();
					
					for (Cat cat : gatos) {
						System.out.println(cat);
					}
					
					break;

				case 3: // update
					System.out.print("Qual o nome do(a) gatinho(a) que deseja editar? ");
					String nomeToUpdate = scan.nextLine();

					System.out.print("Qual o novo nome do(a) gatinho(a)? ");
					String novoNome = scan.nextLine();

					System.out.print("Qual a nova idade do(a) gatinho(a)? ");
					int novaIdade = Integer.parseInt(scan.nextLine());

					System.out.print("Qual o tipo da pelagem dele(a)?\n 1 - Tigrado\n 2 - Frajola\n 3 - Escaminha");
					int choose = Integer.parseInt(scan.nextLine());
					String novaPelagem = "";
					switch (choose) {
						case 1:
							novaPelagem = "Tigrado";
							break;
						case 2:
							novaPelagem = "Frajola";
							break;
						case 3:
							novaPelagem = "Escaminha";
							break;
					}
					catController.update(nomeToUpdate, novoNome, novaIdade, novaPelagem);
					break;

				case 4://add dono
					System.out.print("Qual o nome da pessoa que será um possível dono adotivo? ");
					String pessoaNome = scan.nextLine();

					System.out.print("Qual a idade do ser humano? ");
					int pessoaIdade = Integer.parseInt(scan.nextLine());

					System.out.print("Qual o CPF do ser humano? (sem pontos) ");
					int pessoaCpf = Integer.parseInt(scan.nextLine());

					personController.save(pessoaNome, pessoaCpf, pessoaIdade);
					break;

				case 5://listar donos
					System.out.println("Lista de Possíveis donos adotivos:\n");
					List<Person> pessoas = personController.list();

					for (Person person : pessoas) {
						System.out.println(person);
					}
					break;
				case 6:
					System.out.print("Qual o CPF do ser humano a ser excluído? (sem pontos) ");
					int excluirCpf = Integer.parseInt(scan.nextLine());
					personController.delete(excluirCpf);
					break;
				
				case 7:
					System.out.print("Qual o nome do gatinho que deseja adotar? ");
					String adoptNome = scan.nextLine();

					System.out.print("Qual o CPF do Humano que vai adotar? ");
					int cpfAdopt = Integer.parseInt(scan.nextLine());

					catController.adopt(adoptNome, cpfAdopt);
					break;

				default:
					cond = false;
			}
	
	
		}
		scan.close(); 
	}
*/
}
