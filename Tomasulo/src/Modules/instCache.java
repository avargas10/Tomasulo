/**
 * 
 */
package Modules;

/**
 * @author afeli
 *
 */
public class instCache {
	private static instCache _instance; 
	private String[][] _instruction;
	
	
	/**
	 * 
	 */
	public static instCache getInstance() {
		if(_instance == null) {
			_instance = new instCache();
		}
		return _instance;
	}
	
	private instCache() {
		// TODO Auto-generated constructor stub
		_instruction = new String[7][4];
	}
	
	public String[] getInstruction(int pc) {
		return _instruction[pc];
	} 
	public void setInstruction(int pc,String[] inst) {
		System.out.println("Type: "+inst[0]);
		System.out.println("Rd: "+inst[1]);
		System.out.println("Rs: "+inst[2]);
		System.out.println("Rm: "+inst[3]);
		_instruction[pc] = inst;
	}

}
