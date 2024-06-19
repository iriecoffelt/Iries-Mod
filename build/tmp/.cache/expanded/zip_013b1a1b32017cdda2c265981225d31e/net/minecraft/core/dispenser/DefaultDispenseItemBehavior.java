package net.minecraft.core.dispenser;

import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

public class DefaultDispenseItemBehavior implements DispenseItemBehavior {
   public final ItemStack dispense(BlockSource pBlockSource, ItemStack pItem) {
      ItemStack itemstack = this.execute(pBlockSource, pItem);
      this.playSound(pBlockSource);
      this.playAnimation(pBlockSource, pBlockSource.m_6414_().getValue(DispenserBlock.FACING));
      return itemstack;
   }

   protected ItemStack execute(BlockSource p_123385_, ItemStack pItem) {
      Direction direction = p_123385_.m_6414_().getValue(DispenserBlock.FACING);
      Position position = DispenserBlock.getDispensePosition(p_123385_);
      ItemStack itemstack = pItem.split(1);
      spawnItem(p_123385_.m_7727_(), itemstack, 6, direction, position);
      return pItem;
   }

   public static void spawnItem(Level pLevel, ItemStack pStack, int pSpeed, Direction pFacing, Position pPosition) {
      double d0 = pPosition.x();
      double d1 = pPosition.y();
      double d2 = pPosition.z();
      if (pFacing.getAxis() == Direction.Axis.Y) {
         d1 -= 0.125D;
      } else {
         d1 -= 0.15625D;
      }

      ItemEntity itementity = new ItemEntity(pLevel, d0, d1, d2, pStack);
      double d3 = pLevel.random.nextDouble() * 0.1D + 0.2D;
      itementity.setDeltaMovement(pLevel.random.triangle((double)pFacing.getStepX() * d3, 0.0172275D * (double)pSpeed), pLevel.random.triangle(0.2D, 0.0172275D * (double)pSpeed), pLevel.random.triangle((double)pFacing.getStepZ() * d3, 0.0172275D * (double)pSpeed));
      pLevel.addFreshEntity(itementity);
   }

   protected void playSound(BlockSource pBlockSource) {
      pBlockSource.m_7727_().levelEvent(1000, pBlockSource.m_7961_(), 0);
   }

   protected void playAnimation(BlockSource pBlockSource, Direction pDirection) {
      pBlockSource.m_7727_().levelEvent(2000, pBlockSource.m_7961_(), pDirection.get3DDataValue());
   }
}