package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.mainFlow;
import Modules.instCache;
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

public class mainGUI extends JFrame {

	private JPanel contentPane;
	private JTable instructions;
	private JTable table;
	private JLabel label;
	private JButton btnNext;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 779);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblCode = new JLabel("Actual Instruction");
		lblCode.setBounds(12, 406, 265, 33);
		contentPane.add(lblCode);
		
		JButton btnLoadProgram = new JButton("Load Program");
		btnLoadProgram.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnLoadProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					mainFlow.getInstance().fetchInstructions();
					adderToInstrTable();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLoadProgram.setBounds(54, 50, 294, 64);
		contentPane.add(btnLoadProgram);
		
		instructions = new JTable();
		instructions.setForeground(new Color(0, 0, 0));
		instructions.setFillsViewportHeight(true);
		instructions.setColumnSelectionAllowed(true);
		instructions.setFont(new Font("Tahoma", Font.PLAIN, 16));
		instructions.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
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
		instructions.setBounds(25, 199, 373, 144);
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
		table.setBounds(25, 448, 373, 16);
		contentPane.add(table);
		
		label = new JLabel("Code");
		label.setBounds(15, 142, 115, 33);
		contentPane.add(label);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainFlow.getInstance().nextInstruction();
				String[] instruction = mainFlow.getInstance().getActualInstruction();
				table.getModel().setValueAt(instruction[0], 0, 0);
				table.getModel().setValueAt(instruction[1], 0, 1);
				table.getModel().setValueAt(instruction[2], 0, 2);
				table.getModel().setValueAt(instruction[3], 0, 3);
			}
		});
		btnNext.setBounds(257, 402, 145, 37);
		contentPane.add(btnNext);
	}
	void adderToInstrTable() {
		int i=0;
		while(i<12) {
		String[] instruction = instCache.getInstance().getInstruction(i);
		instructions.getModel().setValueAt(instruction[0],i,0);
		instructions.getModel().setValueAt(instruction[1],i,1);
		instructions.getModel().setValueAt(instruction[2],i,2);
		instructions.getModel().setValueAt(instruction[3],i,3);
		++i;
		}
	}
}
