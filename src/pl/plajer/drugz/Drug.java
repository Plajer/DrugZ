package pl.plajer.drugz;

import org.bukkit.Material;
import org.bukkit.potion.PotionEffect;

import java.util.List;

/**
 * @author Plajer
 * <p>
 * Created at 25.06.2018
 */
public class Drug {

    private String ID;
    private String name;
    private Material item;
    private List<PotionEffect> potionEffects;

    public Drug(String ID, String name, Material item, List<PotionEffect> potionEffects) {
        this.ID = ID;
        this.name = name;
        this.item = item;
        this.potionEffects = potionEffects;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Material getItem() {
        return item;
    }

    public List<PotionEffect> getPotionEffects() {
        return potionEffects;
    }
}
