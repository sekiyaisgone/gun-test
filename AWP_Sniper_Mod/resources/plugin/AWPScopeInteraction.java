package com.awpmod.interaction;

import com.hypixel.hytale.server.core.modules.interaction.interaction.config.Interaction;
import com.hypixel.hytale.server.core.modules.interaction.interaction.config.SimpleInstantInteraction;
import com.hypixel.hytale.server.core.entity.InteractionContext;
import com.hypixel.hytale.server.core.modules.interaction.CooldownHandler;
import com.hypixel.hytale.server.core.codec.BuilderCodec;

import javax.annotation.Nonnull;

/**
 * AWP Scope Interaction - Provides ADS (Aim Down Sights) functionality.
 *
 * When the player right-clicks with the AWP, this interaction:
 * 1. Reduces FOV for a zoom effect
 * 2. Reduces weapon sway for improved accuracy
 * 3. Applies a slight movement speed penalty while scoped
 */
public class AWPScopeInteraction extends SimpleInstantInteraction {

    public static final BuilderCodec<AWPScopeInteraction> CODEC = BuilderCodec.builder(
        AWPScopeInteraction.class,
        AWPScopeInteraction::new,
        SimpleInstantInteraction.CODEC
    ).build();

    private static final float SCOPE_FOV_MULTIPLIER = 0.35f;
    private static final float SCOPED_SWAY_REDUCTION = 0.7f;
    private static final float SCOPED_SPEED_MULTIPLIER = 0.4f;

    private boolean isScoped = false;

    @Override
    protected void firstRun(@Nonnull InteractionType interactionType,
                           @Nonnull InteractionContext interactionContext,
                           @Nonnull CooldownHandler cooldownHandler) {
        isScoped = !isScoped;

        if (isScoped) {
            // Enter scope mode
            // Reduce FOV for zoom effect
            interactionContext.getPlayer().setCameraFOVMultiplier(SCOPE_FOV_MULTIPLIER);
            // Reduce weapon sway
            interactionContext.getPlayer().setWeaponSwayMultiplier(1.0f - SCOPED_SWAY_REDUCTION);
            // Apply movement speed penalty
            interactionContext.getPlayer().setSpeedMultiplier(SCOPED_SPEED_MULTIPLIER);
            // Play ADS animation
            interactionContext.playItemAnimation("ADS");
        } else {
            // Exit scope mode
            interactionContext.getPlayer().setCameraFOVMultiplier(1.0f);
            interactionContext.getPlayer().setWeaponSwayMultiplier(1.0f);
            interactionContext.getPlayer().setSpeedMultiplier(1.0f);
            // Return to idle
            interactionContext.playItemAnimation("Idle");
        }
    }
}
