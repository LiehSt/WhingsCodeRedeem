package me.whings.plugin.command;

import me.whings.plugin.WhingsCodeRedeemPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class CodeCommand implements CommandExecutor {
    private final FileConfiguration config = WhingsCodeRedeemPlugin.getInstance().getConfig();
    private final String path = "redeemed.";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Hanya player yang bisa klaim kode.");
            return true;
        }

        if (args.length != 1) {
            player.sendMessage("§cGunakan: /code <kode>");
            return true;
        }

        String code = args[0].toLowerCase();
        UUID uuid = player.getUniqueId();
        List<String> used = config.getStringList(path + uuid);

        if (used.contains(code)) {
            player.sendMessage("§eKamu sudah pernah klaim kode ini.");
            return true;
        }

        if (!config.contains("codes." + code)) {
            player.sendMessage("§cKode tidak ditemukan.");
            return true;
        }

        List<String> commands = config.getStringList("codes." + code + ".rewards");
        String message = config.getString("codes." + code + ".message", "&aBerhasil klaim kode!");

        for (String cmd : commands) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd.replace("%player%", player.getName()));
        }

        used.add(code);
        config.set(path + uuid, used);
        WhingsCodeRedeemPlugin.getInstance().saveConfig();

        player.sendMessage(message.replace("&", "§"));
        return true;
    }
}
