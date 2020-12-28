import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public abstract class Computer {
	Label priceLabel = new Label();
	private String baseSystem = null;
	double price = 0;
	private String processor = "";
	private double procPrice = 0;
	private String ramMemory = "";
	private double ramPrice = 0;
	private String hardDrive = "";
	private double hardDrivePrice = 0;
	private String graphicsCard = "";
	private double graphicsCardPrice = 0;
	private String operatingSystem = "Windows 8.1";
	private double osPrice = 0;
	private String mouse = "USB Optical Mouse";
	private String keyboard ="USB Wired Keyboard";
	private String speakerSystem = "2 Piece Powered Speaker Set";
	private String dvdMedia = null;
	private double dvdMediaPrice = 0;
	private String appPackages = "";
	private double appPackageCost = 0;
	
	public void setBaseSystem(String baseSystem)
	{
		this.baseSystem = baseSystem;
	}
	
	public String getBaseSystem() 
	{
		return baseSystem;
	}
	
		public double getPrice()
	{
			return price;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public double getTotalPrice(Computer comp)
	{
		double totalPrice = getPrice() + getProcPrice() + getRamPrice() + 
				getHardDrivePrice() + getGraphicsCardPrice() +
				getOsPrice() + getDvdMediaPrice() + getAppPackageCost();
		
		return totalPrice;
	}
	
	public String getTotalPriceString(Computer comp)
	{
		String totPrice = "Cost: $" + String.valueOf(getTotalPrice(comp));
		
		return totPrice;
	}
	
	public String getProcessor() 
	{
		return processor;
	}

	public void setProcessor(String processor) 
	{
		this.processor = processor;
	}
	
	public void setProcPrice(double procPrice)
	{
		this.procPrice = procPrice;
	}
	
	public double getProcPrice() 
	{
		return procPrice;
	}

	public String getRamMemory() 
	{
		return ramMemory;
	}

	public void setRamMemory(String ramMemory) 
	{
		this.ramMemory = ramMemory;
	}
	
	public void setRamPrice(double ramPrice)
	{
		this.ramPrice = ramPrice;
	}
	
	public double getRamPrice()
	{
		return ramPrice;
	}

	public String getHardDrive() 
	{
		return hardDrive;
	}

	public void setHardDrive(String hardDrive) 
	{
		this.hardDrive = hardDrive;
	}
	
	public void setHardDrivePrice(double hardDrivePrice)
	{
		this.hardDrivePrice = hardDrivePrice;
	}

	public double getHardDrivePrice()
	{
		return hardDrivePrice;
	}
	
	public String getGraphicsCard() 
	{
		return graphicsCard;
	}

	public void setGraphicsCard(String graphicsCard) 
	{
		this.graphicsCard = graphicsCard;
	}
	
	public double getGraphicsCardPrice()
	{
		return graphicsCardPrice;
	}
	
	public void setGraphicsCardPrice(double graphicsCardPrice)
	{
		this.graphicsCardPrice = graphicsCardPrice;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public double getOsPrice() {
		return osPrice;
	}

	public void setOsPrice(double osPrice) {
		this.osPrice = osPrice;
	}

	public String getMouse() {
		return mouse;
	}

	public void setMouse(String mouse) {
		this.mouse = mouse;
	}

	public String getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(String keyboard) {
		this.keyboard = keyboard;
	}

	public String getSpeakerSystem() {
		return speakerSystem;
	}

	public void setSpeakerSystem(String speakerSystem) 
	{
		this.speakerSystem = speakerSystem;
	}
	
	public void setDvdMedia(String dvdMedia)
	{
		this.dvdMedia = dvdMedia;
	}
	
	public String getDvdMedia()
	{
		return dvdMedia;
	}
	
	public double getDvdMediaPrice() {
		return dvdMediaPrice;
	}

	public void setDvdMediaPrice(double dvdMediaPrice) {
		this.dvdMediaPrice = dvdMediaPrice;
	}

	public String getAppPackages() {
		return appPackages;
	}

	public void setAppPackages(String appPackages) {
		this.appPackages = appPackages;
	}

	public double getAppPackageCost() {
		return appPackageCost;
	}

	public void setAppPackageCost(double appPackageCost) {
		this.appPackageCost = appPackageCost;
	}

	public VBox ramSceneSetup(Computer comp)
	{
		String [] ramArray = {"4GB", "6GB", "8GB",
				"12GB", "16GB"};
		
		Label ramBoxLabel = new Label("Select your RAM memory");
		
		CheckBox baseRam = new CheckBox(ramArray[0] + " - $0");
		CheckBox sixRam = new CheckBox(ramArray[1] + " - $28");
		CheckBox eightRam = new CheckBox(ramArray[2] + " - $58");
		CheckBox twelveRam = new CheckBox(ramArray[3] + " - $108");
		CheckBox sixteenRam = new CheckBox(ramArray[4] + " - $176");
		
		baseRam.setSelected(true);
		
		baseRam.setOnAction(event ->
		{
				sixRam.setSelected(false);
				eightRam.setSelected(false);
				twelveRam.setSelected(false);
				sixteenRam.setSelected(false);
				
				comp.setRamMemory(ramArray[0]);
				
				comp.setRamPrice(0);
				
				priceLabel.setText(getTotalPriceString(comp));
		});
		
		sixRam.setOnAction(event ->
		{
				baseRam.setSelected(false);
				eightRam.setSelected(false);
				twelveRam.setSelected(false);
				sixteenRam.setSelected(false);
				
				comp.setRamPrice(28);
				
				comp.setRamMemory(ramArray[1]);
				
				priceLabel.setText(getTotalPriceString(comp));
		});
		
		eightRam.setOnAction(event ->
		{
				sixRam.setSelected(false);
				baseRam.setSelected(false);
				twelveRam.setSelected(false);
				sixteenRam.setSelected(false);
				
				comp.setRamMemory(ramArray[2]);
				
				comp.setRamPrice(58);
				
				priceLabel.setText(getTotalPriceString(comp));
		});
		
		twelveRam.setOnAction(event ->
		{
				sixRam.setSelected(false);
				baseRam.setSelected(false);
				eightRam.setSelected(false);
				sixteenRam.setSelected(false);
				
				comp.setRamMemory(ramArray[3]);
				
				comp.setRamPrice(108);
				
				priceLabel.setText(getTotalPriceString(comp));
		});
		
		sixteenRam.setOnAction(event ->
		{
				sixRam.setSelected(false);
				baseRam.setSelected(false);
				twelveRam.setSelected(false);
				eightRam.setSelected(false);
				
				comp.setRamMemory(ramArray[4]);
				
				comp.setRamPrice(176);
				
				priceLabel.setText(getTotalPriceString(comp));
		});
		
		VBox ramCheckBoxVBox = new VBox(ramBoxLabel, baseRam, sixRam, eightRam, twelveRam,
				sixteenRam);
		
		ramCheckBoxVBox.setPadding(new Insets(10));
		
		return ramCheckBoxVBox;
				
	}

	public VBox hddSceneSetup(Computer comp)
	{
		String [] hddArray = {"128GB HDD", "250GB HDD", "500GB HDD", "1TB HDD"};
		
		CheckBox baseHDD = new CheckBox(hddArray[0] + " - $0");
		CheckBox twoFiftyHDD = new CheckBox(hddArray[1] + " - $27");
		CheckBox fiveHunHDD = new CheckBox(hddArray[2] + " - $50");
		CheckBox oneTBHDD = new CheckBox(hddArray[3] + " - $89");
		
		baseHDD.setSelected(true); 
		
		baseHDD.setOnAction(event ->
		{
			twoFiftyHDD.setSelected(false);
			fiveHunHDD.setSelected(false);
			oneTBHDD.setSelected(false);
			
			comp.setHardDrive(hddArray[0]);
			
			comp.setHardDrivePrice(0);
			
			priceLabel.setText(getTotalPriceString(comp));
		});
		
		twoFiftyHDD.setOnAction(event ->
		{
			baseHDD.setSelected(false);
			fiveHunHDD.setSelected(false);
			oneTBHDD.setSelected(false);
			
			comp.setHardDrive(hddArray[1]);
			
			comp.setHardDrivePrice(27);
			
			priceLabel.setText(getTotalPriceString(comp));
		});
		
		fiveHunHDD.setOnAction(event ->
		{
			baseHDD.setSelected(false);
			twoFiftyHDD.setSelected(false);
			oneTBHDD.setSelected(false);
			
			comp.setHardDrive(hddArray[2]);
			
			comp.setHardDrivePrice(50);
			
			priceLabel.setText(getTotalPriceString(comp));
		});
		
		oneTBHDD.setOnAction(event ->
		{
			baseHDD.setSelected(false);
			twoFiftyHDD.setSelected(false);
			fiveHunHDD.setSelected(false);
			
			comp.setHardDrive(hddArray[3]);
			
			comp.setHardDrivePrice(89);
			
			priceLabel.setText(getTotalPriceString(comp));
		});
		
		Label hddLabel = new Label("Select your HDD");
		
		VBox hddVbox = new VBox(hddLabel, baseHDD, twoFiftyHDD, fiveHunHDD, oneTBHDD);
		
		hddVbox.setPadding(new Insets(10));
		
		return hddVbox;
	}
	
	public VBox dvdScene(Computer comp)
	{
		Label dvdLabel = new Label("Select your DVD setup");
		
		String [] dvdArray = {"DVD Drive", "Combo DVD/CDRW", "DVD and CDRW", "none"};
		
		CheckBox noDvdBox = new CheckBox(dvdArray[3]);
		CheckBox dvdCheckbox = new CheckBox(dvdArray[0] + " - $17");
		CheckBox comboCheckbox = new CheckBox(dvdArray[1] + " - $40");
		CheckBox dvdAndCDRWCheckBox = new CheckBox(dvdArray[2] + " - $79");
		
		noDvdBox.setSelected(true);
		
		noDvdBox.setOnAction(event ->
		{
			dvdCheckbox.setSelected(false);
			comboCheckbox.setSelected(false);
			dvdAndCDRWCheckBox.setSelected(false);
			
			comp.setDvdMediaPrice(0);
			
			comp.setDvdMedia(dvdArray[3]);	
			
			priceLabel.setText(getTotalPriceString(comp));
		});
		
		dvdCheckbox.setOnAction(event ->
		{
			noDvdBox.setSelected(false);
			comboCheckbox.setSelected(false);
			dvdAndCDRWCheckBox.setSelected(false);
			
			comp.setDvdMediaPrice(17);
			
			comp.setDvdMedia(dvdArray[0]);
			
			priceLabel.setText(getTotalPriceString(comp));
		});
		
		comboCheckbox.setOnAction(event ->
		{
			noDvdBox.setSelected(false);
			dvdCheckbox.setSelected(false);
			dvdAndCDRWCheckBox.setSelected(false);
			
			comp.setDvdMediaPrice(40);
			
			comp.setDvdMedia(dvdArray[1]);
			
			priceLabel.setText(getTotalPriceString(comp));
		});
		
		dvdAndCDRWCheckBox.setOnAction(event ->
		{
			noDvdBox.setSelected(false);
			dvdCheckbox.setSelected(false);
			comboCheckbox.setSelected(false);
			
			comp.setDvdMediaPrice(79);
			
			comp.setDvdMedia(dvdArray[2]);
			
			priceLabel.setText(getTotalPriceString(comp));
		});
		
		VBox dvdVbox = new VBox(dvdLabel, noDvdBox, dvdCheckbox, comboCheckbox, dvdAndCDRWCheckBox);
		dvdVbox.setPadding(new Insets(10));
		
		return dvdVbox;
		
	}
	
	public VBox graphicsCardSceneSetup(Computer comp)
	{
		Label graphicsCardLabel = new Label("Select Your Graphics card");
		
		String [] graphicArray = {"None", "NVIDA GeForce G310 512MB DDR3", "NVIDA GeForce GT620 1GB DDR3",
				"NVIDA GeForce GT640 1GB GDDR5"};
		
		CheckBox none = new CheckBox(graphicArray[0]);
		CheckBox GForceG310 = new CheckBox(graphicArray[1] + " - $80");
		CheckBox GForceGT620 = new CheckBox(graphicArray[2] + " - $169");
		CheckBox GForceGT640 = new CheckBox(graphicArray[3] + " - $490");
		
		none.setSelected(true);
		
		none.setOnAction(event ->
		{
			GForceG310.setSelected(false);
			GForceGT620.setSelected(false);
			GForceGT640.setSelected(false);
			
			comp.setGraphicsCardPrice(0);
			
			comp.setGraphicsCard(graphicArray[0]);
			
			priceLabel.setText(getTotalPriceString(comp));
		});
		
		GForceG310.setOnAction(event ->
		{
			none.setSelected(false);
			GForceGT620.setSelected(false);
			GForceGT640.setSelected(false);
			
			comp.setGraphicsCardPrice(80);
			
			comp.setGraphicsCard(graphicArray[1]);
			
			priceLabel.setText(getTotalPriceString(comp));
		});
		
		GForceGT620.setOnAction(event ->
		{
			none.setSelected(false);
			GForceG310.setSelected(false);
			GForceGT640.setSelected(false);
			
			comp.setGraphicsCardPrice(169);
			
			comp.setGraphicsCard(graphicArray[2]);
			
			priceLabel.setText(getTotalPriceString(comp));
		});
		
		GForceGT640.setOnAction(event ->
		{
			none.setSelected(false);
			GForceG310.setSelected(false);
			GForceGT620.setSelected(false);
			
			comp.setGraphicsCardPrice(490);
			
			comp.setGraphicsCard(graphicArray[3]);
			
			priceLabel.setText(getTotalPriceString(comp));
		});
		
		VBox graphicsVbox = new VBox(graphicsCardLabel, none, GForceG310, GForceGT620, GForceGT640);
		graphicsVbox.setPadding(new Insets(10));
		
		return graphicsVbox;
	}
	
	public VBox OSsceneSetup(Computer comp) 
	{
		Label osLabel = new Label("Select you Operating System");
		
		String [] osArray = {	"Windows 8.1", "Windows 8.1 Pro",
								"Linux"};
		
		CheckBox baseOSCheckbox = new CheckBox(osArray[0]);
		CheckBox winProCheckbox = new CheckBox(osArray[1]);
		CheckBox linuxCheckbox = new CheckBox(osArray[2]);
		
		baseOSCheckbox.setSelected(true);
		
		baseOSCheckbox.setOnAction(event ->
		{
			winProCheckbox.setSelected(false);
			linuxCheckbox.setSelected(false);
			
			comp.setOsPrice(0);
			
			comp.setOperatingSystem(osArray[0]);
			
			priceLabel.setText(getTotalPriceString(comp));
		});
		
		winProCheckbox.setOnAction(event ->
		{
			baseOSCheckbox.setSelected(false);
			linuxCheckbox.setSelected(false);
			
			comp.setOperatingSystem(osArray[1]);
			
			comp.setOsPrice(59);
			
			priceLabel.setText(getTotalPriceString(comp));
		});
		
		linuxCheckbox.setOnAction(event ->
		{
			baseOSCheckbox.setSelected(false);
			winProCheckbox.setSelected(false);
			
			comp.setOperatingSystem(osArray[2]);
			
			comp.setOsPrice(-89);
			
			priceLabel.setText(getTotalPriceString(comp));
		});
		
		VBox osVbox = new VBox(osLabel, baseOSCheckbox, winProCheckbox, linuxCheckbox);
		osVbox.setPadding(new Insets(10));
		
		return osVbox;
	}
	
	public VBox appPackageScene(Computer comp)
	{
		String [] appPackArray = {	"None",
									"Microsoft Office Home and Student 2013" ,
									"Microsoft Office Home & Business 2013",
									"Accounting package",
									"Graphics package"};
		
		CheckBox noAppPackBox = new CheckBox(appPackArray[0]);
		CheckBox MSOFFStudentBox = new CheckBox(appPackArray[1] +
										" - $139");
		CheckBox MSOFFBuisnessBox = new CheckBox(appPackArray[2] +
										" - $219");
		CheckBox accountingBox = new CheckBox(appPackArray[3] +
										" - $399");
		CheckBox graphicsPackBox = new CheckBox(appPackArray[4] + 
										" - $499");
		
		noAppPackBox.setSelected(true);
		
		noAppPackBox.setOnAction(new EventHandler <ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				MSOFFStudentBox.setSelected(false);
				MSOFFBuisnessBox.setSelected(false);
				accountingBox.setSelected(false);
				graphicsPackBox.setSelected(false);
				
				setAppPackageCost(0);
				
				setAppPackages(appPackArray[0]);
				
				priceLabel.setText(getTotalPriceString(comp));
			}
		});
		
		MSOFFStudentBox.setOnAction(new EventHandler <ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				noAppPackBox.setSelected(false);
				MSOFFBuisnessBox.setSelected(false);
				accountingBox.setSelected(false);
				graphicsPackBox.setSelected(false);
				
				setAppPackageCost(139);
				
				setAppPackages(appPackArray[1]);
				
				priceLabel.setText(getTotalPriceString(comp));
			}
		});
		
		MSOFFBuisnessBox.setOnAction(new EventHandler <ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				noAppPackBox.setSelected(false);
				MSOFFStudentBox.setSelected(false);
				accountingBox.setSelected(false);
				graphicsPackBox.setSelected(false);
				
				setAppPackageCost(219);
				
				setAppPackages(appPackArray[2]);
				
				priceLabel.setText(getTotalPriceString(comp));
			}
		});
		
		accountingBox.setOnAction(new EventHandler <ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				noAppPackBox.setSelected(false);
				MSOFFStudentBox.setSelected(false);
				MSOFFBuisnessBox.setSelected(false);
				graphicsPackBox.setSelected(false);
				
				setAppPackageCost(399);
				
				setAppPackages(appPackArray[3]);
				
				priceLabel.setText(getTotalPriceString(comp));
			}
		});
		
		graphicsPackBox.setOnAction(new EventHandler <ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				noAppPackBox.setSelected(false);
				MSOFFStudentBox.setSelected(false);
				MSOFFBuisnessBox.setSelected(false);
				accountingBox.setSelected(false);
				
				setAppPackageCost(499);
				
				setAppPackages(appPackArray[4]);
				
				priceLabel.setText(getTotalPriceString(comp));
			}
		});
		
		VBox appPackVbox = new VBox();
		
		Label appPackLabel = new Label("Select your Application Package");
		
		appPackVbox.getChildren().addAll(appPackLabel, noAppPackBox, MSOFFStudentBox,
										MSOFFBuisnessBox, accountingBox,
										graphicsPackBox);
		
		return appPackVbox;
		
	}
	
	public VBox checkOutScene(Computer comp)
	{
		double saleTax = comp.getTotalPrice(comp) * 0.078;
		
		double shipping = comp.getTotalPrice(comp) * 0.025;
		
		double finalCost = comp.getTotalPrice(comp) + saleTax + shipping;
		
		Label congratLabel = new Label("Congrats on your purchase");
		
		Label orderSummary = new Label("Order Summary\n"
										+ "-----------------");
		
		Label baseSystemLabel = new Label(comp.getBaseSystem());
		
		Label procLabel = new Label("Processor: " + comp.getProcessor() + " - " + 
							String.format("$%.2f", comp.getProcPrice()));
		
		Label ramLabel = new Label("RAM Memory: " + comp.getRamMemory() +" - " + 
									String.format("$%.2f", comp.getRamPrice()));
		
		Label hddLabel = new Label("HDD: " + comp.getHardDrive() + " - " + 
									String.format("$%.2f", comp.getHardDrivePrice()));
		
		Label graphicsLabel = new Label("Graphics Card: " + comp.getGraphicsCard() + " - " + 
									String.format("$%.2f", comp.getGraphicsCardPrice()));
		
		Label osLabel = new Label("Operating System: " + comp.getOperatingSystem() + " - " + 
									String.format("$%.2f", comp.getOsPrice()));
		
		Label dvdLabel = new Label("Media Player: " + comp.getDvdMedia() + " - " +
								String.format("$%.2f", comp.getDvdMediaPrice()));
		
		Label appPackLabel = new Label(	"Application Package: " + 
										comp.getAppPackages() + " - " +
										String.format("$%.2f", comp.getAppPackageCost()));
								
		
		Label keyboardLabel = new Label("Keyboard: " + comp.getKeyboard());
		
		Label mouseLabel = new Label("Mouse: " + comp.getMouse());
		
		Label speakerLabel = new Label("Speaker System: " + comp.getSpeakerSystem());
		
		Label systemCostLabel = new Label("Your Sbtotal: " + 
								String.format("$%.2f", comp.getTotalPrice(comp)));
		
		Label taxLabel = new Label("Sales tax: " + String.format("$%.2f", saleTax));
		
		Label shippingCostLabel = new Label("Shippng and Handling: " +
								String.format("$%.2f", shipping));
		
		Label finalCostSeperator = new Label("----------------\n" +
											"----------------");
		
		Label finalCostLabel = new Label("Total Cost: " + 
									String.format("$%.2f", finalCost));
		
		VBox orderSumVbox = new VBox();
		
		orderSumVbox.getChildren().addAll(congratLabel, orderSummary, baseSystemLabel,
				procLabel, ramLabel, hddLabel, graphicsLabel, osLabel, appPackLabel, dvdLabel,
				keyboardLabel, mouseLabel, speakerLabel, systemCostLabel,
				taxLabel,shippingCostLabel, finalCostSeperator, finalCostLabel);
		
		return orderSumVbox;			
	}
}
