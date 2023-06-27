package modelo;

public class Vitamina extends Produto{
	private String mododeuso;
	private String recomendacao;

    public Vitamina(String nome, String marca,float preco,
    		int quantidadeEstoque,
    		String dataValidade, String quantidade, 
    		String principioativo, String mododeuso, String recomendacao) {
    	super(nome,marca,preco,quantidadeEstoque,dataValidade,quantidade,
    			principioativo);
        this.mododeuso = mododeuso;
        this.recomendacao = recomendacao;
    }

    public String getmododeuso() {
    	return this.mododeuso;
    }

    public String getrecomendacao() {
    	return this.recomendacao;
    }    
    
    public String setmododeduso() {
    	return this.mododeuso;
    }

    public String setrecomendacao() {
    	return this.recomendacao;
    }
}
