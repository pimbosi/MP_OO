package controle;

import java.util.ArrayList;
import modelo.*;

/*
 * Classe ControleProdutos responsavel por 
 * controle dos dados que sao exibidos na view.
 * @author Felipe de Jesus Rodrigues
 * @since 2023
 * @version 1.0
 * */

public class ControleProdutos {
	
	/*
	 * Variaveis de controle.
	 */
	
	private static ControleProdutos instancia;
	private ArrayList<Produto> p;
	private static Farmacia f;

	/*
	 * Construtor da classe como private
	 * para evitar que haja multiplicidade ou perda de dados
	 * ao instanciar essa classe nas devidas classes da view.
	 */
	
	private ControleProdutos() {
		f = Farmacia.getInstance();
		p = f.getprodutos();
		f.preencherDados();
	}
	
	/*
	 * Metodo responsavel por instanciar a classe
	 * e garantir que exista apenas uma instancia dela,
	 * evitando multiplicidade e perda de dados.
	 * @return ControleProdutos
	 */
	
    public static ControleProdutos getInstance() {
        if (instancia == null) {
            instancia = new ControleProdutos();
        }
        return instancia;
    }
	
    /*
     * Metodo resposavel por criar um vetor de String com os nomes
     * dos produtos adicionados no arrayList da classe
     * @see Farmacia
     * @return String[]
     */
    
	public String[] getnomeProdutos() {
		int i = 0;
		String[] Produtonome = new String[p.size()];
		for(Produto produto : p) {
			Produtonome[i] = produto.getnome();
			i++;
		}
		return Produtonome;
	}

	/*
	 * Metodo responsavel pela pesquisa de um produto.
	 * Chama o metodo @see Farmacia#buscaproduto com o argumento
	 * recebido pela funcao, se retornar um indice valido adiciona
	 * o nomeEncontrado no arraylist, se nao, retorna uma String[] 
	 * com valor nulo. No retorno padrao o arrayList eh transformado em String[].
	 * @return String[]
	 */
	
	public String[] getPesquisa(String pesquisa) {
	    ArrayList<String> nomeEncontrado = new ArrayList<>();
	    int indice = -1;
	    String[] nulo = null;
	    
	    indice = f.buscaproduto(pesquisa);
	    
	    if (indice != -1) {
	    	nomeEncontrado.add(p.get(indice).getnome());
	    }else return nulo;
	    
	    return nomeEncontrado.toArray(new String[0]);
	}
	
	/*
	 * Metodo responsavel pelo filtro de um produto, dado sua
	 * categoria. De acordo com o char passado como argumento
	 * adiciona o nome do produto referente aquela classe no arrayList e
	 * trata o retorno transformando o arrayList em String[].
	 * @return String[]
	 */
	
	public String[] filtrarLista(char selecionado) {
	    ArrayList<String> nomes = new ArrayList<>();

	    if(selecionado == 'c') {
	    	for (Produto produto : p) {
    			if (produto instanceof Cosmetico)
    				nomes.add(produto.getnome());
    		}
	    }else if (selecionado == 'v') {
	    	for (Produto produto : p) {
    			if (produto instanceof Vitamina)
    				nomes.add(produto.getnome());
    		}
	    }else if (selecionado == 'm') {
	    	for (Produto produto : p) {
    			if (produto instanceof Medicamento)
    				nomes.add(produto.getnome());
    		}
	    }
	    
	    return nomes.toArray(new String[0]);
	}
	
	/*
	 * Metodo responsavel por fazer o cast do produto
	 * para sua respectiva classe filha.
	 */
	
	public Produto castProduto(int index_selecionado) {
		
	   if (index_selecionado >= 0 && index_selecionado < p.size()) {
	        Produto produto = p.get(index_selecionado);
	
	        if(produto instanceof Medicamento) {
				Medicamento medicamento = (Medicamento) produto;
				return medicamento;
			}else if(produto instanceof Vitamina) {
				Vitamina vitamina = (Vitamina) produto;
				return vitamina;
			}else if (produto instanceof Cosmetico) {
				Cosmetico cosmetico = (Cosmetico) produto;
				return cosmetico;
			}
	   }
	   return null;		
	}
	
