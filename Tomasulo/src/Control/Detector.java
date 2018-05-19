package Control;

import config.configValues;

public class Detector {
	private  String b;
	private  String c;
	private String a;
	
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
	
	public int decoder(String str) {
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
			if(str.compareTo(configValues.LD)==0 || str.compareTo(configValues.SD)==0) {
				result=3;
			}
			if(str.compareTo(configValues.ADDD)==0 || str.compareTo(configValues.SUBD)==0) {
				result=4;
			}
			if(str.compareTo(configValues.MULD)==0 || str.compareTo(configValues.DIVD)==0) {
				result=5;
			}
			return result;
		}
	public String getType(int pos) {
		if(pos==0 || pos==1) {
			return configValues.LOAD+Integer.toString(pos+1);
		}
		else if(1 < pos && pos < 5) {
			return configValues.Add+Integer.toString(pos-1);
		}
		else if(pos==5 || pos==6){
			return configValues.Mul+Integer.toString(pos-4);
		}
		return "";
	}
	public boolean detectRAW1(String[] instr, String[] compare) {
		
		System.out.println("Rd "+compare[1]);
		System.out.println("Rs "+instr[2]);
		if(instr[2].compareTo(compare[1])==0) {
			return true;}
		else {
			return false;}
		}
		
	public int getReg(String reg) {
		System.out.println(reg.substring(1));
		return Integer.parseInt(reg.substring(1));
	}
	public boolean detectRAW2(String[] instr, String[] compare) {
		System.out.println("Rd "+compare[1]);
		System.out.println("Rm "+instr[3]);
		if(instr[3].compareTo(compare[1])==0) {
			return true;}
		else {
			return false;}
		}
		 
}
