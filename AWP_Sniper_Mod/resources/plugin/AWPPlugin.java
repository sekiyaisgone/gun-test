package com.awpmod;

import com.hypixel.hytale.server.core.modules.interaction.interaction.config.Interaction;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.awpmod.interaction.AWPScopeInteraction;

import javax.annotation.Nonnull;

/**
 * AWP Sniper Mod - Main Plugin Class
 *
 * This plugin registers custom interaction types for the AWP sniper rifle.
 * It extends the base pack functionality with:
 * - Custom scope/ADS interaction with FOV zoom
 * - Weapon sway reduction while scoped
 * - Movement speed penalty while aiming
 *
 * Note: The core weapon functionality (shooting, reloading, ammo consumption)
 * is handled entirely through the JSON pack definitions and does not require
 * this plugin. This plugin is only needed for the advanced scope mechanic.
 */
public class AWPPlugin extends JavaPlugin {

    public AWPPlugin(@Nonnull JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        // Register the custom AWP scope interaction type
        this.getCodecRegistry(Interaction.CODEC)
            .register("awp_scope_interaction", AWPScopeInteraction.class, AWPScopeInteraction.CODEC);

        getLogger().info("AWP Sniper Mod plugin loaded successfully!");
        getLogger().info("Registered custom interaction: awp_scope_interaction");
    }
}
