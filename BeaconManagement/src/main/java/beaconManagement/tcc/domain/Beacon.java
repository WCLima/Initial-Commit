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

/**
 * @author  Wagner
 */
@Entity
@Table(name = "beacon", schema = "management")
public class Beacon implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property  name="id"
	 */
	private Long id;

	/**
	 * @uml.property  name="name"
	 */
	@NotBlank
	private String name;

	/**
	 * @uml.property  name="mac"
	 */
	@NotBlank
	private String mac;

	public Beacon() {
		super();
	}

	public Beacon(String name, String mac) {
		super();
		this.name = name;
		this.mac = mac;
	}

	/**
	 * @return
	 * @uml.property  name="id"
	 */
	@Id
	@Column(name = "beacon_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_beacon_id")
	@SequenceGenerator(name = "sq_beacon_id", sequenceName = "management.SQ_BEACON_ID", initialValue = 1, allocationSize = 1)
	public Long getId() {
		return id;
	}

	/**
	 * @param  id
	 * @uml.property  name="id"
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param  name
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 * @uml.property  name="mac"
	 */
	public String getMac() {
		return mac;
	}

	/**
	 * @param  mac
	 * @uml.property  name="mac"
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}

	@Override
	public String toString() {
		return "Beacon [id=" + id + ", name=" + name + ", mac=" + mac + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((mac == null) ? 0 : mac.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Beacon other = (Beacon) obj;
		if (id != other.id)
			return false;
		if (mac == null) {
			if (other.mac != null)
				return false;
		} else if (!mac.equals(other.mac))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
