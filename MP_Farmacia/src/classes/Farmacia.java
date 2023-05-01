package classes;

import java.util.*;

public class Farmacia {

	private String nome;
	private ArrayList<Produto> produtos = new ArrayList<>();
	
	public Farmacia(String nome) {
		this.nome = nome;
	}
	
	public String getfarmacianome() {
		return this.nome;
	}
	
	public String setfarmacianome() {
		return this.nome;
	}
	
	public ArrayList<Produto> getprodutos(){
		return produtos;
	}
	
	public void addproduto(Produto novoproduto) {
		this.produtos.add(novoproduto);
	}
	
	public void removeproduto(Produto removeproduto) {
		this.produtos.remove(removeproduto);
	}
}
