package net.mcreator.universemod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.universemod.UniverseModModElements;
import net.mcreator.universemod.UniverseModMod;

import java.util.Map;
import java.util.HashMap;

@UniverseModModElements.ModElement.Tag
public class OnPlayerTickEventProcedure extends UniverseModModElements.ModElement {
	public OnPlayerTickEventProcedure(UniverseModModElements instance) {
		super(instance, 2);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				UniverseModMod.LOGGER.warn("Failed to load dependency entity for procedure OnPlayerTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.fallDistance = (float) (0);
		entity.setNoGravity((true));
		{
			if (!entity.isOnGround()) {
				Map<String, Object> $_dependencies = new HashMap<>();
				GravityProcedure.executeProcedure($_dependencies, entity, 1);
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
