package com.fr.plugin.action;

/**
 * @author bokai
 * @version 10.0
 * Created by bokai on 2020-04-02
 */
public class ThreadDumpAction extends AbstractAction {
    @Override
    public void doAction(String pid) throws Exception {
        Runtime.getRuntime().exec(new String[]{});
    }
}
