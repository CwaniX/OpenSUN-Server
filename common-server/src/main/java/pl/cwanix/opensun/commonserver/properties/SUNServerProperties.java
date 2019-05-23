package pl.cwanix.opensun.commonserver.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "server")
public class SUNServerProperties {

	private int port = 44405;
	private int maxQueueSize = 128;
	private int maxThreadCount = 2;
	private boolean epollMode = false;
}
