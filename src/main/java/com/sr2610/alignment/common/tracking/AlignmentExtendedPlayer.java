package com.sr2610.alignment.common.tracking;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

import com.sr2610.alignment.common.lib.LibNames;

public class AlignmentExtendedPlayer implements IExtendedEntityProperties {

	public static final String propertyName = LibNames.alignmentTacker;
	private final EntityPlayer player;
	private int currentMorality;

	public AlignmentExtendedPlayer(EntityPlayer player) {
		this.player = player;
		this.currentMorality = 500;
	}

	public final static void registerPlayer(EntityPlayer player) {
		player.registerExtendedProperties(propertyName,
				new AlignmentExtendedPlayer(player));
	}

	public final static AlignmentExtendedPlayer get(EntityPlayer player) {
		return (AlignmentExtendedPlayer) player
				.getExtendedProperties(propertyName);

	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		properties.setInteger("CurrentMorality", currentMorality);
		compound.setTag(propertyName, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound
				.getTag(propertyName);
		this.currentMorality = properties.getInteger("CurrentMorality");
	}

	@Override
	public void init(Entity entity, World world) {
		// Nothing to go here
	}

	public void addMorality(int value) {
		currentMorality = currentMorality + value;
	}

	public int getMorality(){
		return this.currentMorality;
	}

}
