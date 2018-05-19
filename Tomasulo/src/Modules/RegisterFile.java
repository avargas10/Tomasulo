package Modules;

public class RegisterFile {
	private float[] f_Registers;
	private int[] r_Registers;
	public RegisterFile() {
		f_Registers= new float[10];
		r_Registers= new int[4];
		// TODO Auto-generated constructor stub
	}
   public int getFromR(int address) {
	   return r_Registers[address];
   }
   public void setToR(int address,int value) {
	   r_Registers[address]=value;
   }
   public float getFromF(int address) {
	   return f_Registers[address];
   }
   public void setToF(int address,float value) {
	   f_Registers[address]=value;
   }
}
