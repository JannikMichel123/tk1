import java.io.Serializable;
import java.lang.reflect.Array;

public class Flight implements Serializable{
	String IATAcode = null;
	String Name = null;
	String Modelname = null;
	String Flightnumber = null;
	String Departureairport = null;
	String ArrivalAirport = null;
	String  ATernimal = null;
	String Origindate = null;
	String AScheduleddatetime = null;
	String Agate = null;
	String AEstimateddatetime  = null;
	String DScheduleddatetime = null;
	String  DTerminal = null;
	String Dgate = null;
	String DEstimateddatetime  = null;
	String Checkinlocation = null;
	String Checkincouter = null;
	String StartCheckindateandtime = null;
	String EndCheckindateandtime = null;
	String[] Flightstatus = {"B","D","I","L","M","S","X","Y","Z"};
	String FlightStatus = null;   
	public Flight(String IATAcode,String name,String Modelname,String Flightnumber,String Departureairport,
					String ArrivalAirport,String ATerminal) {
		this.IATAcode = IATAcode;
		this.Name = name;
		this.Modelname = Modelname;
		this.Flightnumber = Flightnumber;
		this.Departureairport = Departureairport;
		this.ArrivalAirport = ArrivalAirport;
		this.ATernimal = ATerminal;
	}
	
	public Flight(String iATAcode, String name, String modelname, String flightnumber, String departureairport,
			String arrivalAirport, String aTernimal, String origindate, String aScheduleddatetime, String agate,
			String aEstimateddatetime, String dScheduleddatetime, String dTernimal, String dgate,
			String dEstimateddatetime, String checkinlocation, String checkincouter, String checkindateandtime,
			String endCheckindateandtime) {
		super();
		IATAcode = iATAcode;
		Name = name;
		Modelname = modelname;
		Flightnumber = flightnumber;
		Departureairport = departureairport;
		ArrivalAirport = arrivalAirport;
		ATernimal = aTernimal;
		Origindate = origindate;
		AScheduleddatetime = aScheduleddatetime;
		Agate = agate;
		AEstimateddatetime = aEstimateddatetime;
		DScheduleddatetime = dScheduleddatetime;
		DTerminal = dTernimal;
		Dgate = dgate;
		DEstimateddatetime = dEstimateddatetime;
		Checkinlocation = checkinlocation;
		Checkincouter = checkincouter;
		StartCheckindateandtime = checkindateandtime;
		//Flightstatus = flightstatus;
		//FlightStatus = flightStatus2;
		EndCheckindateandtime = endCheckindateandtime;
	}

	public Flight() {}
	String[] toArray() {
		String[] s =  {this.IATAcode,
		this.Name,
		this.Flightnumber,
		this.Departureairport ,
		this.ArrivalAirport,
		this.ATernimal} ;
		return s;
	}
	
	 
}
