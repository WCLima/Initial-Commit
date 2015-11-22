package beaconManagement.tcc.dao;

import java.util.List;

import beaconManagement.tcc.domain.Beacon;

public interface BeaconDAO {

	boolean insert(Beacon beacon);

	boolean edit(Beacon beacon);

	boolean delete(Beacon beacon);

	List<Beacon> list();

	Beacon findById(Long id);

	Beacon findByMac(String mac);

}
