package net.kerkeruil.tut_mod.block.custom;

import net.kerkeruil.tut_mod.TutorialMod;
import net.kerkeruil.tut_mod.particle.ModParticles;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BarbedWireBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    private static final VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 16, 16, 16);
    private static final VoxelShape COLLISION_SHAPE = Block.createCuboidShape(1, 0, 1, 15, 15, 16);

    public BarbedWireBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return COLLISION_SHAPE;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if(!world.isClient()){
            spawnFoundParticles(world, pos);
        }
    }

    private void spawnFoundParticles(World world, BlockPos positionPlaced) {
        for(int i = 0; i < 20; i++) {
            ServerWorld serverWorld = (ServerWorld) world;
            serverWorld.spawnParticles(ModParticles.NUCLEAR_SIGN_PARTICLE,
                    (double)positionPlaced.getX() + serverWorld.random.nextDouble(),
                    positionPlaced.getY() + serverWorld.random.nextDouble(),
                    (double)positionPlaced.getZ() + serverWorld.random.nextDouble(), 1, 0.0, 0.01, 0.0, 0.2);
        }
    }

     @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        entity.damage(world.getDamageSources().cactus(), 5.0f);
    }
    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}