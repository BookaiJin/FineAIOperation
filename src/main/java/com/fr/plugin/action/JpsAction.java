package com.fr.plugin.action;

import com.fr.log.FineLoggerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bokai
 * @version 10.0
 * Created by bokai on 2020-04-08
 */
public class JpsAction extends AbstractAction {
    public static void main(String... args) throws Exception {
        JpsAction action = new JpsAction();
        action.doAction("1");
    }

    @Override
    public void doAction(String pid) throws Exception {

        List<String> pids = getAllJavaProgress();
        for (Object line : pids.toArray()) {

            FineLoggerFactory.getLogger().info(line.toString());
        }
    }

    private List<String> getAllJavaProgress() throws Exception {

        List<String> pids = new ArrayList<>();

        String jpsFile = getJspFile().getAbsolutePath();
        String[] jpsCommand = new String[]{jpsFile, "-l"};

        Process p = Runtime.getRuntime().exec(jpsCommand);
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            pids.add(line);
        }

        return pids;
    }

    private File getJspFile() {

        String javaHome = System.getProperty("java.home");

        String[] paths = {"bin/jps", "bin/jps.exe", "../bin/jps", "../bin/jps.exe"};

        List<File> jpsList = new ArrayList<File>();
        for (String path : paths) {
            File jpsFile = new File(javaHome, path);
            if (jpsFile.exists()) {
                FineLoggerFactory.getLogger().debug("Found jps: " + jpsFile.getAbsolutePath());
                jpsList.add(jpsFile);
            }
        }

        if (jpsList.isEmpty()) {
            FineLoggerFactory.getLogger().debug("Can not find jps under :" + javaHome);
            String javaHomeEnv = System.getenv("JAVA_HOME");
            FineLoggerFactory.getLogger().debug("Try to find jps under env JAVA_HOME :" + javaHomeEnv);
            for (String path : paths) {
                File jpsFile = new File(javaHomeEnv, path);
                if (jpsFile.exists()) {
                    FineLoggerFactory.getLogger().debug("Found jps: " + jpsFile.getAbsolutePath());
                    jpsList.add(jpsFile);
                }
            }
        }

        if (jpsList.isEmpty()) {
            FineLoggerFactory.getLogger().debug("Can not find jps under current java home: " + javaHome);
            return null;
        }

        // find the shortest path, jre path longer than jdk path
        if (jpsList.size() > 1) {
            jpsList.sort((file1, file2) -> {
                try {
                    return file1.getCanonicalPath().length() - file2.getCanonicalPath().length();
                } catch (IOException e) {
                    // ignore
                }
                return -1;
            });
        }
        return jpsList.get(0);
    }
}
