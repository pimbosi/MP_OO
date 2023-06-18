package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import modelo.*;
import controle.*;

public class TelaProduto implements ActionListener, ListSelectionListener{

	private JFrame janela = new JFrame("Pharma&Cia");
	private JLabel titulo = new JLabel("Cadastrar novo produto");	
	private JLabel l1 = new JLabel			("Nome:    				  ");
	private JLabel l2 = new JLabel			("Marca:  				  ");
	private JLabel l3 = new JLabel			("Preço:				  ");
	private JLabel l4 = new JLabel		("Quantidade em Estoque:  ");
	private JLabel l5 = new JLabel		("Data de Validade:	      ");
	private JLabel l6 = new JLabel		("Quantidade: 		  	  ");
	private JLabel l7 = new JLabel	("Princípio Ativo:  	  ");
	private JLabel l8 = new JLabel		("Composição:			  ");
	private JLabel l9 = new JLabel 	("Advertência: 			  ");
	private JLabel l10 = new JLabel 		("Indicação:			  ");
	private JLabel l11 = new JLabel ("Contraindicação:		  ");
	private JLabel l12 = new JLabel 		("Modo de uso:		      ");
	private JLabel l13 = new JLabel 	("Recomendação: 		  ");
	private JLabel l14 = new JLabel 	("Categoria:              ");
	
	private JTextField t1 = new JTextField(100);
	private JTextField t2= new JTextField(100);
	private JTextField t3 = new JTextField(100);
	private JTextField t4 = new JTextField(100);
	private JTextField t5 = new JTextField(100);
	private JTextField t6 = new JTextField(100);
	private JTextField t7 = new JTextField(100);
	private JTextField t8 = new JTextField(100);
	private JTextField t9 = new JTextField(100);
	private JTextField t10 = new JTextField(100);
	private JTextField t11 = new JTextField(100);
	private JTextField t12 = new JTextField(100);
	private JTextField t13 = new JTextField(100);
	
	private String[] opcoes = {"Selecione", "Medicamento", "Vitamina", "Cosmético"};
    private JComboBox<String> comboBox = new JComboBox<>(opcoes);
	
	private JButton salvar = new JButton("Salvar");
	private JButton cancelar = new JButton("Cancelar");
	
	private String dados[] = new String[10];
	private int edicao = -1;
	
	private static Farmacia f; 
	private ControleProdutos controle = ControleProdutos.getInstance();
	
