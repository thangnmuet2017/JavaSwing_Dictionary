import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Scanner;


public class Do_hoa extends Application  {

    private static MyDictionary dictionary = new MyDictionary();
    private static DictionaryManagement management = new DictionaryManagement();
    private static DictionaryCommandline commandline = new DictionaryCommandline();



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        management.insertFromFile( dictionary ); // lay du lieu tu file "dictionaries.txt"
        launch(args);

    }
// khai bao cac  thanh  phan

    TextField tf_lookup = new TextField();

    Button nutTra = new Button("tra");



    TextArea ta_nghia = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Dictionary");

        SplitPane layout_ngoai_cung = new SplitPane();  // mot ben la menu, mot ben la bang

        VBox layout_lua_chon = new VBox(5);  // day la mmenu lua chon
        layout_lua_chon.setMaxSize(35,10000);

        Button button_lookup = new Button();
        Button button_add = new Button();
        Button button_delete = new Button();
        Button button_sua = new Button() ;
        button_lookup.setText("tra tu");
        button_lookup.setMaxSize(30,30);

        button_add.setText("them tu");
        button_add.setMaxSize(30,30);

        button_sua.setText("sua tu");
        button_sua.setMaxSize(30,30);

        button_delete.setText( "xoa tu" );
        button_delete.setMaxSize(30,30);

        layout_lua_chon.getChildren().addAll(button_lookup, button_add, button_sua, button_delete);
        layout_lua_chon.setPadding(new Insets(270,0,0,0));
        // tao giao dien tra tu
//
        SplitPane layout_tra_tu = new SplitPane();  // kieu 2 ngan
        VBox layout_tra_tu_left = new VBox();   // kieu xep doc
        layout_tra_tu_left.setMaxSize(200,400);
        HBox layout_H1 = new HBox();


        layout_H1.getChildren().addAll( tf_lookup, nutTra);


        Label moi_nhap_tu = new Label("     Nhap tu can tra");

        ListView lv_goi_y = new ListView();
        lv_goi_y.getItems().add("goi y");
        layout_tra_tu_left.getChildren().addAll(moi_nhap_tu , layout_H1, lv_goi_y);
        layout_tra_tu_left.setPadding( new Insets(30,5,120,5));

        ta_nghia.setPadding( new Insets(50,25,20,5) );

        layout_tra_tu.getItems().addAll (layout_tra_tu_left, ta_nghia);

        layout_ngoai_cung.getItems() .addAll(layout_lua_chon, layout_tra_tu);

        tf_lookup.textProperty().addListener((observable, oldValue, newValue) -> // ham xu ly su kien voi textField
        {
            MyDictionary  oldDictionary = dictionary;
            MyDictionary  newDictionare = new MyDictionary();
            nutTra.setDisable( newValue.trim().isEmpty());// vo hieu hoa newButton new ben trong textField ronng
            if ( oldValue != newValue) {
                lv_goi_y.refresh( );
                newDictionare = commandline.dictionarySearcher( tf_lookup.getText(), dictionary);
                oldDictionary = newDictionare;
                for (int i=0; i< newDictionare.getSize(); i++) {
                    lv_goi_y.getItems().add(newDictionare.wordTargetAt(i));
                }

            }
        } );

// nut tra tu dien
        nutTra.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("day la mot cach xu ly su kien");
                String tuCanTra = tf_lookup.getText();
                String nghia = management.getNghia(dictionary, tuCanTra);
                ta_nghia.setText( nghia);
            }
        });









        Scene scene = new Scene( layout_ngoai_cung,550, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
