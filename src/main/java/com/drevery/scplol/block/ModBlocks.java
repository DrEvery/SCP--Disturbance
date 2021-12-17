package com.drevery.scplol.block;

import com.drevery.scplol.SeriesOneAnomalies;
import com.drevery.scplol.block.custom.*;
import com.drevery.scplol.item.ModItemGroup;
import com.drevery.scplol.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, SeriesOneAnomalies.MOD_ID);
//SCP-002

    public static final RegistryObject<Block> SKIN_FLOOR = registerBlock("skin_floor",
            () -> new MeatBlock(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).sound(SoundType.SLIME)
                    .doesNotBlockMovement()));

    public static final RegistryObject<Block> FACE_SKIN_FLOOR = registerBlock("face_skin_floor",
            () -> new FaceSkinFloor(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).sound(SoundType.SLIME)
                    .doesNotBlockMovement()));

    public static final RegistryObject<Block> MEAT_WALL = registerBlock("meat_wall",
            () -> new MeatBlock(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).sound(SoundType.SLIME)
                    .doesNotBlockMovement()));

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
            () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(2f).harvestLevel(2).sound(SoundType.METAL)
                    .notSolid()));

    public static final RegistryObject<Block> MEAT_TABLE = registerBlock("meat_table",
            () -> new BaseBlockRotation(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.SLIME)
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
                    .notSolid().setLightLevel((state) -> {return 12;})));

    public static final RegistryObject<Block> BONE_DINOSAUR = registerBlock("bone_dinosaur",
            () -> new BoneDinosaur(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.BONE)
                    .notSolid()));

    public static final RegistryObject<Block> CEILING_TRAP = registerBlock("ceiling_trap",
            () -> new CeilingTrap(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).sound(SoundType.SLIME)
                    .doesNotBlockMovement()));

    public static final RegistryObject<Block> MEAT_LAMP = registerBlock("meat_lamp",
            () -> new MeatLamp(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.SLIME)
                    .notSolid().setLightLevel((state) -> {return 12;})));

    public static final RegistryObject<Block> MEAT_COUCH_CENTER = registerBlock("meat_couch_center",
            () -> new MeatCouchCenter(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.SLIME)
                    .notSolid()));

    public static final RegistryObject<Block> GENERATOR = registerBlock("generator",
            () -> new Generator(AbstractBlock.Properties.create(Material.EARTH).hardnessAndResistance(2f).harvestLevel(1).sound(SoundType.METAL)
                    .notSolid()));

    public static final RegistryObject<Block> MEAT_BOOKSHELF = registerBlock("meat_bookshelf",
            () -> new BaseBlockRotation(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.SLIME)
                    .notSolid()));

    public static final RegistryObject<Block> MEAT_NIGHTSTAND = registerBlock("meat_nightstand",
            () -> new BaseBlockRotation(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.SLIME)
                    .notSolid()));

    public static final RegistryObject<Block> MEAT_PAINTING = registerBlock("meat_painting",
            () -> new Painting(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(-1f).harvestLevel(1).sound(SoundType.SLIME)
                    .notSolid()));

//

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.BLOCK_GROUP)));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}