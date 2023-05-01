package classes;

public class Vitamina extends Produto{
	private String quantidade;
	private String principioativo;

    public Vitamina(String nome, float preco, String dataValidade, String marca,int quantidadeEstoque, int id, String quantidade, String principioativo) {
        super(nome, preco, dataValidade, marca, quantidadeEstoque, id);
        this.quantidade = quantidade;
        this.principioativo = principioativo;
    }

    public String getquantidade() {
    	return this.quantidade;
    }

    public String getprincipioativo() {
    	return this.principioativo;
    }    
    
    public String setquantidade() {
    	return this.quantidade;
    }

    public String setprincipioativo() {
    	return this.principioativo;
    }
}
