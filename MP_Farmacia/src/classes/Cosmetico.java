package classes;

public class Cosmetico extends Produto{
	private String quantidade;
	private String recomendacao;

    public Cosmetico(String nome, float preco, String dataValidade, String marca,int quantidadeEstoque, int id, String quantidade, String recomendacao) {
        super(nome, preco, dataValidade, marca,quantidadeEstoque, id);
        this.quantidade = quantidade;
        this.recomendacao = recomendacao;
    }
    public String getquantidade() {
    	return this.quantidade;
    }

    public String getrecomendacao() {
    	return this.recomendacao;
    }    
    
    public String setquantidade() {
    	return this.quantidade;
    }

    public String setrecomendacao() {
    	return this.recomendacao;
    }
}
