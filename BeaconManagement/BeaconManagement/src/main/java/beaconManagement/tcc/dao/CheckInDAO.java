package beaconManagement.tcc.dao;

import java.util.Calendar;
import java.util.List;

import beaconManagement.tcc.domain.BeaconDetector;
import beaconManagement.tcc.domain.BeaconEvent;
import beaconManagement.tcc.domain.CheckIn;

public interface CheckInDAO {

	boolean insert(CheckIn check);

	List<CheckIn> list();

	CheckIn findById(Long id);

	List<CheckIn> findByCalendar(Calendar calendar);

	List<CheckIn> findFromCalendar(Calendar calendar);

	List<CheckIn> findBeforeCalendar(Calendar calendar);

	List<CheckIn> findByBeaconEvent(BeaconEvent beaconEvent);

	List<CheckIn> findByBeaconDetector(BeaconDetector beaconDetector);

}
