package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class FormController implements Initializable{

	  @FXML
	    private Button loginbutton;

	    @FXML
	    private TextField raadhaar;

	    @FXML
	    private TextField rage;

	    @FXML
	    private TextField rcontact;

	    @FXML
	    private DatePicker rdob;

	    @FXML
	    private TextField rname;
	    
	    @FXML
	    private ComboBox<String> vcom;
	    private String[] vaccines = {"Covishield","Covaxin","Sputnik V","Pfizer"};
	   
	    @FXML
	    private DatePicker vdate;

	    @FXML
	    private ComboBox<String> vtime;
	    private String[] timeslot = {"10:00am-12:00am","01:00pm-03:00pm","04:00pm-06:00pm"};
	    
	    @FXML
	    private RadioButton vfemale,vmale,vother;

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	  @FXML
	   public void checkf(ActionEvent event) {
		  if(vfemale.isSelected()) {
			  vother.setSelected(false);
			  vmale.setSelected(false);
		  }

	    }

	    @FXML
	   public void checkm(ActionEvent event) {
	    	if(vmale.isSelected()) {
				vfemale.setSelected(false);
				vother.setSelected(false);
	    	}
	    }

	    @FXML
	   public void checko(ActionEvent event) {
	    	if(vother.isSelected()) {
				vmale.setSelected(false);
				vfemale.setSelected(false);
			}

	    }
	
		
	//@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		vcom.getItems().addAll(vaccines);
		vtime.getItems().addAll(timeslot);
		
	}
	
	Connection con;
    PreparedStatement pst;
	    @FXML
        void login(ActionEvent event) throws IOException {
		
		
		String a = null;
		
		if(vmale.isSelected()) {
			a = vmale.getText();;
		}
		else if(vfemale.isSelected()) {
			a = vfemale.getText();
		}
		else if(vother.isSelected()) {
			a = vother.getText();
		}
		
		String username = rname.getText();
		String useraadhaar = raadhaar.getText();
		String userage =  rage.getText();
		String usercontact = rcontact.getText();
		String userdob = rdob.getEditor().getText();
		String vaccinedate = vdate.getEditor().getText();
		String vaccine = vcom.getValue();
		String time = vtime.getValue();
		String gender = a ;
		
		if(username.equals("") || useraadhaar.equals("") || userage.equals("") || usercontact.equals("") || userdob.equals("") || vaccinedate.equals("") || vaccine.equals("") || time.equals("") || gender.equals("") )
		{
		JOptionPane.showMessageDialog(null,"ALL DETAILS ARE REQUIRED!");
		}
		else if(userage.equals("1")||userage.equals("2")||userage.equals("3")||userage.equals("4")||userage.equals("5")||userage.equals("6")||userage.equals("7")||userage.equals("8")||userage.equals("9")||userage.equals("10")||userage.equals("11")||userage.equals("12")||userage.equals("13")||userage.equals("14")||userage.equals("15")||userage.equals("16")||userage.equals("17")) {
			JOptionPane.showMessageDialog(null,"AGE MUST BE 18+");
		}
		else {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccinationsystem","root","Hero@MYSQL8027");
			pst = con.prepareStatement("insert into registerantprofile(Name,DOB,Age,Gender,Aadhaar,Contact,vaccine,vaccinedate,timeslot)values(?,?,?,?,?,?,?,?,?)");
			pst.setString(1, username);
			pst.setString(2, userdob);
			pst.setString(3, userage);
			pst.setString(4, gender);
			pst.setString(5, useraadhaar);
			pst.setString(6, usercontact);
			pst.setString(7, vaccine);
			pst.setString(8, vaccinedate);
			pst.setString(9, time);
			
			int status = pst.executeUpdate();
			if(status==1)
			{
			JOptionPane.showMessageDialog(null,"YOUR BOOKING HAS BEEN CONFIRMED");

			FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistrantProfile.fxml"));	
			root = loader.load();	
			
			RegisterantProfile registerantProfile = loader.getController();
			registerantProfile.displayName2(username);
			registerantProfile.displayName5(useraadhaar);
			registerantProfile.displayName3(userage);
			registerantProfile.displayName4(usercontact);
			registerantProfile.displayName1(userdob);
			registerantProfile.displayName6(vaccinedate);
			registerantProfile.displayName7(vaccine);
			registerantProfile.displayName8(time);
			registerantProfile.displayName9(gender);

			//root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));	
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
			}

			else
			{
			JOptionPane.showMessageDialog(null,"FAILED TO BOOK PLEASE TRY AGAIN!");
			rname.setText("");
			raadhaar.setText("");
			rcontact.setText("");
			rage.setText("");
			rdob.getEditor().setText("");
			vdate.getEditor().setText("");
			vcom.setValue(null);
			vtime.setValue(null);
			vmale.setSelected(false);
			vfemale.setSelected(false);
			vother.setSelected(false);
		
			rname.requestFocus();

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

}


