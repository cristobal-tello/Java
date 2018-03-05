<%-- 
    Document   : main
    Created on : 28-Feb-2018, 17:35:17
    Author     : Developer
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
          <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    </head>
    <body>
        <h1>Hello Worlddddddddddddddddddddddddddddddddddddddddd!</h1>
        <button onclick="sendMessage()">Send message</button>
    </body>
    
     <script type="text/javascript" language="javascript">
            var move;
            $(document).ready(function() {
                

                if(!("WebSocket" in window))
                {
                    alert('WebSockets are not supported in this ' +
                            'browser. Try Internet Explorer 10 or the latest ' +
                            'versions of Mozilla Firefox or Google Chrome.');
                    return;
                }

                var server;
                
                try {
                    server = new WebSocket('ws://' + window.location.host +
                            '/TofulWebSockets/servers/tofulserver');
                    
                } catch(error) {
                    alert(error);
                    return;
                }

                server.onopen = function(event) {
                    console.log("Session open");
                    console.log(event);
                };

                window.onbeforeunload = function() {
                    server.close();
                };

                server.onclose = function(event) {
                    
                };

                server.onerror = function(event) {
                    
                };

                server.onmessage = function(event) {
                    console.log("Ha llegado un mensaje");
                    var message = JSON.parse(event.data);
                    console.log(message);
                };

                sendMessage = function() {
                    if(server != null) {
                        server.send(JSON.stringify({ id: Math.floor((Math.random() * 1000) + 1), message: Date().toString() }));
                    }
                }
            });
        </script>
</html>
