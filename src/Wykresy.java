import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.MouseEvent;

import javafx.event.Event;


public class Wykresy extends Application {


    @Override
    public void start(Stage stage) {
        Pliki.odczytajPlik();
        Scene scene = new Scene(new Group());
        stage.setTitle("Statystyki działów");
        stage.setWidth(500);
        stage.setHeight(500);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Dzial 1", Filtry.zliczIlePracownikowWDzialach(DodajFrame.getLista(), 1)),
                        new PieChart.Data("Dzial 2", Filtry.zliczIlePracownikowWDzialach(DodajFrame.getLista(), 2)),
                        new PieChart.Data("Dzial 3", Filtry.zliczIlePracownikowWDzialach(DodajFrame.getLista(), 3)),
                        new PieChart.Data("Dzial 4", Filtry.zliczIlePracownikowWDzialach(DodajFrame.getLista(), 4)));

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("STATYSTYKI DZIAŁÓW ");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();

        final Label caption = new Label("");
        //caption.setTextFill(Color.DARKORANGE);
        //caption.setStyle("-fx-font: 24 arial;");

       /* for (final PieChart.Data data : chart.getData()) {
            data.getNode().addEventHandler(javafx.scene.input.MouseEvent,
                    new EventHandler<javafx.scene.input.MouseEvent>() {
                        @Override
                        public void handle(javafx.scene.input.MouseEvent event) {
                            //caption.setTranslateX(chart.getSceneX());
                            //caption.setTranslateY(chart.getSceneY());
                            caption.setText(String.valueOf(data.getPieValue()) + "%");
                        }
                    });
        }*/


                       /* @Override
                        public void handle(MouseEvent e) {
                            //caption.setTranslateX(chart.getSceneX());
                            //caption.setTranslateY(chart.getSceneY());
                            caption.setText(String.valueOf(data.getPieValue()) + "%");
                        }*/
        //  };
    }


    public static void main() {
        launch();
    }
}

