package com.hatsnake.ever.chatting.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.hatsnake.ever.member.vo.MemberVO;

@Controller
@ServerEndpoint(value = "/echo")
public class WebSocketChat {
    private static final List<Session> sessionList=new ArrayList<Session>();
    private static final Logger logger = LoggerFactory.getLogger(WebSocketChat.class);
    
    public WebSocketChat() {
        System.out.println("웹소켓(서버) 객체생성");
    }
    
    @GetMapping("/chat")
    public String chat(HttpServletRequest req) {
    	
    	return "chatting/chat";
    }
    
    @OnOpen
    public void onOpen(Session session) {
        try {
            final Basic basic=session.getBasicRemote();
            basic.sendText("대화방에 연결 되었습니다.");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sessionList.add(session);
        
        try {
            for(Session session2 : WebSocketChat.sessionList) {
                session2.getBasicRemote().sendText("접속자 수 : " + sessionList.size());
                
                if(session.getId().equals(session2.getId())) {
                	System.out.println(session2.getId());
                }
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    /*
     * 모든 사용자에게 메시지를 전달한다.
     * @param self
     * @param sender
     * @param message
     */
    private void sendAllSessionToMessage(Session self, String sender, String message) {
    	
        try {
            for(Session session : WebSocketChat.sessionList) {
                if(!self.getId().equals(session.getId())) {
                    session.getBasicRemote().sendText(sender+" : "+message);
                }
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /*
     * 내가 입력하는 메세지
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message,Session session) {
    	
    	String sender = message.split(",")[1];
    	message = message.split(",")[0];
    	
        logger.info("Message From "+sender + ": "+message);
        try {
            final Basic basic=session.getBasicRemote();
            basic.sendText("<나> : "+message);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sendAllSessionToMessage(session, sender, message);
    }
    
    @OnError
    public void onError(Throwable e,Session session) {
        
    }
    
    @OnClose
    public void onClose(Session session) {
        logger.info("Session "+session.getId()+" has ended");
        sessionList.remove(session);
    }
}
