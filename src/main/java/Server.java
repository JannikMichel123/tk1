import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
        
public class Server implements IFlightServer {
	
	private List<String> name= new ArrayList<String>();
    public List<Flight> Flightlist = new ArrayList<Flight>();
    public Server() {}
    public  Flight flight1 = new Flight("LH","Lufthansa","382","541","TK","FRA","1");
    public  Flight flight2 = new Flight("LH","Lufthansa","381","542","FRA","FRA","2");
    public static IFlightServer stub;

	@Override
	public boolean login (String clientName, IFlightClient client) throws RemoteException {
		// TODO Auto-generated method stub
		name.add("lin");
		if(!name.contains(clientName)) {
			name.add(clientName);
			Flightlist.add(flight2);
			Flightlist.add(flight1);
			client.receiveListofFlights(Flightlist);
			client.receiveUpdatedFlight(flight1, true);
			return true;
		}
		else {
			System.out.println("Failed.Username is existed.");
			return false;
		}
		
		
	}

	@Override
	public void logout(String clientName) {
		// TODO Auto-generated method stub
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



}