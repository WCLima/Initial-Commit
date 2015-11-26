/**
 *
 */
package beaconManagement.tcc.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author  Wagner
 */
@Repository
public abstract class CommonDAOImpl {

	/**
	 * @uml.property  name="sessionFactory"
	 * @uml.associationEnd  readOnly="true"
	 */
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
