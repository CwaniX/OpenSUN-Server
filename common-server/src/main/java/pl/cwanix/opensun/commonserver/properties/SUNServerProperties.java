package pl.cwanix.opensun.commonserver.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "opensun")
public class SUNServerProperties {

    @NestedConfigurationProperty
    private SUNServerClientProperties client;
}
