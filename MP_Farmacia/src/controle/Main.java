package controle;

import java.util.*;

import modelo.*;

public class Main {
	
	/*public static void lista_produto(Farmacia farmacia, ArrayList<Produto> produtoarray) {
			System.out.println("-----------------------------"+ farmacia.getfarmacianome()+"----------------------------------\n");
			System.out.print("-------------------------------PRODUTOS------------------------------------\n\n");
		
		for(Produto produto : produtoarray) {
			if(produto instanceof Medicamento) {
				Medicamento medicamento = (Medicamento) produto;
					System.out.print("-------------------------------MEDICAMENTO---------------------------------\n\n");
					System.out.println("Produto: " + medicamento.getnome());
					System.out.println("Preco: R$ " + medicamento.getpreco());
					System.out.println("Data de Validade: " + medicamento.getdataValidade());
					System.out.println("Marca: " + produto.getmarca());
					System.out.println("Quantidade em estoque: " + medicamento.getquantidadeEstoque());
					System.out.println("Dosagem: " + medicamento.getdosagem());
					System.out.println("Princípio Ativo: " + medicamento.getprincipioativo()+"\n");
			}else if(produto instanceof Cosmetico) {
				Cosmetico cosmetico = (Cosmetico) produto;
					System.out.print("-------------------------------COSMETICO-----------------------------------\n\n");
					System.out.println("Produto: " + cosmetico.getnome());
					System.out.println("Preco: R$ " + cosmetico.getpreco());
					System.out.println("Data de Validade: " + cosmetico.getdataValidade());
					System.out.println("Marca: " + cosmetico.getmarca());
					System.out.println("Quantidade em estoque: " + cosmetico.getquantidadeEstoque());
					System.out.println("Quantidade: " + cosmetico.getquantidade());
					System.out.println("Recomendações: " + cosmetico.getrecomendacao()+"\n");
			}else if(produto instanceof Vitamina) {
				Vitamina vitamina = (Vitamina) produto;
					System.out.print("-------------------------------VITAMINA------------------------------------\n\n");
					System.out.println("Produto: " + vitamina.getnome());
					System.out.println("Preco: R$ " + vitamina.getpreco());
					System.out.println("Data de Validade: " + vitamina.getdataValidade());
					System.out.println("Marca: " + vitamina.getmarca());
					System.out.println("Quantidade em estoque: " + vitamina.getquantidadeEstoque());
					System.out.println("Quantidade: " + vitamina.getquantidade());
					System.out.println("Princípio Ativo: " + vitamina.getprincipioativo()+"\n");
			}
		}
	}*/
	
	public static void main(String[] args) {
		/*String resposta;
		
		Farmacia farmacia = new Farmacia("PHARMA & CIA");

		Medicamento novoproduto = new Medicamento("Dipirona", (float)
				5.55, "23/04/2024", "Prati Dondaduzzi Genérico", 25, 
				"5mg 20 comprimidos", "DIPIRONA SODICA", "Dores e enxaquecas",
				"Não indicado para gestantes");

		farmacia.addproduto(novoproduto);

		Cosmetico novoproduto2 = new Cosmetico("Creme Anti-Imperfeições",
				(float) 142.99, "26/05/2023", "La Roche-Posay", 50, "", "40ml", 
				"Uso externo. Não ingerir. Caso haja contato com olhos, lave-os."
				+ " Se houver irritação, suspenda o uso imediatamente e procure"
				+ " orientação médica.", "");
		
		farmacia.addproduto(novoproduto2);
		
		Vitamina novoproduto3 = new Vitamina("Suplemento Vitamínico Adeforte",
				(float) 20.33, "05/11/2023", "Gross", 15, "", "1 ampola", 
				"VITAMINA A, VITAMINA D", "");
		
		farmacia.addproduto(novoproduto3);
			
		ArrayList<Produto> produtoarray = farmacia.getprodutos();
		
		lista_produto(farmacia, produtoarray);

		System.out.println("\nRemover produto pelo id[1,2,3]");		
		Scanner ler = new Scanner(System.in);
		resposta = ler.nextLine();
		ler.close();

		for(Produto produto : produtoarray) {
			if(produto.getnome() == resposta) {
				farmacia.removeproduto(produto);
				break;
			}
		}
	
		lista_produto(farmacia, produtoarray);*/
	
	}
}