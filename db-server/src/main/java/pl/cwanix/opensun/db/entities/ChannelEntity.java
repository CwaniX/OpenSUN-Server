package pl.cwanix.opensun.db.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "channel_instance", schema="config")
public class ChannelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_channel_instance_generator")
	@SequenceGenerator(name = "seq_channel_instance_generator", sequenceName = "seq_channel_instance")
	private int id;
	private String name;
	@ManyToOne
	@JoinColumn(name = "server_instance_id")
	private ServerEntity server;
}
