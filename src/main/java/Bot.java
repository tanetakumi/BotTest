import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.net.URISyntaxException;
//import java.util.logging.Logger;


public class Bot{

    private static JDA jda;
    //private static Logger log = LoggerFactory.getLogger(Bot.class);

    public static void main(String[] args) throws LoginException, URISyntaxException {
        // 設定ファイルを読み込む

        Runtime r = Runtime.getRuntime();
        System.out.println("version    : " + Runtime.version());
        System.out.println("maxMemory  : " + r.maxMemory());
        System.out.println("totalMemory: " + r.totalMemory());
        //log.info("===start===");
        jda = JDABuilder.createDefault("ODE1NTY4NDkxMDE2MzU1ODQw.YDuTWA.t54AS_QYVFh7vART5N3jQiaHOQA")
                .addEventListeners(new MessageReceived())
                .setActivity(Activity.playing("こんにちわ。を購読中"))
                .build();
    }
}
