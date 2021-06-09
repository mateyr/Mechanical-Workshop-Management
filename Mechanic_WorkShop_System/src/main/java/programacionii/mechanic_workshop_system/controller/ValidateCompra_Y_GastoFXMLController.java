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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import programacionii.mechanic_workshop_system.App;

/**
 * FXML Controller class
 *
 * @author navar
 */
public class ValidateCompra_Y_GastoFXMLController implements Initializable {
    
    // Posicion X: 511, Posicion Y: 244
    // Tamaño -> Altura: 300, Ancho: 500
    //setResizable(false);
    
    @FXML
    public TableView<?> tblViewContent;
    @FXML
    public TableColumn<?, ?> tblColumnNumOrden;
    @FXML
    public TableColumn<?, ?> tblColumnMecanico;
    @FXML
    public TableColumn<?, ?> tblColumnEstado;
    @FXML
    public TextField txtBuscar;
    @FXML
    public Button btnOk;
    @FXML
    public Button btnCancelar;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblColumnNumOrden.setReorderable(false);
        tblColumnMecanico.setReorderable(false);
        tblColumnEstado.setReorderable(false);
    }    

    @FXML
    public void btnOkAction(ActionEvent event) throws IOException {
        
    }

    @FXML
    public void btnCancelarAction(ActionEvent event) {
    }
    
}
