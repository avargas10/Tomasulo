/**
 * 
 */
package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import GUI.mainGUI;
import Modules.reservationStation;
import Modules.reservedInstruction;
import config.configValues;

/**
 * @author afeli
 *
 */
public class mainFlow {

	/**
	 * 
	 */
	private String[] _actualInstruction;
	private int _actualInsType;
	private int pc = 0;
	public int[] instrCycles;
	private static mainFlow _instance;
	private Fetch _fetch;
	private mainGUI gui;
	private int clock;
	private Detector detector;
	private List control;
	private reservationStation rs;
	public mainFlow() throws Throwable {
		_fetch = new Fetch();
		_actualInsType=0;
		instrCycles = new int[3];
		detector = new Detector();
		control = new ArrayList<reservedInstruction>();
		clock = 0;

	}
	public void setGUI(mainGUI pGui) {
		gui = pGui;
	}
	public static mainFlow getInstance( ) {
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

	public void setCycles(int add,int mul,int load) throws IOException {
		instrCycles[0] = add;
		instrCycles[1] = mul;
		instrCycles[2] = load;
		rs = new reservationStation(load,mul,add);
		fetchInstructions();
		nextInstruction();
		
	}
	public void nextClock() {
		clock++;
		
		
		gui.setClock(clock);
		if(issue()) {
			nextInstruction();
			
		}
		exeChecker();
		toWR();
		
	}
	
	public void checkEnded() {
		for(int i=0;i<control.size();i++) {
			//if(control[i][])
		}
	}
	public void fetchInstructions() throws IOException {
		_fetch.beginFetching();
		gui.adderToInstrTable();
	}
	public String[] getActualInstruction() {
		return _actualInstruction;
	}
	public void nextInstruction() {
		if(pc>6) {return;}
		_actualInstruction = _fetch.getInstruction(pc);
		_actualInsType = detector.decoder(_actualInstruction[0]);
		//System.out.println("Instr "+_actualInstruction[0]+" Type "+_actualInsType);
		gui.setActual(_actualInstruction);
		++pc;
		
	}
	public boolean issue() {
		reservedInstruction reserved = rs.addInstruction(clock,_actualInstruction, detector.decoder(_actualInstruction[0]),control);
		if(reserved==null) {	
			return false;
		}
		buffersLoad(reserved);
		gui.setInReg(detector.getType(reserved.myPos),detector.getReg(reserved.instr[1]));
		//reserved.showIntruction();
		reserved.pc=pc-1;
		gui.addInstruction(reserved);
		gui.setActiveIssue(reserved.pc);
		return true;
	}
	
	private void toExe(reservedInstruction reserved) {
			//reserved.busy = false;
		
			gui.setActiveExe(reserved.pc);
			reserved.cycles= reserved.cycles+clock;
			control.add(reserved);
			//System.out.println("instruction "+reserved.Op +" at "+clock+" end "+reserved.cycles);
		
	}
	private void toWR() {
		int i = 0;
		while(i<control.size()) {
			reservedInstruction reserved =((reservedInstruction) control.get(i));
			System.out.println("WR "+ reserved.Op+" clock "+clock+" end "+reserved.cycles);
			if(clock==reserved.cycles) {
				//detector.getReg(reserved.instr[1]);
				control.remove(i);
				gui.cleanInstruction(reserved);
				gui.setOffReg(detector.getReg(reserved.instr[1]));
				buffersOut(reserved);
				rs.endedInstruction(reserved.myPos);
				rs.enableFlags(reserved);
				gui.setActiveWRS(reserved.pc);
			}
			else {
				i++;
			}
		}
	}
	private void exeChecker() {
		for(int i=0;i<rs.station1.length;i++) {
			
			if(!rs.station1[i].qj && !rs.station1[i].qk&&rs.station1[i].busy&&!rs.station1[i].waiting) {
				rs.station1[i].waiting=true;
				toExe(rs.station1[i]);
				
				
				
			}
		}
	}
	
	private void buffersLoad(reservedInstruction reserved) {
		if(reserved.myPos==0 || reserved.myPos==1)  {
			if(reserved.instr[0].compareTo(configValues.LD)==0) {
				gui.popLoad(reserved.instr[2]+" + "+reserved.instr[3]);
			}
			else if(reserved.instr[0].compareTo(configValues.SD)==0) {
				gui.popStore(reserved.instr);
			}
		}
		
	}
	private void buffersOut(reservedInstruction reserved) {
		if(reserved.myPos==0 || reserved.myPos==1)  {
			if(reserved.instr[0].compareTo(configValues.LD)==0) {
				gui.outLoad();
			}
			else if(reserved.instr[0].compareTo(configValues.SD)==0) {
				gui.outStore();
			}
		}
		
	}
	

}
