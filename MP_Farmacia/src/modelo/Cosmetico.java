package modelo;

/*
 * Classe Cosmetico herda da classe Produto.
 * @author Felipe de Jesus Rodrigues
 * @since 2023
 * @version 1.0
 * */

public class Cosmetico extends Produto{
	private String composicao;
	private String advertencia;

    public Cosmetico(String nome,String marca,float preco,
    		int quantidadeEstoque, String dataValidade, 
    	 String quantidade,String principioativo, 
    	 String advertencia, String composicao) {
        super(nome,marca,preco,quantidadeEstoque,dataValidade,quantidade,
        		principioativo);
        this.composicao = composicao;
        this.advertencia = advertencia;
    }
    public String getcomposicao() {
    	return this.composicao;
    }

    public String getadvertencia() {
    	return this.advertencia;
    }    
    
    public String setcomposicao() {
    	return this.composicao;
    }

    public String setadvertencia() {
    	return this.advertencia;
    }
}
