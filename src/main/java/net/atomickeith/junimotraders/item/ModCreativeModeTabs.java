package net.atomickeith.junimotraders.item;

import net.atomickeith.junimotraders.JunimoTraders;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JunimoTraders.MOD_ID);

    public static final Supplier<CreativeModeTab> JUNIMO_TRADERS_TAB = CREATIVE_MODE_TAB.register("junimo_traders_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GOLD_COIN.get()))
                    .title(Component.translatable("creativetab.junimotraders.junimo_traders"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.COPPER_COIN);
                        output.accept(ModItems.IRON_COIN);
                        output.accept(ModItems.GOLD_COIN);
                        output.accept(ModItems.IRIDIUM_COIN);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
