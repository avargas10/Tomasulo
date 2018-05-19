package Modules;

import java.util.ArrayList;
import java.util.List;

import Control.Detector;

public class reservationStation {
	public Detector detector;
	public reservedInstruction[] station1;
	public List station1Order;
	public List instructions;
	public int[] cpi;
	public boolean[] executed;
	public reservationStation(int pLoad,int pMul,int pAdd) {
		station1 = new reservedInstruction[7];
		instructions = new ArrayList<reservedInstruction>();
		detector = new Detector(); 
		initStation();
		cpi = new int[3];
		cpi[0]= pLoad;
		cpi[1]= pAdd;
		cpi[2]= pMul;
	}
	
	public void initStation() {
		for(int i =0; i<7;++i) {
			station1[i] = new reservedInstruction();
		}
	}
	
	public reservedInstruction detect(reservedInstruction instruction,List control) {
		int size = control.size();
		int  i = 0;
		while(i<size) {
			reservedInstruction reserved =((reservedInstruction) control.get(i)); 
			String[] instr = reserved.instr;
			if(detector.detectRAW1(instruction.instr, instr)) {
				System.out.println("Hay riesgo 1");
				 instruction.Qj = detector.getType(reserved.myPos);
				 instruction.qj = true;
				 
			}
			if(detector.detectRAW2(instruction.instr, instr)) {
				System.out.println("Hay riesgo 2");
				instruction.Qk = detector.getType(reserved.myPos);
				instruction.qk = true;
			}
			i++;
		}
		return instruction;
	}
	
	public void endedInstruction(int ins) {
		//if(deleteFromCache(ins)) {
			station1[ins] = new reservedInstruction();
		//}
	}
	
	public void enableFlags(reservedInstruction instr) {
		for(int i=0;i<station1.length;i++) {
			if(station1[i].qj && station1[i].Qj.compareTo(detector.getType(instr.myPos))==0) {
				station1[i].qj = false;
				station1[i].Qj ="";
				System.out.println("qj");
			}
			if(station1[i].qk && station1[i].Qk.compareTo(detector.getType(instr.myPos))==0) {
				station1[i].qk = false;
				station1[i].Qk ="";
				System.out.println("qk");
			}
		}
	}
	
	public boolean deleteFromCache(int ins) {
		for(int i = 0;i<instructions.size();i++) {
			if(((reservedInstruction) instructions.get(i)).myPos==ins) {
				instructions.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public reservedInstruction addInstruction(int clock,String[] instruction,int mode,List control) {
		if(instructions.size()>=7) {return null;}
		reservedInstruction newInstr = new reservedInstruction();
		switch(mode) {
			case 3:
				int i = 0;
				while(i<2) {
					System.out.println("State "+station1[i].busy+" of "+i);
					if(!station1[i].busy) {
						newInstr.Op = instruction[0];
						newInstr.instr= instruction;
						newInstr.busy = true;
						newInstr.myPos = i;
						newInstr.Vj = instruction[2];
						newInstr.Vk = instruction[3];
						newInstr.cycles = cpi[0];
						newInstr.A = instruction[2]+" + "+instruction[3];
						station1[i]= detect(newInstr,control);
						instructions.add(station1[i]);
						return station1[i];
						}
					i++;
					
				}
				return null;
			case 4:
				i = 2;
				while(i<5) {
					System.out.println("State "+station1[i].busy+" of "+i);
					if(!station1[i].busy) {
						newInstr.Op = instruction[0];
						newInstr.instr= instruction;
						newInstr.busy = true;
						newInstr.myPos = i;
						newInstr.cycles = cpi[1];
						newInstr.Vj = instruction[2];
						newInstr.Vk = instruction[3];
						station1[i]= detect(newInstr,control);
						instructions.add(station1[i]);
						return station1[i];
					}
					i++;
					
					
				}
				return null;
			case 5:
				i = 5;
				while(i<7) {
					System.out.println("State "+station1[i].busy+" of "+i);
					if(!station1[i].busy) {
						newInstr.Op = instruction[0];
						newInstr.instr= instruction;
						newInstr.busy = true;
						newInstr.myPos = i;
						newInstr.cycles = cpi[2];
						newInstr.Vj = instruction[2];
						newInstr.Vk = instruction[3];
						station1[i]= detect(newInstr,control);
						instructions.add(station1[i]);
						return station1[i];
					}
					
					i++;
					
					
					
				}
				
				return null;
			default:
				
				return null;
				
		}
		 
		
	}
}
