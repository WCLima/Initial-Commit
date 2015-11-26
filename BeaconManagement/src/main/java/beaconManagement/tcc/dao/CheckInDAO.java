package beaconManagement.tcc.dao;

import java.util.List;

import beaconManagement.tcc.domain.BeaconDetector;
import beaconManagement.tcc.domain.BeaconEvent;
import beaconManagement.tcc.domain.CheckIn;

public interface CheckInDAO {

	boolean insert(CheckIn check);

	List<CheckIn> list();

	CheckIn findById(Long id);

	List<CheckIn> findByCalendar(Long calendar);

	List<CheckIn> findFromCalendar(Long calendar);

	List<CheckIn> findBeforeCalendar(Long calendar);

	List<CheckIn> findByBeaconEvent(BeaconEvent beaconEvent);

	List<CheckIn> findByBeaconDetector(BeaconDetector beaconDetector);

}
