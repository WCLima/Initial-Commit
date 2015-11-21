package beaconManagement.tcc.service;

import java.util.List;

import beaconManagement.tcc.domain.Beacon;

public interface BeaconService {

	void insertBeacon(Beacon beacon);

	void deleteBeacon(Beacon beacon);

	void editBeacon(Beacon beacon);

	List<Beacon> getBeacons();

	Beacon getBeaconByMac(String mac);

}
