package Modules;

public class reservedInstruction {
	public boolean busy;
	public String Op;
	public String Vj;
	public String Vk;
	public String Qj;
	public String Qk;
	public boolean qj;
	public boolean qk;
	public boolean finish;
	public String A;
	public String[] instr;
	public int pc;
	public int cycles;
	public int myPos;
	public boolean waiting;
	public reservedInstruction() {
		// TODO Auto-generated constructor stub
		busy = false;
		Op = "";
		Vj = "";
		Vk = "";
		Qk = "";
		Qj = "";
		qj=false;
		qk=false;
		waiting = false;
		finish= false;
		A = "";
		cycles=0;
		pc=0;
		myPos = -1;
		instr = new String[4];
		
	}
	private void initInstr() {
		instr[0]="";
		instr[1]="";
		instr[2]="";
		instr[3]="";
	}
	
	public void showIntruction() {
		System.out.println("Busy "+busy);
		System.out.println("Op "+Op );
		System.out.println("Vj "+Vj);
		System.out.println("Vk "+Vk);
		System.out.println("Qk "+Qk);
		System.out.println("Qj "+Qj);
		System.out.println("A "+A);
		System.out.println("myPos "+myPos);
	}

	
}
