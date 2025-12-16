package com.kjmaster.quintelementa.foundation.data;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.builders.BlockEntityBuilder;
import com.tterrag.registrate.builders.Builder;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;

public class QuintElementaRegistrate extends AbstractRegistrate<QuintElementaRegistrate> {
    private static final Map<RegistryEntry<?, ?>, DeferredHolder<CreativeModeTab, CreativeModeTab>> TAB_LOOKUP = Collections.synchronizedMap(new IdentityHashMap<>());

    protected DeferredHolder<CreativeModeTab, CreativeModeTab> currentTab;

    protected QuintElementaRegistrate(String modid) {
        super(modid);
    }

    public static QuintElementaRegistrate create(String modid) {
        return new QuintElementaRegistrate(modid);
    }

    public static boolean isInCreativeTab(RegistryEntry<?, ?> entry, DeferredHolder<CreativeModeTab, CreativeModeTab> tab) {
        return TAB_LOOKUP.get(entry) == tab;
    }

    @Nullable
    public QuintElementaRegistrate setCreativeTab(DeferredHolder<CreativeModeTab, CreativeModeTab> tab) {
        currentTab = tab;
        return self();
    }

    public DeferredHolder<CreativeModeTab, CreativeModeTab> getCreativeTab() {
        return currentTab;
    }

    @Override
    public @NotNull QuintElementaRegistrate registerEventListeners(@NotNull IEventBus bus) {
        return super.registerEventListeners(bus);
    }

    @Override
    protected <R, T extends R> @NotNull RegistryEntry<R, T> accept(@NotNull String name, @NotNull ResourceKey<? extends Registry<R>> type, @NotNull Builder<R, T, ?, ?> builder, @NotNull NonNullSupplier<? extends T> creator, @NotNull NonNullFunction<DeferredHolder<R, T>, ? extends RegistryEntry<R, T>> entryFactory) {
        RegistryEntry<R, T> entry = super.accept(name, type, builder, creator, entryFactory);
        if (currentTab != null)
            TAB_LOOKUP.put(entry, currentTab);

        return entry;
    }

    @Override
    public <T extends BlockEntity> @NotNull QuintElementaBlockEntityBuilder<T, QuintElementaRegistrate> blockEntity(@NotNull String name,
                                                                                                                    BlockEntityBuilder.@NotNull BlockEntityFactory<T> factory) {
        return blockEntity(self(), name, factory);
    }

    @Override
    public <T extends BlockEntity, P> @NotNull QuintElementaBlockEntityBuilder<T, P> blockEntity(@NotNull P parent, @NotNull String name,
                                                                                                 BlockEntityBuilder.@NotNull BlockEntityFactory<T> factory) {
        return (QuintElementaBlockEntityBuilder<T, P>) entry(name,
                (callback) -> QuintElementaBlockEntityBuilder.create(this, parent, name, callback, factory));
    }
}
