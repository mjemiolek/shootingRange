package managers;

import mainModule.Client;
import repositories.Repository;

import java.util.Set;

public class ClientManager {

    private Repository<Client> repository = new Repository<>();
    private long idCounter = 0;

    public void registerClient(String name, String surname, String address) {
        String id = "CL" + idCounter;
        repository.add(new Client(id, name, surname, address));
        idCounter++;
    }

    public void unregisterClient(String id) {
        Client clientToRemove = findById(id);
        if(clientToRemove != null) {
            repository.remove(clientToRemove);
        }
    }

    public Client findById(String id) {
        for(Client client : repository.findAll()) {
            if(client.getId().equals(id)) {
                return client;
            }
        }
        return null;
    }

    public Set<Client> findAllClients() {
        return repository.findAll();
    }

}
