/**
 * 
 */
package Control;

import java.io.IOException;

/**
 * @author afeli
 *
 */
public class mainFlow {

	/**
	 * 
	 */
	private String[] _actualInstruction;
	private int pc = 0;
	private static mainFlow _instance;
	private Fetch _fetch;
	public mainFlow() throws Throwable {
		_fetch = new Fetch();
	}
	public static mainFlow getInstance() {
		if(_instance == null) {
			try {
				_instance = new mainFlow();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return _instance;
	}
	
	public void fetchInstructions() throws IOException {
		_fetch.beginFetching();
	}
	public String[] getActualInstruction() {
		return _actualInstruction;
	}
	public void nextInstruction() {
		_actualInstruction = _fetch.getInstruction(pc);
		++pc;
	}

}
