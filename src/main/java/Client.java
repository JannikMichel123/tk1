import java.awt.BorderLayout;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Client implements IFlightClient , Serializable {
	public String name;
	public static IFlightServer cstub;
	public static ClientWindow cw ;
	private Client(String name) {
		this.name = name;
	};
	public static Client client = null;
	
	@Override
	public void receiveListofFlights(List<Flight> flights) {
		
		cw = new ClientWindow();
		cw.Flightinfo = flights;
		ArrayList<String> items;
		/*for(Flight flight : flights) {
			items = new ArrayList<>();
			items.add(flight.Name);
			items.add(flight.IATAcode);
			items.add(flight.Flightnumber);
			items.add(flight.Departureairport);
			items.add(flight.ArrivalAirport);
			items.add(flight.ATernimal);
			cw.Flightinfo.add(items);
		}
		System.out.println(cw.Flightinfo.size());*/
		Object[][] obj = new Object[cw.Flightinfo.size()][6];
		int i = 0 , j = 0;
		for(i=0;i<cw.Flightinfo.size();i++) {
				obj[i] = cw.Flightinfo.get(i).toArray();
		}		
		cw.model = new DefaultTableModel(obj,cw.titles);
		cw.table = new JTable(cw.model);
		cw.add(new JScrollPane(cw.table),BorderLayout.NORTH);
		cw.setVisible(true);
		System.out.println("ojbk");	
	}
	
	@Override
	public void receiveUpdatedFlight(Flight flight, boolean deleted) {
		// TODO Auto-generated method stub
	   cw.Flightinfo.remove(flight);

		cw.updateWindow();
		try {
			
		}catch(Exception e ){
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String host = (args.length < 1) ? null : args[0];


        try {
            Registry registry = LocateRegistry.getRegistry(host);
            client = new Client("lin1");
            cstub = (IFlightServer) registry.lookup("IFlightServer");
            cstub.login(client.name,client);
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
	}

}
