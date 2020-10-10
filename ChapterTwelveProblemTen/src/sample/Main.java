package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.Random;

public class Main extends Application {

    private double totalAmountWon =0.0;
    @Override
    public void start(Stage primaryStage) throws Exception
    {

        // 3 images
//        Image strawberry = new Image("file:src/Strawberry.bmp");
//        Image cherry = new Image("file:src/Cherries.bmp");
//        Image grape = new Image("file:src/Grapes.bmp");

        // 3 imageviews
        ImageView fruitOnePicture = new ImageView();
        ImageView fruitTwoPicture = new ImageView();
        ImageView fruitThreePicture = new ImageView();

        HBox fruitImagesHBox = new HBox(20,fruitOnePicture,fruitTwoPicture,fruitThreePicture);
        fruitImagesHBox.setAlignment(Pos.CENTER);
        fruitImagesHBox.setPadding(new Insets(10));

        // Spin button
        Button spinButton = new Button("Spin");

        // Label "Amount Inserted"
        Label amountInsertedLabel = new Label("Amount Inserted: $");
        // TextBox for user amount inserted
        TextField amountInsertedTextField = new TextField();
        // HBox for amount inserted Information
        HBox amountInsertedHBox = new HBox(20,amountInsertedLabel, amountInsertedTextField);

        // Label for "Amount won this spin"
        Label amountWonThisSpinLabel = new Label("Amount Won This Spin: $");
        // Label for "Total Amount Won"
        Label totalAmountWonLabel = new Label("Total Amount Won: $");

        spinButton.setOnAction(e->{
            int[] randomNumbers = new int[3];
            Image[] randomFruits = new Image[3];
            int randomNumber;
            Random rng = new Random();

//            if(amountInsertedTextField.getText().equals("")|| amountInsertedTextField.getText() == null)
//            {
//
//            }


            // Input Validation
            if(!(Objects.equals(amountInsertedTextField.getText(), "") || amountInsertedTextField.getText() == null) && Double.parseDouble(amountInsertedTextField.getText()) >=0)
            {


                for (int i = 0; i < randomNumbers.length; i++)
                {
                    randomNumber = rng.nextInt(3);
                    randomNumbers[i] = randomNumber;
                }

                for (int k = 0; k < randomFruits.length; k++)
                {
                    if (randomNumbers[k] == 0)
                    {
                        randomFruits[k] = new Image("file:src/Strawberry.bmp");
                    }
                    else if (randomNumbers[k] == 1)
                    {
                        randomFruits[k] = new Image("file:src/Cherries.bmp");
                    }
                    else if (randomNumbers[k] == 2)
                    {
                        randomFruits[k] = new Image("file:src/Grapes.bmp");
                    }

                }

                for (int n = 0; n < 4; n++)   // Check out later
                {
                    if (n == 0)
                    {
                        fruitOnePicture.setImage(randomFruits[n]);
                    }
                    else if (n == 1)
                    {
                        fruitTwoPicture.setImage(randomFruits[n]);
                    }
                    else if (n == 2)
                    {
                        fruitThreePicture.setImage(randomFruits[n]);
                    }

                }

                // Winning money logic

                // 3 matches
                if (randomNumbers[0] == randomNumbers[1] && randomNumbers[0] == randomNumbers[2])
                {
                    double amountWonOnThisSpin = Double.parseDouble(amountInsertedTextField.getText()) * 3;
                    amountWonThisSpinLabel.setText("Amount Won This Spin: $" + amountWonOnThisSpin);

                    totalAmountWon += amountWonOnThisSpin;
                    totalAmountWonLabel.setText("Total Amount Won: $" + totalAmountWon);
                }
                // 2 matches
                else if (randomNumbers[0] == randomNumbers[1] || randomNumbers[0] == randomNumbers[2] || randomNumbers[1] == randomNumbers[2])
                {
                    double amountWonOnThisSpin = Double.parseDouble(amountInsertedTextField.getText()) * 2;
                    amountWonThisSpinLabel.setText("Amount Won This Spin: $" + amountWonOnThisSpin);

                    totalAmountWon += amountWonOnThisSpin;
                    totalAmountWonLabel.setText("Total Amount Won: $" + totalAmountWon);
                }
                else
                {
                    double amountWonOnThisSpin = Double.parseDouble(amountInsertedTextField.getText()) * 0;
                    amountWonThisSpinLabel.setText("Amount Won This Spin: $" + amountWonOnThisSpin);

                    totalAmountWon += amountWonOnThisSpin;
                    totalAmountWonLabel.setText("Total Amount Won: $" + totalAmountWon);
                }


                // Set the scene / stage
                primaryStage.setTitle("Slot Machine Results");
                primaryStage.show();

            }
            else if(amountInsertedTextField.getText().equals(""))
            {
                primaryStage.show();
            }
        });




        // put images into an HBox



        // put labels into Vbox
        VBox amountsVBox = new VBox(20,amountWonThisSpinLabel,totalAmountWonLabel);

        // Hbox Middle section
        HBox amountControlsHBox = new HBox(50, amountInsertedHBox, amountsVBox);

        HBox spinHBox = new HBox(20, spinButton);
        spinHBox.setAlignment(Pos.CENTER);
        spinHBox.setPadding(new Insets(10));

        // VBOX | Row of images | Hbox for amount inserted and labels | Spin button
        VBox fullMenu = new VBox(20,fruitImagesHBox, amountControlsHBox,spinHBox);
        fullMenu.setAlignment(Pos.CENTER);
        fullMenu.setPadding(new Insets(10));

        // Set Scene
        Scene firstScene = new Scene(fullMenu, 500, 500);

        // Set stage
        primaryStage.setScene(firstScene);
        primaryStage.setTitle("Welcome to the Casino!");
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
