package graphicsAndControl;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import records.RecordInfo;
import records.Records;
import sortAndSearch.SortByMarks;
import sortAndSearch.SortByName;

import java.util.ArrayList;

public class MainController {
    public TextField IDStudentName, IDStudentId, IDStudentMarks;
    public Button IDSave;

    private final ArrayList<RecordInfo> list = new Records().getList();

    public void onPreSavedClicked() {
        showTheList("PreSaved Records", 1);
    }


    private void showTheList(String title, int token) {
        Stage stage = new Stage();
        stage.setTitle(title);
        VBox root = new VBox();
        root.setPadding(new Insets(100));

        Label[] labels = new Label[list.size()];

        if (token == 1){
            for (int i = 0; i < list.size(); i++) {
                labels[i] = new Label(list.get(i).getName() + " ----> " +
                        list.get(i).getID() + " ----> " +
                        list.get(i).getMarks());

                labels[i].setFont(new Font(25));
                root.getChildren().add(labels[i]);
            }
        }
        else if (token == 2){
            for (int i = 0; i < list.size(); i++) {
                labels[i] = new Label(list.get(i).getMarks() + " ----> " +
                        list.get(i).getID() + " ----> " +
                        list.get(i).getName());

                labels[i].setFont(new Font(25));
                root.getChildren().add(labels[i]);
            }
        }
        else if (token == 3){
            for (int i = 0; i < list.size(); i++){
                String grades = "C";

                if(list.get(i).getMarks() >= 560) grades = "A+";
                else if(list.get(i).getMarks() >= 550) grades = "A";
                else if(list.get(i).getMarks() >= 540) grades = "B+";
                else if(list.get(i).getMarks() >= 530) grades = "B";
                else if(list.get(i).getMarks() >= 520) grades = "C";

                labels[i] = new Label(list.get(i).getName() + " ----> " + grades);
                labels[i].setFont(new Font(25));
                root.getChildren().add(labels[i]);
            }
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @implNote after clicking the save button the inputField name, id & marks
     * get the inputs from the user and create a new Object of
     * RecordInfo class then finally add that object to the Records.
     *
     * Finally, all input field replaced with empty string just because
     * user won't need to clear the inputs he just gave and can input another
     * input if he wants.
     */
    public void saveButtonClicked() {
        String name = IDStudentName.getText();
        String id = IDStudentId.getText();
        int marks = Integer.parseInt(IDStudentMarks.getText());

        RecordInfo info = new RecordInfo(name, id, marks);
        list.add(info);

        IDStudentName.setText("");
        IDStudentId.setText("");
        IDStudentMarks.setText("");
    }

    /**
     * @implSpec This method sort the list in alphabetical order based on Records name.
     * @implNote quicksort method being called that belongs to SortByName class.
     * three parameters sent to the method the ArrayList named list,
     * 0 as the lower index of the list and (list.size - 1) as the higher index.
     *
     * at last, showTheList method have been called and a string and a token number
     * sent as parameter.
     */
    public void onSortByNameClicked() {
        new SortByName().quickSort(list, 0, list.size() - 1);
        showTheList("Sort by names", 1);
    }

    /**
     * @implSpec This method sort the list in ascending order based on Records marks.
     * @implNote works as same as the previous onSortByNameClicked method.
     */
    public void onSortByMarksClicked() {
        new SortByMarks().quickSort(list, 0, list.size() - 1);
        showTheList("Sort by marks", 2);
    }

    public void onSpecificReportClicked() {
        //TODO
    }

    public void onStudentGradesClicked() {
        showTheList("All students Grades", 3);
    }

    public void onModifyClicked() {
        //TODO
    }

    public void onDeleteClicked() {
        //TODO
    }
}


