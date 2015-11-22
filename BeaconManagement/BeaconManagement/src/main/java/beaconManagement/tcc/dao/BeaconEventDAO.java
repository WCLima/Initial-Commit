package beaconManagement.tcc.dao;

import java.util.Calendar;
import java.util.List;

import beaconManagement.tcc.domain.BeaconEvent;

public interface BeaconEventDAO {

	boolean insert(BeaconEvent beaconEvent);

	boolean edit(BeaconEvent beaconEvent);

	boolean delete(BeaconEvent beaconEvent);

	List<BeaconEvent> list();

	BeaconEvent findById(Long id);

	List<BeaconEvent> findByStartCalendar(Calendar startCalendar);

	List<BeaconEvent> findByEndCalendar(Calendar endCalendar);

}
