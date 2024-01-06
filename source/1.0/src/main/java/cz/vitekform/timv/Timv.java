package cz.vitekform.timv;

import cz.vitekform.timv.functions.datafunctions;
import cz.vitekform.timv.functions.configfunctions;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Timv extends JavaPlugin {

    @Override
    public void onEnable() {
        configfunctions ConfigFunctions = new configfunctions();
        ConfigFunctions.setup();
        FileConfiguration config = ConfigFunctions.get();
        config.getDefaults().addDefault("minPlayersPerInstance", 10);
        config.getDefaults().addDefault("maxPlayersPerInstance", 20);
        ConfigFunctions.reload(config);
        datafunctions DataFunctions = new datafunctions();
        FileConfiguration data = DataFunctions.get();
        DataFunctions.reload(data);
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
