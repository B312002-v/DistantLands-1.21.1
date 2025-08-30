package net.beastguy.distantlandsmc.villager;

import com.google.common.collect.ImmutableSet;
import net.beastguy.distantlandsmc.DistantLandsMod;
import net.beastguy.distantlandsmc.block.ModBlocks;
import net.beastguy.distantlandsmc.sound.ModSounds;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, DistantLandsMod.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, DistantLandsMod.MODID);

    public static final Holder<PoiType> CARPENTER_POI = POI_TYPES.register("carpenter_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.CARPENTER_TABLE.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final Holder<VillagerProfession> CARPENTER = VILLAGER_PROFESSIONS.register("carpenter",
            () -> new VillagerProfession("carpenter", holder -> holder.value() == CARPENTER_POI.value(),
                    holder -> holder.value() == CARPENTER_POI.value(), ImmutableSet.of(), ImmutableSet.of(),
                    ModSounds.CHAINSAW_CUT.get()));


    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
