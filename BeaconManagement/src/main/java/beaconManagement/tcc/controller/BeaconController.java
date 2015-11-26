package beaconManagement.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import beaconManagement.tcc.domain.Beacon;
import beaconManagement.tcc.service.BeaconService;

/**
 * @author  Wagner
 */
@Controller
@RequestMapping(value = "/beacon")
public class BeaconController {

	/**
	 * @uml.property  name="beaconService"
	 * @uml.associationEnd  readOnly="true"
	 */
	@Autowired
	private BeaconService beaconService;

	@RequestMapping(value = "/list_beacons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Beacon> getBeacons() {
		return beaconService.getBeacons();
	}

	@RequestMapping(value = "/find_beacon_by_mac", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Beacon findBeaconByMAC(@RequestBody String mac) {
		return beaconService.getBeaconByMac(mac);
	}

	@RequestMapping(value = "/insert_beacon", method = RequestMethod.POST)
	@ResponseBody
	public boolean insertBeaconEvent(@RequestBody Beacon beacon) {
		return beaconService.insertBeacon(beacon);
	}

	@RequestMapping(value = "/delete_beacon", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteBeaconEvent(@RequestBody Beacon beacon) {
		return beaconService.deleteBeacon(beacon);
	}

	@RequestMapping(value = "/edit_beacon", method = RequestMethod.POST)
	@ResponseBody
	public boolean editBeaconEvent(@RequestBody Beacon beacon) {
		return beaconService.editBeacon(beacon);
	}
}
