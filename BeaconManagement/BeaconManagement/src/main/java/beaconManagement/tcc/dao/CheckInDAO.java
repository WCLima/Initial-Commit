package beaconManagement.tcc.dao;

import java.util.Calendar;
import java.util.List;

import beaconManagement.tcc.domain.BeaconEvent;
import beaconManagement.tcc.domain.CheckIn;

public interface CheckInDAO {

	public void insert(CheckIn check);

	public List<CheckIn> list();

	public CheckIn findById(Long id);

	public List<CheckIn> findByCalendar(Calendar calendar);

	public List<CheckIn> findFromCalendar(Calendar calendar);

	public List<CheckIn> findBeforeCalendar(Calendar calendar);

	public List<CheckIn> findByBeaconEvent(BeaconEvent beaconEvent);

}
