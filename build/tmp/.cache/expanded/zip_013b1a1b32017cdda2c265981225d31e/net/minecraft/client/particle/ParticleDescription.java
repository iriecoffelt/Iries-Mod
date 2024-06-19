package net.minecraft.client.particle;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Streams;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ParticleDescription {
   private final List<ResourceLocation> textures;

   private ParticleDescription(List<ResourceLocation> pTextures) {
      this.textures = pTextures;
   }

   public List<ResourceLocation> getTextures() {
      return this.textures;
   }

   public static ParticleDescription fromJson(JsonObject pJson) {
      JsonArray jsonarray = GsonHelper.getAsJsonArray(pJson, "textures", (JsonArray)null);
      if (jsonarray == null) {
         return new ParticleDescription(List.of());
      } else {
         List<ResourceLocation> list = Streams.stream(jsonarray).map((p_107284_) -> {
            return GsonHelper.convertToString(p_107284_, "texture");
         }).map(ResourceLocation::new).collect(ImmutableList.toImmutableList());
         return new ParticleDescription(list);
      }
   }
}