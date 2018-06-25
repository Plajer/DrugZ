package pl.plajer.drugz;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;

/**
 * @author Plajer
 * <p>
 * Created at 25.06.2018
 */
public class DrugListener implements Listener {

    private Main plugin;

    public DrugListener(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onDrugUse(PlayerInteractEvent e) {
        if(e.getItem() == null) return;
        if(e.getItem().getItemMeta() == null || !e.getItem().getItemMeta().hasDisplayName()) return;
        String drugName = e.getItem().getItemMeta().getDisplayName();
        for(Drug drug : plugin.getDrugLoader().getDrugList()) {
            if(drug.getName().equals(drugName)) {
                e.getItem().setAmount(e.getItem().getAmount() - 1);
                for(PotionEffect eff : drug.getPotionEffects()) {
                    e.getPlayer().addPotionEffect(eff);
                }
                e.getPlayer().sendMessage(Utils.color("Messages.Used-Drug").replace("%drug%", drug.getName()));
                return;
            }
        }
    }

}
