import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClientWindow extends JFrame{
	public DefaultTableModel model = null;
	public JTable table = null;
	public JButton jb1,jb2,jb3;
	public JPanel jp1 = null;
	public List<Flight> Flightinfo = new ArrayList<Flight>();
	public String[] titles = {"Operating Airline","IATA Code","Tracking Number","Depature",
			"Arrival","Terminal","Scheduled Time","Estimated Time"};
	public ClientWindow(){
		super("TK Airport Arrivals/ Departures");
		
		jb1 = new JButton("New");
		jb2 = new JButton("Edit");
		jb3 = new JButton("Delete");
		
		jp1 = new JPanel();
		
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		
		
		add(jp1,BorderLayout.SOUTH);
		
		
		setSize(800,480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	void updateWindow() {
		Object[][] obj = new Object[this.Flightinfo.size()][6];
		int i = 0 , j = 0;
		for(i=0;i<this.Flightinfo.size();i++) {
				obj[i] = this.Flightinfo.get(i).toArray();
				System.out.println("test");
		}		
//		this.setVisible(false);
//		this.model = new DefaultTableModel(obj,this.titles);
//		this.table = new JTable(this.model);
//		this.add(new JScrollPane(this.table),BorderLayout.NORTH);
//		this.repaint();
//		this.setVisible(true);

		this.model = new DefaultTableModel(obj,this.titles);
		System.out.println(this.model.getRowCount());
		this.table = new JTable(this.model);
		this.repaint();
		this.setVisible(true);
	}
}
