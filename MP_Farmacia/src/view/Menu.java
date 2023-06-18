package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import controle.*;
import javax.swing.*;
import modelo.*;

public class Menu extends JFrame implements ActionListener {
	
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
	private String[] opcoes = {"Todos", "Medicamento", "Vitamina", "Cosmético"};
    private JComboBox<String> filtro = new JComboBox<>(opcoes);
	
	private static Farmacia f = Farmacia.getInstance(); 
	private ControleProdutos controle = ControleProdutos.getInstance();
	
	public Menu() {
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
		
		listaNomes = controle.getnomeProdutos();
		if (listaNomes != null && listaNomes.length > 0) {
		    listaProdutos = new JList<String>(listaNomes);
		    listaProdutos.setFont(new Font("Arial", Font.BOLD, 30));
		    scrollProdutos.setViewportView(listaProdutos);
		    scrollProdutos.setBounds(200,300,1520,500);
			janela.add(scrollProdutos);
		} else {
			JOptionPane.showMessageDialog(null,"Não foi possível adicionar produtos a lista!", null, 
					JOptionPane.ERROR_MESSAGE);
		}
		
		janela.setLayout(null);
		janela.add(titulo);
		janela.add(addProduto);
		janela.add(atualizar);
		janela.add(excluir);
		janela.add(editar);
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
	
	public static void main(String[] args) {
		 Menu menu = new Menu();

		 addProduto.addActionListener(menu);
		 atualizar.addActionListener(menu);
		 excluir.addActionListener(menu);
		 editar.addActionListener(menu);
		 pesquisa.addActionListener(menu);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == addProduto)
			new TelaProduto();
		
		if(src == excluir) {
			if (listaProdutos.getSelectedIndex() > -1) {
		        String nomeSelecionado = listaProdutos.getSelectedValue();
		        int indexOriginal = controle.getIndexProduto(nomeSelecionado);
		        controle.excluirProduto(indexOriginal, f);
		    }
			JOptionPane.showMessageDialog(null, "Item excluído com sucesso!",
	    		 "EXCLUÍDO", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(src == atualizar){
			listaProdutos.setListData(controle.getnomeProdutos());
			listaProdutos.updateUI();
		}
		
		if(src == editar) {
			if (listaProdutos.getSelectedIndex() > -1) {
		        String nomeSelecionado = listaProdutos.getSelectedValue();
		        int indexOriginal = controle.getIndexProduto(nomeSelecionado);
		        Produto produto = controle.castProduto(indexOriginal);
		        new TelaProduto().mostraDados(indexOriginal, produto);
		    }
		}	
	
		String opcaoSelecionada = (String) filtro.getSelectedItem();
		char selecionado;
		
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
		
		if(src == pesquisa) {
			nomePesquisado = pesquisa.getText();
			if(nomePesquisado.isBlank()) {
				listaProdutos.setListData(controle.getnomeProdutos());
				listaProdutos.updateUI();
			}else {
				listaProdutos.setListData(controle.getPesquisa(nomePesquisado));
				listaProdutos.updateUI();
			}
		}
	}

}