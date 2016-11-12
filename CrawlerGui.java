package webcrawler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Label;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author nilesh
 */
public class CrawlerGui extends Application {

    static String url;
    static TextArea resultArea;
    static TextField tf1;
    @Override
    public void start(Stage primaryStage) {
        
        CrawlerGui.resultArea = new TextArea();
        Button btn = new Button();
        btn.setText("Start Crawling");
        TextField tf = new TextField();
        
        tf.setText("Enter the URL");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                url = tf.getText();
                System.out.println(url);
                new Consumer().Start();
            }
        });

        //layout
        GridPane grid = new GridPane();
        
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(300, 300);
        grid.setVgap(50);
        grid.setHgap(50);

        grid.add(tf, 0, 0);
        grid.add(btn, 1, 0);
        grid.add(CrawlerGui.resultArea,0,3);

        

        Scene scene = new Scene(grid, 500, 500);

        primaryStage.setTitle("Web Crawler");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
