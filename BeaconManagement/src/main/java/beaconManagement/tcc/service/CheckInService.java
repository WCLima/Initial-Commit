package beaconManagement.tcc.service;

import java.util.List;

import beaconManagement.tcc.domain.BeaconDetector;
import beaconManagement.tcc.domain.BeaconEvent;
import beaconManagement.tcc.domain.CheckIn;

public interface CheckInService {

	boolean insertCheckIn(CheckIn checkIn);

	List<CheckIn> getCheckIn();

	List<CheckIn> getCheckInByCalendar(Long dateMillis);

	List<CheckIn> getCheckInBeforeCalendar(Long dateMillis);

	List<CheckIn> getCheckInFromCalendar(Long dateMillis);

	List<CheckIn> getCheckInByBeaconEvent(BeaconEvent event);

	List<CheckIn> getCheckInByBeaconDetector(BeaconDetector detector);

}
