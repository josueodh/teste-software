import java.util.Random;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		System.out.println("Trabalho de Teste de Software 2021.3");
		System.out.println("João Pedro Sequeto Nascimento - 201776022");
		System.out.println("Josué de Oliveira Delgado Heringer - 201876023");
		System.out.println("Marcelo Gonçalves de Souza Costa - 201776016");
		System.out.println("=================================================");
		int boardDimension = 6;
		boolean finished = false;
		int[][] actualRound = new int[boardDimension][boardDimension];
		int[][] previousRound = new int[boardDimension][boardDimension];
		int acumulate = 1;
		actualRound = generateRandom(actualRound, boardDimension);
		while (!finished) {
			print(actualRound, previousRound, acumulate, boardDimension);
			acumulate++;
			Scanner scan = new Scanner(System.in);
			System.out.println("=================================================");
			System.out.println("Deseja finalizar o Jogo ?");
			System.out.println("[ N ] Não");
			System.out.println("[ S ] Sim");
			String next = scan.nextLine();
			if (next.equals("S") || next.equals("Sim")) {
				finished = true;
			}
			previousRound = actualRound;
			actualRound = generateNextSteps(actualRound, boardDimension);
		}
	}

	public static int[][] generateRandom(int[][] actualRound, int boardDimension) {
		for (int j = 0; j < boardDimension; j++) {
			for (int i = 0; i < boardDimension; i++) {
				Random random = new Random();
				boolean result = random.nextBoolean();
				actualRound[j][i] = returnRandomInt();
			}
		}

		return actualRound;
	}

	public static int[][] generateNextSteps(int[][] actualRound, int boardDimension) {
		int[][] nextRound = new int[boardDimension][boardDimension];
		int boardDimensionMinusOne = boardDimension - 1;
		for (int j = 0; j < boardDimension; j++) {
			for (int i = 0; i < boardDimension; i++) {
				int sumNeighbors = returnSumNeighbors(i, j, boardDimensionMinusOne, actualRound);
				nextRound[j][i] = returnNextStep(sumNeighbors, actualRound[j][i]);
			}
		}
		return nextRound;
	}

	public static int returnSumNeighbors(int i, int j, int boardDimensionMinusOne, int[][] actualRound) {
		int sumNeighbors = 0;
		if (j != 0 && j != boardDimensionMinusOne && i != 0 && i != boardDimensionMinusOne) {
			sumNeighbors = actualRound[j - 1][i - 1] + actualRound[j][i - 1] + actualRound[j + 1][i - 1]
					+ actualRound[j - 1][i] + actualRound[j + 1][i] + actualRound[j - 1][i + 1] + actualRound[j][i + 1]
					+ actualRound[j + 1][i + 1];
		} else if (i > 0 && i < boardDimensionMinusOne && j == 0) {
			sumNeighbors = actualRound[j][i + 1] + actualRound[j + 1][i + 1] + actualRound[j + 1][i]
					+ actualRound[j + 1][i - 1] + actualRound[j][i - 1];
		} else if (i > 0 && i < boardDimensionMinusOne && j == boardDimensionMinusOne) {
			sumNeighbors = actualRound[j][i - 1] + actualRound[j - 1][i - 1] + actualRound[j - 1][i]
					+ actualRound[j - 1][i + 1] + actualRound[j][i + 1];
		} else if (j > 0 && j < boardDimensionMinusOne && i == 0) {
			sumNeighbors = actualRound[j - 1][i] + actualRound[j - 1][i + 1] + actualRound[j][i + 1]
					+ actualRound[j + 1][i + 1] + actualRound[j + 1][i];
		} else if (j > 0 && j < boardDimensionMinusOne && i == boardDimensionMinusOne) {
			sumNeighbors = actualRound[j - 1][i] + actualRound[j - 1][i - 1] + actualRound[j][i - 1]
					+ actualRound[j + 1][i - 1] + actualRound[j + 1][i];
		} else if (j == 0 && i == 0) {
			sumNeighbors = actualRound[j][i + 1] + actualRound[j + 1][i + 1] + actualRound[j + 1][i];
		} else if (j == 0 && i == boardDimensionMinusOne) {
			sumNeighbors = actualRound[j][i - 1] + actualRound[j + 1][i - 1] + actualRound[j + 1][i];
		} else if (j == boardDimensionMinusOne && i == 0) {
			sumNeighbors = actualRound[j - 1][i] + actualRound[j - 1][i + 1] + actualRound[j][i + 1];
		} else if (j == boardDimensionMinusOne && i == boardDimensionMinusOne) {
			sumNeighbors = actualRound[j][i - 1] + actualRound[j - 1][i - 1] + actualRound[j - 1][i];
		}

		return sumNeighbors;
	}

	public static int returnNextStep(int totalNeighbors, int element) {

		if (element == 1 && totalNeighbors < 2) {
			return 0;
		} else if (element == 1 && totalNeighbors > 3) {
			return 0;
		} else if (element == 0 && totalNeighbors == 3) {
			return 1;
		} else if (totalNeighbors == 2) {
			return element;
		} else {
			return returnRandomInt();
		}
	}

	public static void print(int[][] actual, int[][] previous, int acumulate, int boardDimension) {
		System.out.println("\n" + acumulate + "° Iteração");
		System.out.println("\t Anterior  \t \t || \t \t Atual");
		for (int j = 0; j < boardDimension; j++) {
			for (int i = 0; i < boardDimension; i++) {
				System.out.print("[ " + previous[j][i] + " ]");
			}
			System.out.print("\t || \t");
			for (int i = 0; i < boardDimension; i++) {
				System.out.print("[ " + actual[j][i] + " ]");
			}
			System.out.println("");
		}
	}

	public static int returnRandomInt() {
		Random random = new Random();
		boolean result = random.nextBoolean();
		return result == true ? 1 : 0;
	}

}