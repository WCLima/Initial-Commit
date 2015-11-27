package beaconManagement.tcc.service;

import java.math.BigDecimal;
import java.util.List;

import beaconManagement.tcc.domain.BeaconEvent;

public interface BeaconEventService {

	boolean insertBeaconEvent(BeaconEvent beaconEvent);

	boolean deleteBeaconEvent(BeaconEvent event);

	boolean editBeaconEvent(BeaconEvent event);

	List<BeaconEvent> getBeaconEvents();

	List<BeaconEvent> getBeaconEventsByStartDate(BigDecimal dateMillis);

	List<BeaconEvent> getBeaconEventsByEndDate(BigDecimal dateMillis);
}
