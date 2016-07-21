package com.htakemoto.config

import groovy.json.JsonOutput
import groovy.util.logging.Slf4j
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.web.socket.messaging.SessionConnectedEvent
import org.springframework.web.socket.messaging.SessionDisconnectEvent

@Component
@Slf4j
class SocketEventListener {

    // for more information:
    // http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#websocket-stomp-handle-broker-relay-configure

    @EventListener
    public void handleContextRefresh(SessionConnectedEvent event) {
        log.debug(JsonOutput.toJson(event))
        log.info("connected sessionId: " + event.message.headers["simpSessionId"])
    }

    @EventListener
    public void handleContextRefresh(SessionDisconnectEvent event) {
        log.debug(JsonOutput.toJson(event))
        log.info("disconnected sessionId: " + event.sessionId)
    }
}
