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

	public void save(BeaconEvent beaconEvent) {
		sessionFactory.getCurrentSession().save(beaconEvent);
	}

	public void edit(BeaconEvent beaconEvent) {
		sessionFactory.getCurrentSession().merge(beaconEvent);
	}

	@SuppressWarnings("unchecked")
	public List<BeaconEvent> list() {
		List<BeaconEvent> list = sessionFactory.getCurrentSession()
				.createQuery("from beaconMgm.BeaconEvent").list();
		return list;
	}

	public BeaconEvent findById(Long id) {
		BeaconEvent event = (BeaconEvent) sessionFactory.getCurrentSession()
				.createQuery("from beaconMgm.BeaconEvent be where be.id=" + id);
		return event;
	}

	@SuppressWarnings("unchecked")
	public List<BeaconEvent> findByStartCalendar(Calendar startCalendar) {
		List<BeaconEvent> list = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from beaconMgm.BeaconEvent be where be.startCalendar="
								+ startCalendar.getTime()).list();
		return list;
	}

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
