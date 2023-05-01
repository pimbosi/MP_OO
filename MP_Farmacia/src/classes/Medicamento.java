package classes;

public class Medicamento extends Produto{
	private String dosagem;
	private String principioativo;

    public Medicamento(String nome, float preco, String dataValidade, String marca, int quantidadeEstoque, int id, String dosagem, String principioativo) {
        super(nome, preco, dataValidade, marca, quantidadeEstoque, id);
        this.dosagem = dosagem;
        this.principioativo = principioativo;
    }

    public String getdosagem() {
    	return this.dosagem;
    }

    public String getprincipioativo() {
    	return this.principioativo;
    }    
    
    public String setdosagem() {
    	return this.dosagem;
    }

    public String setprincipioativo() {
    	return this.principioativo;
    }
}
