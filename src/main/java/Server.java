import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
        
public class Server implements IFlightServer {
	
	private List<ClientHelper> clients= new ArrayList<ClientHelper>();
    public List<Flight> Flightlist = new ArrayList<Flight>();
    public Server() {}
    public static IFlightServer stub;

    public class ClientHelper{
    	IFlightClient stub;
    	String name;
    	public ClientHelper(IFlightClient stub,String name) {
    		this.stub = stub;
    		this.name = name;
    	}
    	
    }
	@Override
	public boolean login (String clientName, IFlightClient client) throws RemoteException {
		// TODO Auto-generated method stub
		if(!clients.stream().filter(c->c.name.equals(clientName)).findFirst().isPresent()) {
			System.out.println("Suceed");
			Registry registry = LocateRegistry.getRegistry(null);
			try {
				registry.bind(clientName, client);
			} catch (AlreadyBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clients.add(new ClientHelper(client,clientName));
			client.receiveListofFlights(Flightlist);
			return true;
		}
		else {
			System.out.println("Failed.Username is existed.");
			return false;
		}
		
		
	}

	@Override
	public void logout(String clientName) {
		//delete client from list and delete stub
		for(int i = 0;i<clients.size();i++) {
			if(clients.get(i).name.equals(clientName)) {
				clients.remove(i);
			}
		}
		System.out.println("You have logged out");
	}
    
    public static void main(String args[]) {
        try {
        	System.setProperty("java.rmi.server.hostname","127.0.0.1");
            Server obj = new Server();
            stub = (IFlightServer) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("IFlightServer", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

	@Override
	public void updataFlight(String clientName, Flight flight) throws RemoteException {
		// TODO Auto-generated method stub
	    for(int i = 0; i<Flightlist.size();i++) {
	    	if(Flightlist.get(i).Flightnumber.equals(flight.Flightnumber)) {
	    		Flightlist.remove(i);
	    	}
	    }
		Flightlist.add(flight);
		for(ClientHelper ch : clients) {
			ch.stub.receiveUpdatedFlight(flight, false);
		}
	}

	@Override
	public void deleteFlight(String clientName, Flight flight) throws RemoteException {
		// TODO Auto-generated method stub
		for(ClientHelper ch : clients) {
			
			ch.stub.receiveUpdatedFlight(flight, true);
		}
	}



}