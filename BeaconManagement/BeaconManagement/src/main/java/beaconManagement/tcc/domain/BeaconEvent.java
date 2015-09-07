package beaconManagement.tcc.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "beaconEvent", schema = "beaconMgm")
public class BeaconEvent implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private Beacon beacon;

	@NotBlank
	private Calendar startCalendar;

	@NotBlank
	private Calendar endCalendar;

	public BeaconEvent() {
		super();
	}

	public BeaconEvent(long id, Beacon beacon, Calendar startCalendar,
			Calendar endCalendar) {
		super();
		this.id = id;
		this.beacon = beacon;
		this.startCalendar = startCalendar;
		this.endCalendar = endCalendar;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Beacon getBeacon() {
		return beacon;
	}

	public void setBeacon(Beacon beacon) {
		this.beacon = beacon;
	}

	public Calendar getStartCalendar() {
		return startCalendar;
	}

	public void setStartCalendar(Calendar startCalendar) {
		this.startCalendar = startCalendar;
	}

	public Calendar getEndCalendar() {
		return endCalendar;
	}

	public void setEndCalendar(Calendar endCalendar) {
		this.endCalendar = endCalendar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beacon == null) ? 0 : beacon.hashCode());
		result = prime * result
				+ ((endCalendar == null) ? 0 : endCalendar.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((startCalendar == null) ? 0 : startCalendar.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeaconEvent other = (BeaconEvent) obj;
		if (beacon == null) {
			if (other.beacon != null)
				return false;
		} else if (!beacon.equals(other.beacon))
			return false;
		if (endCalendar == null) {
			if (other.endCalendar != null)
				return false;
		} else if (!endCalendar.equals(other.endCalendar))
			return false;
		if (id != other.id)
			return false;
		if (startCalendar == null) {
			if (other.startCalendar != null)
				return false;
		} else if (!startCalendar.equals(other.startCalendar))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BeaconEvent [id=" + id + ", beacon=" + beacon
				+ ", startCalendar=" + startCalendar + ", endCalendar="
				+ endCalendar + "]";
	}

}
