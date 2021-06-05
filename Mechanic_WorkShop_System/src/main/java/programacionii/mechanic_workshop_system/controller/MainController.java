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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import static javafx.scene.paint.Color.color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import programacionii.mechanic_workshop_system.App;

/**
 * FXML Controller class
 *
 * @author MateyR
 */
public class MainController implements Initializable
{

    @FXML
    public TabPane tbOptions;
    @FXML
    public Button btnAgenda;
    @FXML
    public Button btnConfi;
    @FXML
    public Button btnOrdenTrabajo;
    @FXML
    public Button btnCompras;
    @FXML
    public Button btnArticulos;
    @FXML
    public Button btnFactura;
    
    private String selectedStyle = "-fx-background-color: #095594;-fx-border-width:4;-fx-background-insets: 0,6;-fx-background-radius: 6px, 0px;";
    private String normalStyle = "-fx-border-color: #1073c5;";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
         addTab("Welcome");
        
    }    
    
    public static Parent loadFXML(String fxml) throws IOException   // Este metodo lo he agregado por que en esta clase lo usaremos bastante
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public void CloseTab(int index)
    {
        /*This method is supposed to close a tab according to the selected index
        Pending we could try to add a button next to the name of the Tab or just a simple separate which is easier*/
    }
    
    public void addTab(String Title)
    {
        Tab firstTab = new Tab(Title);
        firstTab.setStyle("-tab-text-color:  #1073c5");  //Second Option For color : #1073c5
        tbOptions.getTabs().add(firstTab); 
    }

    @FXML
    public void  btnAgendaAction(ActionEvent event) throws IOException
    {
      //Aqui se Debe abrir la Scene que contenga la tabla con los Clientes
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
    public void btnOrdenTrabajoAction(ActionEvent event)
    {
        //Aqui de debe llamar la Scene correspondiente
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
    public void btnComprasAction(ActionEvent event)
    {
        //Se debe abrir la Scene correspondiente
    }
    
    @FXML
    public void btnComprasMouseEntered(MouseEvent event)
    {
        btnCompras.setStyle(selectedStyle);
    }

    @FXML
    public void btnComprasMouseExited(MouseEvent event)
    {
        btnCompras.setStyle(normalStyle);
    }
    
    @FXML
    public void btnArticulosAction(ActionEvent event)
    {
      //Se debe abrir la Scene Correspondiente
    }
  
    @FXML
    public void btnArticulosMouseEntered(MouseEvent event)
    {
        btnArticulos.setStyle(selectedStyle);
    }
    
    @FXML
    public void btnArticulosMouseExited(MouseEvent event)
    {
        btnArticulos.setStyle(normalStyle);
    }
    
    @FXML
    public void btnFacturaAction(ActionEvent event)
    {
        //Se debe abrir la Scene Correspondiente
    }

    @FXML
    public void btnFacturaMouseEntered(MouseEvent event)
    {
        btnFactura.setStyle(selectedStyle);
    }

    @FXML
    public void btnFacturaMouseExited(MouseEvent event)
    {
        btnFactura.setStyle(normalStyle);
    }


  

   

 

   

   

  
    
}
