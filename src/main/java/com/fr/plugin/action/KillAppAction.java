package com.fr.plugin.action;

import com.fr.third.org.apache.commons.lang3.SystemUtils;

/**
 * @author bokai
 * @version 10.0
 * Created by bokai on 2020-04-02
 */
public class KillAppAction extends AbstractAction {

    @Override
    public void doAction(String pid) throws Exception {

        Runtime.getRuntime().exec(getKillAppCommand(pid, false));

        Runtime.getRuntime().exec(getKillAppCommand(pid, true));
    }

    private String[] getKillAppCommand(String pid, boolean isForced) {
        String[] result;
        if (SystemUtils.IS_OS_WINDOWS) {
            result = isForced ? new String[]{"taskkill", "-F", "/pid", pid} : new String[]{"taskkill", "/pid", pid};
        } else if (SystemUtils.IS_OS_LINUX) {
            result = isForced ? new String[]{"kill", "-9", pid} : new String[]{"kill", pid};
        } else {
            throw new UnsupportedOperationException(SystemUtils.OS_NAME + " can not exec kill app action now.");
        }
        return result;
    }
}
