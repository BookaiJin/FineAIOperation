package com.fr.plugin.attach;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import java.util.List;

/**
 * @author bokai
 * @version 10.0
 * Created by bokai on 2020-04-08
 */
public class AgentAttach {

    public static void main(String... args) {
        List<VirtualMachineDescriptor> virtualMachines = VirtualMachine.list();
        for (VirtualMachineDescriptor virtualMachineDescriptor: virtualMachines){

        }
    }
}
