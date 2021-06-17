/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author navar
 */
public class Compras_Y_GastosFXMLController implements Initializable {

    @FXML
    public Button btnOk;
    @FXML
    public TableView<?> tblViewContent;
    @FXML
    public TableColumn<?, ?> tblColumnDescripcion;
    @FXML
    public TableColumn<?, ?> tblColumnCantidad;
    @FXML
    public TableColumn<?, ?> tblColumnPrecio;
    @FXML
    public TableColumn<?, ?> tblColumnDescuento;
    @FXML
    public TableColumn<?, ?> tblColumnSubtotal;
    @FXML
    public TextField txtTotal;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
    @FXML
    public void btnOkAction(ActionEvent event) {
    }
    
}
