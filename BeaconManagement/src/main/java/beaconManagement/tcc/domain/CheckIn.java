package beaconManagement.tcc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "checkin", schema = "management")
public class CheckIn implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank
	private Long checkDateMilis;

	private BeaconEvent beaconEvent;

	private BeaconDetector beaconDetector;

	public CheckIn(Long id, Long checkDateMilis, BeaconEvent beaconEvent,
			BeaconDetector beaconDetector) {
		super();
		this.id = id;
		this.checkDateMilis = checkDateMilis;
		this.beaconEvent = beaconEvent;
		this.beaconDetector = beaconDetector;
	}

	@Id
	@Column(name = "checkin_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_checkin_id")
	@SequenceGenerator(name = "sq_checkin_id", sequenceName = "management.SQ_CHECKIN_ID", initialValue = 1, allocationSize = 1)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCheckDateMilis() {
		return checkDateMilis;
	}

	public void setCheckDateMilis(Long checkDateMilis) {
		this.checkDateMilis = checkDateMilis;
	}

	@ManyToOne
	@JoinColumn(name = "beaconevent_id")
	public BeaconEvent getBeaconEvent() {
		return beaconEvent;
	}

	public void setBeaconEvent(BeaconEvent beaconEvent) {
		this.beaconEvent = beaconEvent;
	}

	@ManyToOne
	@JoinColumn(name = "beacondetector_id")
	public BeaconDetector getBeaconDetector() {
		return beaconDetector;
	}

	public void setBeaconDetector(BeaconDetector beaconDetector) {
		this.beaconDetector = beaconDetector;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((beaconDetector == null) ? 0 : beaconDetector.hashCode());
		result = prime * result
				+ ((beaconEvent == null) ? 0 : beaconEvent.hashCode());
		result = prime * result
				+ ((checkDateMilis == null) ? 0 : checkDateMilis.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CheckIn other = (CheckIn) obj;
		if (beaconDetector == null) {
			if (other.beaconDetector != null)
				return false;
		} else if (!beaconDetector.equals(other.beaconDetector))
			return false;
		if (beaconEvent == null) {
			if (other.beaconEvent != null)
				return false;
		} else if (!beaconEvent.equals(other.beaconEvent))
			return false;
		if (checkDateMilis == null) {
			if (other.checkDateMilis != null)
				return false;
		} else if (!checkDateMilis.equals(other.checkDateMilis))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CheckIn [id=" + id + ", checkDateMilis=" + checkDateMilis
				+ ", beaconEvent=" + beaconEvent + ", beaconDetector="
				+ beaconDetector + "]";
	}

}
