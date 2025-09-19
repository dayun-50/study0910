package com.kedu.endpoints;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.common.collect.EvictingQueue;
import com.google.gson.Gson;
import com.kedu.config.ChatConfigurator;
import com.kedu.config.SpringProvider;
import com.kedu.dto.ChatDTO;
import com.kedu.dto.ChatDataDTO;
import com.kedu.services.ChatService;

@ServerEndpoint(value = "/chat", configurator = ChatConfigurator.class)
public class ChatEndpoint {
	private String hSession;
	private ChatService cServ = SpringProvider.ctx.getBean(ChatService.class);
	
	public static Set<Session> clients = Collections.synchronizedSet(new HashSet<>());
	private static Gson gson = SpringProvider.ctx.getBean(Gson.class);
	
	@OnOpen
		public void onConnection(Session Session, EndpointConfig config) {
		List<ChatDTO> list = cServ.selectAll();
		ChatDataDTO dto = new ChatDataDTO("history",list);
			try {
				Session.getBasicRemote().sendText(gson.toJson(dto));
			}catch(Exception e) {e.printStackTrace();}
		
			clients.add(Session);
			this.hSession = (String)config.getUserProperties().get("hName");
		}
	
	@OnMessage
	public void onMessage(String messagae) {
		ChatDTO cDto = new ChatDTO(0,this.hSession, messagae, "");
		ChatDataDTO dto = new ChatDataDTO("chat", this.hSession+" : "+messagae);
		cServ.insert(cDto);
		
		synchronized (clients) {
			for(Session client : clients) {
				try {
					client.getBasicRemote().sendText(gson.toJson(dto));
				}catch(Exception e){}
			}
		}
	}
	
	@OnClose
	public void onClose(Session session) {
		clients.remove(session);
	}
	
	@OnError
	public void onError(Session session, Throwable t) {
		clients.remove(session);
		t.printStackTrace();
	}
}
