package modelo;

import java.util.*;

/*
 * Classe Farmacia responsavel por armazenar os dados dos produtos.
 * @author Felipe de Jesus Rodrigues
 * @since 2023
 * @version 1.0
 * */

public class Farmacia {
	
	/*
	 * Variavel produtos eh o ArrayList<Produto>
	 * utilizado para armazenar os dados.
	 */
	
	private static Farmacia instancia;
	private String nome;
	private ArrayList<Produto> produtos = new ArrayList<>();
	
	/*
	 * Construtor da classe como private
	 * para evitar que haja multiplicidade ou perda de dados
	 * ao instanciar essa classe nas devidas classes da view.
	 */
	
	private Farmacia(String nome) {
		this.setNome(nome);
        produtos = new ArrayList<>();
    }

	/*
	 * Metodo responsavel por instanciar a classe
	 * e garantir que exista apenas uma instancia dela,
	 * evitando multiplicidade e perda de dados.
	 * @return ControleProdutos
	 */
	
    public static Farmacia getInstance() {
        if (instancia == null) {
            instancia = new Farmacia("Pharma&Cia");
        }
        return instancia;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
    
	/*
	 * Metodo para peencher dados antes de executar o
	 * programa.
	 */
	
	public void preencherDados() {
		
		Medicamento novoproduto = new Medicamento("Dipirona",
				"Prati Dondaduzzi Genérico", (float) 5.55, 25, "23/04/2024",  
				"5mg 20 comprimidos", "DIPIRONA SODICA", "Dores e enxaquecas",
				"Não indicado para gestantes");

		Cosmetico novoproduto2 = new Cosmetico("Creme Anti-Imperfeições",
				"La Roche-Posay",(float) 142.99,50,"26/05/2023","40ml", 
				"CREME", "Uso externo. Não ingerir. Caso haja contato com "
				+ "olhos, lave-os.", "Composto de creme");
		
		Vitamina novoproduto3 = new Vitamina("Suplemento Vitamínico Adeforte",
				"Gross",(float) 20.33,15,"05/11/2023", "1 ampola", 
				"VITAMINA A, VITAMINA D", "8 em 8 horas antes da refeição", 
				"Para melhor saúde vitamínica");
		
		Medicamento n4 = new Medicamento("Ibuprofeno",
				"Prati Dondaduzzi Genérico", (float) 5.55, 25, "23/04/2024",  
				"5mg 20 comprimidos", "DIPIRONA SODICA", "Dores e enxaquecas",
				"Não indicado para gestantes");

		Cosmetico n5 = new Cosmetico("Sabonete JU",
				"La Roche-Posay",(float) 142.99,50,"26/05/2023","40ml", 
				"CREME", "Uso externo. Não ingerir. Caso haja contato com "
				+ "olhos, lave-os.", "Composto de creme");
		
		Vitamina n6 = new Vitamina("WHEY Protein",
				"Gross",(float) 20.33,15,"05/11/2023", "1 ampola", 
				"VITAMINA A, VITAMINA D", "8 em 8 horas antes da refeição", 
				"Para melhor saúde vitamínica");
		
		Medicamento n7 = new Medicamento("Paracetamol",
				"Prati Dondaduzzi Genérico", (float) 5.55, 25, "23/04/2024",  
				"5mg 20 comprimidos", "DIPIRONA SODICA", "Dores e enxaquecas",
				"Não indicado para gestantes");

		Cosmetico n8 = new Cosmetico("Shampoo do CR7",
				"La Roche-Posay",(float) 142.99,50,"26/05/2023","40ml", 
				"CREME", "Uso externo. Não ingerir. Caso haja contato com "
				+ "olhos, lave-os.", "Composto de creme");
		
		Vitamina n9 = new Vitamina("Vitamina C",
				"Gross",(float) 20.33,15,"05/11/2023", "1 ampola", 
				"VITAMINA A, VITAMINA D", "8 em 8 horas antes da refeição", 
				"Para melhor saúde vitamínica");
		
		Medicamento n10 = new Medicamento("Cetrolac",
				"Prati Dondaduzzi Genérico", (float) 5.55, 25, "23/04/2024",  
				"5mg 20 comprimidos", "DIPIRONA SODICA", "Dores e enxaquecas",
				"Não indicado para gestantes");

		Cosmetico n11 = new Cosmetico("Condicionador do CR7",
				"La Roche-Posay",(float) 142.99,50,"26/05/2023","40ml", 
				"CREME", "Uso externo. Não ingerir. Caso haja contato com "
				+ "olhos, lave-os.", "Composto de creme");
		
		Vitamina n12 = new Vitamina("Iodara",
				"Gross",(float) 20.33,15,"05/11/2023", "1 ampola", 
				"VITAMINA A, VITAMINA D", "8 em 8 horas antes da refeição", 
				"Para melhor saúde vitamínica");
		
		Medicamento n13 = new Medicamento("Imuran",
				"Prati Dondaduzzi Genérico", (float) 5.55, 25, "23/04/2024",  
				"5mg 20 comprimidos", "DIPIRONA SODICA", "Dores e enxaquecas",
				"Não indicado para gestantes");

		Cosmetico n14 = new Cosmetico("Desodorante Rexona",
				"La Roche-Posay",(float) 142.99,50,"26/05/2023","40ml", 
				"CREME", "Uso externo. Não ingerir. Caso haja contato com "
				+ "olhos, lave-os.", "Composto de creme");
		
		Vitamina n15 = new Vitamina("Nutren Senior",
				"Gross",(float) 20.33,15,"05/11/2023", "1 ampola", 
				"VITAMINA A, VITAMINA D", "8 em 8 horas antes da refeição", 
				"Para melhor saúde vitamínica");
		
		addproduto(novoproduto);
		addproduto(novoproduto2);
		addproduto(novoproduto3);
		addproduto(n4);
		addproduto(n5);
		addproduto(n6);
		addproduto(n7);
		addproduto(n8);
		addproduto(n9);
		addproduto(n10);
		addproduto(n11);
		addproduto(n12);
		addproduto(n13);
		addproduto(n14);
		addproduto(n15);
		
	}
	
	/*
	 * Metodo responsavel por retornar os dados
	 * armazenados no ArrayList produtos.
	 * @return ArrayList<Produto>
	 */
	
	public ArrayList<Produto> getprodutos(){
		return produtos;
	}
	
	/*
	 * Metodo responsavel por adicionar os dados
	 * no ArrayList produtos.
	 * Retorna booleano de acordo com o resultado
	 * dessa acao.
	 * @return boolean
	 */
	
	public boolean addproduto(Produto novoproduto) {
		return this.produtos.add(novoproduto);
	}
	
	/*
	 * Metodo responsavel por atualizar os dados
	 * no ArrayList produtos.
	 */
	
	public void setproduto(int index, Produto novoproduto) {
		this.produtos.set(index, novoproduto);
	}
	
	/*
	 * Metodo responsavel por remover os dados
	 * no ArrayList produtos.
	 * Retorna booleano de acordo com o resultado
	 * dessa acao.
	 * @return boolean
	 */
	
	public boolean removeproduto(Produto removeproduto) {
		return this.produtos.remove(removeproduto);
	}

	/*
	 * Metodo responsavel por buscar o produto dado
	 * seu nome no ArrayList produtos.
	 * Retorna o indice do produto caso o nome seja encontrado
	 * e retorna -1 caso nao seja enctonrado.
	 * @return int
	 */
	
	public int buscaproduto(String pesquisa) {
		for (int i = 0; i < produtos.size(); i++) {
	        if (produtos.get(i).getnome().equals(pesquisa)) {
	            return i;
	        }
	    }
	    return -1;
	}

}
