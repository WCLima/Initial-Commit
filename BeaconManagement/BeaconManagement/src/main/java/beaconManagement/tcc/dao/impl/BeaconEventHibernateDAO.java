/**
 *
 */
package beaconManagement.tcc.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import beaconManagement.tcc.dao.BeaconEventDAO;
import beaconManagement.tcc.domain.BeaconEvent;

@Repository
@Transactional
public class BeaconEventHibernateDAO implements BeaconEventDAO {

	@Autowired
	public SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.dao.BeaconEventDAO#insert(beaconManagement.tcc.domain
	 * .BeaconEvent)
	 */
	public void insert(BeaconEvent beaconEvent) {
		sessionFactory.getCurrentSession().persist(beaconEvent);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.dao.BeaconEventDAO#save(beaconManagement.tcc.domain
	 * .BeaconEvent)
	 */
	public void delete(BeaconEvent beaconEvent) {
		if (findById(beaconEvent.getId()) != null) {
			sessionFactory.getCurrentSession().delete(beaconEvent);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.dao.BeaconEventDAO#edit(beaconManagement.tcc.domain
	 * .BeaconEvent)
	 */
	public void edit(BeaconEvent beaconEvent) {
		if (findById(beaconEvent.getId()) != null) {
			sessionFactory.getCurrentSession().merge(beaconEvent);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see beaconManagement.tcc.dao.BeaconEventDAO#list()
	 */
	@SuppressWarnings("unchecked")
	public List<BeaconEvent> list() {
		List<BeaconEvent> list = sessionFactory.getCurrentSession()
				.createQuery("from beaconMgm.BeaconEvent").list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see beaconManagement.tcc.dao.BeaconEventDAO#findById(java.lang.Long)
	 */
	public BeaconEvent findById(Long id) {
		BeaconEvent event = (BeaconEvent) sessionFactory.getCurrentSession()
				.createQuery(
						"from beaconMgm.BeaconEvent be where be.beaconevent_id="
								+ id);
		return event;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.dao.BeaconEventDAO#findByStartCalendar(java.util
	 * .Calendar)
	 */
	@SuppressWarnings("unchecked")
	public List<BeaconEvent> findByStartCalendar(Calendar startCalendar) {
		List<BeaconEvent> list = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from beaconMgm.BeaconEvent be where be.startCalendar="
								+ startCalendar.getTime()).list();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * beaconManagement.tcc.dao.BeaconEventDAO#findByEndCalendar(java.util.Calendar
	 * )
	 */
	@SuppressWarnings("unchecked")
	public List<BeaconEvent> findByEndCalendar(Calendar endCalendar) {
		List<BeaconEvent> list = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from beaconMgm.BeaconEvent be where be.endCalendar="
								+ endCalendar.getTime()).list();
		return list;
	}

}
