package view;

import java.awt.*;
import java.awt.event.*;
import controle.*;
import javax.swing.*;
import modelo.*;

/*
 * Classe TelaPrincipal cria a janela principal do programa
 * que contem a listagem dos produtos e botoes de acoes.
 * @author Felipe de Jesus Rodrigues
 * @since 2023
 * @version 1.0
 * */

public class TelaPrincipal implements ActionListener {
	
	// Variaveis referentes a GUI
	
	private static JFrame janela = new JFrame("Pharma&Cia");
	private static JLabel titulo = new JLabel("PHARMA & CIA");	
	
	private static JButton addProduto = new JButton("Adicionar Produto");
	private static JButton atualizar = new JButton("Atualizar");
	private static JButton excluir = new JButton("Excluir");
	private static JButton editar = new JButton("Editar");
	
	private static String[] listaNomes = new String[80];
	private static String nomePesquisado = new String();
	private static JScrollPane scrollProdutos = new JScrollPane();
	private static JList<String> listaProdutos;
	
	private static JLabel pesquisar = new JLabel("Pesquisar: ");
	private static JTextField pesquisa = new JTextField(100);
	
	private static JLabel filtrar = new JLabel("Filtrar: ");
	private static String[] opcoes={"Todos", "Medicamento", "Vitamina", 
			"Cosmético"};
    private static JComboBox<String> filtro = new JComboBox<>(opcoes);
	
    // Variaveis de controle
    
	private static Farmacia f = Farmacia.getInstance(); 
	private static ControleProdutos controle = ControleProdutos.getInstance();
	
	
	public TelaPrincipal() {
		
		// Setando os componentes da GUI
		
		titulo.setBounds(210, 40, 5000, 150);
		titulo.setFont(new Font("Arial", Font.BOLD, 180));
		titulo.setForeground(new Color(255, 255, 255));
		
		addProduto.setBounds(170, 950, 800, 30);
		addProduto.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		addProduto.setBackground(new Color(255, 255, 255));
		addProduto.setFocusable(false);
		
		editar.setBounds(170, 900, 800, 30);
		editar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		editar.setBackground(new Color(255, 255, 255));
		editar.setFocusable(false);
		
		atualizar.setBounds(980, 950, 800, 30);
		atualizar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		atualizar.setBackground(new Color(255, 255, 255));
		atualizar.setFocusable(false);
		
		excluir.setBounds(980, 900, 800, 30);
		excluir.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		excluir.setBackground(new Color(255, 255, 255));
		excluir.setFocusable(false);

		pesquisar.setBounds(195,820,300,30);
		pesquisar.setFont(new Font("Arial", Font.BOLD, 30));
		pesquisar.setForeground(Color.white);
		pesquisa.setFont(new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 25));
		pesquisa.setBounds(375,820,500,30);
		
