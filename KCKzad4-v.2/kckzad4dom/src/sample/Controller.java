package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.print.DocFlavor;
import java.awt.*;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    BarChart<String,Number> barChart;

    @FXML
    public TableView myTable;

    @FXML
    public TableColumn miesiac, zarobki;

    @FXML
    public TextField month, money;

//    @FXML
//    public Button update;


    Pieniazki styczen =  new Pieniazki("Styczeń",5300);
    Pieniazki luty =   new Pieniazki("Luty",2250);
    Pieniazki marzec =    new Pieniazki("Marzec",3333);
    Pieniazki kwiecien =     new Pieniazki("Kwiecień",9000);
    Pieniazki maj =   new Pieniazki("Maj",7320);
    Pieniazki czerwiec =    new Pieniazki("Czerwiec",1300);
    Pieniazki lipiec =    new Pieniazki("Lipiec",3500);

    final ObservableList<Pieniazki> data = FXCollections.observableArrayList(styczen,luty,marzec,kwiecien,maj,czerwiec,lipiec);


    XYChart.Series series1 = new XYChart.Series();

    public void initialize (URL url, ResourceBundle rb){

        miesiac.setCellValueFactory(new PropertyValueFactory<Pieniazki,String>("miesiac"));
        zarobki.setCellValueFactory(new PropertyValueFactory<Pieniazki,String>("zarobki"));

        myTable.setItems(data);

        barChart.setTitle("Zarobki w tys. zł");

        series1.getData().add(new XYChart.Data(styczen.getMiesiac(), styczen.getZarobki()/1000));
        series1.getData().add(new XYChart.Data(luty.getMiesiac(), luty.getZarobki()/1000));
        series1.getData().add(new XYChart.Data(marzec.getMiesiac(), marzec.getZarobki()/1000));
        series1.getData().add(new XYChart.Data(kwiecien.getMiesiac(), kwiecien.getZarobki()/1000));
        series1.getData().add(new XYChart.Data(maj.getMiesiac(), maj.getZarobki()/1000));
        series1.getData().add(new XYChart.Data(czerwiec.getMiesiac(), czerwiec.getZarobki()/1000));
        series1.getData().add(new XYChart.Data(lipiec.getMiesiac(), lipiec.getZarobki()/1000));


        barChart.getData().addAll(series1);

    }

    public void add(){

        Pieniazki entry = new Pieniazki(month.getText(),Integer.parseInt(money.getText()));

        data.add(entry);
        myTable.setItems(data);


        series1.getData().add(new XYChart.Data(entry.getMiesiac(), entry.getZarobki()/1000));

       // barChart.getData().addAll(series1);

        clearForm();
    }

    private void clearForm(){
        month.clear();
        money.clear();
    }

}





