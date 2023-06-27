package teste;

import controle.*;
import modelo.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//Classe dedicada a testes unitários

public class Teste {

	private final Farmacia f = Farmacia.getInstance();
	private final ControleProdutos c = ControleProdutos.getInstance();
	
	@Test
	void testExcluirProduto() {
		int index_valido = 1, index_invalido = -1;
				
		//Teste com indice valido
		
		assertTrue(c.excluirProduto(index_valido, f));
		
		/*Teste com indice invalido fora dos limites do 
		 * arraylist
		*/
		//Uso do try catch para tratamento do erro
		try {
	        assertFalse(c.excluirProduto(index_invalido, f));
	        fail("Expected IndexOutOfBoundsException to be thrown");
	    } catch (IndexOutOfBoundsException e) {
	    	
	    }
	}
	
	@Test
	void testPesquisa() {
		String valido = "Dipirona", invalido = "";
		
		/*Vetor de string criado para passar como parâmetro 
		 * de retorno ao teste
		 * */
		
		String[] retorno = c.getPesquisa(valido);
		
		//Teste com valor correto
		
		assertEquals("Dipirona", retorno[0]);
		
		//Teste com valor incorreto
		
		assertEquals(null, c.getPesquisa(invalido));

	}
	
	@Test
	void testCastProduto() {
		int indice_valido = 1, indice_invalido = -1;
		
		//Teste se o retorno é != null caso seja passado um índice válido
		
		assertNotNull(c.castProduto(indice_valido));
		
		//Teste se é == null se o índice for inválido
		
		assertNull(c.castProduto(indice_invalido));
		
	}
	
}
