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
            () -> new SkinFloor(AbstractBlock.Properties.of(Material.DIRT).strength(-1f).sound(SoundType.SLIME_BLOCK)
                    .noCollission()));

    public static final RegistryObject<Block> FACE_SKIN_FLOOR = registerBlock("face_skin_floor",
            () -> new FaceSkinFloor(AbstractBlock.Properties.of(Material.DIRT).strength(-1f).sound(SoundType.SLIME_BLOCK)
                    .noCollission()));

    public static final RegistryObject<Block> MEAT_BLOCK = registerBlock("meat_block",
            () -> new Block(AbstractBlock.Properties.of(Material.DIRT).strength(-1f).sound(SoundType.SLIME_BLOCK)));

    public static final RegistryObject<Block> STONED_MEAT_WALL = registerBlock("stoned_meat_wall",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(-1f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> SOLID_SKIN_FLOOR = registerBlock("solid_skin_floor",
            () -> new Block(AbstractBlock.Properties.of(Material.DIRT).strength(-1f).sound(SoundType.SLIME_BLOCK)));

    public static final RegistryObject<Block> BONE_BLOCK = registerBlock("bone_block",
            () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(-1f).sound(SoundType.BONE_BLOCK)));

    public static final RegistryObject<Block> METAL_DOOR = registerBlock("metal_door",
            () -> new DoorBlock(AbstractBlock.Properties.of(Material.METAL).strength(2f).harvestLevel(2).sound(SoundType.METAL)
                    .noOcclusion()));

    public static final RegistryObject<Block> MEAT_DOOR = registerBlock("meat_door",
            () -> new DoorBlock(AbstractBlock.Properties.of(Material.WOOD).strength(-1F).harvestLevel(1).sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> MEAT_TABLE = registerBlock("meat_table",
            () -> new BaseHorizontalBlock(AbstractBlock.Properties.of(Material.DIRT).strength(-1f).harvestLevel(1).sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> BONE_BLOCKS = registerBlock("bone_blocks",
            () -> new BoneBlocks(AbstractBlock.Properties.of(Material.DIRT).strength(-1f).harvestLevel(1).sound(SoundType.BONE_BLOCK)
                    .noOcclusion().noCollission()));

    public static final RegistryObject<Block> MEAT_RADIO = registerBlock("meat_radio",
            () -> new MeatRadio(AbstractBlock.Properties.of(Material.DIRT).strength(-1f).harvestLevel(1).sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> SKIN_STAND = registerBlock("skin_stand",
            () -> new SkinStand(AbstractBlock.Properties.of(Material.DIRT).strength(-1f).harvestLevel(1).sound(SoundType.BONE_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> MEAT_BED = registerBlock("meat_bed",
            () -> new MeatBed(AbstractBlock.Properties.of(Material.DIRT).strength(-1f).harvestLevel(1).sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> MEAT_TV = registerBlock("meat_tv",
            () -> new MeatTV(AbstractBlock.Properties.of(Material.DIRT).strength(-1f).harvestLevel(1).sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> SKIN_LAMP = registerBlock("skin_lamp",
            () -> new SkinLamp(AbstractBlock.Properties.of(Material.DIRT).strength(-1f).sound(SoundType.SLIME_BLOCK)
                    .noOcclusion().lightLevel((state) -> 12)));

    public static final RegistryObject<Block> BONE_DINOSAUR = registerBlock("bone_dinosaur",
            () -> new BoneDinosaur(AbstractBlock.Properties.of(Material.DIRT).strength(-1f).harvestLevel(1).sound(SoundType.BONE_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> CEILING_TRAP = registerBlock("ceiling_trap",
            () -> new CeilingTrap(AbstractBlock.Properties.of(Material.DIRT).strength(-1f).sound(SoundType.SLIME_BLOCK)
                    .noCollission()));

    public static final RegistryObject<Block> MEAT_LAMP = registerBlock("meat_lamp",
            () -> new MeatLamp(AbstractBlock.Properties.of(Material.DIRT).strength(-1f).harvestLevel(1).sound(SoundType.SLIME_BLOCK)
                    .noOcclusion().lightLevel((state) -> 12)));

    public static final RegistryObject<Block> MEAT_COUCH_CENTER = registerBlock("meat_couch_center",
            () -> new MeatCouchCenter(AbstractBlock.Properties.of(Material.DIRT).strength(-1f).harvestLevel(1).sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> GENERATOR = registerBlock("generator",
            () -> new Generator(AbstractBlock.Properties.of(Material.HEAVY_METAL).strength(2f).harvestLevel(1).sound(SoundType.METAL)
                    .noOcclusion()));

    public static final RegistryObject<Block> SKIN_BOOKSHELF = registerBlock("skin_bookshelf",
            () -> new BaseHorizontalBlock(AbstractBlock.Properties.of(Material.WOOD).strength(-1f).harvestLevel(1).sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> MEAT_NIGHTSTAND = registerBlock("meat_nightstand",
            () -> new BaseHorizontalBlock(AbstractBlock.Properties.of(Material.WOOD).strength(-1f).harvestLevel(1).sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> MEAT_PAINTING = registerBlock("meat_painting",
            () -> new Painting(AbstractBlock.Properties.of(Material.WOOD).strength(-1f).harvestLevel(1).sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> FLOOR_TRAP = registerBlock("floor_trap",
            () -> new FloorTrap(AbstractBlock.Properties.of(Material.WOOD).strength(-1f).harvestLevel(1).sound(SoundType.SLIME_BLOCK)
                    .noOcclusion().noCollission()));

    public static final RegistryObject<Block> BEAR = registerBlock("bear",
            () -> new Bear(AbstractBlock.Properties.of(Material.DIRT).strength(-1f).harvestLevel(1).sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> INDUSTRIAL_LAMP = registerBlock("industrial_lamp",
            () -> new IndustrialLamp(AbstractBlock.Properties.of(Material.HEAVY_METAL).strength(2f).harvestLevel(1).sound(SoundType.METAL)
                    .noOcclusion().lightLevel((state) -> 12)));

    public static final RegistryObject<Block> SKIN_DOOR = registerBlock("skin_door",
            () -> new DoorBlock(AbstractBlock.Properties.of(Material.DIRT).strength(-1F).harvestLevel(1).sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    //SCP-058

    //Core Reg Code
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ModItemGroup.BLOCK_GROUP)));
    }
}
