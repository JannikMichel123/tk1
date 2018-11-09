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
/*	String Origindata = null;
	String AScheduleddatetime = null;
	String[] Agate = null;
	String AEstimateddatetime  = null;
	String DScheduleddatetime = null;
	int  DTernimal = 0;
	String[] Dgate = null;
	String DEstimateddatetime  = null;
	int Checkinlocation = 0;
	int[] Checkincouter = null;
	String Checkindateandtime = null;
	String[] Flightstatus = {"B","D","I","L","M","S","X","Y","Z"};
	String FlightStatus = null;   */
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
