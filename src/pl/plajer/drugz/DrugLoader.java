package pl.plajer.drugz;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Plajer
 * <p>
 * Created at 25.06.2018
 */
public class DrugLoader {

    private List<Drug> drugList = new ArrayList<>();

    public DrugLoader(Main plugin) {
        for(String key : plugin.getConfig().getConfigurationSection("Drugs").getKeys(false)){
            Drug drug;
            String name = Utils.colorRaw(plugin.getConfig().getString("Drugs." + key + ".Name"));
            Material item = Material.getMaterial(plugin.getConfig().getString("Drugs." + key + ".Item"));
            List<String[]> potions = new ArrayList<>();
            for(String potion : plugin.getConfig().getStringList("Drugs." + key + ".Potions")){
                potions.add(potion.split(";"));
            }
            List<PotionEffect> potionEffects = new ArrayList<>();
            for(String[] potion : potions){
                potionEffects.add(new PotionEffect(PotionEffectType.getByName(potion[0].toUpperCase()), Integer.valueOf(potion[1]) * 20, Integer.valueOf(potion[2])));
            }
            drug = new Drug(key, name, item, potionEffects);
            drugList.add(drug);
            Bukkit.getConsoleSender().sendMessage("[DrugZ} New drug " + key + " has been loaded!");
        }
    }

    public List<Drug> getDrugList() {
        return drugList;
    }
}
