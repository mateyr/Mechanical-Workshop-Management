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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import programacionii.mechanic_workshop_system.App;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import programacionii.mechanic_workshop_system.App;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MateyR
 */

public class LoginController implements Initializable {

    @FXML
    public TextField txtUser;
    @FXML
    public PasswordField txtPass;
    @FXML
    public Button btnLogging;
    @FXML
    public Hyperlink lblForgot;
    @FXML
    public Button btnClose;

    public Button btnIngresar;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

    }    

    public void btnIngresarAction(ActionEvent event) throws IOException
    {
      Scene scene = new Scene(new FXMLLoader(App.class.getResource("Main.fxml")).load()); //No he usado el Metodo LoadFXML por que ese metodo pertenece a otra clase considero que es mejor hacerlo de esta manera 
      Stage stage = new Stage();
      btnIngresar.getScene().getWindow().hide();  // Aqui ocultamos el Login.fxml
      stage.setScene(scene);
      stage.setFullScreen(true);
      stage.showAndWait();  
    }
 

    @FXML
    public void btnCloseAction(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

}
