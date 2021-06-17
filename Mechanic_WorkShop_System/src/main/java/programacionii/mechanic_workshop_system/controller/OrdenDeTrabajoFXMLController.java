/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionii.mechanic_workshop_system.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import programacionii.mechanic_workshop_system.enums.Color;
import programacionii.mechanic_workshop_system.enums.Departamento;
import programacionii.mechanic_workshop_system.enums.MarcaVehiculo;
import programacionii.mechanic_workshop_system.enums.Modelos;
import programacionii.mechanic_workshop_system.enums.TipoVehiculo;
import programacionii.mechanic_workshop_system.enums.Municipios;

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
    public Button btnSaveOrden;
    @FXML
    public Button btnCancelar;
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
    public ComboBox<Enum> cmbMunicipio;
    @FXML
    public TextArea txtADireccion;
    @FXML
    public ComboBox<Departamento> cmbDepartamento;
    @FXML
    public ComboBox<?> cmbBoColonia;
    @FXML
    public TextField txtCelular;
    @FXML
    public Label lblIconCar;
    @FXML
    public ComboBox<TipoVehiculo> cmbTipoVehiculo;
    @FXML
    public ComboBox<MarcaVehiculo> cmbMarca;
    @FXML
    public TextField txtPlaca;
    @FXML
    public TextField txtMotor;
    @FXML
    public TextField txtVIN;
    @FXML
    public TextField txtCodVehiculo;
    @FXML
    public Button btnSugereciaVehiculo;
    @FXML
    public ComboBox<Integer> cmbYearVehiculo;
    @FXML
    public ComboBox<Enum> cmbModelo;
    @FXML
    public ComboBox<Color> cmbColorVehiculo;
    @FXML
    public Spinner<?> spnKms;
    @FXML
    public TextField txtChasis;
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
    public TableView<?> tblProductos;
    @FXML
    public TableColumn<?, ?> tblColumnCodigo;
    @FXML
    public TableColumn<?, ?> tblColumnDescripcion;
    @FXML
    public TableColumn<?, ?> tblColumnPrecio;
    @FXML
    public TableColumn<?, ?> tblColumnSubtotal;
    @FXML
    public TableColumn<?, ?> tblColumnDescuento;
    @FXML
    public TableColumn<?, ?> tblColumnTotal;
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
    @FXML
    public TextField txtMO;
    @FXML
    public TableColumn<?, ?> tblColumnCantidad;
    @FXML
    public Button btnAddProducto;
    @FXML
    public Button btnCalcularAll;
    @FXML
    public Label lblNumOrden;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnNewOrdenSinDatos.setText("Nueva orden\nSin datos ✖");
        btnNewOrdenConDatos.setText("Nueva Orden\nCon datos ✔");
        editFuntionTableView();
        loadComboBoxs();
        validateMunicipio();
        validateModelos();
