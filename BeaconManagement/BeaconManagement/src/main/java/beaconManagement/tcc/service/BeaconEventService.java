package beaconManagement.tcc.service;

import java.util.Calendar;
import java.util.List;

import beaconManagement.tcc.domain.BeaconEvent;

public interface BeaconEventService {

	public void saveBeaconEvent(BeaconEvent event);

	public void editBeaconEvent(BeaconEvent event);

	public List<BeaconEvent> getBeaconEvents();

	public BeaconEvent getBeaconEventById(Long id);

	public List<BeaconEvent> getBeaconEventsByStartdate(Calendar calendar);

	public List<BeaconEvent> getBeaconEventsByEnddate(Calendar calendar);
}
