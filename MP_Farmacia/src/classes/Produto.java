package classes;

public abstract class Produto {

	private int id;
	private String nome;
	private String marca;
	private float preco;
	private int quantidadeEstoque;
	private String dataValidade;

	public Produto(String nome, float preco, String dataValidade, String marca, int quantidadeEstoque, int id) {
		this.nome = nome;
		this.preco = preco;
		this.dataValidade = dataValidade;
		this.marca = marca;
		this.quantidadeEstoque = quantidadeEstoque;
		this.id = id;
	}
	
	public String getnome() {
		return this.nome;
	}
	
	public int getid() {
		return this.id;
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
	
	public String setnome(String nome) {
		return this.nome;
	}
	
	public int setid(int id) {
		return this.id;
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

}
