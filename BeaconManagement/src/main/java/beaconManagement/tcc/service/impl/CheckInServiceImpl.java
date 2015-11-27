/**
 *
 */
package beaconManagement.tcc.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beaconManagement.tcc.dao.CheckInDAO;
import beaconManagement.tcc.domain.Beacon;
import beaconManagement.tcc.domain.BeaconDetector;
import beaconManagement.tcc.domain.BeaconEvent;
import beaconManagement.tcc.domain.CheckIn;
import beaconManagement.tcc.service.CheckInService;

/**
 * @author Wagner
 */
@Service
public class CheckInServiceImpl implements CheckInService {

	/**
	 * @uml.property name="checkInDao"
	 * @uml.associationEnd readOnly="true"
	 */
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
	public List<CheckIn> getCheckInByCalendar(BigDecimal dateMillis) {
		return checkInDao.findByDateMillis(dateMillis);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see beaconManagement.tcc.service.CheckInService#getCheckInByBeacon(
	 * beaconManagement.tcc.domain.Beacon)
	 */
	public List<CheckIn> getCheckInByBeacon(Beacon beacon) {
		return checkInDao.findByBeacon(beacon);
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
	public List<CheckIn> getCheckInBeforeCalendar(BigDecimal dateMillis) {
		return checkInDao.findBeforeDateMillis(dateMillis);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.service.CheckInService#getCheckInFromCalendar(java
	 * .util.Calendar)
	 */
	public List<CheckIn> getCheckInFromCalendar(BigDecimal dateMillis) {
		return checkInDao.findFromDateMillis(dateMillis);
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
