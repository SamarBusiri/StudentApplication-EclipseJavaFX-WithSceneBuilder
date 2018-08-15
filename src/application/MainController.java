package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

	@FXML private TextField Name;
	@FXML private TextField Address;
	@FXML private TextField Province;
	@FXML private TextField City;
	@FXML private TextField PostalCode;
	@FXML private TextField PhoneNumber;
	@FXML private TextField Email;
	@FXML private CheckBox StudentCouncil;
	@FXML private CheckBox VolunteerWork;
	@FXML private RadioButton ComputerScience;
	@FXML private RadioButton Business;
    @FXML private Button Display;
	@FXML private TextArea textArea;
	@FXML private ComboBox<String> courses ;
	@FXML private ListView<String> lstCourses;
	int count = 0;
	String a[]=new String[4];



	@FXML private void onDisplayClicked() {
		String course="";
		String value1 = " ";
		String value2 = " ";
		String value3 =" ";
		ObservableList<String> courses = lstCourses.getItems();

		for (String each: courses)
		{
			course = course +each+System.lineSeparator() ;
		}

		if (StudentCouncil.isSelected()) {
			value1 = "Student Council" + System.lineSeparator();
		}
		if (VolunteerWork.isSelected()) {
			value2 = "Volunteer Work" ;
		}

		value3=(Name.getText() +", " +Address.getText() +", " +Province.getText() +", " +
				City.getText() +", " +PostalCode.getText() +", " +PhoneNumber.getText() +", " +Email.getText() + System.lineSeparator() + System.lineSeparator() + "course" );
		textArea.setText(value3 + course + System.lineSeparator() +"Additional Information"+ System.lineSeparator() +value1+ value2);

	}
	@FXML private void initialize()
	{
		ObservableList<String> ComputerScienceCourses = FXCollections.observableArrayList("Java", "Oracle", "C++");
		ObservableList<String> BusinessCourses = FXCollections.observableArrayList("Management", "Finance", "Accounting");


	if (ComputerScience.isSelected())
	{
		courses.setItems(ComputerScienceCourses);

	}else if (Business.isSelected())
	{
			courses.setItems(BusinessCourses);
	}
    }

	@FXML private void OnSelectCourse()
	{
		int check = 0;
		String userChoice = courses.getValue();
		lstCourses.getItems().add(userChoice);

        if(count<=3)
        {
		a[count]=userChoice;
		count++;
		}

        for(int i=0;i<=3;i++)
        {
        	if (userChoice == a[i])
        	{
        		check=1;
        		break;
        	}
        }
        if(check==0)
        	{}
     }




}
