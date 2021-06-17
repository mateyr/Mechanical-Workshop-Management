/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import static programacionii.mechanic_workshop_system.controller.MainAdministradorController.loadFXML;
import programacionii.mechanic_workshop_system.dao.implementation.JsonUserOnWorkingImpl;
import programacionii.mechanic_workshop_system.pojo.User;
//import programacionii.mechanic_workshop_system.pojo.User;

/**
 * FXML Controller class
 *
 * @author MateyR
 */
public class AdminSettingController implements Initializable
{

    public Button btnInfoP;
    public Button btnUsers;
   
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
    }    

    public void btnInfoPAction(ActionEvent event) throws IOException
    {
        Scene scene = new Scene(loadFXML("InfoPersonal"));
        Stage stage = new Stage();
        stage.initOwner(((Node)event.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.setResizable(false); //Para evitar que el usuario cambie el tamaño del frame.
        stage.showAndWait();
    }

    public void btnUsersAction(ActionEvent event)
    {
    }
    
}
