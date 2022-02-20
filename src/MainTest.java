import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.*;

public class MainTest {
	Main main;
	int [][] result;
	@Before
	public void setUp(){
		main = new Main();
		result = new int[3][3];
		result[0][0] = 0;
		result[0][1] = 0;
		result[0][2] = 0;
		result[1][0] = 0;
		result[1][1] = 0;
		result[1][2] = 0;
		result[2][0] = 0;
		result[2][1] = 0;
		result[2][2] = 0;
	}
	
	@Test
	public void qualquerCelulaVivaCommenosDeDoisVizinhosVivosMorreDeSolidao() {
		assertEquals(0, main.returnNextStep(1,1));
	}
	
	@Test 
	public void qualquerCelulaVivaComMaisDeTresVizinhosivosMorreDeSuperpopulacao(){
		assertEquals(0, main.returnNextStep(4,1));
	}
	
	@Test
	public void qualquerCelulaMortaComExatamenteTresVizinhosVivosSeTornaUmaCelulaViva(){
		assertEquals(1, main.returnNextStep(3, 0));
	}
	
	@Test
	public void qualquerCelulaVivaComExatamenteDoisVizinhosFicaVivaNaProximaGeracao(){
		assertEquals(1, main.returnNextStep(2, 1));
	}
	
	@Test 
	public void qualquerCelulaMortaComExatamenteDoisVizinhosFicaIgualNaProximaGeracao(){
		assertEquals(0, main.returnNextStep(2, 0));
	}
	
	@Test
	public void qualquerCelulaMortaComExatamenteDoisVizinhosFicaMortaNaProximaGeracao(){
		assertEquals(0, main.returnNextStep(2, 0));
	}

	
	@Test
	public void randomizadorGerandoValoresIguaisAZeroEUm(){
		int result =  main.returnNextStep(4, 0);
		boolean checkResult = false;
		if(result == 1 || result == 0){
			checkResult = true;
		}
		assertEquals(true,checkResult);
	}
	
