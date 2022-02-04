package com.drevery.scpdisturbance.registration;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.block.*;
import com.drevery.scpdisturbance.block.base.BaseHorizontalBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SCPDisturbance.MOD_ID);

    //SCP-002
    public static final RegistryObject<Block> SKIN_FLOOR = registerBlock("skin_floor",
            () -> new SkinFloor(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).sound(SoundType.SLIME)
                    .doesNotBlockMovement()));

    public static final RegistryObject<Block> FACE_SKIN_FLOOR = registerBlock("face_skin_floor",
            () -> new FaceSkinFloor(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).sound(SoundType.SLIME)
                    .doesNotBlockMovement()));

    public static final RegistryObject<Block> MEAT_BLOCK = registerBlock("meat_block",
            () -> new Block(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).sound(SoundType.SLIME)));

    public static final RegistryObject<Block> STONED_MEAT_WALL = registerBlock("stoned_meat_wall",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(-1f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> SOLID_SKIN_FLOOR = registerBlock("solid_skin_floor",
            () -> new Block(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).sound(SoundType.SLIME)));

    public static final RegistryObject<Block> BONE_BLOCK = registerBlock("bone_block",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(-1f).sound(SoundType.BONE)));

    public static final RegistryObject<Block> METAL_DOOR = registerBlock("metal_door",
            () -> new DoorBlock(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(2f).harvestLevel(2).sound(SoundType.METAL)
                    .notSolid()));

    public static final RegistryObject<Block> MEAT_DOOR = registerBlock("meat_door",
            () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(-1F).harvestLevel(1).sound(SoundType.SLIME)
                    .notSolid()));

    public static final RegistryObject<Block> MEAT_TABLE = registerBlock("meat_table",
            () -> new BaseHorizontalBlock(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.SLIME)
                    .notSolid()));

    public static final RegistryObject<Block> BONE_BLOCKS = registerBlock("bone_blocks",
            () -> new BoneBlocks(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.BONE)
                    .notSolid().doesNotBlockMovement()));

    public static final RegistryObject<Block> MEAT_RADIO = registerBlock("meat_radio",
            () -> new MeatRadio(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.SLIME)
                    .notSolid()));

    public static final RegistryObject<Block> SKIN_STAND = registerBlock("skin_stand",
            () -> new SkinStand(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.BONE)
                    .notSolid()));

    public static final RegistryObject<Block> MEAT_BED = registerBlock("meat_bed",
            () -> new MeatBed(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.SLIME)
                    .notSolid()));

    public static final RegistryObject<Block> MEAT_TV = registerBlock("meat_tv",
            () -> new MeatTV(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.SLIME)
                    .notSolid()));

    public static final RegistryObject<Block> SKIN_LAMP = registerBlock("skin_lamp",
            () -> new SkinLamp(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).sound(SoundType.SLIME)
                    .notSolid().setLightLevel((state) -> 12)));

    public static final RegistryObject<Block> BONE_DINOSAUR = registerBlock("bone_dinosaur",
            () -> new BoneDinosaur(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.BONE)
                    .notSolid()));

    public static final RegistryObject<Block> CEILING_TRAP = registerBlock("ceiling_trap",
            () -> new CeilingTrap(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).sound(SoundType.SLIME)
                    .doesNotBlockMovement()));

    public static final RegistryObject<Block> MEAT_LAMP = registerBlock("meat_lamp",
            () -> new MeatLamp(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.SLIME)
                    .notSolid().setLightLevel((state) -> 12)));

    public static final RegistryObject<Block> MEAT_COUCH_CENTER = registerBlock("meat_couch_center",
            () -> new MeatCouchCenter(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.SLIME)
                    .notSolid()));

    public static final RegistryObject<Block> GENERATOR = registerBlock("generator",
            () -> new Generator(AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(2f).harvestLevel(1).sound(SoundType.METAL)
                    .notSolid()));

    public static final RegistryObject<Block> SKIN_BOOKSHELF = registerBlock("skin_bookshelf",
            () -> new BaseHorizontalBlock(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.SLIME)
                    .notSolid()));

    public static final RegistryObject<Block> MEAT_NIGHTSTAND = registerBlock("meat_nightstand",
            () -> new BaseHorizontalBlock(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.SLIME)
                    .notSolid()));

    public static final RegistryObject<Block> MEAT_PAINTING = registerBlock("meat_painting",
            () -> new Painting(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.SLIME)
                    .notSolid()));

    public static final RegistryObject<Block> FLOOR_TRAP = registerBlock("floor_trap",
            () -> new FloorTrap(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.SLIME)
                    .notSolid().doesNotBlockMovement()));

    public static final RegistryObject<Block> BEAR = registerBlock("bear",
            () -> new Bear(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.SLIME)
                    .notSolid()));

    public static final RegistryObject<Block> INDUSTRIAL_LAMP = registerBlock("industrial_lamp",
            () -> new IndustrialLamp(AbstractBlock.Properties.create(Material.ANVIL).hardnessAndResistance(2f).harvestLevel(1).sound(SoundType.METAL)
                    .notSolid().setLightLevel((state) -> 12)));

    public static final RegistryObject<Block> SKIN_DOOR = registerBlock("skin_door",
            () -> new DoorBlock(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1F).harvestLevel(1).sound(SoundType.SLIME)
                    .notSolid()));

    //SCP-058

    //Core Reg Code
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(ModItemGroup.BLOCK_GROUP)));
    }
}
