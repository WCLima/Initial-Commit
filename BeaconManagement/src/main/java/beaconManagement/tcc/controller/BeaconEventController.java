package beaconManagement.tcc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import beaconManagement.tcc.domain.BeaconEvent;
import beaconManagement.tcc.service.BeaconEventService;

@Controller
@RequestMapping(value = "event")
public class BeaconEventController {

	@Autowired
	private BeaconEventService beaconEventService;

	@RequestMapping(value = "/list_event", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<BeaconEvent> getBeaconEvents() {
		return beaconEventService.getBeaconEvents();
	}

	@RequestMapping(value = "/list_event_start_date", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<BeaconEvent> getBeaconEventsStartDate(@RequestBody Long calendar) {
		return beaconEventService.getBeaconEventsByStartDate(calendar);
	}

	@RequestMapping(value = "/list_event_end_date", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<BeaconEvent> getBeaconEventsEndDate(@RequestBody Long calendar) {
		return beaconEventService.getBeaconEventsByEndDate(calendar);
	}

	@RequestMapping(value = "/insert_event", method = RequestMethod.POST)
	@ResponseBody
	public boolean insertBeaconEvent(@RequestBody BeaconEvent beaconEvent) {
		return beaconEventService.insertBeaconEvent(beaconEvent);
	}

	@RequestMapping(value = "/delete_event", method = RequestMethod.POST)
	@ResponseBody
	public boolean deleteBeaconEvent(@RequestBody BeaconEvent beaconEvent) {
		return beaconEventService.deleteBeaconEvent(beaconEvent);
	}

	@RequestMapping(value = "/edit_event", method = RequestMethod.POST)
	@ResponseBody
	public boolean editBeaconEvent(@RequestBody BeaconEvent beaconEvent) {
		return beaconEventService.editBeaconEvent(beaconEvent);
	}
}
