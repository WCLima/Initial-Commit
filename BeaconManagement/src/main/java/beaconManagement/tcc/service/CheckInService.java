package beaconManagement.tcc.service;

import java.math.BigDecimal;
import java.util.List;

import beaconManagement.tcc.domain.BeaconDetector;
import beaconManagement.tcc.domain.BeaconEvent;
import beaconManagement.tcc.domain.CheckIn;

public interface CheckInService {

	boolean insertCheckIn(CheckIn checkIn);

	List<CheckIn> getCheckIn();

	List<CheckIn> getCheckInByCalendar(BigDecimal dateMillis);

	List<CheckIn> getCheckInBeforeCalendar(BigDecimal dateMillis);

	List<CheckIn> getCheckInFromCalendar(BigDecimal dateMillis);

	List<CheckIn> getCheckInByBeaconEvent(BeaconEvent event);

	List<CheckIn> getCheckInByBeaconDetector(BeaconDetector detector);

}
