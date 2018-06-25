package pl.plajer.drugz;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * @author Plajer
 * <p>
 * Created at 25.06.2018
 */
public class DrugCommand implements CommandExecutor {

    private Main plugin;

    public DrugCommand(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("drugz").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage(Utils.color("Messages.Only-By-Players"));
            return true;
        }
        if(args.length == 0) {
            sender.sendMessage(Utils.color("Messages.Type-Drug-Name"));
            return true;
        }
        String drugName = args[0];
        for(Drug drug : plugin.getDrugLoader().getDrugList()) {
            if(drug.getID().equals(drugName)) {
                ItemStack drugItem = new ItemStack(drug.getItem(), 1);
                ItemMeta drugMeta = drugItem.getItemMeta();
                drugMeta.setDisplayName(drug.getName());
                drugItem.setItemMeta(drugMeta);
                ((Player) sender).getInventory().addItem(drugItem);
                sender.sendMessage(Utils.color("Messages.Drug-Received").replace("%drug%", drug.getName()));
                return true;
            }
        }
        sender.sendMessage(Utils.color("Messages.Drug-Not-Found"));
        return false;
    }
}
