package beaconManagement.tcc.service;

import java.util.List;

import beaconManagement.tcc.domain.Beacon;

public interface BeaconService {

	public void saveBeacon(Beacon beacon);

	public void editBeacon(Beacon beacon);

	public List<Beacon> getBeacons();

	public Beacon getBeaconById(Long id);

	public Beacon getBeaconByMac(String mac);

}
