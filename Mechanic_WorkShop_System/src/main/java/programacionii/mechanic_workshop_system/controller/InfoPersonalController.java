/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.control.TextField;
import programacionii.mechanic_workshop_system.dao.implementation.JsonUserOnWorkingImpl;
import programacionii.mechanic_workshop_system.enums.UserType;
import programacionii.mechanic_workshop_system.pojo.User;

/**
 * FXML Controller class
 *
 * @author MateyR
 */
public class InfoPersonalController implements Initializable
{

    @FXML
    public ComboBox<UserType> cmbTipoUsuario;
    @FXML
    public TextField txtId;
    @FXML
    public TextField txtNombre;
    @FXML
    public TextField txtApellido;
    @FXML
    public Spinner<Integer> spnEdad;
    @FXML
    public TextField txtUserName;
    @FXML
    public TextField txtActualPassword;
    @FXML
    public TextField txtNuevaPassword;
    @FXML
    public TextField txtConfirmarPassword;

    private JsonUserOnWorkingImpl jUserOn;
    private List<User> users = new ArrayList<User>();
    private User user;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
       ObservableList<UserType> cmbusers = FXCollections.observableArrayList(UserType.values());
      
       cmbTipoUsuario.getItems().setAll(cmbusers);
       spnEdad.setValueFactory(new IntegerSpinnerValueFactory(18,90,18,1));
       
       jUserOn = new JsonUserOnWorkingImpl();
        try
        {
            users = (List<User>) jUserOn.getAll();
        } catch (IOException ex)
        {
            Logger.getLogger(InfoPersonalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        user = users.get(users.size() - 1);
        try
        {
            fillText();
        } catch (IOException ex)
        {
            Logger.getLogger(InfoPersonalController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        txtId.setDisable(true);
    }
    
    
    private void fillText() throws IOException
    {    
        if(user.getUserType().equals(UserType.Mecanico)){
           spnEdad.setDisable(true);
           cmbTipoUsuario.setDisable(true);
           txtUserName.setDisable(true);
        }
        txtId.setText(String.valueOf(user.getId()));
        txtNombre.setText(user.getName());
        txtApellido.setText(user.getLastName());
        txtUserName.setText(user.getPassword());
        cmbTipoUsuario.getSelectionModel().select(user.getUserType());
     
    }
}
