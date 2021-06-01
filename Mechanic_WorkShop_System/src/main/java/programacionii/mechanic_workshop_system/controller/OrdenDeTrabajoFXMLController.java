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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author navar
 */
public class OrdenDeTrabajoFXMLController implements Initializable {

    @FXML
    public Button btnPrint;
    @FXML
    public Button btnNewOrdenSinDatos;
    @FXML
    public Button btnNewOrdenConDatos;
    @FXML
    public TableView<?> tblRevisionVehiculo1;
    @FXML
    public TableColumn<?, ?> tableColumnDato1;
    @FXML
    public TableColumn<?, ?> tableColumnSi1;
    @FXML
    public TableColumn<?, ?> tableColumnNo1;
    @FXML
    public TableView<?> tblRevisionVehiculo2;
    @FXML
    public TableColumn<?, ?> tableColumnDato2;
    @FXML
    public TableColumn<?, ?> tableColumnSi2;
    @FXML
    public TableColumn<?, ?> tableColumnNo2;
    @FXML
    public TableView<?> tblRevisionVehiculo3;
    @FXML
    public TableColumn<?, ?> tableColumnDato3;
    @FXML
    public TableColumn<?, ?> tableColumnSi3;
    @FXML
    public TableColumn<?, ?> tableColumnNo3;
    @FXML
    public TableView<?> tblRevisionVehiculo4;
    @FXML
    public TableColumn<?, ?> tableColumnDato4;
    @FXML
    public TableColumn<?, ?> tableColumnSi4;
    @FXML
    public TableColumn<?, ?> tableColumnNo4;
    @FXML
    public TextField txtCodCliente;
    @FXML
    public TextField txtNombreCompleto;
    @FXML
    public TextField txtCedula;
    @FXML
    public TextField txtCorreoElectronico;
    @FXML
    public TextField txtTelefono;
    @FXML
    public Button btnSugerenciaCliente;
    @FXML
    public ComboBox<?> cmbMunicipio;
    @FXML
    public TextArea txtADireccion;
    @FXML
    public ComboBox<?> cmbDepartamento;
    @FXML
    public ComboBox<?> cmbBoColonia;
    @FXML
    public TextField txtCelular;
    @FXML
    public Label lblIconCar;
    @FXML
    public ComboBox<?> cmbTipoVehiculo;
    @FXML
    public ComboBox<?> cmbMarca;
    @FXML
    public TextField txtPlaca;
    @FXML
    public TextField txtMotor;
    @FXML
    public TextField txtVIN;
    @FXML
    public TextField txtCodVehiculo;
    @FXML
    public Label cmbColor;
    @FXML
    public Button btnSugereciaVehiculo;
    @FXML
    public ComboBox<?> cmbYearVehiculo;
    @FXML
    public ComboBox<?> cmbModelo;
    @FXML
    public Spinner<?> spnKms;
    @FXML
    public TextField txtColor;
    @FXML
    public TextArea txtARevisar;
    @FXML
    public TextField txtPresupuesto;
    @FXML
    public TextField txtCodProducto;
    @FXML
    public TextField txtDescpProducto;
    @FXML
    public TextField txtCantidadProducto;
    @FXML
    public TextField txtDtoProducto;
    @FXML
    public TextField txtPrecioProducto;
    @FXML
    public TextField txtTotalProductos;
    @FXML
    public TableView<?> tblProductos;
    @FXML
    public TextField txtSubTotal;
    @FXML
    public TextField txtDto;
    @FXML
    public TextField txtSubTotalNeto;
    @FXML
    public TextField txtIVA;
    @FXML
    public TextField txtTotal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    public void btnPrintAction(ActionEvent event) {
    }

    @FXML
    public void btnNewOrdenSinDatosAction(ActionEvent event) {
    }

    @FXML
    public void btnNewOrdenConDatosAction(ActionEvent event) {
    }

    @FXML
    public void btnSugerenciaClienteAction(ActionEvent event) {
    }

    @FXML
    public void btnSugereciaVehiculoAction(ActionEvent event) {
    }
    
}
