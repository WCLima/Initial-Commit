package beaconManagement.tcc.service;

import java.util.Calendar;
import java.util.List;

import beaconManagement.tcc.domain.BeaconEvent;
import beaconManagement.tcc.domain.CheckIn;

public interface CheckInService {

	void insertCheckIn(CheckIn checkIn);

	List<CheckIn> getCheckIn();

	CheckIn getCheckInById(Long id);

	List<CheckIn> getCheckInByCalendar(Calendar calendar);

	List<CheckIn> getCheckInBeforeCalendar(Calendar calendar);

	List<CheckIn> getCheckInFromCalendar(Calendar calendar);

	List<CheckIn> getCheckInByBeaconEvent(BeaconEvent event);

}
