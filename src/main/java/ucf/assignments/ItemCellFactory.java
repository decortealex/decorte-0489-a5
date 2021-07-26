package ucf.assignments;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ItemCellFactory implements Callback<ListView<InventoryItem>, ListCell<InventoryItem>> {
    @Override
    public ListCell<InventoryItem> call(ListView<InventoryItem> listView) {
        return new ItemCell();
    }
}
