package urna;

import java.util.Scanner;

public class Main {
	public static void recebePolitico(Candidato X){
		Scanner sc = new Scanner(System.in);
		System.out.println("DADOS DO CANDIDATO:");
		System.out.print("Insira o nome do candidato: ");
		X.nome = sc.nextLine();
		System.out.print("Insira o número do candidato " + X.nome + ": ");
		X.numero = Integer.parseInt(sc.nextLine());
		System.out.println();
	}
	
	public static void recebeDados(Candidato A, Candidato B){
		recebePolitico(A);
		recebePolitico(B);
	}
	
	public static void listaDados(Candidato X){
		System.out.println("Nome: " + X.nome);
		System.out.println("Número: " + X.numero);
		System.out.println("Votos válidos: " + X.votos);
		System.out.println("Percentual de votos: " + X.percentual);
		System.out.println();
	}
	
	public static int eleicao(Candidato A, Candidato B){
		Scanner input = new Scanner(System.in);
		int voto = 0;
		String conf = "";
		char c = 'a';
		boolean cont = true;
		boolean cfim = false;
		int totalVotos = 0;
		
		System.out.println("ELEIÇÃO: ");
		
		do{
			cfim = false;
			System.out.print("Digite o número do seu candidato: ");
			voto = Integer.parseInt(input.nextLine());

			if(voto == A.numero){
				while(c != 's' || c != 'S' || c != 'n' || c != 'N'){
					System.out.print("Deseja confirmar seu voto no candidato "
										+ A.nome + "[s/n]? ");
					conf = input.nextLine();
					c = conf.charAt(0);
				
					if(c == 's' || c == 'S'){
						A.votos++;
					
						System.out.println("Você votou no candidato " + A.nome + "!");
						cfim = true;
						break;
					}
					else if(c == 'n' || c == 'N'){
						break;
					}
				}			
			}
			
			else if (voto == B.numero){
				while(c != 's' || c != 'S' || c != 'n' || c != 'N'){
					System.out.print("Deseja confirmar seu voto no candidato "
										+ B.nome + "[s/N]? ");
					conf = input.nextLine();
					c = conf.charAt(0);
					
					if(c == 's' || c == 'S'){
						B.votos++;
							
						System.out.println("Você votou no candidato " + B.nome + "!");
						cfim = true;
						break;
					}
					else if(c == 'n' || c == 'N'){
						break;
					}
				}
			}
			else{
				while(c != 's' || c != 'S' || c != 'n' || c != 'N'){
					System.out.print("Deseja confirmar seu voto nulo[s/N]? ");
					conf = input.nextLine();
					c = conf.charAt(0);
					
					if(c == 's' || c == 'S'){
						System.out.println("Você votou nulo!");
						cfim = true;
						break;
					}
					else if(c == 'n' || c == 'N'){
						break;
					}
				}
			}			

			System.out.println();
			
			if(cfim == true){
				totalVotos++;
				while(c != 's' || c != 'S' || c != 'n' || c != 'N'){
					System.out.print("Deseja continuar a eleição[s/N]? ");
					conf = input.nextLine();
					c = conf.charAt(0);				
				
					if(c == 'n' || c == 'N'){
						cont = false;
						break;
					}
					else if(c == 's' || c == 'S'){
						break;
					}
				}
				System.out.println();
			}			
		}while(cont == true);
		
		return totalVotos;
	}
	
	public static void calculaVencedor(Candidato A, Candidato B){
		if(A.votos > B.votos){
			System.out.println("O candidato " + A.nome + " foi eleito!!!");
			System.out.println();
			listaDados(A);
			listaDados(B);
		}
		else if (B.votos > A.votos){
			System.out.println("O candidato " + B.nome + " foi eleito!!!");
			System.out.println();
			listaDados(B);
			listaDados(A);
		}
		
	}
	
	public static void calculaPercentual(Candidato A, int total){
		A.percentual = (A.votos * 100) / total;
	}
	
	
	public static void main(String[] args) {
		int totalVotos = 0;		
		Candidato politico[] = new Candidato[2];
		for(int i = 0; i < 2; i++){
			politico[i] = new Candidato();
		}
		
		recebeDados(politico[0], politico[1]);
		totalVotos = eleicao(politico[0], politico[1]);
		calculaPercentual(politico[0], totalVotos);
		calculaPercentual(politico[1], totalVotos);
		calculaVencedor(politico[0], politico[1]);
	}
}
