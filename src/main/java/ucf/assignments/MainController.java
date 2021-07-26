package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private ChoiceBox<String> sortBox;

    @FXML
    private TextField searchField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;

    @FXML
    private Button searchButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addButton;

    @FXML
    private ListView<InventoryItem> listView;

    private Inventory inventory;

    public MainController() {
        listView = new ListView<>();
        inventory = new Inventory();
        sortBox.setItems(FXCollections.observableArrayList("Sort By Value", "Sort By Name"));

    }

    @FXML
    public void initialize() {
        listView.setCellFactory(new ItemCellFactory());

    }

    @FXML
    public void handleAddItem(Event e) {
        inventory.addItem(
                new InventoryItem(nameField.getText(),
                                  Double.parseDouble(priceField.getText())));

        listView.getItems().setAll(inventory.forListView());
    }

    @FXML
    public void handleDeleteItem(Event e) {
        inventory.deleteItem(listView.getSelectionModel().getSelectedIndex());
    }

    @FXML
    public void handleSearch(Event e) {
        InventoryItem item = inventory.getItemByName(searchField.getText());

        if(item != null) {
            listView.getItems().remove(item);
            listView.getItems().set(0, item);
            listView.getSelectionModel().selectFirst();
        }
    }

}
