package Modules;

import java.util.ArrayList;
import java.util.List;

import Control.Detector;

public class reservationStation {
	public Detector detector;
	public reservedInstruction[] station1;
	public List station1Order;
	public List instructions;
	public boolean[] executed;
	public reservationStation() {
		station1 = new reservedInstruction[7];
		instructions = new ArrayList<reservedInstruction>();
		detector = new Detector();
		
	}
	
	
	public void detect(String[] instruction) {
		int size = instructions.size();
		int  i = 0;
		while(i<size) {
			String[] instr = ((reservedInstruction) instructions.get(i)).instr;
			if(detector.detectRAW1(instruction, instr)) {
				 ((reservedInstruction) instructions.get(i)).Qj = instr[1];
			}
			if(detector.detectRAW2(instruction, instr)) {
				 ((reservedInstruction) instructions.get(i)).Qk = instr[1];
			}
			--size;
		}
	}
	
	public void addInstruction(String[] instruction,int mode) {
		if(instructions.size()>7) {return ;}
		reservedInstruction newInstr = new reservedInstruction();
		switch(mode) {
			case 0:
				int i = 0;
				while(i<2) {
					if(!station1[i].busy) {
						newInstr.instr= instruction;
						newInstr.busy = true;
						newInstr.myPos = i;
						++i;
					}
					
					break;
				}
			case 1:
				i = 2;
				while(i<5) {
					if(!station1[i].busy) {
						newInstr.instr= instruction;
						newInstr.busy = true;
						newInstr.myPos = i;
						++i;
					}
					
					break;
				}
			case 2:
				i = 5;
				while(i<7) {
					if(!station1[i].busy) {
						newInstr.instr= instruction;
						newInstr.busy = true;
						newInstr.myPos = i;
						++i;
					}
					
					break;
				}
			default:
				
				break;
				
		}
		 instructions.add(newInstr);
		
	}
}
