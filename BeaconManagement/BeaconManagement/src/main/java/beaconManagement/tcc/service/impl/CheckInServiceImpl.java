/**
 *
 */
package beaconManagement.tcc.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beaconManagement.tcc.dao.CheckInDAO;
import beaconManagement.tcc.domain.CheckIn;
import beaconManagement.tcc.service.CheckInService;

@Service
public class CheckInServiceImpl implements CheckInService {

	@Autowired
	private CheckInDAO checkInDAO;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.service.CheckInService#saveCheckIn(beaconManagement
	 * .tcc.domain.CheckIn)
	 */
	public void saveCheckIn(CheckIn checkIn) {
		checkInDAO.save(checkIn);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.service.CheckInService#editCheckIn(beaconManagement
	 * .tcc.domain.CheckIn)
	 */
	public void editCheckIn(CheckIn checkIn) {
		checkInDAO.edit(checkIn);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.service.CheckInService#getCheckIn()
	 */
	public List<CheckIn> getCheckIn() {
		return checkInDAO.list();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.service.CheckInService#getCheckInById(java.lang.
	 * Long)
	 */
	public CheckIn getCheckInById(Long id) {
		return checkInDAO.findById(id);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.service.CheckInService#getCheckInByCalendar(java
	 * .util.Calendar)
	 */
	public List<CheckIn> getCheckInByCalendar(Calendar calendar) {
		return checkInDAO.findByCalendar(calendar);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.service.CheckInService#getCheckInByStatus(boolean)
	 */
	public List<CheckIn> getCheckInByStatus(boolean status) {
		return checkInDAO.findByStatus(status);
	}

}
