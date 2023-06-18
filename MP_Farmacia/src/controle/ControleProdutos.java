package controle;

import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import modelo.*;

public class ControleProdutos {
	
	private static ControleProdutos instance;
	private ArrayList<Produto> p;
	private Farmacia f;
	private int index_selecionado = -1;
	
	private ControleProdutos() {
		f = Farmacia.getInstance();
		p = f.getprodutos();
		f.preencherDados();
	}
	
    public static ControleProdutos getInstance() {
        if (instance == null) {
            instance = new ControleProdutos();
        }
        return instance;
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
	    ArrayList<String> nomesEncontrados = new ArrayList<>();

	    for (Produto produto : p) {
	        if (produto.getnome().equals(pesquisa)) {
	            nomesEncontrados.add(produto.getnome());
	        }
	    }

	    return nomesEncontrados.toArray(new String[0]);
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
		this.index_selecionado  = index_selecionado;
		
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
	
	public int getIndexProduto(String nome) {
	    for (int i = 0; i < p.size(); i++) {
	        if (p.get(i).getnome().equals(nome)) {
	            return i;
	        }
	    }
	    return -1;
	}
	
	public void adicionarProduto(int index_selecionado, String[] novoProduto, Farmacia f, char categoria) {
		this.index_selecionado = index_selecionado;
		
		if(index_selecionado != -1) {
			Produto produto = castProduto(index_selecionado);
		
			if(produto instanceof Medicamento || produto == null) {
				Medicamento medicamento = new Medicamento(novoProduto[0], novoProduto[1], 
				Float.parseFloat(novoProduto[2]), Integer.parseInt(novoProduto[3]),
				novoProduto[4], novoProduto[5], novoProduto[6], novoProduto[7],
				novoProduto[8]);
				
				f.setproduto(index_selecionado, medicamento);
			}
			if(produto instanceof Vitamina) {
				Vitamina vitamina = new Vitamina(novoProduto[0], novoProduto[1], 
				Float.parseFloat(novoProduto[2]), Integer.parseInt(novoProduto[3]),
				novoProduto[4], novoProduto[5], novoProduto[6], novoProduto[7],
				novoProduto[8]);
				
				f.setproduto(index_selecionado, vitamina);
			}
			if(produto instanceof Cosmetico) {
				Cosmetico cosmetico = new Cosmetico(novoProduto[0], novoProduto[1], 
				Float.parseFloat(novoProduto[2]), Integer.parseInt(novoProduto[3]),
				novoProduto[4], novoProduto[5], novoProduto[6], novoProduto[7],
				novoProduto[8]);
				
				f.setproduto(index_selecionado, cosmetico);
			}
		}else if(categoria == 'm'){
			Medicamento medicamento = new Medicamento(novoProduto[0], novoProduto[1], 
				Float.parseFloat(novoProduto[2]), Integer.parseInt(novoProduto[3]),
				novoProduto[4], novoProduto[5], novoProduto[6], novoProduto[7],
				novoProduto[8]);
			
				f.addproduto(medicamento);
		}else if(categoria == 'v'){
			Vitamina vitamina = new Vitamina(novoProduto[0], novoProduto[1], 
				Float.parseFloat(novoProduto[2]), Integer.parseInt(novoProduto[3]),
				novoProduto[4], novoProduto[5], novoProduto[6], novoProduto[7],
				novoProduto[8]);
			
				f.addproduto(vitamina);
		}else if(categoria == 'c'){
			Cosmetico cosmetico = new Cosmetico(novoProduto[0], novoProduto[1], 
				Float.parseFloat(novoProduto[2]), Integer.parseInt(novoProduto[3]),
				novoProduto[4], novoProduto[5], novoProduto[6], novoProduto[7],
				novoProduto[8]);
			
				f.addproduto(cosmetico);
		}
	}
	
	public void excluirProduto(int index_selecionado, Farmacia f) {
		f.removeproduto(p.get(index_selecionado));
	}

}