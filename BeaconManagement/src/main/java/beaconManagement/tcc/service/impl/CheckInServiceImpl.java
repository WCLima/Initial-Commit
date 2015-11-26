/**
 *
 */
package beaconManagement.tcc.service.impl;

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
	private CheckInDAO checkInDao;

	public boolean insertCheckIn(CheckIn checkIn) {
		return checkInDao.insert(checkIn);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.service.CheckInService#getCheckIn()
	 */
	public List<CheckIn> getCheckIn() {
		return checkInDao.list();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.service.CheckInService#getCheckInByCalendar(java
	 * .util.Calendar)
	 */
	public List<CheckIn> getCheckInByCalendar(Long calendar) {
		return checkInDao.findByCalendar(calendar);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.service.CheckInService#getCheckInByStatus(boolean)
	 */
	public List<CheckIn> getCheckInByBeaconEvent(BeaconEvent event) {
		return checkInDao.findByBeaconEvent(event);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.service.CheckInService#getCheckInBeforeCalendar(
	 * java.util.Calendar)
	 */
	public List<CheckIn> getCheckInBeforeCalendar(Long calendar) {
		return checkInDao.findBeforeCalendar(calendar);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.service.CheckInService#getCheckInFromCalendar(java
	 * .util.Calendar)
	 */
	public List<CheckIn> getCheckInFromCalendar(Long calendar) {
		return checkInDao.findFromCalendar(calendar);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.service.CheckInService#getCheckInByBeaconDetector
	 * (beaconManagement.tcc.domain.BeaconDetector)
	 */
	public List<CheckIn> getCheckInByBeaconDetector(BeaconDetector detector) {
		return checkInDao.findByBeaconDetector(detector);
	}
}
