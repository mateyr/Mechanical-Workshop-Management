/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import programacionii.mechanic_workshop_system.App;
/**
 * FXML Controller class
 *
 * @author MateyR
 */
public class MainMecanicoController implements Initializable
{
    
    @FXML
    public TabPane tbOptions;
    @FXML
    public Button btnAgenda;
    @FXML
    public Button btnConfi;
    @FXML
    public Button btnOrdenTrabajo;
    
    private String selectedStyle = "-fx-background-color: #095594;-fx-border-width:4;-fx-background-insets: 0,6;-fx-background-radius: 6px, 0px;";
    private String normalStyle = "-fx-border-color: #1073c5;";
    @FXML
    public Label lblTabName;
    @FXML
    public Button btnCloseFirstTab;
    public Button btnCloseTab;   // Este lo uso para Cerrar todas la pestañas menos la primera
    private String userType;

   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    { 
  
    }    
    
    public static Parent loadFXML(String fxml) throws IOException   // Este metodo lo he agregado por que en esta clase lo usaremos bastante
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public void addTab(String Title)
    {   
        Tab tab = new Tab("");
        btnCloseTab = new Button("X");
        btnCloseTab.addEventHandler(ActionEvent.ACTION, (t) ->
        {
            tbOptions.getTabs().remove(tab);
        });
        
        ConfigBtnCloseTab(btnCloseTab);
        Label tabTitle =  new Label(Title,btnCloseTab);
        tabTitle.setContentDisplay(ContentDisplay.RIGHT);
        tabTitle.setAlignment(Pos.CENTER);
        tabTitle.setTextAlignment(TextAlignment.JUSTIFY);
        tabTitle.setTextFill(Paint.valueOf("#0d0d0d"));
        tab.setGraphic(tabTitle);
        tbOptions.getTabs().add(tab);   
    }

    @FXML
    public void  btnAgendaAction(ActionEvent event) throws IOException
    {
        Scene scene = new Scene(loadFXML("AgendaClientes"));
        Stage stage = new Stage();
        stage.initOwner(((Node)event.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.setX(142); //Valor x para centrar el frame.
        stage.setY(39); //Valor y para centrar el frame.
        stage.setWidth(1239); //Valor para ajustar al tamaño adecuado.
        stage.setHeight(710); //Valor para ajustar al tamaño adecuado.
        stage.setResizable(false); //Para evitar que el usuario cambie el tamaño del frame.
        stage.showAndWait();
    }
    
    @FXML
    public void btnAgendaMouseEntered(MouseEvent event)
    {
        btnAgenda.setStyle(selectedStyle);  
    }
    
    @FXML
    public void btnAgendaMouseExited(MouseEvent event)
    { 
        btnAgenda.setStyle(normalStyle);
    }

    @FXML
    public void btnOrdenTrabajoAction(ActionEvent event) throws IOException
    {
        Scene scene = new Scene(loadFXML("OrdenDeTrabajoFXML"));
        Stage stage = new Stage();
        stage.initOwner(((Node)event.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.setX(142); //Valor x para centrar el frame.
        stage.setY(39); //Valor y para centrar el frame.
        stage.setWidth(1239); //Valor para ajustar al tamaño adecuado.
        stage.setHeight(710); //Valor para ajustar al tamaño adecuado.
        stage.setResizable(false); //Para evitar que el usuario cambie el tamaño del frame.
        stage.showAndWait();
    }
    
    @FXML
    public void btnOrdenTrabajoMouseEntered(MouseEvent event)
    {
        btnOrdenTrabajo.setStyle(selectedStyle);
    }
    
    @FXML
    public void btnOrdenTrabajoMouseExited(MouseEvent event)
    {
        btnOrdenTrabajo.setStyle(normalStyle);
    }
    
    @FXML
    public void btnComprasAction(ActionEvent event) throws IOException
    {
        Scene scene = new Scene(loadFXML("ValidateCompra_Y_GastoFXML"));
        Stage stage = new Stage();
        stage.initOwner(((Node)event.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.setX(142); //Valor x para centrar el frame.
        stage.setY(39); //Valor y para centrar el frame.
        stage.setWidth(1239); //Valor para ajustar al tamaño adecuado.
        stage.setHeight(710); //Valor para ajustar al tamaño adecuado.
        stage.setResizable(false); //Para evitar que el usuario cambie el tamaño del frame.
        stage.showAndWait();
    
    }

    @FXML
    public void btnCloseTabAction(ActionEvent event)
    {
      tbOptions.getTabs().remove(0);
    }
    
    @FXML
    public void btnCloseFirstTabMouseEntered(MouseEvent event)
    {
        btnCloseFirstTab.setTextFill(Paint.valueOf("#FFFFFF"));
        btnCloseFirstTab.setStyle("-fx-background-color: fe0000");
    }

    @FXML
    public void btnCloseFirstTabMouseExited(MouseEvent event)
    { 
        btnCloseFirstTab.setTextFill(Paint.valueOf("#8c8a8a"));
        btnCloseFirstTab.setStyle("-fx-background-color: #d8d4d4");
    }
    
    private void ConfigBtnCloseTab(Button btn)
    {
        btn.setAlignment(Pos.TOP_CENTER);
        btn.setContentDisplay(ContentDisplay.TOP);
        btn.setMnemonicParsing(false);
        btn.setTextAlignment(TextAlignment.CENTER);
        btn.setTextFill(Paint.valueOf("#8c8a8a"));
        btn.setStyle("-fx-background-color: #d8d4d4");
        btn.setFont(Font.font("",FontWeight.BOLD, 9));  //El primer parametro no tengo idea :v
        
        btn.addEventHandler(MouseEvent.MOUSE_ENTERED, (t) ->
        {
            btn.setTextFill(Paint.valueOf("#FFFFFF"));
            btn.setStyle("-fx-background-color: fe0000");
        });

        btn.addEventHandler(MouseEvent.MOUSE_EXITED, (t) ->
        {
            btn.setTextFill(Paint.valueOf("#8c8a8a"));
            btn.setStyle("-fx-background-color: #d8d4d4");
        });
    }

    
   
    
}
