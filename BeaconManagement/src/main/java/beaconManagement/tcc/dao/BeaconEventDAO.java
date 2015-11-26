package beaconManagement.tcc.dao;

import java.util.List;

import beaconManagement.tcc.domain.BeaconEvent;

public interface BeaconEventDAO {

	boolean insert(BeaconEvent beaconEvent);

	boolean edit(BeaconEvent beaconEvent);

	boolean delete(BeaconEvent beaconEvent);

	List<BeaconEvent> list();

	BeaconEvent findById(Long id);

	List<BeaconEvent> findByStartCalendar(Long startCalendar);

	List<BeaconEvent> findByEndCalendar(Long endCalendar);

}
