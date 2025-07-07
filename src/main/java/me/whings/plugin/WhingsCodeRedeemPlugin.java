package me.whings.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import me.whings.plugin.command.CodeCommand;
import me.whings.plugin.command.WhingsCommand;

public class WhingsCodeRedeemPlugin extends JavaPlugin {
    private static WhingsCodeRedeemPlugin instance;

    public static WhingsCodeRedeemPlugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getCommand("whingscoderedeem").setExecutor(new WhingsCommand());
        getCommand("code").setExecutor(new CodeCommand());
        getLogger().info("Whings Code Redeem plugin aktif!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Whings Code Redeem plugin dimatikan.");
    }
}
