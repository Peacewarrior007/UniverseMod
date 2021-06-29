package net.mcreator.universemod.procedures;

import net.mcreator.universemod.UniverseModModElements;
import net.minecraft.entity.Entity;

import java.util.Map;

@UniverseModModElements.ModElement.Tag
public class GravityProcedure extends UniverseModModElements.ModElement {
	public GravityProcedure(UniverseModModElements instance) {
		super(instance, 4);
	}

	public static void executeProcedure(Map<String, Object> dependencies, Entity entity, double power) {
		double velocity = 0;
		if ((((velocity) + (power)) < 4)) {
			velocity = (double) (((velocity) + (power / 10)));
			entity.setMotion(entity.getMotion().getX(), (entity.getMotion().getY() - velocity), entity.getMotion().getZ());
		}
	}
}