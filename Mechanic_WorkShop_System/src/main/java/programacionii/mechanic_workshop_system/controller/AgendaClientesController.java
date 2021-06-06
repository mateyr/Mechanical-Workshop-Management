/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author UZIEL
 */
public class AgendaClientesController implements Initializable
{

    @FXML
    public TextField txtBuscar;
    @FXML
    public TableView<?> tblClientes;
    @FXML
    public TableColumn<?, ?> clmNombre;
    @FXML
    public TableColumn<?, ?> clmApellido;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
}