//        Alert a = new Alert(Alert.AlertType.INFORMATION, "Indice: " + cmbDepartamento.getSelectionModel().getSelectedIndex(), ButtonType.OK);
//        a.showAndWait();
        //addImageButtons();
    }

    private void editFuntionTableView() {
        tblColumnCodigo.setReorderable(false);
        tblColumnDescripcion.setReorderable(false);
        tblColumnCantidad.setReorderable(false);
        tblColumnPrecio.setReorderable(false);
        tblColumnSubtotal.setReorderable(false);
        tblColumnDescuento.setReorderable(false);
        tblColumnTotal.setReorderable(false);
    }

    private void loadComboBoxs() {
        List<Integer> years = new ArrayList<>();
       int[] year = new int[]{
            1998, 1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008,
            2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019,
            2020, 2021
        };
        
        for (int i = 0; i < year.length; i++) {
            years.add(year[i]);
        }
        
        ObservableList<Color> colores = FXCollections.observableArrayList(Color.values());
        ObservableList<Departamento> departamentos = FXCollections.observableArrayList(Departamento.values());
        ObservableList<MarcaVehiculo> marcaVehiculo = FXCollections.observableArrayList(MarcaVehiculo.values());
        ObservableList<TipoVehiculo> tipoVehiculo = FXCollections.observableArrayList(TipoVehiculo.values());
        //ObservableList<Municipios.BoacoMunicipio> municipio = FXCollections.observableArrayList(Municipios.BoacoMunicipio.values());
        ObservableList<Integer> yearVehiculo = FXCollections.observableArrayList(years);
        
        cmbColorVehiculo.setItems(colores);
        cmbDepartamento.setItems(departamentos);
        cmbMarca.setItems(marcaVehiculo);
        cmbTipoVehiculo.setItems(tipoVehiculo);
        //cmbMunicipio.setItems(municipio);
        cmbYearVehiculo.setItems(yearVehiculo);
        
        cmbColorVehiculo.setValue(Color.Blanco);
        cmbDepartamento.getSelectionModel().select(0);
        cmbMarca.setValue(MarcaVehiculo.Toyota);
        cmbTipoVehiculo.setValue(TipoVehiculo.Carro);
        //cmbMunicipio.getSelectionModel().select(0);
        cmbYearVehiculo.getSelectionModel().select(0);
    }
    
    private void validateMunicipio() {
        ObservableList<Departamento> departamentos = cmbDepartamento.getItems();
        ObservableList<Enum> municipio = null;
        for (int i = 0; i < departamentos.size(); i++) {
            if(departamentos.get(i).equals(cmbDepartamento.getSelectionModel().getSelectedItem())){
                switch(i) {
                    case 0: //Boaco
                        municipio = FXCollections.observableArrayList(Municipios.BoacoMunicipio.values());
                        break;
                    case 1: //Carazo
                        municipio = FXCollections.observableArrayList(Municipios.CarazoMunicipio.values());
                        break;
                    case 2: //Chinandega
                        municipio = FXCollections.observableArrayList(Municipios.ChinandegaMunicipio.values());
                        break;
                    case 3: //Chontales
                        municipio = FXCollections.observableArrayList(Municipios.ChontalesMunicipio.values());
                        break;
                    case 4: //Costa caribe norte
                        municipio = FXCollections.observableArrayList(Municipios.CostaCaribeNorteMunicipio.values());
                        break;
                    case 5: //Costa caribe sur
                        municipio = FXCollections.observableArrayList(Municipios.CostaCaribeSurMunicipio.values());
                        break;
                    case 6: //Esteli
                        municipio = FXCollections.observableArrayList(Municipios.EsteliMunicipio.values());
                        break;
                    case 7: //Granada
                        municipio = FXCollections.observableArrayList(Municipios.GranadaMunicipio.values());
                        break;
                    case 8: //Jinotega
                        municipio = FXCollections.observableArrayList(Municipios.JinotegaMunicipio.values());
                        break;
                    case 9: //Leon
                        municipio = FXCollections.observableArrayList(Municipios.LeonMunicipio.values());
                        break;
                    case 10: //Madriz
                        municipio = FXCollections.observableArrayList(Municipios.MadrizMunicipio.values());
                        break;
                    case 11: //Managua
                        municipio = FXCollections.observableArrayList(Municipios.ManaguaMunicipio.values());
                        break;
                    case 12: //Masaya
                        municipio = FXCollections.observableArrayList(Municipios.MasayaMunicipio.values());
                        break;
                    case 13: //Matagalpa
                        municipio = FXCollections.observableArrayList(Municipios.MatagalpaMunicipio.values());
                        break;
                    case 14: //Nueva Segovia
                        municipio = FXCollections.observableArrayList(Municipios.NuevaSegoviaMunicipio.values());
                        break;
                    case 15: //Rio san juan
                        municipio = FXCollections.observableArrayList(Municipios.RioSanJuanMunicipio.values());
                        break;
                    case 16: //Rivas
                        municipio = FXCollections.observableArrayList(Municipios.RivasMunicipio.values());
                        break;
                    default: break;
                }
                break;
            }
        }
        cmbMunicipio.setItems(municipio);
        cmbMunicipio.getSelectionModel().select(0);
    }

    private void validateModelos() {
        ObservableList<MarcaVehiculo> marcas = cmbMarca.getItems();
        ObservableList<Enum> modelos = null;
        
        for (int i = 0; i < marcas.size(); i++) {
            if(marcas.get(i).equals(cmbMarca.getSelectionModel().getSelectedItem())) {
                switch(i) {
                    case 0: //Toyota
                        modelos = FXCollections.observableArrayList(Modelos.ToyotaModel.values());
                        break;
                    case 1: //Honda
                        modelos = FXCollections.observableArrayList(Modelos.HondaModel.values());
                        break;
                    case 2: //Hyuundai
                        modelos = FXCollections.observableArrayList(Modelos.HyundaiModel.values());
                        break;
                    case 3: //Ford
                        modelos = FXCollections.observableArrayList(Modelos.FordModel.values());
                        break;
                    case 4: //Kia
                        modelos = FXCollections.observableArrayList(Modelos.KiaModel.values());
                        break;
                    case 5: //Chevrolet
                        modelos = FXCollections.observableArrayList(Modelos.ChevroletModel.values());
                        break;
                    case 6: //Suzuki
                        modelos = FXCollections.observableArrayList(Modelos.SuzukiModel.values());
                        break;
                    case 7: //Mazda
                        modelos = FXCollections.observableArrayList(Modelos.MazdaModel.values());
                        break;
                    case 8: //Nissan
                        modelos = FXCollections.observableArrayList(Modelos.NissanModel.values());
                        break;
                    case 9: //Mitsubishi
                        modelos = FXCollections.observableArrayList(Modelos.MitsubishiModel.values());
                        break;
                    case 10: //BMW
                        modelos = FXCollections.observableArrayList(Modelos.BmwModel.values());
                        break;
                    case 11: //Mercedes Benz
                        modelos = FXCollections.observableArrayList(Modelos.MercedesBenzModel.values());
                        break;
                    case 12: //Daihatsu
                        modelos = FXCollections.observableArrayList(Modelos.DaihatsuModel.values());
                        break;
                    case 13: //Volkswagen
                        modelos = FXCollections.observableArrayList(Modelos.VolkswagenModel.values());
                        break;
                    default: break;
                }
                break;
            }
        }
        
        cmbModelo.setItems(modelos);
        cmbModelo.getSelectionModel().select(0);
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
    public void btnSaveOrdenAction(ActionEvent event) {
    }

    @FXML
    public void btnCancelarAction(ActionEvent event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    public void btnSugerenciaClienteAction(ActionEvent event) {
    }

    @FXML
    public void btnSugereciaVehiculoAction(ActionEvent event) {
    }

    @FXML
    public void btnAddProductoAction(ActionEvent event) {
    }
    
    @FXML
    public void cmbDepartamentoAction(ActionEvent event) {
        validateMunicipio();
    }
    
    @FXML
    public void cmbMunicipioAction(ActionEvent event) {
        
    }
    
    @FXML
    public void cmbMarcaAction(ActionEvent event) {
        validateModelos();
    }
    
    @FXML
    public void btnCalcularAllAction(ActionEvent event) {
    }
}
