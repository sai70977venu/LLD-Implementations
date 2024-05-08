package lld.parkinglotmanagement.model.notificationdeletor;

import java.util.HashSet;
import java.util.Set;

public class ParkingLotChangeDelegate implements ParkingLotChangeNotifier {

    private final Set<ParkingLotModalObserver> observers;

    public ParkingLotChangeDelegate() {
        this.observers = new HashSet<>();
    }

    @Override
    public void registerPlugin(ParkingLotModalObserver plugin) {
        this.observers.add(plugin);
    }

    @Override
    public void unregisterPlugin(ParkingLotModalObserver plugin) {
        this.observers.remove(plugin);
    }

    public void notifyBeforeChange() {
        this.observers.forEach(ParkingLotModalObserver::notifyChange);
    }

    public void notifyAfterChange() {
        this.observers.forEach(ParkingLotModalObserver::notifyChange);
    }
}
