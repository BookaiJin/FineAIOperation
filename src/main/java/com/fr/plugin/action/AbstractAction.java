package com.fr.plugin.action;

/**
 * @author bokai
 * @version 10.0
 * Created by bokai on 2020-04-02
 */
public abstract class AbstractAction implements Action{

    public static Action DEFAULT_ACTION = new Action() {
        @Override
        public void doAction(String pid) throws Exception {

        }
    };

}
