package modelo;

/*
 * Classe Medicamento herda da classe Produto.
 * @author Felipe de Jesus Rodrigues
 * @since 2023
 * @version 1.0
 * */

public class Medicamento extends Produto{
	private String indicacao;
	private String contraindicacao;

    public Medicamento(String nome,String marca,float preco,
    		int quantidadeEstoque,String dataValidade,
    	 String quantidade, String principioativo, 
    	 String indicacao, String contraindicacao) {
        super(nome,marca,preco,quantidadeEstoque,dataValidade,quantidade, 
        		principioativo);
        this.indicacao = indicacao;
        this.contraindicacao = contraindicacao;
    }

    public String getindicacao(){
    	return this.indicacao;
    }

    public String getcontraindicacao() {
    	return this.contraindicacao;
    }    
    
    public String setindicacao() {
    	return this.indicacao;
    }

    public String setcontraindicacao() {
    	return this.contraindicacao;
    }
}
