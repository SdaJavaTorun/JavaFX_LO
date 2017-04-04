package com.sdajava.simplegui;

import com.sdajava.simplegui.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Person> personData = FXCollections.observableArrayList();


    public Main(){

        personData.addAll(new Person("Test", "Test2"));
        personData.addAll(new Person("Test", "Test2"));
        personData.addAll(new Person("Test", "Test2"));
        personData.addAll(new Person("Test", "Test2"));
        personData.addAll(new Person("Test", "Test2"));
        personData.addAll(new Person("Test", "Test2"));
        personData.addAll(new Person("Test", "Test2"));
        personData.addAll(new Person("Test", "Test2"));


    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("Ksiazka adresowa");

            initRootLayout();
            showPersonOverview();

    }

    public void initRootLayout(){


        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout =  fxmlLoader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);

            PersonOverviewController controller = loader.getController();
            controller.setMain(this);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
