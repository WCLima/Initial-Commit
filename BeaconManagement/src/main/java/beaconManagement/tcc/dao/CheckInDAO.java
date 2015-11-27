package beaconManagement.tcc.dao;

import java.math.BigDecimal;
import java.util.List;

import beaconManagement.tcc.domain.BeaconDetector;
import beaconManagement.tcc.domain.BeaconEvent;
import beaconManagement.tcc.domain.CheckIn;

public interface CheckInDAO {

	boolean insert(CheckIn check);

	List<CheckIn> list();

	CheckIn findById(Long id);

	List<CheckIn> findByDateMillis(BigDecimal dateMillis);

	List<CheckIn> findFromDateMillis(BigDecimal dateMillis);

	List<CheckIn> findBeforeDateMillis(BigDecimal dateMillis);

	List<CheckIn> findByBeaconEvent(BeaconEvent beaconEvent);

	List<CheckIn> findByBeaconDetector(BeaconDetector beaconDetector);

}
