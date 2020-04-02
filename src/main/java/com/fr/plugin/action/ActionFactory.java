package com.fr.plugin.action;

import com.fr.log.FineLoggerFactory;

/**
 * @author bokai
 * @version 10.0
 * Created by bokai on 2020-04-02
 */
public class ActionFactory {

    private ActionFactory(){
        throw new UnsupportedOperationException("You cannot init this class.");
    }

    public static Action getAction(int operationId){

        switch (operationId) {
            case 0:
                FineLoggerFactory.getLogger().info("kill application.");
                return new KillAppAction();
            case 1:
                FineLoggerFactory.getLogger().info("create heap dump");
                return new HeapDumpAction();
            case 2:
                FineLoggerFactory.getLogger().info("create thread dump");
                return new ThreadDumpAction();
            default:
                return AbstractAction.DEFAULT_ACTION;
        }
    }
}
