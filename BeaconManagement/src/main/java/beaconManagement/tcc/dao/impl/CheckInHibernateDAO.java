/**
 *
 */
package beaconManagement.tcc.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import beaconManagement.tcc.dao.CheckInDAO;
import beaconManagement.tcc.domain.Beacon;
import beaconManagement.tcc.domain.BeaconDetector;
import beaconManagement.tcc.domain.BeaconEvent;
import beaconManagement.tcc.domain.CheckIn;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class CheckInHibernateDAO extends CommonDAOImpl implements CheckInDAO {

	private static final Logger LOGGER = Logger
			.getLogger(CheckInHibernateDAO.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.dao.CheckInDAO#list()
	 */
	@SuppressWarnings("unchecked")
	public List<CheckIn> list() {
		List<CheckIn> list = null;
		try {
			list = getCurrentSession().createQuery("from CheckIn c").list();
		} catch (HibernateException e) {
			LOGGER.error("Cannot find: " + e);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.dao.CheckInDAO#findById(java.lang.Long)
	 */
	public CheckIn findById(Long id) {
		CheckIn checkIn = null;
		try {
			Query query = getCurrentSession().createQuery(
					"from CheckIn c where c.id= :idCheckIn");
			query.setParameter("idCheckIn", id);
			checkIn = (CheckIn) query.uniqueResult();
		} catch (HibernateException e) {
			LOGGER.error("Cannot find id: " + e);
		}
		return checkIn;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.dao.CheckInDAO#findByCalendar(java.util.Calendar)
	 */
	@SuppressWarnings("unchecked")
	public List<CheckIn> findByDateMillis(BigDecimal dateMillis) {
		List<CheckIn> list = null;
		try {
			Query query = getCurrentSession().createQuery(
					"from CheckIn c where c.checkdatemilis= :checkCalendar");
			query.setParameter("checkCalendar", dateMillis);
			list = query.list();
		} catch (HibernateException e) {
			LOGGER.error("Cannot find calendar: " + e);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.dao.CheckInDAO#findByStatus(boolean)
	 */
	@SuppressWarnings("unchecked")
	public List<CheckIn> findByBeaconEvent(BeaconEvent event) {
		List<CheckIn> list = null;
		try {
			Query query = getCurrentSession().createQuery(
					"from CheckIn c where c.beaconevent_id = :idEvent");
			query.setParameter("idEvent", event);
			list = query.list();
		} catch (HibernateException e) {
			LOGGER.error("Cannot find event: " + e);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.dao.CheckInDAO#findByBeaconDetector(beaconManagement
	 * .tcc.domain.BeaconDetector)
	 */
	@SuppressWarnings("unchecked")
	public List<CheckIn> findByBeaconDetector(BeaconDetector detector) {
		List<CheckIn> list = null;
		try {
			Query query = getCurrentSession()
					.createQuery(
							"from CheckIn c where c.beacondetector_id= :beaconDetector");
			query.setParameter("beaconDetector", detector);
			list = query.list();
		} catch (HibernateException e) {
			LOGGER.error("Cannot find detector: " + e);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.dao.CheckInDAO#findFromCalendar(java.util.Calendar)
	 */
	@SuppressWarnings("unchecked")
	public List<CheckIn> findFromDateMillis(BigDecimal dateMillis) {
		List<CheckIn> list = null;
		try {
			Query query = getCurrentSession().createQuery(
					"from CheckIn c where c.checkdatemilis > :checkInCalendar");
			query.setParameter("checkInCalendar", dateMillis);
			list = query.list();
		} catch (HibernateException e) {
			LOGGER.error("Cannot find checkin: " + e);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * beaconManagement.tcc.dao.CheckInDAO#findBeforeCalendar(java.util.Calendar
	 * )
	 */
	@SuppressWarnings("unchecked")
	public List<CheckIn> findBeforeDateMillis(BigDecimal dateMillis) {
		List<CheckIn> list = null;
		try {
			Query query = getCurrentSession().createQuery(
					"from CheckIn c where c.checkdatemilis < :checkInCalendar");
			query.setParameter("checkInCalendar", dateMillis);
			list = query.list();
		} catch (HibernateException e) {
			LOGGER.error("Cannot find checkin: " + e);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.dao.CheckInDAO#findByBeacon(beaconManagement.tcc
	 * .domain.Beacon)
	 */
	@SuppressWarnings("unchecked")
	public List<CheckIn> findByBeacon(Beacon beacon) {
		List<CheckIn> list = null;
		try {
			Query query = getCurrentSession().createQuery(
					"from CheckIn c where c.beacon_id = :idBeacon");
			query.setParameter("idBeacon", beacon);
			list = query.list();
		} catch (HibernateException e) {
			LOGGER.error("Cannot find event: " + e);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.dao.CommonDAO#insert(java.lang.Object)
	 */
	public boolean insert(CheckIn item) {
		try {
			getCurrentSession().persist(item);
		} catch (HibernateException e) {
			LOGGER.error("Cannot insert: " + e);
			return false;
		}
		return true;
	}

}
