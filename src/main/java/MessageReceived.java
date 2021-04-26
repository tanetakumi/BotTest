import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.security.ProtectionDomain;

public class MessageReceived extends ListenerAdapter {
    public MessageReceived(){

    }
    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        System.out.println("Received:"+e.getMessage());
        Message msg = e.getMessage();
        if (msg.getContentRaw().equals("!file"))
        {
            System.out.println("now");
            MessageChannel channel = e.getChannel();
            try {
                channel.sendMessage(getApplicationPath(MessageReceived.class).toString()).queue();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
        }
    }

    public Path getApplicationPath(Class<?> cls) throws URISyntaxException{
            ProtectionDomain pd = cls.getProtectionDomain();
            CodeSource cs = pd.getCodeSource();
            URL location = cs.getLocation();
            URI uri = location.toURI();
            return Paths.get(uri);
    }
}
