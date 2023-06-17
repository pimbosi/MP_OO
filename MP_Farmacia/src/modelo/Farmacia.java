package modelo;

import java.util.*;

public class Farmacia {
	
	private static Farmacia instance;
	private ArrayList<Produto> produtos = new ArrayList<>();
	
	private Farmacia() {
        produtos = new ArrayList<>();
    }

    public static Farmacia getInstance() {
        if (instance == null) {
            instance = new Farmacia();
        }
        return instance;
    }

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
	
	public ArrayList<Produto> getprodutos(){
		return produtos;
	}
	
	public void addproduto(Produto novoproduto) {
		this.produtos.add(novoproduto);
	}
	
	public void setproduto(int index, Produto novoproduto) {
		this.produtos.set(index, novoproduto);
	}
	
	public void removeproduto(Produto removeproduto) {
		this.produtos.remove(removeproduto);
	}
	
	public void buscaproduto(Produto buscaproduto) {
		this.produtos.remove(buscaproduto);
	}
}
