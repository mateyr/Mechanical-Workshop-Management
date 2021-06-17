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
import programacionii.mechanic_workshop_system.dao.implementation.JsonUserOnWorkingImpl;
import programacionii.mechanic_workshop_system.dao.implementation.JsonUserDaoImpl;
import programacionii.mechanic_workshop_system.enums.UserType;
import programacionii.mechanic_workshop_system.pojo.User;

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
    
    private JsonUserDaoImpl jUserDao;
    private JsonUserOnWorkingImpl jsuow;
    private User user = new User(2,"Rodian","Matey","MateyR","12345",22,UserType.Mecanico);  // Para propositos didacticos
    private List<User> users = new ArrayList<User>();
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        jUserDao = new JsonUserDaoImpl();
        jsuow = new JsonUserOnWorkingImpl();
        
    }    
  
    public void btnIngresarAction(ActionEvent event) throws IOException
    {
      users = (List<User>) jUserDao.getAll();
      users.stream().forEach((t) ->
      {
          if(t.getUsername().equals(txtUser.getText()) && t.getPassword().equals(txtPass.getText()))
          {
              try
              {
                  jsuow.create(t);
              } catch (IOException ex)
              {
                  Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
              }
              txtPass.setText("");
              txtUser.setText("");
              Scene scene = null;
              if(t.getUserType().equals(UserType.Administrador))
              {
                  try 
                  {
                      scene = new Scene(new FXMLLoader(App.class.getResource("MainAdministrador.fxml")).load()); //No he usado el Metodo LoadFXML por que ese metodo pertenece a otra clase considero que es mejor hacerlo de esta manera 
                      scene.setUserData(t);
                  }catch (IOException ex)
                  {
                      Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
              
              if(t.getUserType().equals(UserType.Mecanico))
              {
                  try 
                  {
                      scene = new Scene(new FXMLLoader(App.class.getResource("MainMecanico.fxml")).load()); //No he usado el Metodo LoadFXML por que ese metodo pertenece a otra clase considero que es mejor hacerlo de esta manera  
                  }catch (IOException ex)
                  {
                      Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
      
               Stage stage = new Stage();
               btnIngresar.getScene().getWindow().hide();  // Aqui ocultamos el Login.fxml
               stage.setScene(scene);
               stage.setFullScreen(true);
               stage.showAndWait();  
          }else{
              System.out.println("No Existe tal Usuario"); //Buscar Equivalente a JOptionPane
          }
        
      });
       
    }

    @FXML
    public void btnCloseAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();   
    }

}
