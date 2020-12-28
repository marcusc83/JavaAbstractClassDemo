import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Intel extends Computer
{
	final private String [] procArray = {"G1610", "G1620 2.70GHz", "G1630 2.80GHz", 
			"G1820 2.70GHz", "G1830 2.80GHz"};
	
	Intel(String processor, String ramMemory, String hardDrive,
			String graphicsCard,String operatingSystem, 
			String mouse, String keyboard, String speakerSystem)
	{
		this.setProcessor(processor);
		this.setRamMemory(ramMemory);
		this.setHardDrive(hardDrive);
		this.setGraphicsCard(graphicsCard);
		this.setOperatingSystem(operatingSystem);
		this.setMouse(getMouse());
		this.setKeyboard(getKeyboard());
		this.setSpeakerSystem(getSpeakerSystem());
		this.setPrice(499.00);
	}
	
	Intel()
	{
		this.setProcessor(getProcArray(0));
		this.setRamMemory(getRamMemory());
		this.setHardDrive(getHardDrive());
		this.setGraphicsCard(getGraphicsCard());
		this.setOperatingSystem(getOperatingSystem());
		this.setMouse(getMouse());
		this.setKeyboard(getKeyboard());
		this.setSpeakerSystem(getSpeakerSystem());
		this.setPrice(499.00);
	}
	
	public String getProcArray(int i)
	{
		return procArray[i];
	}
	
	public HBox intelTitleSetter()
	{
		Label intelTitleLabel = new Label("Customize your Intel system");
		
		HBox intelTitleHbox = new HBox(intelTitleLabel);
		
		intelTitleHbox.setPadding(new Insets(10));
		
		intelTitleHbox.setAlignment(Pos.CENTER);
		
		return intelTitleHbox;
		
	}
	
	public VBox intelSceneSetter(Intel intel)
	{
		
		GridPane intelScenePane = new GridPane();
		
		HBox titleLabelBox = new HBox(intel.intelTitleSetter());
		titleLabelBox.setAlignment(Pos.CENTER);
		titleLabelBox.setPadding(new Insets(10));
		
		intelScenePane.add(intel.intelProcSetup(intel), 0, 0);
		intelScenePane.add(intel.ramSceneSetup(intel), 1, 0);
		intelScenePane.add(intel.hddSceneSetup(intel), 2, 0);
		intelScenePane.add(intel.dvdScene(intel), 2, 1);
		intelScenePane.add(intel.graphicsCardSceneSetup(intel), 0, 1);
		intelScenePane.add(intel.OSsceneSetup(intel), 1, 1);
		intelScenePane.add(appPackageScene(intel), 1, 3);
		
		priceLabel.setText(getTotalPriceString(intel));
		
		VBox intelSceneVbox = new VBox(titleLabelBox, intelScenePane, priceLabel);
		intelSceneVbox.setPadding(new Insets(10));
		
		
		return intelSceneVbox;
	}
	
	public VBox intelProcSetup(Intel intel)
	{
		Label procLabel = new Label("Select your Intel Processor");
		
		CheckBox baseProcessorCheckbox = new CheckBox(getProcArray(0) + " - $0.00");
		CheckBox G1620ProcessorCheckbox = new CheckBox(getProcArray(1) + " - $50.00");
		CheckBox G1630ProcessorCheckbox = new CheckBox(getProcArray(2)+ " - $90.00");
		CheckBox G1820ProcessorCheckbox = new CheckBox(getProcArray(3) + " - $105.00");
		CheckBox G1830ProcessorCheckbox = new CheckBox(getProcArray(4) + " - $130.00");
		
		baseProcessorCheckbox.setSelected(true);
		
		baseProcessorCheckbox.setOnAction(event ->
		{
			G1620ProcessorCheckbox.setSelected(false);
			G1630ProcessorCheckbox.setSelected(false);
			G1820ProcessorCheckbox.setSelected(false);
			G1830ProcessorCheckbox.setSelected(false);
			
			intel.setProcPrice(0);
			
			intel.setProcessor(getProcArray(0));
			
			priceLabel.setText(getTotalPriceString(intel));
		});
		
		G1620ProcessorCheckbox.setOnAction(event ->
		{
			baseProcessorCheckbox.setSelected(false);
			G1630ProcessorCheckbox.setSelected(false);
			G1820ProcessorCheckbox.setSelected(false);
			G1830ProcessorCheckbox.setSelected(false);
			
			intel.setProcPrice(50);
			
			intel.setProcessor(getProcArray(1));
			
			priceLabel.setText(getTotalPriceString(intel));
		});
		
		G1630ProcessorCheckbox.setOnAction(event ->
		{
			baseProcessorCheckbox.setSelected(false);
			G1620ProcessorCheckbox.setSelected(false);
			G1820ProcessorCheckbox.setSelected(false);
			G1830ProcessorCheckbox.setSelected(false);
			
			intel.setProcPrice(90);
			
			intel.setProcessor(getProcArray(2));
			
			priceLabel.setText(getTotalPriceString(intel));
		});
		
		G1820ProcessorCheckbox.setOnAction(event ->
		{
			baseProcessorCheckbox.setSelected(false);
			G1620ProcessorCheckbox.setSelected(false);
			G1630ProcessorCheckbox.setSelected(false);
			G1830ProcessorCheckbox.setSelected(false);
			
			intel.setProcPrice(105);
			
			intel.setProcessor(getProcArray(3));
			
			priceLabel.setText(getTotalPriceString(intel));
		});
		
		G1830ProcessorCheckbox.setOnAction(event ->
		{
			baseProcessorCheckbox.setSelected(false);
			G1630ProcessorCheckbox.setSelected(false);
			G1820ProcessorCheckbox.setSelected(false);
			G1620ProcessorCheckbox.setSelected(false);
			
			intel.setProcPrice(130);
			
			intel.setProcessor(getProcArray(4));
			
			priceLabel.setText(getTotalPriceString(intel));
		});
		
		VBox IntelProcessorvbox = new VBox();
		
		IntelProcessorvbox.getChildren().addAll(procLabel, baseProcessorCheckbox, G1620ProcessorCheckbox,
				G1630ProcessorCheckbox, G1820ProcessorCheckbox, G1830ProcessorCheckbox);
		
		IntelProcessorvbox.setPadding(new Insets(10));
		
		return IntelProcessorvbox;
		
	}
}
