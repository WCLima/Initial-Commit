package beaconManagement.tcc.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beaconManagement.tcc.domain.BeaconEvent;
import beaconManagement.tcc.service.BeaconEventService;

@Controller
@RequestMapping(value = "/beaconEvents")
public class BeaconEventController {

	@Autowired
	private BeaconEventService beaconEventService;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BeaconEvent> getBeaconEvents() {
		return beaconEventService.getBeaconEvents();
	}

	@RequestMapping(value = "/list_start_date", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BeaconEvent> getBeaconEventsStartDate(
			@RequestBody Calendar calendar) {
		return beaconEventService.getBeaconEventsByStartDate(calendar);
	}

	@RequestMapping(value = "/list_end_date", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BeaconEvent> getBeaconEventsEndDate(
			@RequestBody Calendar calendar) {
		return beaconEventService.getBeaconEventsByEndDate(calendar);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.PUT)
	public boolean insertBeaconEvent(@RequestBody BeaconEvent beaconEvent) {
		return beaconEventService.insertBeaconEvent(beaconEvent);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public boolean deleteBeaconEvent(@RequestBody BeaconEvent beaconEvent) {
		return beaconEventService.deleteBeaconEvent(beaconEvent);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public boolean editBeaconEvent(@RequestBody BeaconEvent beaconEvent) {
		return beaconEventService.editBeaconEvent(beaconEvent);
	}
}
