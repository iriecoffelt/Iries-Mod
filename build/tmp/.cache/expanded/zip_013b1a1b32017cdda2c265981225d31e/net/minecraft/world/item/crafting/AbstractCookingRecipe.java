package net.minecraft.world.item.crafting;

import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class AbstractCookingRecipe implements Recipe<Container> {
   protected final RecipeType<?> type;
   protected final ResourceLocation f_43727_;
   private final CookingBookCategory category;
   protected final String group;
   protected final Ingredient ingredient;
   protected final ItemStack result;
   protected final float experience;
   protected final int cookingTime;

   public AbstractCookingRecipe(RecipeType<?> pType, ResourceLocation p_249379_, String pGroup, CookingBookCategory pCategory, Ingredient pIngredient, ItemStack pResult, float pExperience, int pCookingTime) {
      this.type = pType;
      this.category = pCategory;
      this.f_43727_ = p_249379_;
      this.group = pGroup;
      this.ingredient = pIngredient;
      this.result = pResult;
      this.experience = pExperience;
      this.cookingTime = pCookingTime;
   }

   /**
    * Used to check if a recipe matches current crafting inventory
    */
   public boolean matches(Container pInv, Level pLevel) {
      return this.ingredient.test(pInv.getItem(0));
   }

   public ItemStack assemble(Container pContainer, RegistryAccess pRegistryAccess) {
      return this.result.copy();
   }

   /**
    * Used to determine if this recipe can fit in a grid of the given width/height
    */
   public boolean canCraftInDimensions(int pWidth, int pHeight) {
      return true;
   }

   public NonNullList<Ingredient> getIngredients() {
      NonNullList<Ingredient> nonnulllist = NonNullList.create();
      nonnulllist.add(this.ingredient);
      return nonnulllist;
   }

   /**
    * Gets the experience of this recipe
    */
   public float getExperience() {
      return this.experience;
   }

   public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
      return this.result;
   }

   /**
    * Recipes with equal group are combined into one button in the recipe book
    */
   public String getGroup() {
      return this.group;
   }

   /**
    * Gets the cook time in ticks
    */
   public int getCookingTime() {
      return this.cookingTime;
   }

   public ResourceLocation m_6423_() {
      return this.f_43727_;
   }

   public RecipeType<?> getType() {
      return this.type;
   }

   public CookingBookCategory category() {
      return this.category;
   }
}