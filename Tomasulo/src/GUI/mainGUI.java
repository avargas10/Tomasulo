package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.mainFlow;
import Modules.instCache;
import Modules.reservedInstruction;
import config.configValues;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class mainGUI extends JFrame {

	private JPanel contentPane;
	private JTable instructions;
	private JTable table;
	JLabel clockNum;
	int popPos = 0;
	int popStore = 0;
	private JPanel[] issues;
	private JPanel[] exes;
	private JPanel[] WRS;
	private JLabel lblInstructionQueque;
	private JButton btnNext;
	private JTable reservedStation;
	private JTable fpReg;
	private JTable loadBuffer;
	private JTable storeBuffer;
	private JTextField tf_add;
	private JTextField tf_load;
	private JTextField tf_mul;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainGUI frame = new mainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainGUI() {
		mainFlow.getInstance().setGUI(this);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 872);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		issues = new JPanel[7];
		exes = new JPanel[7];
		WRS = new JPanel[7];
		JLabel lblCode = new JLabel("Actual Instruction");
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblCode.setBounds(8, 375, 265, 33);
		contentPane.add(lblCode);
		
		instructions = new JTable();
		instructions.setToolTipText("");
		instructions.setForeground(new Color(0, 0, 0));
		instructions.setFillsViewportHeight(true);
		instructions.setColumnSelectionAllowed(true);
		instructions.setFont(new Font("Tahoma", Font.PLAIN, 16));
		instructions.setModel(new DefaultTableModel(
			new Object[][] {
				{"Instr", "Rd", "Rs", "Rm"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Instr", "Rd", "Rs", "Rm"
			}
		));
		instructions.getColumnModel().getColumn(0).setPreferredWidth(80);
		instructions.getColumnModel().getColumn(0).setMinWidth(80);
		instructions.getColumnModel().getColumn(1).setPreferredWidth(80);
		instructions.getColumnModel().getColumn(1).setMinWidth(80);
		instructions.getColumnModel().getColumn(2).setPreferredWidth(80);
		instructions.getColumnModel().getColumn(2).setMinWidth(80);
		instructions.getColumnModel().getColumn(3).setPreferredWidth(80);
		instructions.getColumnModel().getColumn(3).setMinWidth(80);
		instructions.setBounds(25, 199, 373, 128);
		contentPane.add(instructions);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Instr", "Rd", "Rs", "Rm"
			}
		));
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setBounds(21, 417, 373, 16);
		contentPane.add(table);
		
		lblInstructionQueque = new JLabel("Instruction Queue");
		lblInstructionQueque.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblInstructionQueque.setBounds(8, 130, 220, 33);
		contentPane.add(lblInstructionQueque);
		
		btnNext = new JButton("Next");
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFlow.getInstance().nextClock();
				
			}
		});
		btnNext.setBounds(253, 371, 145, 37);
		contentPane.add(btnNext);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblStatus.setBounds(448, 130, 115, 33);
		contentPane.add(lblStatus);
		
		JLabel lblIssue = new JLabel("Issue");
		lblIssue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIssue.setBounds(429, 167, 50, 33);
		contentPane.add(lblIssue);
		
		JLabel lblExe = new JLabel("Exe");
		lblExe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExe.setBounds(505, 167, 27, 33);
		contentPane.add(lblExe);
		
		JLabel lblWr = new JLabel("WR");
		lblWr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWr.setBounds(571, 167, 28, 33);
		contentPane.add(lblWr);
		int x = 439;
		int y = 199;
		int sum = 0;
		for(int i=0;i<7;++i) {
			JPanel issue1 = new JPanel();
			issue1.setBackground(new Color(255, 0, 0));
			issue1.setBounds(x, y+sum, 17, 16);
			issues[i]= issue1;
			JPanel exe1 = new JPanel();
			exe1.setBackground(new Color(255, 0, 0));
			exe1.setBounds(x+70, y+sum, 17, 16);
			exes[i]= exe1;
			JPanel wr1 = new JPanel();
			wr1.setBackground(new Color(255, 0, 0));
			wr1.setBounds(x+140, y+sum, 17, 16);
			WRS[i]= wr1;
			contentPane.add(issues[i]);
			contentPane.add(exes[i]);
			contentPane.add(WRS[i]);
			sum = sum+18;
		}
		
		reservedStation = new JTable();
		reservedStation.setModel(new DefaultTableModel(
			new Object[][] {
				{"LOAD1", null, null, null, null, null, null, null},
				{"LOAD2", null, null, null, null, null, null, null},
				{"ADD1", null, null, null, null, null, null, null},
				{"ADD2", null, null, null, null, null, null, null},
				{"ADD3", null, null, null, null, null, null, null},
				{"MUL1", null, null, null, null, null, null, null},
				{"MUL2", null, null, null, null, null, null, null},
			},
			new String[] {
				"Name", "Busy", "Op", "Vj", "Vk", "Qj", "Qk", "A"
			}
		));
		reservedStation.setForeground(Color.BLACK);
		reservedStation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		reservedStation.setFillsViewportHeight(true);
		reservedStation.setColumnSelectionAllowed(true);
		reservedStation.setBounds(25, 547, 503, 112);
		contentPane.add(reservedStation);
		
		JLabel lblReservedStationo = new JLabel("Reserved Station");
		lblReservedStationo.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblReservedStationo.setBounds(12, 494, 265, 33);
		contentPane.add(lblReservedStationo);
		
		JLabel lblFpRegisters = new JLabel("Fp Registers");
		lblFpRegisters.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblFpRegisters.setBounds(681, 130, 151, 33);
		contentPane.add(lblFpRegisters);
		
		fpReg = new JTable();
		fpReg.setModel(new DefaultTableModel(
			new Object[][] {
				{"F0", null},
				{"F1", null},
				{"F2", null},
				{"F3", null},
				{"F4", null},
				{"F5", null},
				{"F6", null},
				{"F7", null},
				{"F8", null},
				{"F9", null},
				{"F10", null},
			},
			new String[] {
				"Name", "Value"
			}
		));
		fpReg.setToolTipText("");
		fpReg.setForeground(Color.BLACK);
		fpReg.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fpReg.setFillsViewportHeight(true);
		fpReg.setColumnSelectionAllowed(true);
		fpReg.setBounds(681, 167, 180, 176);
		contentPane.add(fpReg);
		
		loadBuffer = new JTable();
		loadBuffer.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		loadBuffer.setToolTipText("");
		loadBuffer.setForeground(Color.BLACK);
		loadBuffer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loadBuffer.setFillsViewportHeight(true);
		loadBuffer.setColumnSelectionAllowed(true);
		loadBuffer.setBounds(681, 431, 136, 33);
		contentPane.add(loadBuffer);
		
		JLabel lblLoadBuffer = new JLabel("Load Buffer");
		lblLoadBuffer.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblLoadBuffer.setBounds(681, 394, 151, 33);
		contentPane.add(lblLoadBuffer);
		
		storeBuffer = new JTable();
		storeBuffer.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		storeBuffer.setToolTipText("");
		storeBuffer.setForeground(Color.BLACK);
		storeBuffer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		storeBuffer.setFillsViewportHeight(true);
		storeBuffer.setColumnSelectionAllowed(true);
		storeBuffer.setBounds(897, 431, 153, 33);
		contentPane.add(storeBuffer);
		
		JLabel lblStoreBuffer = new JLabel("Store Buffer");
		lblStoreBuffer.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblStoreBuffer.setBounds(897, 394, 153, 33);
		contentPane.add(lblStoreBuffer);
		
		JLabel lblTomasulo = new JLabel("Tomasulo");
		lblTomasulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblTomasulo.setBounds(471, 14, 288, 49);
		contentPane.add(lblTomasulo);
		
		JLabel lblClock = new JLabel("Clock: ");
		lblClock.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblClock.setBounds(448, 375, 80, 33);
		contentPane.add(lblClock);
		
		clockNum = new JLabel("0");
		clockNum.setFont(new Font("Tahoma", Font.PLAIN, 27));
		clockNum.setBounds(554, 375, 80, 33);
		contentPane.add(clockNum);
		
		tf_add = new JTextField();
		tf_add.setBounds(897, 573, 136, 39);
		contentPane.add(tf_add);
		tf_add.setColumns(10);
		
		JLabel lblAdd = new JLabel("ADD");
		lblAdd.setBounds(754, 576, 63, 33);
		contentPane.add(lblAdd);
		
		tf_load = new JTextField();
		tf_load.setColumns(10);
		tf_load.setBounds(897, 620, 136, 39);
		contentPane.add(tf_load);
		
		JLabel lblLoad = new JLabel("LOAD");
		lblLoad.setBounds(746, 625, 71, 33);
		contentPane.add(lblLoad);
		
		tf_mul = new JTextField();
		tf_mul.setColumns(10);
		tf_mul.setBounds(897, 670, 136, 39);
		contentPane.add(tf_mul);
		
		JLabel lblMul = new JLabel("MUL");
		lblMul.setBounds(754, 673, 63, 33);
		contentPane.add(lblMul);
		
		JLabel lblCycles = new JLabel("Cycles");
		lblCycles.setBounds(920, 533, 88, 33);
		contentPane.add(lblCycles);
		
		JButton btnSetCycles = new JButton("Set Cycles");
		btnSetCycles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					mainFlow.getInstance().setCycles(
							Integer.parseInt(tf_add.getText())
							, Integer.parseInt(tf_mul.getText())
							, Integer.parseInt(tf_load.getText()));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				btnNext.setEnabled(true);
				btnSetCycles.setEnabled(false);
			}
			
			
		});
		btnSetCycles.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnSetCycles.setBounds(897, 734, 162, 37);
		contentPane.add(btnSetCycles);
	}
	public void adderToInstrTable() {
		int i=0;
		while(i<7) {
		String[] instruction = instCache.getInstance().getInstruction(i);
		instructions.getModel().setValueAt(instruction[0],i+1,0);
		instructions.getModel().setValueAt(instruction[1],i+1,1);
		instructions.getModel().setValueAt(instruction[2],i+1,2);
		instructions.getModel().setValueAt(instruction[3],i+1,3);
		++i;
		}
	}
	public void setActiveIssue(int instr) {
		issues[instr].setBackground(Color.GREEN);
	}
	public void setActiveExe(int instr) {
		exes[instr].setBackground(Color.GREEN);
	}
	public void setActiveWRS(int instr) {
		WRS[instr].setBackground(Color.GREEN);
	}
	public void addInstruction(reservedInstruction ins) {
		reservedStation.getModel().setValueAt(ins.busy, ins.myPos,1);
		reservedStation.getModel().setValueAt(ins.Op, ins.myPos,2);
		reservedStation.getModel().setValueAt(ins.Vj, ins.myPos,3);
		reservedStation.getModel().setValueAt(ins.Vk, ins.myPos,4);
		reservedStation.getModel().setValueAt(ins.Qj, ins.myPos,5);
		reservedStation.getModel().setValueAt(ins.Qk, ins.myPos,6);
		reservedStation.getModel().setValueAt(ins.A, ins.myPos,7);
	}
	public void cleanInstruction(reservedInstruction ins) {
		reservedStation.getModel().setValueAt(false, ins.myPos,1);
		reservedStation.getModel().setValueAt("", ins.myPos,2);
		reservedStation.getModel().setValueAt("", ins.myPos,3);
		reservedStation.getModel().setValueAt("", ins.myPos,4);
		reservedStation.getModel().setValueAt("", ins.myPos,5);
		reservedStation.getModel().setValueAt("", ins.myPos,6);
		reservedStation.getModel().setValueAt("", ins.myPos,7);
	}
	public void setActual(String[] instruction) {
		table.getModel().setValueAt(instruction[0], 0, 0);
		table.getModel().setValueAt(instruction[1], 0, 1);
		table.getModel().setValueAt(instruction[2], 0, 2);
		table.getModel().setValueAt(instruction[3], 0, 3);
	}
	public void setClock(int clock) {
		clockNum.setText(Integer.toString(clock));
	}
	
	public void setInReg(String instr,int reg) {
		fpReg.getModel().setValueAt(instr, reg, 1);
	}
	public void setOffReg(int reg) {
		fpReg.getModel().setValueAt("", reg, 1);
	}
	
	public void popLoad(String address) {
		loadBuffer.getModel().setValueAt(address,popPos,0 );
		popPos++;
	}
	public void outLoad() {
		String buffer2 = (String) loadBuffer.getModel().getValueAt(1, 0);
		loadBuffer.getModel().setValueAt(buffer2,0,0);
		loadBuffer.getModel().setValueAt("",1,0);
		popPos--;
	}
	public void popStore(String[] instr) {
		storeBuffer.getModel().setValueAt(instr[2]+" + "+instr[3],popStore,0 );
		storeBuffer.getModel().setValueAt(instr[1],popStore,1 );
		popStore++;
	}
	public void outStore() {
		String buffer2_0 = (String) storeBuffer.getModel().getValueAt(1, 0);
		String buffer2_1 = (String) storeBuffer.getModel().getValueAt(1, 1);
		storeBuffer.getModel().setValueAt(buffer2_0,0,0);
		storeBuffer.getModel().setValueAt(buffer2_1,0,1);
		storeBuffer.getModel().setValueAt("",1,0);
		storeBuffer.getModel().setValueAt("",1,1);
		popStore--;
	}
}
