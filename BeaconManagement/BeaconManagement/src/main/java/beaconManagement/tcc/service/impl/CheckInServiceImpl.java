/**
 *
 */
package beaconManagement.tcc.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beaconManagement.tcc.dao.CheckInDAO;
import beaconManagement.tcc.domain.BeaconDetector;
import beaconManagement.tcc.domain.BeaconEvent;
import beaconManagement.tcc.domain.CheckIn;
import beaconManagement.tcc.service.CheckInService;

@Service
public class CheckInServiceImpl implements CheckInService {

	@Autowired
	private CheckInDAO checkInDAO;

	public void insertCheckIn(CheckIn checkIn) {
		checkInDAO.insert(checkIn);
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
	public List<CheckIn> getCheckInByBeaconEvent(BeaconEvent event) {
		return checkInDAO.findByBeaconEvent(event);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.service.CheckInService#getCheckInBeforeCalendar(
	 * java.util.Calendar)
	 */
	public List<CheckIn> getCheckInBeforeCalendar(Calendar calendar) {
		return checkInDAO.findBeforeCalendar(calendar);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.service.CheckInService#getCheckInFromCalendar(java
	 * .util.Calendar)
	 */
	public List<CheckIn> getCheckInFromCalendar(Calendar calendar) {
		return checkInDAO.findFromCalendar(calendar);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.service.CheckInService#getCheckInByBeaconDetector
	 * (beaconManagement.tcc.domain.BeaconDetector)
	 */
	public List<CheckIn> getCheckInByBeaconDetector(BeaconDetector detector) {
		return checkInDAO.findByBeaconDetector(detector);
	}
}
