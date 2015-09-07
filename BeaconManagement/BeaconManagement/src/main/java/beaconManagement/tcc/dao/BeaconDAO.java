package beaconManagement.tcc.dao;

import java.util.List;

import beaconManagement.tcc.domain.Beacon;

public interface BeaconDAO {

	public void save(Beacon beacon);

	public void edit(Beacon beacon);

	public List<Beacon> list();

	public Beacon findById(Long id);

	public Beacon findByMac(String mac);

}
