import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClientWindow extends JFrame{
	
	
	public class NewActionListener implements ActionListener{
		IFlightServer fs;
		public NewActionListener(IFlightServer fs ){
			this.fs = fs;
		}
		public void actionPerformed(ActionEvent ae) {
			//open the edit window but without the values.
			try {
				
				EditDialog dialog = new EditDialog(new Flight(),fs);
				dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}	
	
	public class EditActionListener implements ActionListener{
		IFlightServer fs;
		ClientWindow cw;
		public List<Flight> Flightinfo;
		public EditActionListener(IFlightServer fs,ClientWindow cw ){
			this.fs = fs;
			this.cw = cw;
			
		}
		public void actionPerformed(ActionEvent ae) {
			//Open an new window.
			try {
				//Flight v = (Flight)cw.model.getDataVector().elementAt(cw.table.getSelectedRow());
				
				EditDialog dialog = new EditDialog(cw.Flightinfo.get(cw.table.getSelectedRow()),fs);
				dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}	
	
	public class DeleteActionListener implements ActionListener{
		IFlightServer fs;
		ClientWindow cw;
		public DeleteActionListener(IFlightServer fs,ClientWindow cw  ){
			this.fs = fs;
			this.cw = cw;
		}
		public void actionPerformed(ActionEvent ae) {
			//call Server to delete the selected item
			int selectedRow = cw.table.getSelectedRow();
			if(selectedRow != -1) {
				cw.Flightinfo.remove(selectedRow);
				cw.updateWindow();
			}
		}
	}
	
	
	public DefaultTableModel model = null;
	public JTable table = null;
	public JButton jb1,jb2,jb3;
	public JPanel jp1 = null;
	public List<Flight> Flightinfo = new ArrayList<Flight>();
	public String[] titles = {"Operating Airline","IATA Code","Tracking Number","Depature",
			"Arrival","Terminal","Scheduled Time","Estimated Time"};
	public IFlightServer fs;
	
	public ClientWindow(IFlightServer fs) throws RemoteException{
		super("TK Airport Arrivals/ Departures");
		
		this.fs=fs;

		jb1 = new JButton("New");
		jb1.addActionListener(new NewActionListener(this.fs));
		jb2 = new JButton("Edit");
		jb2.addActionListener(new EditActionListener(this.fs,this));
		jb3 = new JButton("Delete");
		jb3.addActionListener(new DeleteActionListener(this.fs,this));
		
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
		int i = 0;
		for(i=0;i<this.Flightinfo.size();i++) {
				obj[i] = this.Flightinfo.get(i).toArray();
				System.out.println("test");
		}		

		this.model = new DefaultTableModel(obj,this.titles);
		this.table.setModel(model);
		this.repaint();
		this.setVisible(true);
	}
}
