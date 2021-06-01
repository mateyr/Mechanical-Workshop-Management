/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
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
    public Button btnAgenda_Clientes;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
         addTab("Weclome");
    }    
    
    private static Parent loadFXML(String fxml) throws IOException   // Este metodo lo he agregado por que en esta clase lo usaremos bastante
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    private void CloseTab(int index)
    {
        /*This method is supposed to close a tab according to the selected index
        Pending we could try to add a button next to the name of the Tab or just a simple separate which is easier*/
    }
    
    private void addTab(String Title)
    {
        Tab firstTab = new Tab(Title);
        firstTab.setStyle("-tab-text-color:  #1073c5;");
        tbOptions.getTabs().add(firstTab); 
    }
    
}
