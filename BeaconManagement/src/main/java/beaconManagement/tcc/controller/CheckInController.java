package beaconManagement.tcc.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import beaconManagement.tcc.domain.BeaconDetector;
import beaconManagement.tcc.domain.CheckIn;
import beaconManagement.tcc.service.CheckInService;

/**
 * @author Wagner
 */
@Controller
@RequestMapping(value = "/checkin")
public class CheckInController {

	/**
	 * @uml.property name="checkInService"
	 * @uml.associationEnd readOnly="true"
	 */
	@Autowired
	private CheckInService checkInService;

	@RequestMapping(value = "/list_checkins", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<CheckIn> getCheckIn() {
		return checkInService.getCheckIn();
	}

	@RequestMapping(value = "/list_checkins_by_detector", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<CheckIn> getCheckInByBeaconDetector(
			@RequestBody BeaconDetector detector) {
		return checkInService.getCheckInByBeaconDetector(detector);
	}

	@RequestMapping(value = "/list_checkins_by_date", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<CheckIn> getCheckInByCalendar(@RequestBody BigDecimal calendar) {
		return checkInService.getCheckInByCalendar(calendar);
	}

	@RequestMapping(value = "/list_checkins_from_date", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<CheckIn> getCheckInFromCalendar(@RequestBody BigDecimal calendar) {
		return checkInService.getCheckInFromCalendar(calendar);
	}

	@RequestMapping(value = "/list_checkins_before_date", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<CheckIn> getCheckInBeforeCalendar(
			@RequestBody BigDecimal calendar) {
		return checkInService.getCheckInBeforeCalendar(calendar);
	}

	@RequestMapping(value = "/insert_checkin", method = RequestMethod.POST)
	@ResponseBody
	public boolean insertCheckIn(@RequestBody CheckIn checkIn) {
		return checkInService.insertCheckIn(checkIn);
	}
}
