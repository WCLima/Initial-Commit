package beaconManagement.tcc.service;

import java.util.Calendar;
import java.util.List;

import beaconManagement.tcc.domain.BeaconEvent;
import beaconManagement.tcc.domain.CheckIn;

public interface CheckInService {

	public void saveCheckIn(CheckIn checkIn);

	public void editCheckIn(CheckIn checkIn);

	public List<CheckIn> getCheckIn();

	public CheckIn getCheckInById(Long id);

	public List<CheckIn> getCheckInByCalendar(Calendar calendar);

	public List<CheckIn> getCheckInByBeaconEvent(BeaconEvent event);

}