		filtrar.setBounds(1315,820,300,30);
		filtrar.setFont(new Font("Arial", Font.BOLD, 30));
		filtrar.setForeground(Color.white);
		filtro.setFont(new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 30));
		filtro.setBackground(Color.WHITE);
		filtro.setBounds(1440,820,280,32);
		
		/*
		 * listaNomes recebe o retorno do metodo da classe ControleProdutos
		 * @see ControleProdutos#getnomeProdutos
		 * Se passar da condicao a lista sera adicionada a janela da
		 * tela principal, caso nao passe, exibira uma mensagem de erro
		 * */ 
		
		listaNomes = controle.getnomeProdutos();
		if (listaNomes != null && listaNomes.length > 0) {
		    listaProdutos = new JList<String>(listaNomes);
		    listaProdutos.setFont(new Font("Arial", Font.BOLD, 30));
		    scrollProdutos.setViewportView(listaProdutos);
		    scrollProdutos.setBounds(200,300,1520,500);
			janela.add(scrollProdutos);
		} else {
			JOptionPane.showMessageDialog(null,"Não foi "
					+ "possível adicionar produtos a lista!", null, 
					JOptionPane.ERROR_MESSAGE);
		}
		
		// Adicionando os componentes ao JFrame
		
		janela.setLayout(null);
		janela.add(titulo);
		janela.add(addProduto);
		janela.add(excluir);
		janela.add(editar);
		janela.add(atualizar);
		janela.add(pesquisa);
		janela.add(pesquisar);
		janela.add(filtro);
		janela.add(filtrar);
		janela.getContentPane().setBackground(new Color(200, 0, 0));
		janela.setSize(1920,1080);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		
	}
	
	/* Main que adiciona os devidos componentes ao metodo 
	   @see TelaPrincipal#actionPerformed
	*/
	public static void main(String[] args) {
		 TelaPrincipal tela = new TelaPrincipal();

		 addProduto.addActionListener(tela);
		 atualizar.addActionListener(tela);
		 excluir.addActionListener(tela);
		 editar.addActionListener(tela);
		 pesquisa.addActionListener(tela);
	}
	
	/*Metodo responsavel identificar acoes em certos componentes
	 */
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource(); /* recebe o metodo responsavel 
									   por identificar a acao
		 							*/
		String opcaoSelecionada = (String) filtro.getSelectedItem(); /* 
				metodo da classe combobox que identifica o item selecionado
		 															*/
		char selecionado;
		boolean retorno = false;
	
		/*
		 * Adicionar o produto abre uma nova tela
		 * @see TelaProduto
		 */
		if(src == addProduto)
			new TelaProduto(); 
		
		/*
		 * Para excluir o produto, verifica se o metodo do JList
		 * nao possui um valor de indice invalido.
		 * O metodo @see Farmacia#buscaproduto retorna o indice
		 * identificado que eh passado como argumento do metodo
		 * @see ControleProdutos#excluirProduto
		 * Caso esse metodo retorne true, exibe a mensagem de sucesso
		 * caso false, exibe a mensagem de erro
		 * */
		
		if(src == excluir) {
			if (listaProdutos.getSelectedIndex() > -1) {
		        String nomeSelecionado = listaProdutos.getSelectedValue();
		        int indexOriginal = f.buscaproduto(nomeSelecionado);
		        retorno = controle.excluirProduto(indexOriginal, f);
		    }
			if(retorno == true) {
				JOptionPane.showMessageDialog(null, "Produto excluído com "
						+ "sucesso!",
						"EXCLUÍDO", JOptionPane.INFORMATION_MESSAGE);
			}else { 
				JOptionPane.showMessageDialog(null, "Erro ao excluir produto!"
						+ "\nCertifique-se de que um produto foi selecionado",	
					"ERRO", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		/*
		 * Para editar, verifica se o metodo do JList
		 * nao possui um valor de indice invalido.
		 * Variavel nomeSelecionado recebe o retorno do metodo do JList.
		 * Essa variavel eh passada como argumento do metodo
		 * @see Farmacia#buscaproduto que retorna o indice que sera 
		 * passado como argumento do metodo @see ControleProdutos#castProduto
		 * Tela de edicao @see TelaProduto#mostraDados recebe o indice e
		 * o retorno de castProduto.
		 */
		
		if(src == editar) {
			if (listaProdutos.getSelectedIndex() > -1) {
		        String nomeSelecionado = listaProdutos.getSelectedValue();
		        int indexOriginal = f.buscaproduto(nomeSelecionado);
		        Produto produto = controle.castProduto(indexOriginal);
		        new TelaProduto().mostraDados(indexOriginal, produto);
		    }else { 
				JOptionPane.showMessageDialog(null, "Não foi possível editar "
						+ "o produto.\nCertifique-se de que um produto foi "
						+ "selecionado",	
					"ERRO", JOptionPane.ERROR_MESSAGE);
		    }
		}	
		
		/*
		 * Usa metodos do JList para atualizar a GUI com novos dados
		 */
		
		if(src == atualizar){
			listaProdutos.setListData(controle.getnomeProdutos());
			listaProdutos.updateUI();
		}
	
		/*
		 * Cadeia de ifs responsaveis por filtrar a lista.
		 * Chama o metodo @see ControleProdutos#filtrarLista
		 * passa o argumento char para diferenciar a opcao selecionada.
		 * Atualiza a GUI com dados filtrados.
		 */
		
		if (opcaoSelecionada.equals("Cosmético")){
			selecionado = 'c';
			listaProdutos.setListData(controle.filtrarLista(selecionado));
			listaProdutos.updateUI();
		}else if (opcaoSelecionada.equals("Vitamina")){
			selecionado = 'v';
			listaProdutos.setListData(controle.filtrarLista(selecionado));
			listaProdutos.updateUI();
		}else if (opcaoSelecionada.equals("Medicamento")){
			selecionado = 'm';
			listaProdutos.setListData(controle.filtrarLista(selecionado));
			listaProdutos.updateUI();
		}else {
			listaProdutos.setListData(controle.getnomeProdutos());
			listaProdutos.updateUI();
		}
		
		/*
		 * Para pesquisa, a variavel nomePesquisado recebe a string 
		 * passada pelo metodo getText do JTextField.
		 * Se a pesquisa estiver em branco, atualiza a GUI com os dados
		 * sem filtro. Caso contrario chama o metodo
		 * @see ControleProdutos#getnomeProdutos
		 * se o retorno for valido atualiza a lista e a GUI com os dados
		 * da pesquisa.
		 */
		
		if(src == pesquisa) {
			nomePesquisado = pesquisa.getText();
			if(nomePesquisado.isBlank()) {
				listaProdutos.setListData(controle.getnomeProdutos());
				listaProdutos.updateUI();
			}else {
				if ((controle.getPesquisa(nomePesquisado)) == null){
					JOptionPane.showMessageDialog(null, "Produto "
						+ "não encontrado!",
						"NÃO ENCONTRADO", JOptionPane.INFORMATION_MESSAGE);
				}else {
					listaProdutos.setListData
					(controle.getPesquisa(nomePesquisado));
					listaProdutos.updateUI();
				}
			}
		}
	}

}
