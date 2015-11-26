package beaconManagement.tcc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "beaconevent", schema = "management")
public class BeaconEvent implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank
	private Long startDateMilis;

	@NotBlank
	private Long endDateMilis;

	public BeaconEvent(Long id, Long startDateMilis, Long endDateMilis) {
		super();
		this.id = id;
		this.startDateMilis = startDateMilis;
		this.endDateMilis = endDateMilis;
	}

	@Id
	@Column(name = "beaconevent_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_beaconevent_id")
	@SequenceGenerator(name = "sq_beaconevent_id", sequenceName = "management.SQ_BEACONEVENT_ID", initialValue = 1, allocationSize = 1)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStartDateMilis() {
		return startDateMilis;
	}

	public void setStartDateMilis(Long startDateMilis) {
		this.startDateMilis = startDateMilis;
	}

	public Long getEndDateMilis() {
		return endDateMilis;
	}

	public void setEndDateMilis(Long endDateMilis) {
		this.endDateMilis = endDateMilis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((endDateMilis == null) ? 0 : endDateMilis.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((startDateMilis == null) ? 0 : startDateMilis.hashCode());
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
		if (endDateMilis == null) {
			if (other.endDateMilis != null)
				return false;
		} else if (!endDateMilis.equals(other.endDateMilis))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (startDateMilis == null) {
			if (other.startDateMilis != null)
				return false;
		} else if (!startDateMilis.equals(other.startDateMilis))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BeaconEvent [id=" + id + ", startDateMilis=" + startDateMilis
				+ ", endDateMilis=" + endDateMilis + "]";
	}

}
