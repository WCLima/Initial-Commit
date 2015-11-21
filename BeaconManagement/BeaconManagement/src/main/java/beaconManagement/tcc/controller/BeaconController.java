package beaconManagement.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beaconManagement.tcc.domain.Beacon;
import beaconManagement.tcc.service.BeaconService;

@Controller
@RequestMapping(value = "/beacons")
public class BeaconController {

	@Autowired
	private BeaconService beaconService;

	@RequestMapping(value = "/list_beacons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Beacon> getBeacons() {
		return beaconService.getBeacons();
	}

	@RequestMapping(value = "/find_mac", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Beacon findBeaconByMAC(@RequestBody String mac) {
		return beaconService.getBeaconByMac(mac);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.PUT)
	public void insertBeaconEvent(@RequestBody Beacon beacon) {
		beaconService.insertBeacon(beacon);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void deleteBeaconEvent(@RequestBody Beacon beacon) {
		beaconService.deleteBeacon(beacon);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void editBeaconEvent(@RequestBody Beacon beacon) {
		beaconService.editBeacon(beacon);
	}
}
