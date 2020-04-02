package com.fr.plugin;

import com.fr.log.FineLoggerFactory;
import com.fr.plugin.action.ActionFactory;

/**
 * @author bokai
 * @version 10.0
 * Created by bokai on 2020-04-02
 */
public class Main {

    public static void main(String... args) {

        String pid = args[0];
        int operationId = Integer.parseInt(args[1]);

        try {
            ActionFactory.getAction(operationId).doAction(pid);
        } catch (Exception e){
            FineLoggerFactory.getLogger().error(e, "Do action failed");
        }
    }
}
