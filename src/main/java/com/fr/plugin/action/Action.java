package com.fr.plugin.action;

/**
 * @author bokai
 * @version 10.0
 * Created by bokai on 2020-04-02
 */
public interface Action {

    /**
     * 操作的接口
     * @param pid 操作的pid
     */
    void doAction(String pid) throws Exception;
}
