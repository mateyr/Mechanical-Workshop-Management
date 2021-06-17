/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import static programacionii.mechanic_workshop_system.controller.MainAdministradorController.loadFXML;

/**
 * FXML Controller class
 *
 * @author MateyR
 */
public class MecanicoSettingController implements Initializable
{

    @FXML
    public BorderPane BorderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
       Node parent = null;
        try
        {
            parent = loadFXML("InfoPersonal");
        } catch (IOException ex)
        {
            Logger.getLogger(MecanicoSettingController.class.getName()).log(Level.SEVERE, null, ex);
        }
           BorderPane.setCenter(parent);
    }    
    
}
