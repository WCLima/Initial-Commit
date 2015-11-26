package beaconManagement.tcc.dao;

import java.util.List;

import beaconManagement.tcc.domain.BeaconDetector;
import beaconManagement.tcc.domain.BeaconEvent;
import beaconManagement.tcc.domain.CheckIn;

public interface CheckInDAO {

	boolean insert(CheckIn check);

	List<CheckIn> list();

	CheckIn findById(Long id);

	List<CheckIn> findByDateMillis(Long dateMillis);

	List<CheckIn> findFromDateMillis(Long dateMillis);

	List<CheckIn> findBeforeDateMillis(Long dateMillis);

	List<CheckIn> findByBeaconEvent(BeaconEvent beaconEvent);

	List<CheckIn> findByBeaconDetector(BeaconDetector beaconDetector);

}
