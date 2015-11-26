package beaconManagement.tcc.service;

import java.util.List;

import beaconManagement.tcc.domain.BeaconDetector;
import beaconManagement.tcc.domain.BeaconEvent;
import beaconManagement.tcc.domain.CheckIn;

public interface CheckInService {

	boolean insertCheckIn(CheckIn checkIn);

	List<CheckIn> getCheckIn();

	List<CheckIn> getCheckInByCalendar(Long calendar);

	List<CheckIn> getCheckInBeforeCalendar(Long calendar);

	List<CheckIn> getCheckInFromCalendar(Long calendar);

	List<CheckIn> getCheckInByBeaconEvent(BeaconEvent event);

	List<CheckIn> getCheckInByBeaconDetector(BeaconDetector detector);

}
