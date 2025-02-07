/*Projeto: Gerenciador de Lista de Tarefas
Descrição do Problema
Você deve criar um programa em Java que gerencie uma lista de tarefas simples. O programa deve permitir que o usuário realize as seguintes operações:

Adicionar uma nova tarefa: O usuário insere o nome de uma tarefa, que é adicionada à lista.
Exibir todas as tarefas: Mostre as tarefas em formato de lista, indicando quais estão concluídas e quais não estão.
Marcar uma tarefa como concluída: O usuário seleciona uma tarefa pelo número e ela é marcada como concluída.
Remover uma tarefa: O usuário seleciona uma tarefa pelo número e ela é removida da lista.
Encerrar o programa: Saia do programa quando o usuário escolher.
Requisitos
Cada tarefa deve ter:
Um nome.
Um status (concluída ou não).
O programa deve apresentar um menu interativo com as opções acima.
Se o usuário tentar realizar uma ação com um número inválido de tarefa, exiba uma mensagem de erro amigável.
O programa deve rodar em loop até o usuário escolher sair.
Desafios Adicionais (opcional)
Permita que o usuário edite o nome de uma tarefa existente.
Salve as tarefas em um arquivo para que possam ser carregadas ao reabrir o programa.
*/

//try throws

//Pesquisar Maps e HashMaps



import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import lombok.Data;
//import lombok.Setter;



public class GerenciadorTarefas {
	
