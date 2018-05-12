package Control;

public class Detector {
	private static int b;
	private static int c;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		// Cre
		int[][] numeros = new int[4][4];
		int n = 0;
		for (int x = 0; x < 2;x++) {
			for (int y = 0; y < numeros[x].length; y++) {
				 int pr= 2;
				 numeros[x][y] = pr;
			}   
		}
		n=0;
		for (int x = 2; x < 4;x++) {
			for (int y = 0; y < numeros[x].length; y++) {
				 n++;
				 numeros[x][y] = n;
			}   
		}

		for (int x = 0; x < numeros.length;x++) {
			int a = numeros[x][1];
			b = numeros[x][2];
			c = numeros[x][3];
			int y = x+1;
			if (y < numeros.length) {
			if (a == numeros [y][1]) {
				System.out.print("["+numeros[y][1]+"]"+"WAW");
			}
			if (b == numeros [y][1]) {
				System.out.print("["+numeros[y][1]+"]"+"WAR");
			}
			if (c == numeros [y][1]) {
				System.out.print("["+numeros[y][1]+"]"+"WAR");
			}
				/*System.out.print("["+numeros[x][y]+"]");*/
			System.out.println("\n");
			}
		}
		
		System.out.println("Número de fila: "+numeros.length);
		System.out.println("Número de columnas: "+numeros[0].length);  
	}
}
