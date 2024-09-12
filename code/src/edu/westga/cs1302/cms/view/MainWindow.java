package edu.westga.cs1302.cms.view;

import edu.westga.cs1302.cms.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Code behind for the MainWindow of the application
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
	@FXML
	private TextField name;
	@FXML
	private TextField grade;
	@FXML
	private ListView<Student> students;
	@FXML
	private Label averageLabel;

	@FXML
	void addStudent(ActionEvent event) {
		String studentName = this.name.getText();

		try {
			Double grade = Double.parseDouble(this.grade.getText());
			Student student = new Student(studentName, grade);
			this.students.getItems().add(student);
		} catch (NumberFormatException errorThing) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText(
					"Unable to create student: " + errorThing.getMessage() + ". Please reenter grade and try again.");
			errorPopup.showAndWait();

		} catch (IllegalArgumentException errorObject) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText(
					"Unable to create student: " + errorObject.getMessage() + ". Please reenter name and try again.");
			errorPopup.showAndWait();
		}
	}

	@FXML
	void removeStudent(ActionEvent event) {
		Student student = this.students.getSelectionModel().getSelectedItem();
		if (student != null) {
			this.students.getItems().remove(student);
		} else {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("No student selected. Unable to remove.");
			errorPopup.showAndWait();

		}
	}
		
	@FXML
	void getAverageClicked(ActionEvent event) {
		double sum = 0.0;
		int size = this.students.getItems().size();
		for (Student currStudent : this.students.getItems()) {
			sum += currStudent.getGrade();
		}
		double average = sum / size;
		this.averageLabel.setText("Average: " + String.format("%.2f", average));
	    }

	@FXML
	void initialize() {
		assert this.name != null : "fx:id=\"name\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.students != null : "fx:id=\"students\" was not injected: check your FXML file 'MainWindow.fxml'.";

		this.students.getSelectionModel().selectedItemProperty().addListener((obs, oldStudent, newStudent) -> {
			Alert errorPopup = new Alert(Alert.AlertType.INFORMATION);
			errorPopup.setContentText("Student's grade is: " + newStudent.getGrade());
			errorPopup.showAndWait();
		});
	}

}
