package me.whings.plugin.command;

import me.whings.plugin.WhingsCodeRedeemPlugin;
import org.bukkit.command.*;
import org.bukkit.configuration.file.FileConfiguration;
import java.util.Set;

public class WhingsCommand implements CommandExecutor {
    private final FileConfiguration config = WhingsCodeRedeemPlugin.getInstance().getConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("whingscoderedeem.admin")) {
            sender.sendMessage("§cKamu tidak punya izin.");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage("§cGunakan: /wcr <create|delete|list|reload>");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "create" -> {
                if (args.length < 3) {
                    sender.sendMessage("§cGunakan: /wcr create <code> <command>");
                    return true;
                }
                String code = args[1].toLowerCase();
                String reward = String.join(" ", args).substring(args[0].length() + args[1].length() + 2);
                config.set("codes." + code + ".rewards", java.util.Collections.singletonList(reward));
                config.set("codes." + code + ".message", "&aBerhasil klaim kode!");
                WhingsCodeRedeemPlugin.getInstance().saveConfig();
                sender.sendMessage("§aKode berhasil dibuat: " + code);
            }
            case "delete" -> {
                if (args.length != 2) {
                    sender.sendMessage("§cGunakan: /wcr delete <code>");
                    return true;
                }
                config.set("codes." + args[1].toLowerCase(), null);
                WhingsCodeRedeemPlugin.getInstance().saveConfig();
                sender.sendMessage("§cKode dihapus: " + args[1]);
            }
            case "list" -> {
                Set<String> codes = config.getConfigurationSection("codes") != null
                    ? config.getConfigurationSection("codes").getKeys(false)
                    : null;
                if (codes == null || codes.isEmpty()) {
                    sender.sendMessage("§7Belum ada kode.");
                    return true;
                }
                sender.sendMessage("§6Daftar Kode:");
                for (String c : codes) {
                    sender.sendMessage("§e- " + c);
                }
            }
            case "reload" -> {
                WhingsCodeRedeemPlugin.getInstance().reloadConfig();
                sender.sendMessage("§aConfig berhasil direload.");
            }
            default -> sender.sendMessage("§cSubcommand tidak dikenal.");
        }
        return true;
    }
}
