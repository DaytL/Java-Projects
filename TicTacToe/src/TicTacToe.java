import java.util.*;




public class TicTacToe {
	
		static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
		static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
		
		public static void main(String args[]) {
		char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
							  {'-', '+', '-', '+', '-'},
							  {' ', '|', ' ', '|', ' '},
							  {'-', '+', '-', '+', '-'},
							  {' ', '|', ' ', '|', ' '}};
		
		printGameBoard(gameBoard);
		

		while(true) {
		Scanner scan = new Scanner(System.in); 
		System.out.println("Enter your placement(1-9)");
		int playerPos = scan.nextInt();
		while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)){
			System.out.println("Position taken! Enter the correct Position");
			playerPos = scan.nextInt();
		}
		
		placePiece(gameBoard, playerPos, "player");
		
		String result = checkWinner();
		if(result.length() > 0)			
		{System.out.println(result);
		break;
		}
		
		Random rand = new Random();
		int cpuPos = rand.nextInt(9) + 1; // cpuPos range 1-9
		while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){
			cpuPos = rand.nextInt(9) + 1;
		}
		placePiece(gameBoard, cpuPos, "cpu");
		
		printGameBoard(gameBoard);
		
		result = checkWinner();
		if(result.length() > 0)			
		{System.out.println(result);
		break;
		}
		}
	}
	
		public static String checkWinner() {
			List topRow = Array.asList(1,2,3);
			List midRow = Array.asList(4,5,6);
			List botRow = Array.asList(7,8,9);
			List lefcol = Array.asList(1,4,7);
			List midcol = Array.asList(2,5,8);
			List rigcol = Array.asList(3,6,9);
			List cross1 = Array.asList(1,5,9);
			List cross2 = Array.asList(7,5,3);
			
			List<List> winning= new ArrayList<List>();
			winning.add(topRow);
			winning.add(midRow);
			winning.add(botRow);
			winning.add(lefcol);
			winning.add(midcol);
			winning.add(rigcol);
			winning.add(cross1);
			winning.add(cross2);
			
			for(List l : winning) {
				if(playerPositions.containsAll(l))
					return "Congratulation you won!";
				else if(playerPositions.containsAll(l))
					return "You Lost!";
				else if(playerPositions.size() + cpuPositions.size() == 9)
					return "TIE";
			}
			
			
			return "";
			}
		
		public static void printGameBoard(char [][] gameBoard) {
		for(char [] row : gameBoard) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
		
		public static void placePiece(char [][] gameBoard, int pos, String user) {
			char symbol = ' ';
			if(user.equals("player")) {
				symbol = 'X';
				playerPositions.add(pos);
			}
			else if(user.equals("cpu")) {
				symbol = 'O';
				cpuPositions.add(pos);
			}
			switch(pos) {
				case 1:
					gameBoard[0][0] = symbol;
					break;
				case 2:
					gameBoard[0][2] = symbol;
					break;
				case 3:
					gameBoard[0][4] = symbol;
					break;
				case 4:
					gameBoard[2][0] = symbol;
					break;
				case 5:
					gameBoard[2][2] = symbol;
					break;
				case 6:
					gameBoard[2][4] = symbol;
					break;
				case 7:
					gameBoard[4][0] = symbol;
					break;
				case 8:
					gameBoard[4][2] = symbol;
					break;
				case 9:
					gameBoard[4][4] = symbol;
					break;
			}
	}
}
	
