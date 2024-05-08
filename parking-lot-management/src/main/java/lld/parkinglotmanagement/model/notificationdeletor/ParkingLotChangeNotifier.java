package lld.parkinglotmanagement.model.notificationdeletor;

public interface ParkingLotChangeNotifier {

    public void registerPlugin(ParkingLotModalObserver plugin);

    public void unregisterPlugin(ParkingLotModalObserver plugin);

    public void notifyBeforeChange();

    public void notifyAfterChange();
}
