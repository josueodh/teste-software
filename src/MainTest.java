import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.*;

public class MainTest {
	

	
	@Test
	public void qualquerCelulaVivaCommenosDeDoisVizinhosVivosMorreDeSolidao() {
		Main main = new Main();
		assertEquals(0, main.returnNextStep(1,1));
	}
	
	@Test 
	public void qualquerCelulaVivaComMaisDeTresVizinhosivosMorreDeSuperpopulacao(){
		Main main = new Main();
		assertEquals(0, main.returnNextStep(4,1));
	}
	
	@Test
	public void qualquerCelulaMortaComExatamenteTresVizinhosVivosSeTornaUmaCelulaViva(){
		Main main = new Main();
		assertEquals(1, main.returnNextStep(3, 0));
	}
	
	@Test
	public void qualquerCelulaVivaComExatamenteDoisVizinhosFicaVivaNaProximaGeracao(){
		Main main = new Main();
		assertEquals(1, main.returnNextStep(2, 1));
	}
	
	@Test
	public void qualquerCelulaMortaComExatamenteDoisVizinhosFicaMortaNaProximaGeracao(){
		Main main = new Main();
		assertEquals(0, main.returnNextStep(2, 0));
	}
	
	@Test
	public void randomizadorGerandoValoresIguaisAZeroEUm(){
		Main main = new Main();
		int result =  main.returnNextStep(4, 0);
		boolean checkResult = false;
		if(result == 1 || result == 0){
			checkResult = true;
		}
		assertEquals(true,checkResult);
	}
	
	@Test
	public void deveGerarUmArrayBidimensionalComValoresRandomizadosIguaisAZeroOuUm(){
		Main main = new Main();
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


}
