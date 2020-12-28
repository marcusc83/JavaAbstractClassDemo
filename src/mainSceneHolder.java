import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class mainSceneHolder extends Computer
	{
		
		public Scene mainSceneceneSetter(Stage PrimaryStage)
		{
		//creating baseSystem layout, this will let them choose either
				//Amd or Intel and then give options for the 
				//rest of the components
				Label baseSystemLabel = new Label("You can choose from one of the"
						+ " following systems, and than cusomtize"
						+ " it");
				baseSystemLabel.setPadding(new Insets(10));
				
				//keeps track of the running total and displays it
				Label runningTotalLabel = new Label("Total:");
				runningTotalLabel.setPadding(new Insets(10));
				
				//creating toggle group so only one button can 
				//be selected at once
				ToggleGroup radioButtonsGroup = new ToggleGroup();
				
				//creating two radio buttons for choice between two scenes
				RadioButton AMDButton = new RadioButton("AMD base configuration "
						+ "starts at $599.00");
				AMDButton.setPadding(new Insets(10));
				
				RadioButton IntelButton = new RadioButton("Intel Base configuration "
						+ "starts at $499.00");
				IntelButton.setPadding(new Insets(10));
				
				AMDButton.setToggleGroup(radioButtonsGroup);
				IntelButton.setToggleGroup(radioButtonsGroup);
				
				//starting with both boxes unchecked
				AMDButton.setSelected(false);
				IntelButton.setSelected(false);
				
				//creating HBox for the radio buttons
				HBox radiobuttonshbox = new HBox(AMDButton, IntelButton);
				radiobuttonshbox.setPadding(new Insets(10));
				radiobuttonshbox.setAlignment(Pos.CENTER);
				
				
				//vbox to contain all other child boxes
				VBox root = new VBox(baseSystemLabel, radiobuttonshbox);
				root.setMinSize(900, 600);
				root.setPadding(new Insets(15));
				root.setAlignment(Pos.CENTER);
				
				Button backButton = new Button("Back");
				backButton.setPadding(new Insets(10));
				backButton.setAlignment(Pos.TOP_RIGHT);
				
				backButton.setOnAction(new EventHandler <ActionEvent> ()
				{
					@Override
					public void handle(ActionEvent event)
					{
						root.getChildren().clear();
						PrimaryStage.setScene(mainSceneceneSetter(PrimaryStage));
					}
				});
				
				Button checkoutButton = new Button("Checkout");
				checkoutButton.setPadding(new Insets(10));
				checkoutButton.setAlignment(Pos.BOTTOM_RIGHT);
				
				
										
				AMDButton.setOnAction(new EventHandler <ActionEvent>()
				{
					@Override
					public void handle(ActionEvent event)
					{
						AMD amd = new AMD();
						
						priceLabel.setText(getTotalPriceString(amd));
						
						checkoutButton.setOnAction(new EventHandler <ActionEvent>()
						{
							@Override
							public void handle(ActionEvent event)
							{
								root.getChildren().clear();
								root.getChildren().add(checkOutScene(amd));
							}
						});
						
						amd.setBaseSystem("AMD");
						
						root.getChildren().clear();
						
						root.getChildren().addAll(backButton, amd.AMDSceneSetter(amd),
													checkoutButton);
					}
					
				});
				
				
				IntelButton.setOnAction(new EventHandler <ActionEvent>()
				{
					@Override
					public void handle(ActionEvent event)
					{
						Intel intel = new Intel();
						
						intel.setBaseSystem("Intel");
						
						priceLabel.setText(getTotalPriceString(intel));
						
						checkoutButton.setOnAction(new EventHandler <ActionEvent>()
						{
							@Override
							public void handle(ActionEvent event)
							{
								root.getChildren().clear();
								root.getChildren().add(checkOutScene(intel));
							}
						});
						
						root.getChildren().clear();
						
						root.getChildren().addAll(backButton, intel.intelSceneSetter(intel),
											checkoutButton);
					}
				});
				
				Scene scene = new Scene(root);
				return scene;
		}
		
	}