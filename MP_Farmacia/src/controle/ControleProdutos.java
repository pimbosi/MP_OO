package controle;

import java.util.ArrayList;
import modelo.*;

public class ControleProdutos {
	
	private static ControleProdutos instancia;
	private ArrayList<Produto> p;
	private static Farmacia f;
	
	public ControleProdutos() {
		f = Farmacia.getInstance();
		p = f.getprodutos();
		f.preencherDados();
	}
	
    public static ControleProdutos getInstance() {
        if (instancia == null) {
            instancia = new ControleProdutos();
        }
        return instancia;
    }
	
	public String[] getnomeProdutos() {
		int i = 0;
		String[] Produtonome = new String[p.size()];
		for(Produto produto : p) {
			Produtonome[i] = produto.getnome();
			i++;
		}
		return Produtonome;
	}

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
	
	public boolean excluirProduto(int index_selecionado, Farmacia f) {
		boolean retorno = false;
		retorno = f.removeproduto(p.get(index_selecionado));
		return retorno;
	}

}