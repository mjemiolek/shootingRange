package managers;

import mainModule.Worker;
import repositories.Repository;

import java.util.Set;

public class WorkerManager {

    private Repository<Worker> repository = new Repository<>();
    private long idCounter = 0;

    public void registerWorker(String name, String surname, String address, String peselNumber, double costPerHour) {
        String id = "WR" + idCounter;
        idCounter++;
        repository.add(new Worker(id, name, surname, address, peselNumber, costPerHour));
    }

    public void unregisterWorker(String id) {
        Worker workerToRemove = findById(id);
        if(workerToRemove != null) {
            repository.remove(workerToRemove);
        }
    }

    public Worker findById(String id) {
        for(Worker worker : findAllWorkers()) {
            if(worker.getId().equals(id)) {
                return worker;
            }
        }
        return null;
    }

    public Set<Worker> findAllWorkers() {
        return repository.findAll();
    }

}
