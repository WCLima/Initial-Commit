/**
 *
 */
package beaconManagement.tcc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beaconManagement.tcc.dao.BeaconEventDAO;
import beaconManagement.tcc.domain.BeaconEvent;
import beaconManagement.tcc.service.BeaconEventService;

/**
 * @author  Wagner
 */
@Service
public class BeaconEventServiceImpl implements BeaconEventService {

	/**
	 * @uml.property  name="beaconEventDao"
	 * @uml.associationEnd  readOnly="true"
	 */
	@Autowired
	private BeaconEventDAO beaconEventDao;

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.service.BeaconEventService#insertBeaconEvent(
	 * beaconManagement.tcc.domain.BeaconEvent)
	 */
	public boolean insertBeaconEvent(BeaconEvent beaconEvent) {
		return beaconEventDao.insert(beaconEvent);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see beaconManagement.tcc.service.BeaconEventService#saveBeaconEvent(
	 * beaconManagement.tcc.domain.BeaconEvent)
	 */
	public boolean deleteBeaconEvent(BeaconEvent event) {
		return beaconEventDao.delete(event);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see beaconManagement.tcc.service.BeaconEventService#editBeaconEvent(
	 * beaconManagement.tcc.domain.BeaconEvent)
	 */
	public boolean editBeaconEvent(BeaconEvent event) {
		return beaconEventDao.edit(event);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see beaconManagement.tcc.service.BeaconEventService#getBeaconEvents()
	 */
	public List<BeaconEvent> getBeaconEvents() {
		return beaconEventDao.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.service.BeaconEventService#getBeaconEventsByStartdate
	 * (java.util.Calendar)
	 */
	public List<BeaconEvent> getBeaconEventsByStartDate(Long dateMillis) {
		return beaconEventDao.findByStartDateMillis(dateMillis);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.service.BeaconEventService#getBeaconEventsByEnddate
	 * (java.util.Calendar)
	 */
	public List<BeaconEvent> getBeaconEventsByEndDate(Long dateMillis) {
		return beaconEventDao.findByEndDateMillis(dateMillis);
	}

}
