package beaconManagement.tcc.dao;

import java.util.List;

import beaconManagement.tcc.domain.Beacon;

public interface BeaconDAO {

	void insert(Beacon beacon);

	void edit(Beacon beacon);

	void delete(Beacon beacon);

	List<Beacon> list();

	Beacon findById(Long id);

	Beacon findByMac(String mac);

}
