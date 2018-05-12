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
		_instruction = new String[12][4];
	}
	
	public String[] getInstruction(int pc) {
		return _instruction[pc];
	} 
	public void setInstruction(int pc,String[] inst) {
		_instruction[pc] = inst;
	}

}
