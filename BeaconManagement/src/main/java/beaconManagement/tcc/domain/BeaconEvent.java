package beaconManagement.tcc.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Wagner
 */
@Entity
@Table(name = "beaconevent", schema = "management")
public class BeaconEvent implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property name="id"
	 */
	private Long id;

	/**
	 * @uml.property name="startDateMillis"
	 */
	@NotBlank
	private BigDecimal startDateMillis;

	/**
	 * @uml.property name="endDateMillis"
	 */
	@NotBlank
	private BigDecimal endDateMillis;

	public BeaconEvent() {
		super();
	}

	public BeaconEvent(Long id, BigDecimal startDateMillis,
			BigDecimal endDateMillis) {
		super();
		this.id = id;
		this.startDateMillis = startDateMillis;
		this.endDateMillis = endDateMillis;
	}

	/**
	 * @return
	 * @uml.property name="id"
	 */
	@Id
	@Column(name = "beaconevent_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_beaconevent_id")
	@SequenceGenerator(name = "sq_beaconevent_id", sequenceName = "management.SQ_BEACONEVENT_ID", initialValue = 1, allocationSize = 1)
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 * @uml.property name="id"
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return
	 * @uml.property name="startDateMillis"
	 */
	public BigDecimal getStartDateMillis() {
		return startDateMillis;
	}

	public void setStartDateMillis(BigDecimal startDateMillis) {
		this.startDateMillis = startDateMillis;
	}

	/**
	 * @return
	 * @uml.property name="endDateMillis"
	 */
	public BigDecimal getEndDateMillis() {
		return endDateMillis;
	}

	public void setEndDateMillis(BigDecimal endDateMillis) {
		this.endDateMillis = endDateMillis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((endDateMillis == null) ? 0 : endDateMillis.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((startDateMillis == null) ? 0 : startDateMillis.hashCode());
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
		if (endDateMillis == null) {
			if (other.endDateMillis != null)
				return false;
		} else if (!endDateMillis.equals(other.endDateMillis))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (startDateMillis == null) {
			if (other.startDateMillis != null)
				return false;
		} else if (!startDateMillis.equals(other.startDateMillis))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BeaconEvent [id=" + id + ", startDateMillis=" + startDateMillis
				+ ", endDateMillis=" + endDateMillis + "]";
	}

}
