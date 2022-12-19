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
//import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class SceneController {

private Stage stage;
private Scene scene;
private Parent root;

@FXML
private Button toregister;

@FXML
private Button ulogin;

@FXML
private TextField atext;

@FXML
private PasswordField ptext;

@FXML
private TextField user;


@FXML
public void FormFX(ActionEvent event) throws IOException{
	FXMLLoader loader = new FXMLLoader(getClass().getResource("FormFX.fxml"));	
	root = loader.load();	
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void switchToHomePage(ActionEvent event) throws IOException {
Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
stage = (Stage)((Node)event.getSource()).getScene().getWindow();
scene = new Scene(root);
stage.setScene(scene);
stage.show();
}
public void switchToLogInForVaccination(ActionEvent event) throws IOException {
Parent root = FXMLLoader.load(getClass().getResource("LogInForVaccination.fxml"));
stage = (Stage)((Node)event.getSource()).getScene().getWindow();
scene = new Scene(root);
stage.setScene(scene);
stage.show();
}
public void switchToPatientInfoForm(ActionEvent event) throws IOException {
Parent root = FXMLLoader.load(getClass().getResource("PatientInfoForm.fxml"));
stage = (Stage)((Node)event.getSource()).getScene().getWindow();
scene = new Scene(root);
stage.setScene(scene);
stage.show();
}
public void switchToAdminPage(ActionEvent event) throws IOException {
Parent root = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
stage = (Stage)((Node)event.getSource()).getScene().getWindow();
scene = new Scene(root);
stage.setScene(scene);
stage.show();
}
public void switchToAdminLogIn(ActionEvent event) throws IOException {
Parent root = FXMLLoader.load(getClass().getResource("AdminLogIn.fxml"));
stage = (Stage)((Node)event.getSource()).getScene().getWindow();
scene = new Scene(root);
stage.setScene(scene);
stage.show();
}
public void switchForChild(ActionEvent event) throws IOException {
Parent root = FXMLLoader.load(getClass().getResource("ForChild.fxml"));
stage = (Stage)((Node)event.getSource()).getScene().getWindow();
scene = new Scene(root);
stage.setScene(scene);
stage.show();
}
public void switchToFAQs(ActionEvent event) throws IOException {
Parent root = FXMLLoader.load(getClass().getResource("FAQs.fxml"));
stage = (Stage)((Node)event.getSource()).getScene().getWindow();
scene = new Scene(root);
stage.setScene(scene);
stage.show();
}
public void switchToCom(ActionEvent event) throws IOException {
Parent root = FXMLLoader.load(getClass().getResource("Com.java"));
stage = (Stage)((Node)event.getSource()).getScene().getWindow();
scene = new Scene(root);
stage.setScene(scene);
stage.show();
}
Connection con;
PreparedStatement pst;
@FXML
public void Profile(ActionEvent event) throws IOException{
	
	String uaadhaar = atext.getText();
	String upass =  ptext.getText();
	
	if(uaadhaar.equals("") || upass.equals(""))
	{
	JOptionPane.showMessageDialog(null,"INCOMPLETE DETAILS");
	}
	else
	{
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccinationsystem","root","Hero@MYSQL8027");
	Statement stm = con.createStatement();
	String sql = "select * from registerantprofile where Aadhaar='"+uaadhaar+"' and Contact='"+upass.toString()+"'";
	ResultSet rs = stm.executeQuery(sql);
	
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccinationsystem","root","Hero@MYSQL8027");
		String sql1 = "select * from registerantprofile where Aadhaar=?";
		PreparedStatement psmt = conn.prepareStatement(sql1);
		psmt.setInt(1, Integer.parseInt(atext.getText()));
		ResultSet rs1 = psmt.executeQuery();

	 if(rs.next() && rs1.next())
	{
	
		 JOptionPane.showMessageDialog(null,"YOU'VE SUCCESSFULLY LOGGED IN!");
		 System.out.println(rs1.getString("Name"));
			String pname = rs1.getString("Name");
			String pdob = rs1.getString("DOB");
			String page =  rs1.getString("Age");
			String pdate = rs1.getString("vaccinedate");
			String pvaccine = rs1.getString("vaccine");
			String ptime = rs1.getString("timeslot");
			String pgender = rs1.getString("Gender") ;
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("AfterLogin.fxml"));	
			root = loader.load();	
			
			AfterLoginProfile Profile = loader.getController();
			Profile.displayName2(pname);
			Profile.displayName5(uaadhaar);
			Profile.displayName3(page);
			Profile.displayName4(upass);
			Profile.displayName1(pdob);
			Profile.displayName6(pdate);
			Profile.displayName7(pvaccine);
			Profile.displayName8(ptime);
			Profile.displayName9(pgender);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
}
	

	else
	{
	
		JOptionPane.showMessageDialog(null,"LOGIN FAILED!");

	}
	 conn.close();
	}
	catch (ClassNotFoundException e)
	{
	e.printStackTrace();
	}
	catch (SQLException e)
	{
	e.printStackTrace();
	}
	catch (Exception e1)
	{
		JOptionPane.showMessageDialog(null,e1);
	}
	}
}


