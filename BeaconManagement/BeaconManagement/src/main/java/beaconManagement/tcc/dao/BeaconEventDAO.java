package beaconManagement.tcc.dao;

import java.util.Calendar;
import java.util.List;

import beaconManagement.tcc.domain.BeaconEvent;

public interface BeaconEventDAO {

	void insert(BeaconEvent beaconEvent);

	void edit(BeaconEvent beaconEvent);

	void delete(BeaconEvent beaconEvent);

	List<BeaconEvent> list();

	BeaconEvent findById(Long id);

	List<BeaconEvent> findByStartCalendar(Calendar startCalendar);

	List<BeaconEvent> findByEndCalendar(Calendar endCalendar);

}
