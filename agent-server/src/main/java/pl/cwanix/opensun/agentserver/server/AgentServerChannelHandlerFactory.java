package pl.cwanix.opensun.agentserver.server;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessorExecutor;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandlerFactory;

@Component
@RequiredArgsConstructor
public class AgentServerChannelHandlerFactory implements SUNServerChannelHandlerFactory {

	private final SUNPacketProcessorExecutor processorExecutor;

	@Override
	public SUNServerChannelHandler getChannelHandler() {
		return new AgentServerChannelHandler(processorExecutor);
	}
}
