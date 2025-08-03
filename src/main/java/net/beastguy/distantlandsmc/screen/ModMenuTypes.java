package net.beastguy.distantlandsmc.screen;

import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.screen.custom.CarpenterTableMenu;
import net.beastguy.distantlandsmc.screen.custom.CarpenterTableMenu2;
import net.beastguy.distantlandsmc.screen.custom.PedestalMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, DistantLandsMod.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<PedestalMenu>> PEDESTAL_MENU =
            registerMenuType("pedestal_menu", PedestalMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<CarpenterTableMenu>> CARPENTER_TABLE_MENU =
            registerMenuType("carpenter_table_menu", CarpenterTableMenu::new);

    //public static final DeferredHolder<MenuType<?>, MenuType<CarpenterTableMenu2>> CARPENTER_TABLE_MENU2 =
    //      registerMenuType("carpenter_table_menu2", CarpenterTableMenu2::new);


    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(
            String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}