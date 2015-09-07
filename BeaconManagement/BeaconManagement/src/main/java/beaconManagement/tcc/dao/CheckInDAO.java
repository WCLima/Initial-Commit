package beaconManagement.tcc.dao;

import java.util.Calendar;
import java.util.List;

import beaconManagement.tcc.domain.CheckIn;

public interface CheckInDAO {

	public void save(CheckIn check);

	public void edit(CheckIn check);

	public List<CheckIn> list();

	public CheckIn findById(Long id);

	public List<CheckIn> findByCalendar(Calendar calendar);

	public List<CheckIn> findByStatus(boolean status);

}
