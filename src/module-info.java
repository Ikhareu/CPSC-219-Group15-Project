module OnlineHouseRentingSystem {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;

	opens application to javafx.graphics, javafx.fxml;
	opens view to javafx.graphics, javafx.fxml;
	
}
