/**
 *
 */
package beaconManagement.tcc.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import beaconManagement.tcc.dao.CheckInDAO;
import beaconManagement.tcc.domain.BeaconDetector;
import beaconManagement.tcc.domain.BeaconEvent;
import beaconManagement.tcc.domain.CheckIn;

@Repository
public class CheckInHibernateDAO extends CommonDAOImpl implements CheckInDAO {

	private static final Logger LOGGER = Logger
			.getLogger(CheckInHibernateDAO.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.dao.CheckInDAO#list()
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
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
	@Transactional(readOnly = true)
	public CheckIn findById(Long id) {
		CheckIn checkIn = null;
		try {
			checkIn = (CheckIn) getCurrentSession().createQuery(
					"from CheckIn c where c.id=" + id);
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
	@Transactional(readOnly = true)
	public List<CheckIn> findByCalendar(Calendar calendar) {
		List<CheckIn> list = null;
		try {
			list = getCurrentSession().createQuery(
					"from CheckIn c where c.checkCalendar=" + calendar).list();
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
	@Transactional(readOnly = true)
	public List<CheckIn> findByBeaconEvent(BeaconEvent event) {
		List<CheckIn> list = null;
		try {
			list = getCurrentSession().createQuery(
					"from CheckIn c where c.beaconevent_id = " + event.getId())
					.list();
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
	@Transactional(readOnly = true)
	public List<CheckIn> findByBeaconDetector(BeaconDetector detector) {
		List<CheckIn> list = null;
		try {
			list = getCurrentSession().createQuery(
					"from CheckIn c where c.beacondetector_id = "
							+ detector.getId()).list();
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
	@Transactional(readOnly = true)
	public List<CheckIn> findFromCalendar(Calendar calendar) {
		List<CheckIn> list = null;
		try {
			list = getCurrentSession().createQuery(
					"from CheckIn c where c.checkCalendar > " + calendar)
					.list();
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
	@Transactional(readOnly = true)
	public List<CheckIn> findBeforeCalendar(Calendar calendar) {
		List<CheckIn> list = null;
		try {
			list = getCurrentSession().createQuery(
					"from CheckIn c where c.checkCalendar < " + calendar)
					.list();
		} catch (HibernateException e) {
			LOGGER.error("Cannot find checkin: " + e);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see beaconManagement.tcc.dao.CommonDAO#insert(java.lang.Object)
	 */
	@Transactional(readOnly = true)
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
