package com.mojang.realmsclient.util.task;

import com.mojang.logging.LogUtils;
import com.mojang.realmsclient.client.RealmsClient;
import com.mojang.realmsclient.dto.RealmsServer;
import com.mojang.realmsclient.exception.RetryCallException;
import com.mojang.realmsclient.gui.screens.RealmsConfigureWorldScreen;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.slf4j.Logger;

@OnlyIn(Dist.CLIENT)
public class CloseServerTask extends LongRunningTask {
   private static final Logger LOGGER = LogUtils.getLogger();
   private final RealmsServer serverData;
   private final RealmsConfigureWorldScreen configureScreen;

   public CloseServerTask(RealmsServer pServerData, RealmsConfigureWorldScreen pConfigureScreen) {
      this.serverData = pServerData;
      this.configureScreen = pConfigureScreen;
   }

   public void run() {
      this.m_90409_(Component.translatable("mco.configure.world.closing"));
      RealmsClient realmsclient = RealmsClient.create();

      for(int i = 0; i < 25; ++i) {
         if (this.aborted()) {
            return;
         }

         try {
            boolean flag = realmsclient.close(this.serverData.id);
            if (flag) {
               this.configureScreen.stateChanged();
               this.serverData.state = RealmsServer.State.CLOSED;
               setScreen(this.configureScreen);
               break;
            }
         } catch (RetryCallException retrycallexception) {
            if (this.aborted()) {
               return;
            }

            pause((long)retrycallexception.delaySeconds);
         } catch (Exception exception) {
            if (this.aborted()) {
               return;
            }

            LOGGER.error("Failed to close server", (Throwable)exception);
            this.m_87791_("Failed to close the server");
         }
      }

   }
}