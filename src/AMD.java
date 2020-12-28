import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AMD extends Computer
	{
			
		AMD(String processor, String ramMemory, String hardDrive,
				String graphicsCard,String operatingSystem, 
				String mouse, String keyboard, String speakerSystem)
		{
			this.setProcessor(getProcessor());
			this.setRamMemory(ramMemory);
			this.setHardDrive(hardDrive);
			this.setGraphicsCard(graphicsCard);
			this.setOperatingSystem(operatingSystem);
			this.setMouse(getMouse());
			this.setKeyboard(getKeyboard());
			this.setSpeakerSystem(getSpeakerSystem());
			
			this.setPrice(599.00);
		}
		
		AMD()

		{
			setPrice(599.00);
			setProcessor("");
			setRamMemory("");
			setHardDrive("");
			setGraphicsCard("");
			setOperatingSystem("Windows 8.1");
			setMouse("USB Optical Mouse");
			setKeyboard("USB Wired Keyboard");
			setSpeakerSystem("2 Piece Powered Set");
		}
		
		public VBox AMDSceneSetter(AMD amd)
		{
			titleLabelSetter();
			
			AMDProcessorSetup(amd);
			
			GridPane amdScenePane = new GridPane();
			
			HBox titleLabelBox = new HBox(amd.titleLabelSetter());
			titleLabelBox.setAlignment(Pos.CENTER);
			titleLabelBox.setPadding(new Insets(10));
			
			amdScenePane.add(amd.AMDProcessorSetup(amd), 0, 0);
			amdScenePane.add(amd.ramSceneSetup(amd), 1, 0);
			amdScenePane.add(amd.hddSceneSetup(amd), 2, 0);
			amdScenePane.add(amd.dvdScene(amd), 2, 1);
			amdScenePane.add(amd.graphicsCardSceneSetup(amd), 0, 1);
			amdScenePane.add(amd.OSsceneSetup(amd), 1, 1);
			amdScenePane.add(appPackageScene(amd), 1, 3);
			
			priceLabel.setText(getTotalPriceString(amd));
			
			VBox amdSceneVbox = new VBox(titleLabelBox, amdScenePane, priceLabel);
			amdSceneVbox.setPadding(new Insets(10));
			
			return amdSceneVbox;
										
		}
		
		public HBox titleLabelSetter()
		{
			Label titleLabel = new Label("Customize your AMD system");
			
			HBox titleLabelHolder = new HBox(titleLabel);
			
			titleLabelHolder.setAlignment(Pos.CENTER);
			
			titleLabelHolder.setPadding(new Insets(20));
			
			return titleLabelHolder;
		}
		
		public VBox AMDProcessorSetup(AMD amd)
		{
			String [] procArray = {"FX2100", "FX8350", "FX9590", 
					"FX4100", "FX4300"};
			
			Label procLabel = new Label("Select your AMD Processor");
			
			CheckBox baseProcessorCheckbox = new CheckBox(procArray[0] + " - $0.00");
			CheckBox FX8350ProcessorCheckbox = new CheckBox(procArray[1] + " - $25.00");
			CheckBox FX9590ProcessorCheckbox = new CheckBox(procArray[2] + " - $90.00");
			CheckBox FX4100ProcessorCheckbox = new CheckBox(procArray[3] + " - $187.00");
			CheckBox FX4300ProcessorCheckbox = new CheckBox(procArray[4] + " - $280.00");
			
			baseProcessorCheckbox.setSelected(true);
			
			baseProcessorCheckbox.setOnAction(new EventHandler <ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event)
				{	
					FX8350ProcessorCheckbox.setSelected(false);
					FX9590ProcessorCheckbox.setSelected(false);
					FX4100ProcessorCheckbox.setSelected(false);
					FX4300ProcessorCheckbox.setSelected(false);
					
					amd.setProcPrice(0);
					
					amd.setProcessor(procArray[0]);
					
					priceLabel.setText(getTotalPriceString(amd));
					
				}
			});
			
			FX8350ProcessorCheckbox.setOnAction(new EventHandler <ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event)
				{
					baseProcessorCheckbox.setSelected(false);
					FX9590ProcessorCheckbox.setSelected(false);
					FX4100ProcessorCheckbox.setSelected(false);
					FX4300ProcessorCheckbox.setSelected(false);
					
					amd.setProcPrice(25);
					
					amd.setProcessor(procArray[1]);
					
					priceLabel.setText(getTotalPriceString(amd));
				}
			});
			
			FX9590ProcessorCheckbox.setOnAction(new EventHandler <ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event)
				{
					baseProcessorCheckbox.setSelected(false);
					FX8350ProcessorCheckbox.setSelected(false);
					FX4100ProcessorCheckbox.setSelected(false);
					FX4300ProcessorCheckbox.setSelected(false);
					
					amd.setProcPrice(90);
					
					amd.setProcessor(procArray[2]);
					
					priceLabel.setText(getTotalPriceString(amd));
				}
			});
			
			FX4100ProcessorCheckbox.setOnAction(new EventHandler <ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event)
				{
					baseProcessorCheckbox.setSelected(false);
					FX9590ProcessorCheckbox.setSelected(false);
					FX8350ProcessorCheckbox.setSelected(false);
					FX4300ProcessorCheckbox.setSelected(false);
					
					amd.setProcPrice(187);
					
					amd.setProcessor(procArray[3]);
					
					priceLabel.setText(getTotalPriceString(amd));
				}
			});
			
			FX4300ProcessorCheckbox.setOnAction(new EventHandler <ActionEvent>()
			{
				@Override
				public void handle(ActionEvent event)
				{
					baseProcessorCheckbox.setSelected(false);
					FX9590ProcessorCheckbox.setSelected(false);
					FX4100ProcessorCheckbox.setSelected(false);
					FX8350ProcessorCheckbox.setSelected(false);
					
					amd.setProcPrice(280);
					
					amd.setProcessor(procArray[4]);
					
					priceLabel.setText(getTotalPriceString(amd));
				}
			});
			
			VBox AMDProcessorvbox = new VBox();
			
			AMDProcessorvbox.getChildren().addAll(procLabel, baseProcessorCheckbox, FX8350ProcessorCheckbox,
					FX9590ProcessorCheckbox, FX4100ProcessorCheckbox, FX4300ProcessorCheckbox);
			
			AMDProcessorvbox.setPadding(new Insets(10));

			
			return AMDProcessorvbox;
		}
	}