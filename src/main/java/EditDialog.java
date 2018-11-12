import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class EditDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	IFlightServer fs;
	/*
	 * Launch the application.
	
	public static void main(String[] args) {
		try {
			EditDialog dialog = new EditDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} */

	/**
	 * Create the dialog.
	 */
	public EditDialog(Flight flight,IFlightServer fs) {
		setBounds(100, 100, 800,480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IATA Code");
		lblNewLabel.setBounds(6, 6, 109, 16);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Aircraft Model Name");
		lblNewLabel_1.setBounds(6, 34, 109, 16);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tracking Number");
		lblNewLabel_2.setBounds(6, 62, 109, 16);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Departure Airport");
		lblNewLabel_3.setBounds(6, 90, 109, 16);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Origin Date");
		lblNewLabel_4.setBounds(6, 118, 109, 16);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Scheduled Departure");
		lblNewLabel_5.setBounds(6, 146, 109, 16);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Departure Terminal");
		lblNewLabel_6.setBounds(6, 174, 109, 16);
		contentPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Departure Gates");
		lblNewLabel_7.setBounds(6, 202, 109, 16);
		contentPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Estimated Departure");
		lblNewLabel_8.setBounds(6, 230, 109, 16);
		contentPanel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Check-in Location");
		lblNewLabel_9.setBounds(6, 258, 109, 16);
		contentPanel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Check-in Counter");
		lblNewLabel_10.setBounds(6, 286, 109, 16);
		contentPanel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Check-in Start");
		lblNewLabel_11.setBounds(6, 314, 109, 16);
		contentPanel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Flight Status");
		lblNewLabel_12.setBounds(6, 342, 109, 16);
		contentPanel.add(lblNewLabel_12);
		
		textField = new JTextField();
		textField.setBounds(127, 1, 186, 26);
		textField.setText(flight.IATAcode);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(127, 29, 186, 26);
		textField_1.setText(flight.Modelname);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(127, 57, 186, 26);
		textField_2.setText(flight.Flightnumber);
		contentPanel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(127, 85, 186, 26);
		contentPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(127, 113, 186, 26);
		contentPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(127, 141, 186, 26);
		contentPanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(127, 169, 186, 26);
		contentPanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(127, 197, 186, 26);
		contentPanel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(127, 225, 186, 26);
		contentPanel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(127, 253, 186, 26);
		contentPanel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(127, 281, 186, 26);
		contentPanel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(127, 309, 186, 26);
		contentPanel.add(textField_11);
		
		JLabel lblNewLabel_13 = new JLabel("Operating Airline");
		lblNewLabel_13.setBounds(379, 6, 109, 16);
		contentPanel.add(lblNewLabel_13);
		
		JLabel lblArrivalAirport = new JLabel("Arrival Airport");
		lblArrivalAirport.setBounds(379, 90, 109, 16);
		contentPanel.add(lblArrivalAirport);
		
		JLabel lblScheduledArrival = new JLabel("Scheduled Arrival");
		lblScheduledArrival.setBounds(379, 146, 109, 16);
		contentPanel.add(lblScheduledArrival);
		
		JLabel lblArrivalTerminal = new JLabel("Arrival Terminal");
		lblArrivalTerminal.setBounds(379, 174, 109, 16);
		contentPanel.add(lblArrivalTerminal);
		
		JLabel lblArrivalGates = new JLabel("Arrival Gates");
		lblArrivalGates.setBounds(379, 202, 109, 16);
		contentPanel.add(lblArrivalGates);
		
		JLabel lblEstimatedArrival = new JLabel("Estimated Arrival");
		lblEstimatedArrival.setBounds(379, 230, 109, 16);
		contentPanel.add(lblEstimatedArrival);
		
		JLabel lblCheckinEnd = new JLabel("Check-in End");
		lblCheckinEnd.setBounds(379, 314, 109, 16);
		contentPanel.add(lblCheckinEnd);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(500, 1, 130, 26);
		contentPanel.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(500, 85, 130, 26);
		contentPanel.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(500, 141, 130, 26);

		contentPanel.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(500, 169, 130, 26);
		contentPanel.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(500, 197, 130, 26);
		contentPanel.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(500, 225, 130, 26);
		contentPanel.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(500, 309, 130, 26);
		contentPanel.add(textField_18);
		
		textField_3.setText(flight.Departureairport);
		textField_4.setText(flight.Origindate);
		textField_5.setText(flight.DScheduleddatetime);
		textField_6.setText(flight.DTerminal);
		textField_7.setText(flight.Dgate);
		textField_8.setText(flight.DEstimateddatetime);
		textField_9.setText(flight.Checkinlocation);
		textField_10.setText(flight.Checkincouter);
		textField_11.setText(flight.StartCheckindateandtime);
		textField_12.setText(flight.Name);
		textField_13.setText(flight.ArrivalAirport);
		textField_14.setText(flight.AScheduleddatetime);
		textField_15.setText(flight.ATernimal);
		textField_16.setText(flight.Agate);
		textField_17.setText(flight.AEstimateddatetime);
		textField_18.setText(flight.EndCheckindateandtime);
		String[] flightStatus = { "B", "D", "I", "L", "M","S","X" };
		JComboBox comboBox = new JComboBox(flightStatus);
		if(flight.FlightStatus != null) {
			comboBox.setSelectedItem(flight.FlightStatus);
		}
		comboBox.setBounds(127, 338, 503, 27);
		contentPanel.add(comboBox);
//		'B' = Arrival by bus at Concourse B
//				o 'D' = Diverted
//				o 'I' = Undefined late arrival or
//				departure
//				o 'L' = Aborted departure
//				o 'M' = Flight delayed until tomorrow
//				o 'S' = Definitively canceled flight
//				o 'X' = Canceled flight for which there
//				may be a replacement o 'Y' = Return to stand
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnNewButton = new JButton("New button");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				try {
					fs.updataFlight("lin1", new Flight(textField.getText(),textField_12.getText(),
							textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_13.getText(),
							textField_15.getText(),textField_4.getText(),textField_14.getText(),textField_16.getText(),
							textField_17.getText(),textField_5.getText(),textField_6.getText(),textField_7.getText(),
							textField_8.getText(),textField_9.getText(),textField_10.getText(),textField_11.getText(),
							textField_18.getText(),(String)comboBox.getSelectedItem()));
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			});
			buttonPane.add(btnNewButton);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
