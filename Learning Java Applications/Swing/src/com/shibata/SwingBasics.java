package com.shibata;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.JScrollPane;

public class SwingBasics {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingBasics window = new SwingBasics();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	class TableData extends AbstractTableModel {

		private int[][] allData;
		private static final long serialVersionUID = -99707503673910159L;

		public TableData() {
//			allData[0] = new int[] { 1, 2, 3 };
//			allData[1] = new int[] { 4, 5, 6 };
//			allData[2] = new int[] { 7, 8, 9 };
			loadFile("data.csv");
		}

		void loadFile(String fileName) {
			Path file = FileSystems.getDefault().getPath("", fileName);
			try {
				List<String> lines = Files.readAllLines(file);
				for (int i = 0; i < lines.size(); i++) {	
					String[] values = lines.get(i).split(",");
					if(allData == null) {
						allData = new int[lines.size()][values.length];						
					}
					for (int j = 0; j < values.length; j++) {
						allData[i][j] = Integer.parseInt(values[j]);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public int getRowCount() {
			return allData.length;
		}

		@Override
		public int getColumnCount() {
			return allData[0].length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return allData[rowIndex][columnIndex];
		}

	}

	/**
	 * Create the application.
	 */
	public SwingBasics() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Lato", Font.PLAIN, 11));
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 64);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		TableData data = new TableData();
		table.setModel(data);
	}
}
