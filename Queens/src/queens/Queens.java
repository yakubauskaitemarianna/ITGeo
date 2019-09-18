package queens;

public class Queens {
	int[] generatedField;
	int counter = 0;
	
	public Queens(int N) {
		generatedField = new int[N];
	}
	
	public boolean QueenPlaceChecker(int x, int y) {
		
		for (int i = 0; i < x; i++) {
			if (generatedField[i] == y || (i - x) == (generatedField[i] - y) || 
				(i - x) == (y - generatedField[i])) {
				return false;
			}
		}
		return true;
	}
	
	public void printQueens(int[] generatedField) {
        int N = generatedField.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (generatedField[i] == j) {
                    System.out.print("♕");
                } else {
                    System.out.print("☐");
                }
            }
            System.out.println();
        }
        System.out.println();
        counter++;
    }
	
	public void placeNqueens(int r, int n) {
        for (int c = 0; c < n; c++) {
            if (QueenPlaceChecker(r, c)) {
                generatedField[r] = c;
                if (r == n - 1) {
                    printQueens(generatedField);
                } else {
                    placeNqueens(r + 1, n);
                }
            }
        }
	}
	
	public void QueenPlaces() {
        placeNqueens(0, generatedField.length);
        System.out.println("Total: " + counter);
    }
	
	public static void main(String args[]) {
        Queens Q = new Queens(8);
        Q.QueenPlaces();
     
    }
	
	
}
