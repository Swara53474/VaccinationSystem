package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class RegisterantProfile {
	private Stage stage;
	private Scene scene;
	private Parent root;

	@FXML
    private Button BookButton;
	    @FXML
	    private Label raadhaarLabel;

	    @FXML
	    private Label rageLabel;

	    @FXML
	    private Label rcontactLabel;

	    @FXML
	    private Label rdateLabel;

	    @FXML
	    private Label rdobLabel;

	    @FXML
	    private Label rgenderLabel;

	    @FXML
	    private Label rnameLabel;

	    @FXML
	    private Label rtimeslotLabel;

	    @FXML
	    private Label rvaccineLabel;

	
	public void displayName1(String userdob) throws IOException{
		rdobLabel.setText(userdob);
	}
	public void displayName2(String username) throws IOException{
		rnameLabel.setText(username);
	}
	public void displayName3(String userage) throws IOException{
		rageLabel.setText(userage);
	}
	public void displayName4(String usercontact) throws IOException{
		rcontactLabel.setText(usercontact);
	}
	public void displayName5(String useraadhaar) throws IOException{
		raadhaarLabel.setText(useraadhaar);
	}
	public void displayName6(String vaccinedate) throws IOException{
		rdateLabel.setText(vaccinedate);
	}
	public void displayName7(String vaccine) throws IOException{
		rvaccineLabel.setText(vaccine);
	}
	public void displayName8(String time) throws IOException{
		rtimeslotLabel.setText(time);
	}
	public void displayName9(String gender) throws IOException{
		rgenderLabel.setText(gender);
	}
	public void switchToHomePage(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		}
	
	Connection con;
    PreparedStatement pst;
	
	@FXML
    void BOOK(ActionEvent event) throws IOException {
		
		/*String rpname = rnameLabel.getText();
		String rpaadhaar = raadhaarLabel.getText();
		String rpage =  rageLabel.getText();
		String rpcontact = rcontactLabel.getText();
		String rpdob = rdobLabel.getText();
		String rpvaccinedate = rdateLabel.getText();
		String rpvaccine = rvaccineLabel.getText();
		String rptime = rtimeslotLabel.getText() ;
		String rpgender = rgenderLabel.getText();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccinationsystem","root","Hero@MYSQL8027");
			pst = con.prepareStatement("insert into registerantprofile(Name,DOB,Age,Gender,Aadhaar,Contact,vaccine,vaccinedate,timeslot)values(?,?,?,?,?,?,?,?,?)");
			pst.setString(1, rpname);
			pst.setString(2, rpdob);
			pst.setString(3, rpage);
			pst.setString(4, rpgender);
			pst.setString(5, rpaadhaar);
			pst.setString(6, rpcontact);
			pst.setString(7, rpvaccine);
			pst.setString(8, rpvaccinedate);
			pst.setString(9, rptime);
			
			int status = pst.executeUpdate();
			if(status==1)
			{
			JOptionPane.showMessageDialog(null,"YOUR BOOKING HAS BEEN CONFIRMED");


		    root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			}

			else
			{
			JOptionPane.showMessageDialog(null,"FAILED TO BOOK PLEASE TRY AGAIN!");
			root = FXMLLoader.load(getClass().getResource("LogInForVacciation.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

			}
			}
			catch (ClassNotFoundException e)
			{
			e.printStackTrace();
			}
			catch (SQLException e)
			{
			e.printStackTrace();
			}*/
    }
}
