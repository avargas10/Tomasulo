package Control;

public class Detector {
	private static String b;
	private static String c;
	private static String a;
	
	public Detector() {}
	
	public void detector(String[][] matriz) {
		// TODO Auto-generated method stub
		

		for (int x = 0; x < matriz.length;x++) {
			a = matriz[x][1];
			b = matriz[x][2];
			c = matriz[x][3];
			int y = x+1;
			if (y < matriz.length) {
			if (a == matriz [y][1]) {
				System.out.print("["+matriz[y][1]+"]"+"WAW");
			}
			if (b == matriz [y][1]) {
				System.out.print("["+matriz[y][1]+"]"+"WAR");
			}
			if (c == matriz [y][1]) {
				System.out.print("["+matriz[y][1]+"]"+"WAR");
			}
				/*System.out.print("["+numeros[x][y]+"]");*/
			System.out.println("\n");
			}
		}
		
		System.out.println("Número de fila: "+matriz.length);
		System.out.println("Número de columnas: "+matriz[0].length);  
	}
}
