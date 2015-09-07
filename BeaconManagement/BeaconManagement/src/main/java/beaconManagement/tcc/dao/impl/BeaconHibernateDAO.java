/**
 *
 */
package beaconManagement.tcc.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import beaconManagement.tcc.dao.BeaconDAO;
import beaconManagement.tcc.domain.Beacon;

@Repository
@Transactional
public class BeaconHibernateDAO implements BeaconDAO {

	@Autowired
	public SessionFactory sessionFactory;

	public void save(Beacon beacon) {
		sessionFactory.getCurrentSession().save(beacon);
	}

	public void edit(Beacon beacon) {
		sessionFactory.getCurrentSession().merge(beacon);
	}

	@SuppressWarnings("unchecked")
	public List<Beacon> list() {
		List<Beacon> list = sessionFactory.getCurrentSession()
				.createQuery("from beaconMgm.Beacon").list();
		return list;
	}

	public Beacon findById(Long id) {
		Beacon item = (Beacon) sessionFactory.getCurrentSession()
				.createQuery("from beaconMgm.Beacon b where b.id=" + id)
				.uniqueResult();
		return item;
	}

	public Beacon findByMac(String mac) {
		Beacon item = (Beacon) sessionFactory.getCurrentSession()
				.createQuery("from beaconMgm.Beacon b where b.mac=" + mac)
				.uniqueResult();
		return item;
	}

}
