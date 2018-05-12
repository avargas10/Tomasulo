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
				System.out.print("["+matriz[y][1]+"]"+"["+matriz[x][0]+"]");
			}
			if (b == matriz [y][1]) {
				System.out.print("["+matriz[y][1]+"]"+"["+matriz[x][0]+"]");
			}
			if (c == matriz [y][1]) {
				System.out.print("["+matriz[y][1]+"]"+"["+matriz[x][0]+"]");
			}
				/*System.out.print("["+numeros[x][y]+"]");*/
			System.out.println("\n");
			}
		}
		
		System.out.println("Número de fila: "+matriz.length);
		System.out.println("Número de columnas: "+matriz[0].length);  
	}
	
	public int detector_instr(String str) {
		// TODO Auto-generated method stub
			int result = -1;

			if (str == "LD" || str == "SD") {
				result = 0;
			}
			if (str == "ADD" || str == "SUB" ) {
				result = 1;
			}
			if (str == "MUL" || str == "DIV") {
				result = 2;
			}
			if (str == "L.D" || str == "S.D" ) {
				result = 3;
			}
			if (str == "ADD.D" || str == "SUB.D") {
				result = 4;
			}
			if (str == "MUL.D" || str == "DIV.D" ) {
				result = 5;
			}
			return result;
		}
		 
}