@FXML
private PasswordField aptext;

@FXML
private TextField autext;

public void switchToAdmiModified(ActionEvent event) throws IOException {
	
	String au = autext.getText();
	String ap =  aptext.getText();
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccinationsystem","root","Hero@MYSQL8027");
		Statement stm = con.createStatement();
		String sql = "select * from adminlogin where user='"+au+"' and password='"+ap.toString()+"'";
		ResultSet rs = stm.executeQuery(sql);
		
		 if(rs.next())
		{
		
			 JOptionPane.showMessageDialog(null,"YOU'VE SUCCESSFULLY LOGGED IN!");
			
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("AdmiModified.fxml"));	
				root = loader.load();	
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
	}
		else
		{
			JOptionPane.showMessageDialog(null,"LOGIN FAILED!");
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


@FXML
private Label InfoLabel;
@FXML
private Text rtext;
@FXML
private Text aadhaartext;

@FXML
private Text agetext;

@FXML
private Text ctext;

@FXML
private Text datetext;
@FXML
private Text dotext;

@FXML
private Text gtext;
@FXML
private Text timetext;

@FXML
private Text vtext;

@FXML
private Label displayi;

@FXML
public void GET(ActionEvent event) throws IOException{
	
	try {
    Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccinationsystem","root","Hero@MYSQL8027");
	String sql="Select * from registerantprofile ";
	PreparedStatement psmt = con.prepareStatement(sql);
	
	ResultSet rs=psmt.executeQuery(sql);
	
	String a1 = "";
	String a2 = "";
	String a3 = "";
	String a4 = "";
	String a5 = "";
	String a6 = "";
	String a7 = "";
	String a8 = "";
	String a9 = "";
	int i = 0;
	while(rs.next()) { 
		
		System.out.println(rs.getString("Name")+rs.getString("DOB")+rs.getString("Age")+rs.getString("Gender")+rs.getString("Aadhaar")+rs.getString("Contact")+rs.getString("vaccine")+rs.getString("vaccinedate")+rs.getString("timeslot"));
		a1 = a1 +"\n"+ rs.getString("Name");
		a2 = a2 +"\n"+ rs.getString("DOB");
		a3 = a3 +"\n"+ rs.getString("Gender");
		a4 = a4 +"\n"+ rs.getString("Aadhaar");
		a5 = a5 +"\n"+ rs.getString("Contact");
		a6 = a6 +"\n"+ rs.getString("vaccine");
		a7 = a7 +"\n"+ rs.getString("vaccinedate");
		a8 = a8 +"\n"+ rs.getString("timeslot");
		a9 = a9 +"\n"+ rs.getString("Age");
		
		//InfoLabel.setText(a);
		i = i + 1;
		
	}
	System.out.println(i);
	displayi.setText(""+i);
	rtext.setText(a1);
	dotext.setText(a2);
	gtext.setText(a3);
	aadhaartext.setText(a4);
	ctext.setText(a5);
	vtext.setText(a6);
	datetext.setText(a7);
	timetext.setText(a8);
	agetext.setText(a9);
	//rtext.setText(a1);
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

@FXML
private Label laadhaar;

@FXML
private Label lage;

@FXML
private Label lame;

@FXML
private Label lcotact;

@FXML
private Label ldate;

@FXML
private Label ldo;

@FXML
private Label lgeder;

@FXML
private Label ltime;

@FXML
private Label lvaccie;
@FXML
private TextField text;

@FXML
public void SpecificInfo(ActionEvent event) throws IOException{
	try {
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccinationsystem","root","Hero@MYSQL8027");
	String sql1 = "select * from registerantprofile where Aadhaar=?";
	PreparedStatement psmt = conn.prepareStatement(sql1);
	psmt.setInt(1, Integer.parseInt(text.getText()));
	ResultSet rs1 = psmt.executeQuery();

 if(rs1.next()){

	 System.out.println(rs1.getString("Name"));
	 lame.setText(rs1.getString("Name"));
	 ldo.setText(rs1.getString("DOB"));
	 lage.setText(rs1.getString("Age"));
	 ldate.setText(rs1.getString("vaccinedate"));
	 lvaccie.setText(rs1.getString("vaccine"));
	 ltime.setText(rs1.getString("timeslot"));
	 lgeder.setText(rs1.getString("Gender"));
	 laadhaar.setText(rs1.getString("Aadhaar"));
	 lcotact.setText(rs1.getString("Contact"));
	}
 else
	{
	
		JOptionPane.showMessageDialog(null,"FAILED!");

	}
	 conn.close();
	}
	catch (SQLException e)
	{
	e.printStackTrace();
	}
	catch (Exception e1)
	{
		JOptionPane.showMessageDialog(null,e1);
	}
}
}