	@Test
	public void deveGerarUmArrayBidimensionalComValoresRandomizadosIguaisAZeroOuUm(){
		int[][] result = new int[3][3];
		boolean checkResult = true;
		result = main.generateRandom(result, 3);
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				if(result[j][i] != 1 && result[j][i] != 0){
					checkResult = false;
				}
			}
		}
		assertEquals(true,checkResult);
	}
	@Test
	public void deveGerarUmaNovaGeracaoDeValores(){
		int [][] nextGeneration = main.generateNextSteps(result, 3);
		assertEquals(9, nextGeneration[0].length + nextGeneration[1].length + nextGeneration[2].length);
	}
	
	@Test
	public void elementoEhZeroZero(){
		assertEquals(0, main.returnSumNeighbors(0, 0, 2,result ));
		result[0][0] = 1;
		assertEquals(0, main.returnSumNeighbors(0, 0, 2,result ));
		result[0][1] = 1;
		assertEquals(1, main.returnSumNeighbors(0, 0, 2,result ));
		result[0][2] = 1;
		assertEquals(1, main.returnSumNeighbors(0, 0, 2,result ));
		result[1][0] = 1;
		assertEquals(2, main.returnSumNeighbors(0, 0, 2,result ));
		result[1][1] = 1;
		assertEquals(3, main.returnSumNeighbors(0, 0, 2,result ));
		result[1][2] = 1;
		assertEquals(3, main.returnSumNeighbors(0, 0, 2,result ));
		result[2][0] = 1;
		assertEquals(3, main.returnSumNeighbors(0, 0, 2,result ));
		result[2][1] = 1;
		assertEquals(3, main.returnSumNeighbors(0, 0, 2,result ));
		result[2][2] = 1;
		assertEquals(3, main.returnSumNeighbors(0, 0, 2,result ));
	
	}
	
	@Test 
	public void elementoEhZeroUm(){
		int total = main.returnSumNeighbors(0, 1,2, result);
		assertEquals(0, 0);		
	}
	
	@Test
	public void elementoEhCentralizado(){
		assertEquals(0, main.returnSumNeighbors(1, 1, 2,result ));
		result[0][0] = 1;
		assertEquals(1, main.returnSumNeighbors(1, 1, 2,result ));
		result[0][1] = 1;
		assertEquals(2, main.returnSumNeighbors(1, 1, 2,result ));
		result[0][2] = 1;
		assertEquals(3, main.returnSumNeighbors(1, 1, 2,result ));
		result[1][0] = 1;
		assertEquals(4, main.returnSumNeighbors(1, 1, 2,result ));
		result[1][1] = 1;
		assertEquals(4, main.returnSumNeighbors(1, 1, 2,result ));
		result[1][2] = 1;
		assertEquals(5, main.returnSumNeighbors(1, 1, 2,result ));
		result[2][0] = 1;
		assertEquals(6, main.returnSumNeighbors(1, 1, 2,result ));
		result[2][1] = 1;
		assertEquals(7, main.returnSumNeighbors(1, 1, 2,result ));
		result[2][2] = 1;
		assertEquals(8, main.returnSumNeighbors(1, 1, 2,result ));
	}
	
	@Test
	public void elementoZeroDois(){
		assertEquals(0, main.returnSumNeighbors(0, 2, 2,result ));
		result[0][0] = 1;
		assertEquals(0, main.returnSumNeighbors(0, 2, 2,result ));
		result[0][1] = 1;
		assertEquals(0, main.returnSumNeighbors(0,2, 2,result ));
		result[0][2] = 1;
		assertEquals(0, main.returnSumNeighbors(0, 2, 2,result ));
		result[1][0] = 1;
		assertEquals(1, main.returnSumNeighbors(0, 2, 2,result ));
		result[1][1] = 1;
		assertEquals(2, main.returnSumNeighbors(0, 2, 2,result ));
		result[1][2] = 1;
		assertEquals(2, main.returnSumNeighbors(0, 2, 2,result ));
		result[2][0] = 1;
		assertEquals(2, main.returnSumNeighbors(0, 2, 2,result ));
		result[2][1] = 1;
		assertEquals(3, main.returnSumNeighbors(0, 2, 2,result ));
		result[2][2] = 1;
		assertEquals(3, main.returnSumNeighbors(0, 2, 2,result ));
	}
	
	@Test
	public void elementoEhUmZero(){
		int total = main.returnSumNeighbors(1, 0, 2, result);
		assertEquals(0, total);
	}
	
	@Test
	public void elementoEhUmDois(){
		int total = main.returnSumNeighbors(1, 2, 2,result );
		assertEquals(0, total);
	}
	
	@Test
	public void elementoEhDoisZero(){
		assertEquals(0, main.returnSumNeighbors(2, 0, 2,result ));
		result[0][0] = 1;
		assertEquals(0, main.returnSumNeighbors(2, 0, 2,result ));
		result[0][1] = 1;
		assertEquals(1, main.returnSumNeighbors(2, 0, 2,result ));
		result[0][2] = 1;
		assertEquals(1, main.returnSumNeighbors(2, 0, 2,result ));
		result[1][0] = 1;
		assertEquals(1, main.returnSumNeighbors(2, 0, 2,result ));
		result[1][1] = 1;
		assertEquals(2, main.returnSumNeighbors(2, 0, 2,result ));
		result[1][2] = 1;
		assertEquals(3, main.returnSumNeighbors(2, 0, 2,result ));
		result[2][0] = 1;
		assertEquals(3, main.returnSumNeighbors(2, 0, 2,result ));
		result[2][1] = 1;
		assertEquals(3, main.returnSumNeighbors(2, 0, 2,result ));
		result[2][2] = 1;
		assertEquals(3, main.returnSumNeighbors(2, 0, 2,result ));
	}
	
	@Test 
	public void elementoEhDoisUm(){
		int total = main.returnSumNeighbors(2, 1, 2,result );
		assertEquals(0, total);
	}
	
	@Test 
	public void elementoEhDoisDois(){
		int total = main.returnSumNeighbors(2, 2, 2,result );
		assertEquals(0, total);
	}
	
	
	@Test
	public void elementoEhDoisDoisZerandoTodosOsValoresDaMatriz(){
		result[0][0] = 0;
		assertEquals(0, main.returnSumNeighbors(2, 2, 2,result ));
		result[0][1] = 0;
		assertEquals(0, main.returnSumNeighbors(2, 2, 2,result ));
		result[0][2] = 0;
		assertEquals(0, main.returnSumNeighbors(2, 2, 2,result ));
		result[1][0] = 0;
		assertEquals(0, main.returnSumNeighbors(2, 2, 2,result ));
		result[1][1] = 1;
		assertEquals(1, main.returnSumNeighbors(2, 2, 2,result ));
		result[1][2] = 1;
		assertEquals(2, main.returnSumNeighbors(2, 2, 2,result ));
		result[2][0] = 0;
		assertEquals(2, main.returnSumNeighbors(2, 2, 2,result ));
		result[2][1] = 1;
		assertEquals(3, main.returnSumNeighbors(2, 2, 2,result ));
		result[2][2] = 0;
		assertEquals(3, main.returnSumNeighbors(2, 2, 2,result ));

	}
	
	
	


	

	
	

}
