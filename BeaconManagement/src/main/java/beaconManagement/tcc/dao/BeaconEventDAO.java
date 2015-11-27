package beaconManagement.tcc.dao;

import java.math.BigDecimal;
import java.util.List;

import beaconManagement.tcc.domain.BeaconEvent;

public interface BeaconEventDAO {

	boolean insert(BeaconEvent beaconEvent);

	boolean edit(BeaconEvent beaconEvent);

	boolean delete(BeaconEvent beaconEvent);

	List<BeaconEvent> list();

	BeaconEvent findById(Long id);

	List<BeaconEvent> findByStartDateMillis(BigDecimal startDateMillis);

	List<BeaconEvent> findByEndDateMillis(BigDecimal endDateMillis);

}
