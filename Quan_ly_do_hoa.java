import javafx.scene.control.ListView;

public class Quan_ly_do_hoa {

    static ListView thayDoiDeXuat(MyDictionary dictionary ) {
        javafx.scene.control.ListView listView = new javafx.scene.control.ListView();
        listView.setEditable(true);
        int size = dictionary.getSize();

        for (int i=0; i< size; i++ ) {
            listView.getItems().add( dictionary.wordAt(i ) );
        }
        return listView;

    }

}
