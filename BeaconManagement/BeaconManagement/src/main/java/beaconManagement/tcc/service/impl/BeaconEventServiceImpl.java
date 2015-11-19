/**
 *
 */
package beaconManagement.tcc.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beaconManagement.tcc.dao.BeaconEventDAO;
import beaconManagement.tcc.domain.BeaconEvent;
import beaconManagement.tcc.service.BeaconEventService;

@Service
public class BeaconEventServiceImpl implements BeaconEventService {

	@Autowired
	private BeaconEventDAO beaconEventDAO;

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.service.BeaconEventService#saveBeaconEvent(
	 * beaconManagement.tcc.domain.BeaconEvent)
	 */
	public void saveBeaconEvent(BeaconEvent event) {
		beaconEventDAO.save(event);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.service.BeaconEventService#editBeaconEvent(
	 * beaconManagement.tcc.domain.BeaconEvent)
	 */
	public void editBeaconEvent(BeaconEvent event) {
		beaconEventDAO.edit(event);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.service.BeaconEventService#getBeaconEvents()
	 */
	public List<BeaconEvent> getBeaconEvents() {
		return beaconEventDAO.list();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.service.BeaconEventService#getBeaconEventById(java
	 * .lang.Long)
	 */
	public BeaconEvent getBeaconEventById(Long id) {
		return beaconEventDAO.findById(id);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.service.BeaconEventService#getBeaconEventsByStartdate
	 * (java.util.Calendar)
	 */
	public List<BeaconEvent> getBeaconEventsByStartDate(Calendar calendar) {
		return beaconEventDAO.findByStartCalendar(calendar);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.service.BeaconEventService#getBeaconEventsByEnddate
	 * (java.util.Calendar)
	 */
	public List<BeaconEvent> getBeaconEventsByEndDate(Calendar calendar) {
		return beaconEventDAO.findByEndCalendar(calendar);
	}

}
