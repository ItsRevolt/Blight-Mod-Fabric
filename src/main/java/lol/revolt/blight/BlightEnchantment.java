package lol.revolt.blight;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

public class BlightEnchantment extends Enchantment {
    public BlightEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 25;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        /*

        if((target instanceof LivingEntity) || (target instanceof MobEntity)) {
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 3 * level, level - 1));
            ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.scheduleAtFixedRate(() -> {

                // Code to be executed after the delay
                System.out.println("After " + 1 * level + " seconds");
                    // If the conditions are met, kill the target
                    System.out.println("still poisoned after");
                    if (((LivingEntity) target).hasStatusEffect(StatusEffects.POISON)) {

                        if (((LivingEntity) target).getHealth() <= 1) {
                            target.kill();
                            executorService.shutdown();
                        }
                    } else {
                        executorService.shutdown();
                    }
            }, 0, 1, TimeUnit.SECONDS);

            // Shutdown the executor service after use
        }

         */
        if (target instanceof LivingEntity entity && !user.getWorld().isClient()) {
            entity.addStatusEffect(new StatusEffectInstance(new BlightStatusEffect(level), 20 * 3 * level, level - 1));
            //target.kill();
        }
        super.onTargetDamaged(user, target, level);
    }
}
