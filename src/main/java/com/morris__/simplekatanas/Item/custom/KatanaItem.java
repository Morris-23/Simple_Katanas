package com.morris__.simplekatanas.Item.custom;

import com.morris__.simplekatanas.custom.KatanaTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class KatanaItem extends SwordItem {

    private final KatanaTier tier;

    public KatanaItem(ToolMaterial material, Settings settings, KatanaTier tier) {
        super(material, settings);
        this.tier = tier;
    }

    public KatanaTier getTier() {
        return tier;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BLOCK;
    }

    // Infinite block
    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return TypedActionResult.consume(user.getStackInHand(hand));
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return super.isEnchantable(stack); // je data tags
    }
}