	/*
	 * Metodo responsavel por adicionar e editar produto.
	 * O atributo "index_selecionado" vai definir se este metodo
	 * ira adicionar um produto, ou editar um produto.
	 * Para editar um produto o metodo @see ControleProdutos#castProduto
	 * dependendo do retorno, sera atualizado o produto daquela classe com
	 * o metodo @see Farmacia#setproduto 
	 * Para adicionar um novo produto a sua classe correspondente, o atributo
	 * "categoria" para definir de qual classe filha sera o @see Produto
	 * o metodo @see Farmacia#addproduto 
	 * eh chamado para adicionar o novo produto.
	 * Retorna valor booleano correspondente ao sucesso ou fracasso do metodo.
	 * @return boolean
	 */
	
	public boolean adicionarEditarProduto(int index_selecionado, String[] 
			novoProduto, Farmacia f, char categoria) {
		boolean retorno = false;
		
		if(index_selecionado != -1) {
			Produto produto = castProduto(index_selecionado);
			retorno = true;
		
			if(produto instanceof Medicamento) {
				Medicamento medicamento = new Medicamento(novoProduto[0], 
				novoProduto[1],Float.parseFloat(novoProduto[2]), 
				Integer.parseInt(novoProduto[3]),novoProduto[4],
				novoProduto[5], novoProduto[6], novoProduto[7],
				novoProduto[8]);
				
				f.setproduto(index_selecionado, medicamento);
			}
			if(produto instanceof Vitamina) {
				Vitamina vitamina = new Vitamina(novoProduto[0], 
				novoProduto[1],Float.parseFloat(novoProduto[2]),
				Integer.parseInt(novoProduto[3]),novoProduto[4],
				novoProduto[5], novoProduto[6], novoProduto[7],
				novoProduto[8]);
				
				f.setproduto(index_selecionado, vitamina);
			}
			if(produto instanceof Cosmetico) {
				Cosmetico cosmetico = new Cosmetico(novoProduto[0],
				novoProduto[1],Float.parseFloat(novoProduto[2]),
				Integer.parseInt(novoProduto[3]),novoProduto[4],
				novoProduto[5], novoProduto[6], novoProduto[7],
				novoProduto[8]);
				
				f.setproduto(index_selecionado, cosmetico);
			}
		}else if(categoria == 'm'){
			Medicamento medicamento = new Medicamento(novoProduto[0],
				novoProduto[1],Float.parseFloat(novoProduto[2]),
				Integer.parseInt(novoProduto[3]),novoProduto[4],
				novoProduto[5], novoProduto[6], novoProduto[7],
				novoProduto[8]);
			
				retorno = f.addproduto(medicamento);
		}else if(categoria == 'v'){
			Vitamina vitamina = new Vitamina(novoProduto[0],
				novoProduto[1],Float.parseFloat(novoProduto[2]),
				Integer.parseInt(novoProduto[3]),novoProduto[4],
				novoProduto[5], novoProduto[6], novoProduto[7],
				novoProduto[8]);
			
				retorno = f.addproduto(vitamina);
		}else if(categoria == 'c'){
			Cosmetico cosmetico = new Cosmetico(novoProduto[0],
				novoProduto[1],Float.parseFloat(novoProduto[2]),
				Integer.parseInt(novoProduto[3]),novoProduto[4],
				novoProduto[5], novoProduto[6], novoProduto[7],
				novoProduto[8]);
			
				retorno = f.addproduto(cosmetico);
		}
		return retorno;
	}
	
	/*
	 * Metodo responsavel por excluir um produto dado seu indice.
	 * Chama o metodo @see Farmacia#removeproduto
	 * para excluir o produto selecionado. 
	 * Retorna o retorno do metodo removeproduto.
	 * @return boolean
	 */
	
	public boolean excluirProduto(int index_selecionado, Farmacia f) {
		boolean retorno = false;
		retorno = f.removeproduto(p.get(index_selecionado));
		return retorno;
	}

}