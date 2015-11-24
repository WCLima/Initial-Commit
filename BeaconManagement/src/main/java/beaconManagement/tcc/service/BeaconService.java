package beaconManagement.tcc.service;

import java.util.List;

import beaconManagement.tcc.domain.Beacon;

public interface BeaconService {

	boolean insertBeacon(Beacon beacon);

	boolean deleteBeacon(Beacon beacon);

	boolean editBeacon(Beacon beacon);

	List<Beacon> getBeacons();

	Beacon getBeaconByMac(String mac);

}
