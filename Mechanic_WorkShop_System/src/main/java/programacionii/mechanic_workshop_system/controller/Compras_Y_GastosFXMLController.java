/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import programacionii.mechanic_workshop_system.pojo.PresupuestoOrdenDeTrabajo;

/**
 * FXML Controller class
 *
 * @author navar
 */
public class Compras_Y_GastosFXMLController implements Initializable {

    @FXML
    public Button btnOk;
    @FXML
    public TableView<PresupuestoOrdenDeTrabajo> tblViewContent;
    @FXML
    public TableColumn<PresupuestoOrdenDeTrabajo, String> tblColumnDescripcion;
    @FXML
    public TableColumn<PresupuestoOrdenDeTrabajo, Integer> tblColumnCantidad;
    @FXML
    public TableColumn<PresupuestoOrdenDeTrabajo, Double> tblColumnPrecio;
    @FXML
    public TableColumn<PresupuestoOrdenDeTrabajo, Double> tblColumnDescuento;
    @FXML
    public TableColumn<PresupuestoOrdenDeTrabajo, Double> tblColumnSubtotal;
    @FXML
    public TextField txtTotal;
    
    private ObservableList<PresupuestoOrdenDeTrabajo> comprasGastos;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comprasGastos = FXCollections.observableArrayList();
        
        this.tblColumnDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.tblColumnCantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.tblColumnPrecio.setCellValueFactory(new PropertyValueFactory("precio"));
        this.tblColumnDescuento.setCellValueFactory(new PropertyValueFactory("descuento"));
        this.tblColumnSubtotal.setCellValueFactory(new PropertyValueFactory("subTotal"));
        loadData();
        
    }    

   
    @FXML
    public void btnOkAction(ActionEvent event) {
        Stage stage = (Stage) btnOk.getScene().getWindow();
        stage.close(); 
    }
    public void loadData(){
        PresupuestoOrdenDeTrabajo presupuestoOT = new PresupuestoOrdenDeTrabajo();
        if(this.comprasGastos.contains(presupuestoOT)){
            this.comprasGastos.add(presupuestoOT);
            this.tblViewContent.setItems(comprasGastos);
        }
    }
    
}
