package pl.strzelnicaview;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.ChoiceBox;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextField;

import mainModule.Client;
import managers.ClientManager;

public class ClientMenuController {

    private ClientManager clientManager;
    private Client currentClient;

    private MainScreenController mainScreenController;

    @FXML
    private TextField newName;
    @FXML
    private TextField newSurname;
    @FXML
    private TextField newAddress;
    @FXML
    private ChoiceBox<String> clientChooser;
    @FXML
    private Text IDText;
    @FXML
    private Text nameText;
    @FXML
    private Text surnameText;
    @FXML
    private Text addressText;

    @FXML
    void ExitToMenu() throws IOException {
        mainScreenController.loadMenuScreen();
    }

    @FXML
    void addNewClient() {
        String name, surname, address;
        name = newName.getText();
        surname = newSurname.getText();
        address = newAddress.getText();
        if( (name != null) && (surname != null) && (address != null) ) {
            clientManager.registerClient(name, surname, address);
        }
        fillClientChooser();
    }

    @FXML
    void deleteClient() {
        if(currentClient != null) {
            clientManager.unregisterClient(currentClient.getId());
        }
        setTexts("", "", "", "");
        fillClientChooser();
    }

    @FXML
    public void initialize() {

    }

    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }

    private void fillClientChooser() {
        List<String> identifiers = new ArrayList<>();
        for(Client client : clientManager.findAllClients()) {
            identifiers.add(String.valueOf(client.getId()));
        }
        clientChooser.getItems().clear();
        clientChooser.getItems().addAll(identifiers);
    }

    private void setTexts(String ID, String name, String Surname, String Address) {
        IDText.setText(ID);
        nameText.setText(name);
        surnameText.setText(Surname);
        addressText.setText(Address);
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
        fillClientChooser();
        clientChooser.setOnAction(this::getClient);
    }

    public void getClient(ActionEvent event) {
        String clientID = clientChooser.getValue();
        Client client = clientManager.findById(clientID);
        if(client != null) {
            currentClient = client;
            setTexts(client.getId(), client.getName(), client.getSurname(), client.getAddress());
        }
    }

}
