package com.morris__.simplekatanas.custom;

import com.morris__.simplekatanas.Item.custom.KatanaItem;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;

public class ModEvents {

    private static final int PARRY_WINDOW_TICKS = 6;

    public static void registerEvents() {

        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {

            if (!(entity instanceof PlayerEntity player)) return true;
            if (!player.isUsingItem()) return true;

            ItemStack stack = player.getActiveItem();
            if (!(stack.getItem() instanceof KatanaItem katana)) return true;

            KatanaTier tier = katana.getTier();

            int usedTicks = player.getItemUseTime();

            // ⚔️ PERFECT PARRY → 0 damage
            if (usedTicks <= PARRY_WINDOW_TICKS) {



                switch (tier) {
                    case WOOD, STONE -> {
                        float pitch = 0.90f + player.getWorld().random.nextFloat() * 0.1f;

                        player.getWorld().playSound(
                                null,
                                player.getBlockPos(),
                                SoundEvents.BLOCK_WOOD_HIT,
                                SoundCategory.PLAYERS,
                                0.5f,
                                pitch
                        );
                    }
                    case METAL -> {
                        float pitch = 0.90f + player.getWorld().random.nextFloat() * 0.1f;

                        player.getWorld().playSound(
                                null,
                                player.getBlockPos(),
                                SoundEvents.ITEM_TRIDENT_HIT,
                                SoundCategory.PLAYERS,
                                0.5f,
                                pitch
                        );
                    }
                }

                spawnParryParticles(player, tier); // ✨ PARTICLES

                if (!(source.getSource() instanceof ProjectileEntity)) {
                    applyParryEffect(player, source.getAttacker());      // arrow parry
                }

                damageKatana(stack, player, 1);
                return false; // ⛔ volledig block
            }

            // 🛡️ LATE BLOCK → speler krijgt normale damage
            damageKatana(stack, player, 2);
            player.addExhaustion(2.0f);

            return true; // damage gaat door
        });
    }

    private static void damageKatana(ItemStack stack, PlayerEntity player, int amount) {
        stack.damage(
                amount,
                player,
                player.getActiveHand() == Hand.MAIN_HAND
                        ? EquipmentSlot.MAINHAND
                        : EquipmentSlot.OFFHAND
        );
    }

    // ✨ Perfect-parry particles
    private static void spawnParryParticles(PlayerEntity player, KatanaTier tier) {

        if (!(player.getWorld() instanceof ServerWorld serverWorld)) return;

        Vec3d look = player.getRotationVec(1.0f);
        Vec3d pos = player.getPos()
                .add(0, player.getStandingEyeHeight(), 0)
                .add(look.multiply(0.6));

        switch (tier) {
            case WOOD, STONE -> {
                serverWorld.spawnParticles(
                        ParticleTypes.CRIT,
                        pos.x, pos.y, pos.z,
                        4,
                        0.1, 0.1, 0.1,
                        0.05
                );
            }
            case METAL -> {
                serverWorld.spawnParticles(
                        ParticleTypes.CRIT,
                        pos.x, pos.y, pos.z,
                        5,
                        0.1, 0.1, 0.1,
                        0.1
                );


                serverWorld.spawnParticles(
                        ParticleTypes.ASH,
                        pos.x, pos.y, pos.z,
                        2,
                        0.15, 0.15, 0.15,
                        0.08

                );
            }
        }

    }
    private static void applyParryEffect(PlayerEntity player, Entity attacker) {

        if (!(attacker instanceof LivingEntity living)) return;

        // 🔄 Reset attack animation
        living.timeUntilRegen = 10;
        living.hurtTime = 10;

        // 💥 Knockback
        Vec3d knockback = living.getPos().subtract(player.getPos()).normalize();
        living.addVelocity(
                knockback.x * 0.8,
                0.2,
                knockback.z * 0.8
        );
        living.velocityModified = true;

        // 🧠 Mini-stun (slowness + weakness)
        living.addStatusEffect(new StatusEffectInstance(
                StatusEffects.SLOWNESS,
                20, // 1 second
                4,  // strong
                false,
                false,
                true
        ));

        living.addStatusEffect(new StatusEffectInstance(
                StatusEffects.WEAKNESS,
                20,
                1,
                false,
                false,
                true
        ));
    }

}
