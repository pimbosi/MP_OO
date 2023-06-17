package modelo;

import java.text.DecimalFormat;

public abstract class Produto {

	private String nome;
	private String marca;
	private float preco;
	private int quantidadeEstoque;
	private String dataValidade;
	private String quantidade;
	private String principioativo;

	public Produto(String nome, String marca, float preco,
			int quantidadeEstoque, String dataValidade,
			String quantidade, String principioativo) {
		this.nome = nome;
		this.preco = preco;
		this.dataValidade = dataValidade;
		this.marca = marca;
		this.quantidadeEstoque = quantidadeEstoque;
		this.quantidade = quantidade;
		this.principioativo = principioativo; 
	}
		
	public String getnome() {
		return this.nome;
	}
	
	public String getmarca() {
		return this.marca;
	}
	
	public float getpreco() {
		return this.preco;
	}
	
	public int getquantidadeEstoque() {
		return this.quantidadeEstoque;
	}

	public String getdataValidade() {
		return this.dataValidade;
	}
	
	public String getPrincipioativo() {
		return principioativo;
	}
	
	public String setnome(String nome) {
		return this.nome;
	}
	
	public String getQuantidade() {
		return quantidade;
	}
	
	public String setmarca(String marca) {
		return this.marca;
	}
	
	public float setpreco(float preco) {
		return this.preco;
	}
	
	public int setquantidadeEstoque(int quantidadeEstoque) {
		return this.quantidadeEstoque;
	}

	public String setdataValidade(String dataValidade) {
		return this.dataValidade;
	}

	public void setPrincipioativo(String principioativo) {
		this.principioativo = principioativo;
	}
	
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

}
