package com.kedu.config;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

public class WebSocketConfigurator  extends Configurator{
	@Override                    //엔드포인트로 넘기는놈이고 , 이놈이 http에있는 세션값을 끄낼수있는놈이여
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		HttpSession session = (HttpSession)request.getHttpSession();
		sec.getUserProperties().put("hSession", session);
	}
	
}