	public TelaProduto() {
		
		titulo.setBounds(322, 8, 500, 80);
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		titulo.setForeground(new Color(255, 255, 255));
		
		l1.setFont(new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 40));
		l1.setForeground(new Color(255, 255, 255));
		l2.setFont(new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 40));
		l2.setForeground(new Color(255, 255, 255));
		l3.setFont(new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 40));
		l3.setForeground(new Color(255, 255, 255));
		l4.setFont(new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 40));
		l4.setForeground(new Color(255, 255, 255));
		l5.setFont(new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 40));
		l5.setForeground(new Color(255, 255, 255));
		l6.setFont(new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 40));
		l6.setForeground(new Color(255, 255, 255));
		l7.setFont(new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 40));
		l7.setForeground(new Color(255, 255, 255));
		l8.setFont(new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 40));
		l8.setForeground(new Color(255, 255, 255));
		l9.setFont(new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 40));
		l9.setForeground(new Color(255, 255, 255));
		l10.setFont(new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 40));
		l10.setForeground(new Color(255, 255, 255));
		l11.setFont(new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 40));
		l11.setForeground(new Color(255, 255, 255));
		l12.setFont(new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 40));
		l12.setForeground(new Color(255, 255, 255));
		l13.setFont(new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 40));
		l13.setForeground(new Color(255, 255, 255));
		l14.setFont(new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 40));
		l14.setForeground(new Color(255, 255, 255));
		
		l1.setBounds(200,140,600,40);
		l2.setBounds(200,200,600,40);
		l3.setBounds(200,260,600,40);
		l4.setBounds(200,320,600,40);
		l5.setBounds(200,380,600,40);
		l6.setBounds(200,440,600,40);
		l7.setBounds(200,500,600,40);
		l8.setBounds(200,620,600,40);
		l9.setBounds(200,680,600,40);
		l10.setBounds(200,620,600,40);
		l11.setBounds(200,680,600,40);
		l12.setBounds(200,620,600,40);
		l13.setBounds(200,680,600,40);
		l14.setBounds(200,560,600,45);
		
		Font fonte = new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 25);
		
		t1.setFont(fonte);
		t2.setFont(fonte);
		t3.setFont(fonte);
		t4.setFont(fonte);
		t5.setFont(fonte);
		t6.setFont(fonte);
		t7.setFont(fonte);
		t8.setFont(fonte);
		t9.setFont(fonte);
		t10.setFont(fonte);
		t11.setFont(fonte);
		t12.setFont(fonte);
		t13.setFont(fonte);
		
		t1.setBounds(800,140,800,40);
		t2.setBounds(800,200,800,40);
		t3.setBounds(800,260,800,40);
		t4.setBounds(800,320,800,40);
		t5.setBounds(800,380,800,40);
		t6.setBounds(800,440,800,40);
		t7.setBounds(800,500,800,40);
		t8.setBounds(800,620,800,40);
		t9.setBounds(800,680,800,40);
		t10.setBounds(800,620,800,40);
		t11.setBounds(800,680,800,40);
		t12.setBounds(800,620,800,40);
		t13.setBounds(800,680,800,40);
		
		l8.setVisible(false);
		l9.setVisible(false);
		l10.setVisible(false);
		l11.setVisible(false);
		l12.setVisible(false);
		l13.setVisible(false);
		
		t8.setVisible(false);
		t9.setVisible(false);
		t10.setVisible(false);
		t11.setVisible(false);
		t12.setVisible(false);
		t13.setVisible(false);
		
		comboBox.setFont(new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 40));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(800,560,350,40);
		
		salvar.setBounds(170, 900, 800, 30);
		salvar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		salvar.setBackground(new Color(255, 255, 255));
		salvar.setFocusable(false);
		
		cancelar.setBounds(980, 900, 800, 30);
		cancelar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		cancelar.setBackground(new Color(255, 255, 255));
		cancelar.setFocusable(false);
		
		janela.setLayout(null);
		
		janela.add(l1);
		janela.add(l2);
		janela.add(l3);
		janela.add(l4);
		janela.add(l5);
		janela.add(l6);
		janela.add(l7);
		janela.add(l8);
		janela.add(l9);
		janela.add(l10);
		janela.add(l11);
		janela.add(l12);
		janela.add(l13);
		janela.add(l14);
		janela.add(t1);
		janela.add(t2);
		janela.add(t3);
		janela.add(t4);
		janela.add(t5);
		janela.add(t6);
		janela.add(t7);
		janela.add(t8);
		janela.add(t9);
		janela.add(t10);
		janela.add(t11);
		janela.add(t12);
		janela.add(t13);
		janela.add(comboBox);
		//janela.add(titulo);
		janela.add(salvar);
		janela.add(cancelar);
		
		janela.getContentPane().setBackground(new Color(200, 0, 0));
		janela.setSize(1920,1080);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);

		cancelar.addActionListener(this);
		comboBox.addActionListener(this);
		salvar.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();		
		
		if(src == cancelar) 
			janela.dispose();
		
	      String opcaoSelecionada = (String) comboBox.getSelectedItem();

	      if (opcaoSelecionada.equals("Cosmético")){
	    	  l8.setVisible(true);
	    	  l9.setVisible(true);
	    	  t8.setVisible(true);
	    	  t9.setVisible(true);
	      }else {
	    	  l8.setVisible(false);
	    	  l9.setVisible(false);
	    	  t8.setVisible(false);
	    	  t9.setVisible(false);
	      }

	      if (opcaoSelecionada.equals("Medicamento")) {
              l10.setVisible(true);
              l11.setVisible(true);
              t10.setVisible(true);
              t11.setVisible(true);
          } else {
        	  l10.setVisible(false);
              l11.setVisible(false);
              t10.setVisible(false);
              t11.setVisible(false);
          }
          
          if (opcaoSelecionada.equals("Vitamina")){
        	    l12.setVisible(true);
                l13.setVisible(true);
                t12.setVisible(true);
                t13.setVisible(true);
          }else {
        	  	l12.setVisible(false);
        	  	l13.setVisible(false);
        	  	t12.setVisible(false);
                t13.setVisible(false);
          }
          
          if(src == salvar) {
        	  boolean dados_incorretos = false;

        	  if (t1.getText().isBlank() ||
        	      t2.getText().isBlank() ||
        	      t3.getText().isBlank() ||
        	      t4.getText().isBlank() ||
        	      t5.getText().isBlank() ||
        	      t6.getText().isBlank() ||
        	      t7.getText().isBlank() || 
        	      opcaoSelecionada.equals("Selecione")) {
        	      dados_incorretos = true;
        	  }

        	  try {
        		    Float.parseFloat(t3.getText());
        		} catch (NumberFormatException e2) {
        			dados_incorretos = true;
        		}
        	  
        	  try {
        		    Integer.parseInt(t4.getText());
        		} catch (NumberFormatException e2) {
        			dados_incorretos = true;
        		}
        	  
        	  if (opcaoSelecionada.equals("Cosmético") && 
        		(t8.getText().isBlank() || t9.getText().isBlank())) {
        	      dados_incorretos = true;
        	  }

        	  if (opcaoSelecionada.equals("Medicamento") &&
        		(t10.getText().isBlank() || t11.getText().isBlank())) {
        	      dados_incorretos = true;
        	  }

        	  if (opcaoSelecionada.equals("Vitamina") &&
        		(t12.getText().isBlank() || t13.getText().isBlank())) {
        	      dados_incorretos = true;
        	  }

        	  if (!dados_incorretos) {
        		  char categoria = 'N';
        		  
    			  dados[0] = t1.getText();
    			  dados[1] = t2.getText();
    			  dados[2] = t3.getText();
    			  dados[3] = t4.getText();
    			  dados[4] = t5.getText();
    			  dados[5] = t6.getText();
    			  dados[6] = t7.getText();
    			  if(opcaoSelecionada.equals("Cosmético")) {
    	  			  dados[7] = t8.getText();
        			  dados[8] = t9.getText();
        			  categoria = 'c'; 
    			  }
    			  if(opcaoSelecionada.equals("Medicamento")) {
    	  			  dados[7] = t10.getText();
        			  dados[8] = t11.getText();
        			  categoria = 'm';
    			  }
    			  if(opcaoSelecionada.equals("Vitamina")) {
    	  			  dados[7] = t12.getText();
        			  dados[8] = t13.getText();
        			  categoria = 'v';
    			  }
    			  f = Farmacia.getInstance();
    			  controle.adicionarProduto(edicao, dados, f, categoria);
        		  
        	      JOptionPane.showMessageDialog(null, "Dados salvos!",
        	    		 "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
        	      janela.dispose();
        	  } else {
        	      JOptionPane.showMessageDialog(null, "Verifique se preencheu "
        	      + "todos os campos corretamente.\n\nObs: Os campos 'Preço' e 'Quantidade"
        	      + " em estoque' \nsó aceitam números como valores!", "ERRO", 
        	      JOptionPane.ERROR_MESSAGE);
        	  }

          }
	}
		

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mostraDados(int edicao, Produto produto) {
		this.edicao = edicao;
		
		t1.setText(produto.getnome());
		t2.setText(produto.getmarca());
		t3.setText(Float.toString(produto.getpreco()));
		t4.setText(Integer.toString(produto.getquantidadeEstoque()));
		t5.setText(produto.getdataValidade());
		t6.setText(produto.getQuantidade());
		t7.setText(produto.getPrincipioativo());
		
		if(produto instanceof Cosmetico) {
			Cosmetico cosmetico = (Cosmetico) produto;
			comboBox.setSelectedItem("Cosmético");
			comboBox.setEnabled(false);
			t8.setText(cosmetico.getcomposicao());
			t9.setText(cosmetico.getadvertencia());
		}else if(produto instanceof Medicamento) {
			Medicamento medicamento = (Medicamento) produto;
			comboBox.setSelectedItem("Medicamento");
			comboBox.setEnabled(false);
			t10.setText(medicamento.getindicacao());
			t11.setText(medicamento.getcontraindicacao());
		}else if(produto instanceof Vitamina) {
			Vitamina vitamina = (Vitamina) produto;
			comboBox.setSelectedItem("Vitamina");
			comboBox.setEnabled(false);
			t12.setText(vitamina.getmododeuso());
			t13.setText(vitamina.getrecomendacao());
		}
	}
	
}
