package cz.vitekform.timv.functions;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class datafunctions {

    private static String dir;
    private static File f;
    private static FileConfiguration config;

    public void setup(){
        dir = System.getProperty("user.dir");
        if (!new File(dir + "/plugins/BCMD").isDirectory()){
            new File(dir + "/plugins/BCMD").mkdirs();
        }
        f = new File(dir + "/plugins/BCMD/data.yml");
        config = YamlConfiguration.loadConfiguration(f);
    }

    public void reload(FileConfiguration config){
        try {
            config.save(f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setup();
    }

    public FileConfiguration get(){
        return config;
    }

    public void save(FileConfiguration configuration){
        try {
            configuration.save(f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