	public static void main(String[] args) throws ArithmeticException, IOException, IndexOutOfBoundsException{
		Scanner scanner = new Scanner(System.in);
		ArrayList<Tarefa> list = new ArrayList<Tarefa>();
		

				int input = 0;
				while (input != 6){
					System.out.println("\n \u001B[32m\u001B[1m*=====* <Gerenciador de Tarefas> *=====*\u001B[0m\u001B[36m\n\u001B[3m1. > Adicionar Tarefa\n2. > Exibir Tarefas\n3. > Marcar Tarefa como \"Concluída\"\n4. > Apagar Tarefa\n5. > Editar Tarefa\n6. > Sair \u001B[0m\u001B[33m\u001B[3m");
				
					try {
						input = scanner.nextInt();
						scanner.nextLine();  // Limpa o buffer após nextInt()
					} catch (InputMismatchException e) {
						System.out.println("\u001B[31mEntrada inválida. Por favor, insira um número válido.");
						scanner.nextLine();  // Limpa o buffer de entrada
						System.out.print("Pressione Enter para voltar ao menu...\u001B[0m");
    					scanner.nextLine();
						continue;
					}
					
					switch(input){
						case 1:
							list.add(new Tarefa());
							try{
							System.out.print("\u001B[35mNome da Tarefa: ");
							String name = scanner.nextLine();
							System.out.print("Descrição da Tarefa: ");
							String description = scanner.nextLine();
							System.out.print("Concluída (digite 1) ou Não Concluída (digite 2):");
							int mark1 = scanner.nextInt();
							scanner.nextLine();
							boolean status = false;
							if (mark1 == 1) { status = true; }
							if (mark1 == 2) { status = false; }
							else { System.out.println("\u001B[31mNúmero inválido, será marcado como Não Concluída."); 
									System.out.print("Pressione Enter para voltar ao menu...\u001B[0m");
									scanner.nextLine();
								}
							list.get(list.size() - 1).addTarefa(name, status, description, list.size());
							}catch(InputMismatchException e){
								System.out.println("\u001B[31mEntrada inválida. Por favor, insira valores válidos");
								scanner.nextLine();  // Limpa o buffer de entrada
								System.out.print("Pressione Enter para voltar ao menu...\u001B[0m");
    							scanner.nextLine();
								continue;
							}
						break;

						case 2:
							System.out.println("\nTarefas Atuais:\u001B[32m");
    						for (int a = 0; a < list.size(); a++) {
								list.get(a).showTarefa();  // Alterado para o nome correto do método
							}
							System.out.println("\u001B[33m=*=*=* Fim da lista de Tarefas *=*=*=");
							System.out.print("\u001B[30mPressione Enter para voltar ao menu...\u001B[0m");
    						scanner.nextLine();
						break;

						case 3:
							System.out.println("Qual tarefa deseja marcar como concluída?");
							try{
							int k = scanner.nextInt();
							list.get(k-1).setStatus(true);
							} catch(InputMismatchException e){
								System.out.println("\u001B[31mEntrada inválida. Por favor, insira um número do ID correto.");
								scanner.nextLine();  // Limpa o buffer de entrada
								System.out.print("Pressione Enter para voltar ao menu...\u001B[0m");
    							scanner.nextLine();
								continue;
							}
					
						break;

						case 4: 
							System.out.println("Qual tarefa deseja deletar?");
							try{
							int l = scanner.nextInt();
							scanner.nextLine();
							list.remove(l-1);
							} catch(Exception e){
								System.out.println("\u001B[31mEntrada inválida. Por favor, insira um número do ID correto.");
								scanner.nextLine(); // Limpa o buffer de entrada
								System.out.print("Pressione Enter para voltar ao menu...\u001B[0m");
    							scanner.nextLine();
								continue;
							}
						break;

						case 5:
							System.out.println("Qual tarefa você deseja editar?");
							
							try{
								int m = scanner.nextInt();
								scanner.nextLine();
								if (m-1 >= 0 && m-1 < list.size()){
									System.out.println("O que você deseja editar: Nome (0), Descrição (1), Status (2)?");
									int j = scanner.nextInt();
									scanner.nextLine();
									if (j == 0 || j == 1){
										System.out.print("Escreva a alteração: ");
										if (j == 0) {list.get(m-1).setName(scanner.nextLine());}
										if (j == 1) {list.get(m-1).setDescription(scanner.nextLine());}
									}
									if (j == 2){
										System.out.println("Tem certeza que deseja desmarcar tarefa como concluída? (S/N)");
										String resp1 = scanner.nextLine();
										resp1 = resp1.trim().toUpperCase();
										if (resp1.equals("S")) {list.get(m-1).setStatus(false);}
										if (resp1.equals("N")) {break;}							
									}
								} else {
									System.out.println("\u001B[31mÍndice inválido!\u001B[0m");
								}
							}catch (Exception e){
								System.out.println("\u001B[31mEntrada inválida. Por favor, insira um número válido.");
								scanner.nextLine(); // Limpa o buffer de entrada
								System.out.print("Pressione Enter para voltar ao menu...\u001B[0m");
    							scanner.nextLine();
								continue;
							}

						break;

						//case 6:
						//break;
						case 6:
							try {
								System.out.println("\u001B[31mTem certeza que deseja sair? (S/N)\u001B[0m");
								String resposta = scanner.nextLine().trim().toUpperCase();
								
								if (resposta.equals("S")) {
									System.out.println("\u001B[32mEncerrando o programa...\u001B[0m");
									input = 6;  // Garante que o loop será encerrado
								} else if (resposta.equals("N")) {
									input = 0;  // Retorna ao menu
								} else {
									throw new InputMismatchException();  // Lança exceção para tratar entrada inválida
							}
							} catch (InputMismatchException e) {
								System.out.println("\u001B[31mEntrada inválida. Digite 'S' para sair ou 'N' para voltar ao menu.");
								System.out.print("Pressione Enter para voltar ao menu...\u001B[0m");
								scanner.nextLine(); // Aguarda input antes de voltar
								input = 0;
							}
						break;
						

						default:
						System.out.println("\u001B[31mOpção inválida!");
						System.out.print("Pressione Enter para voltar ao menu...\u001B[0m");
    					scanner.nextLine();
						break;
					}
					}

			
			scanner.close();
			}

}

@Data
class Tarefa{
	String name;
	boolean status;
	String description;
	int index;

	void addTarefa(String name, boolean status, String description, int index){
		this.name = name;
		this.status = status;
		this.description = description;
		this.index = index;
	}


	void showTarefa(){
		System.out.println("\n*=====* " + name + " *=====*");
		System.out.println("Descrição: " + description);
		if (status == true){System.out.println("Status: Concluída");}
		if (status == false){System.out.println("Status: Não Concluída");}
		System.out.println("ID: " + index +"\n");
	}


    // Métodos setters e getters (Caso: sem Lombok)
    // public void setName(String name) { this.name = name; }
    // public void setStatus(boolean status) { this.status = status; }
    // public void setDescription(String description) { this.description = description; }
    // public String getName() { return name; }
    // public boolean getStatus() { return status; }
    // public String getDescription() { return description; }
    // public int getId() { return index; }

}


