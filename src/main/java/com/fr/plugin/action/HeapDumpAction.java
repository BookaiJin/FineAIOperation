package com.fr.plugin.action;

import com.sun.tools.attach.VirtualMachine;
import java.io.File;
import sun.tools.attach.HotSpotVirtualMachine;

/**
 * @author bokai
 * @version 10.0
 * Created by bokai on 2020-04-02
 */
public class HeapDumpAction extends AbstractAction {

    private static final String LIVE_OBJECT_OPTION = "-live";
    private static final String ALL_OBJECT_OPTION = "-all";

    @Override

    public void doAction(String pid) throws Exception {

        HotSpotVirtualMachine virtualMachine = (HotSpotVirtualMachine) VirtualMachine.attach(pid);

        File file = new File("~/");
        virtualMachine.dumpHeap(file, LIVE_OBJECT_OPTION);
    }
}
