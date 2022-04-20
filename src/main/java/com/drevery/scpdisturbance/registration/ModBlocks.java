package com.drevery.scpdisturbance.registration;

import com.drevery.scpdisturbance.SCPDisturbance;
import com.drevery.scpdisturbance.block.*;
import com.drevery.scpdisturbance.block.base.BaseHorizontalBlock;
import io.github.connortron110.connorsapi.registration.block.BlockDeferredRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SCPDisturbance.MOD_ID);

    //SCP-002
    public static final RegistryObject<Block> SKIN_FLOOR = registerBlock("skin_floor",
            () -> new SkinFloor(BlockBehaviour.Properties.of(Material.DIRT).strength(-1f).sound(SoundType.SLIME_BLOCK)
                    .noCollission()));

    public static final RegistryObject<Block> FACE_SKIN_FLOOR = registerBlock("face_skin_floor",
            () -> new FaceSkinFloor(BlockBehaviour.Properties.of(Material.DIRT).strength(-1f).sound(SoundType.SLIME_BLOCK)
                    .noCollission()));

    public static final RegistryObject<Block> MEAT_BLOCK = registerBlock("meat_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(-1f).sound(SoundType.SLIME_BLOCK)));

    public static final RegistryObject<Block> STONED_MEAT_WALL = registerBlock("stoned_meat_wall",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(-1f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> SOLID_SKIN_FLOOR = registerBlock("solid_skin_floor",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(-1f).sound(SoundType.SLIME_BLOCK)));

    public static final RegistryObject<Block> BONE_BLOCK = registerBlock("bone_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(-1f).sound(SoundType.BONE_BLOCK)));

    public static final RegistryObject<Block> METAL_DOOR = registerBlock("metal_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops().sound(SoundType.METAL)
                    .noOcclusion()));

    public static final RegistryObject<Block> MEAT_DOOR = registerBlock("meat_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(-1F).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> MEAT_TABLE = registerBlock("meat_table",
            () -> new MeatTable(BlockBehaviour.Properties.of(Material.DIRT).strength(-1f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> TABLE_A = registerBlock("table_a",
            () -> new TableA(BlockBehaviour.Properties.of(Material.DIRT).strength(-1F).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> BONE_BLOCKS = registerBlock("bone_blocks",
            () -> new BoneBlocks(BlockBehaviour.Properties.of(Material.DIRT).strength(-1f).requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK)
                    .noOcclusion().noCollission()));

    public static final RegistryObject<Block> MEAT_RADIO = registerBlock("meat_radio",
            () -> new MeatRadio(BlockBehaviour.Properties.of(Material.DIRT).strength(-1f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> MEAT_BED = registerBlock("meat_bed",
            () -> new MeatBed(BlockBehaviour.Properties.of(Material.DIRT).strength(-1f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> MEAT_TV = registerBlock("meat_tv",
            () -> new MeatTV(BlockBehaviour.Properties.of(Material.DIRT).strength(-1f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> SKIN_LAMP = registerBlock("skin_lamp",
            () -> new SkinLamp(BlockBehaviour.Properties.of(Material.DIRT).strength(-1f).sound(SoundType.SLIME_BLOCK)
                    .noOcclusion().lightLevel((state) -> 12)));

    public static final RegistryObject<Block> BONE_DINOSAUR = registerBlock("bone_dinosaur",
            () -> new BoneDinosaur(BlockBehaviour.Properties.of(Material.DIRT).strength(-1f).requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> CEILING_TRAP = registerBlock("ceiling_trap",
            () -> new CeilingTrap(BlockBehaviour.Properties.of(Material.DIRT).strength(-1f).sound(SoundType.SLIME_BLOCK)
                    .noCollission()));

    public static final RegistryObject<Block> MEAT_LAMP = registerBlock("meat_lamp",
            () -> new MeatLamp(BlockBehaviour.Properties.of(Material.DIRT).strength(-1f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)
                    .noOcclusion().lightLevel((state) -> 12)));

    public static final RegistryObject<Block> MEAT_COUCH_CENTER = registerBlock("meat_couch_center",
            () -> new MeatCouchCenter(BlockBehaviour.Properties.of(Material.DIRT).strength(-1f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> GENERATOR = registerBlock("generator",
            () -> new Generator(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2f).requiresCorrectToolForDrops().sound(SoundType.METAL)
                    .noOcclusion()));

    public static final RegistryObject<Block> SKIN_BOOKSHELF = registerBlock("skin_bookshelf",
            () -> new SkinBookshelf(BlockBehaviour.Properties.of(Material.WOOD).strength(-1f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> MEAT_NIGHTSTAND = registerBlock("meat_nightstand",
            () -> new MeatNightstand(BlockBehaviour.Properties.of(Material.WOOD).strength(-1f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> MEAT_PAINTING = registerBlock("meat_painting",
            () -> new Painting(BlockBehaviour.Properties.of(Material.WOOD).strength(-1f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> FLOOR_TRAP = registerBlock("floor_trap",
            () -> new FloorTrap(BlockBehaviour.Properties.of(Material.WOOD).strength(-1f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)
                    .noCollission()));

    public static final RegistryObject<Block> BEAR = registerBlock("bear",
            () -> new Bear(BlockBehaviour.Properties.of(Material.DIRT).strength(-1f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    public static final RegistryObject<Block> INDUSTRIAL_LAMP = registerBlock("industrial_lamp",
            () -> new IndustrialLamp(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(2f).requiresCorrectToolForDrops().sound(SoundType.METAL)
                    .noOcclusion().lightLevel((state) -> 12)));

    public static final RegistryObject<Block> SKIN_DOOR = registerBlock("skin_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.DIRT).strength(-1F).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    //SCP-058
    public static final RegistryObject<Block> SCP_058_EGG = registerBlock("scp_058_egg",
            () -> new SCP058Egg(BlockBehaviour.Properties.of(Material.EGG).strength(-1F).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)
                    .noOcclusion()));

    //SCP-416
    public static final RegistryObject<Block> FENCE_BOTTOM = registerBlock("fence_bottom",
            () -> new FenceDown(BlockBehaviour.Properties.of(Material.METAL).strength(3F).requiresCorrectToolForDrops().sound(SoundType.METAL)
                    .noOcclusion()));

    public static final RegistryObject<Block> FENCE_MIDDLE = registerBlock("fence_middle",
            () -> new FenceMiddle(BlockBehaviour.Properties.of(Material.METAL).strength(3F).requiresCorrectToolForDrops().sound(SoundType.METAL)
                    .noOcclusion()));

    public static final RegistryObject<Block> FENCE_TOP = registerBlock("fence_top",
            () -> new FenceTop(BlockBehaviour.Properties.of(Material.METAL).strength(3F).requiresCorrectToolForDrops().sound(SoundType.METAL)
                    .noOcclusion()));

    public static final RegistryObject<Block> BARBED_WIRE = registerBlock("barbed_wire",
            () -> new BarbedWire(BlockBehaviour.Properties.of(Material.METAL).strength(3F).requiresCorrectToolForDrops().sound(SoundType.METAL)
                    .noOcclusion()));

    public static final RegistryObject<Block> FENCE_GATE_METAL_416 = registerBlock("fence_gate_metal_416",
            () -> new FenceGateMetal416(BlockBehaviour.Properties.of(Material.METAL).strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)
                    .noOcclusion()));

    public static final RegistryObject<Block> GRANDIDIER_WOOD = registerBlock("grandidier_wood",
            () -> new BaseHorizontalBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1f).requiresCorrectToolForDrops().sound(SoundType.WOOD)
                    .noOcclusion()));

    public static final RegistryObject<Block> JOSHUA_TREE = registerBlock("joshua_tree",
            () -> new BaseHorizontalBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1f).requiresCorrectToolForDrops().sound(SoundType.WOOD)
                    .noOcclusion()));

    //SCP-902
    public static final RegistryObject<Block> SCP_902 = registerBlock("scp_902",
            () -> new BaseHorizontalBlock(BlockBehaviour.Properties.of(Material.METAL).strength(1f).requiresCorrectToolForDrops().sound(SoundType.METAL)
                    .noOcclusion()));




    //Core Reg Code
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, p -> new BlockItem(block.get(), p)).tab(ModItemGroup.BLOCK_GROUP).build();
    }
}
