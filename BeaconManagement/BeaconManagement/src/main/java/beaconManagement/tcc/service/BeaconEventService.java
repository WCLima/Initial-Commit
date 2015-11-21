package beaconManagement.tcc.service;

import java.util.Calendar;
import java.util.List;

import beaconManagement.tcc.domain.BeaconEvent;

public interface BeaconEventService {

	void insertBeaconEvent(BeaconEvent beaconEvent);

	void deleteBeaconEvent(BeaconEvent event);

	void editBeaconEvent(BeaconEvent event);

	List<BeaconEvent> getBeaconEvents();

	List<BeaconEvent> getBeaconEventsByStartDate(Calendar calendar);

	List<BeaconEvent> getBeaconEventsByEndDate(Calendar calendar);
}
