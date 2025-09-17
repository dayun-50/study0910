package com.kedu.endpoints;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.kedu.config.WebSocketConfigurator;


@ServerEndpoint(value = "/chat", configurator = WebSocketConfigurator.class)
public class CatEndpoint {
	private HttpSession hSession;
	public static Set<Session> clients = Collections.synchronizedSet(new HashSet<>());	//사용자 세션저장용
	//모든 엔드포엔트들에게 공유하기위해 스테틱 부여
	
	@OnOpen //요게 붙어있어야지 접속시 시작되는 매서드래  //오놈이 config에있는 ServerEndpointConfig sec 요놈시키
	public void onConnection(Session Session, EndpointConfig config) {
		System.out.println("됐냐?");
		clients.add(Session);
		this.hSession = (HttpSession)config.getUserProperties().get("hSession");
		System.out.println(this.hSession.getAttribute("loginID"));
	}

	@OnMessage //여기도 마찬가지로 요 어노테이션이 중요!
	public void onMessage(String message) {	
		synchronized (clients) { // for문도는데 다른 스레드가 방해해서 오류나는걸 싱크로나이즈드?뭐여암튼 얘가 막아준데
			for(Session client : clients) {
				try {
					client.getBasicRemote().sendText(message);
				}catch(Exception e) { }
			}
		}
	}

	@OnClose
	public void onClose(Session session) { //화면을껏을때 세션삭제
		clients.remove(session);
	}

	@OnError
	public void onError(Session session, Throwable t) { //화면을끈게아니라 튕기거나 에러떳을때 세션삭제
		clients.remove(session);
		t.printStackTrace();
	}
}
