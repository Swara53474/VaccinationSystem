package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AfterLoginProfile implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;

	 @FXML
	    private Label paadhaarLabel;

	    @FXML
	    private Label pageLabel;

	    @FXML
	    private Label pcontactLabel;

	    @FXML
	    private Label pdateLabel;

	    @FXML
	    private Label pdobLabel;

	    @FXML
	    private Label pgenderLabel;

	    @FXML
	    private Label pnameLabel;

	    @FXML
	    private Label ptimeLabel1;

	    @FXML
	    private Label pvaccineLabel;
	    
	    @FXML
	    private Label welcome;
	    
	    @FXML
	    private Button logout;
	    
	    @FXML
	    private Button u2nd;  

	    @FXML
	    private DatePicker udate;

	    @FXML
	    private ComboBox<String> utime;
	    private String[] timeslot = {"10:00am-12:00am","01:00pm-03:00pm","04:00pm-06:00pm"};
	    
	    @FXML
	    private Label uvaccineLabel;

	    public void ToHomePage(ActionEvent event) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			}
	    public void logout(ActionEvent event) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("LogInForVaccination.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			}

		public void displayName2(String pname) throws IOException{
			pnameLabel.setText(pname);
			welcome.setText("WELCOME "+pname);
		}

		public void displayName5(String uaadhaar) throws IOException{
			paadhaarLabel.setText(uaadhaar);
		}

		public void displayName3(String page) throws IOException{
			pageLabel.setText(page);
		}

		public void displayName1(String pdob) throws IOException{
			pdobLabel.setText(pdob);
		}

		public void displayName4(String upass) throws IOException{
			pcontactLabel.setText(upass);
			
		}

		public void displayName6(String pdate) throws IOException{
			pdateLabel.setText(pdate);
			
		}

		public void displayName7(String pvaccine) throws IOException{
			pvaccineLabel.setText(pvaccine);
			uvaccineLabel.setText(pvaccine);
		}

		public void displayName8(String ptime) throws IOException{
			ptimeLabel1.setText(ptime);
		}

		public void displayName9(String pgender) throws IOException{
			pgenderLabel.setText(pgender);
		}
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			utime.getItems().addAll(timeslot);
		}
		Connection con;
	    PreparedStatement pst;
		    @FXML
	        void book2nd(ActionEvent event) throws IOException {
		    	String saadhaar = paadhaarLabel.getText();
				String svaccinedate = udate.getEditor().getText();
				String vaccine = uvaccineLabel.getText();
				String time = utime.getValue();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccinationsystem","root","Hero@MYSQL8027");
					pst = con.prepareStatement("insert into seconddose(Aadhaar,svaccine,sdate,stime)values(?,?,?,?)");
				
					pst.setString(1, saadhaar);
					pst.setString(2, vaccine);
					pst.setString(3, svaccinedate);
					pst.setString(4, time);
					
					int status = pst.executeUpdate();
					if(status==1)
					{
					JOptionPane.showMessageDialog(null,"YOUR BOOKING HAS BEEN CONFIRMED");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"FAILED TO BOOK PLEASE TRY AGAIN!");
						}
		    }
				catch (ClassNotFoundException e)
				{
				e.printStackTrace();
				}
				catch (SQLException e)
				{
				e.printStackTrace();
				}
}
}
