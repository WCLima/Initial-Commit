package beaconManagement.tcc.dao;

import java.util.Calendar;
import java.util.List;

import beaconManagement.tcc.domain.Beacon;
import beaconManagement.tcc.domain.BeaconEvent;

public interface BeaconEventDAO {

	public void save(BeaconEvent beaconEvent);

	public void edit(BeaconEvent beaconEvent);

	public List<BeaconEvent> list();

	public BeaconEvent findById(Long id);

	public BeaconEvent findByBeacon(Beacon beacon);

	public List<BeaconEvent> findByStartCalendar(Calendar startCalendar);

	public List<BeaconEvent> findByEndCalendar(Calendar endCalendar);

}
