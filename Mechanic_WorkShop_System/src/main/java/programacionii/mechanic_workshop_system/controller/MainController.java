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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Tab firstTab = tbOptions.getTabs().get(0);
        //firstTab.
        firstTab.setStyle("-tab-text-color: cornflowerblue;");
    }    
    
    private static Parent loadFXML(String fxml) throws IOException   // Este metodo lo he agregado por que en esta clase lo usaremos bastante
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
}
