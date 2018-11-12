import java.awt.BorderLayout;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Client extends UnicastRemoteObject  implements IFlightClient , Serializable {
	public static  String name;
	public static IFlightServer cstub;
	public static ClientWindow cw ;
	
	public Client(String name)  throws RemoteException {
		this.name = name;
	}
	public static Client client = null;
	
	@Override
	public void receiveListofFlights(List<Flight> flights) throws RemoteException {
		cw.Flightinfo = flights;
		cw.updateWindow();
		System.out.println("ojbk");	
	}
	
	@Override
	public void receiveUpdatedFlight(Flight flight, boolean deleted) {
		// TODO Auto-generated method stub
	    for(int i = 0; i<cw.Flightinfo.size();i++) {
	    	if(cw.Flightinfo.get(i).Flightnumber.equals(flight.Flightnumber)) {
	    		cw.Flightinfo.remove(i);
	    	}
	    }
	    if(!deleted) {
	    	cw.Flightinfo.add(flight);
	    }
		cw.updateWindow();
		try {
			
		}catch(Exception e ){
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws RemoteException {
		String host = (args.length < 1) ? null : args[0];
//		try {
//			LoginDialog dialog = new LoginDialog();
//			dialog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	    JFrame frame = new JFrame("InputDialog Example #2");
	    name = JOptionPane.showInputDialog(
	        frame, 
	        "Enter your User Name"
	    );
	    if(name==null || name.equals("")) {
	    	System.exit(0);
	    }
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            client = new Client(name);
//            registry.bind(name, client);
            cstub = (IFlightServer) registry.lookup("IFlightServer");
            
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
		cw = new ClientWindow(cstub);
		//cw.Flightinfo = flights;
		Object[][] obj = new Object[cw.Flightinfo.size()][6];
		int i = 0 ;
		for(i=0;i<cw.Flightinfo.size();i++) {
				obj[i] = cw.Flightinfo.get(i).toArray();
		}		
		cw.model = new DefaultTableModel(obj,cw.titles);
		cw.table = new JTable(cw.model);
		cw.add(new JScrollPane(cw.table),BorderLayout.NORTH);
		cw.setVisible(true);
		if(!cstub.login(name,client)) {System.exit(1);}
		
	}

}
