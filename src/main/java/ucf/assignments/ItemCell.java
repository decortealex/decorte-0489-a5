package ucf.assignments;

import javafx.scene.control.ListCell;

public class ItemCell extends ListCell<InventoryItem> {
    @Override
    public void updateItem(InventoryItem item, boolean empty) {
        super.updateItem(item, empty);

        int index = this.getIndex();

        String cellContent = index + ". " + item.getName() + ", $" + item.getPrice() + " " + item.getSerial();

        this.setText(cellContent);
    }
}
