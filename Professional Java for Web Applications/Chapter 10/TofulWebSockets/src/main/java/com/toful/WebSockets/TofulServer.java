package com.toful.WebSockets;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/servers/tofulserver")
public class TofulServer {
    
    @OnOpen
    public void onOpen(Session session)
    {
        System.out.println("onOpen " + session.getId());
    }
    
    @OnMessage
    public void onMessage(Session session, String message) throws IOException
    {
        System.out.println("onMessage: " + session.getId() + " Msg: " + message);
        ObjectMapper mapper = new ObjectMapper();
        TofulMessage tofulMessage = mapper.readValue(message, TofulMessage.class);
        
        System.out.println("Message is: " + tofulMessage.toString());
        
        // Send a reply. In this example, just reverse the text
        
        String reverseTextBack = new StringBuilder(tofulMessage.getMessage()).reverse().toString();
        session.getBasicRemote().sendText(mapper.writeValueAsString(reverseTextBack));
    }
    
    @OnClose
    public void onClose(Session session)
    {
        System.out.println("onClose");
    }
}
