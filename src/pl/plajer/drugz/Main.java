package pl.plajer.drugz;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Plajer
 * <p>
 * Created at 25.06.2018
 */
public class Main extends JavaPlugin {

    private DrugLoader drugLoader;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        new DrugCommand(this);
        drugLoader = new DrugLoader(this);
        new DrugListener(this);
    }

    public DrugLoader getDrugLoader() {
        return drugLoader;
    }
}
