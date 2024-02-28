package net.kerkeruil.tut_mod.screen;


import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;

import net.kerkeruil.tut_mod.TutorialMod;
import net.kerkeruil.tut_mod.screen.Renderer.EnergyInfoArea;
import net.kerkeruil.tut_mod.screen.Renderer.FluidStackRenderer;
import net.kerkeruil.tut_mod.util.MouseUtil;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class GemEmpoweringScreen extends HandledScreen<GemEmpoweringScreenHandler> {
    private static final Identifier TEXTURE =
            new Identifier(TutorialMod.mod_ID, "textures/gui/gem_empowering_station_gui.png");
    private EnergyInfoArea energyInfoArea;
//    private FluidStackRenderer fluidStackRenderer;

    public GemEmpoweringScreen(GemEmpoweringScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleY = 1000;
        playerInventoryTitleY = 1000;
        assignEnergyInfoArea();
//        assignFluidStackRenderer();
    }

//    private void assignFluidStackRenderer() {
//        fluidStackRenderer = new FluidStackRenderer((FluidConstants.BUCKET / 81) * 64, true, 16, 39);
//    }
//
    private void assignEnergyInfoArea() {
        energyInfoArea = new EnergyInfoArea(((width - backgroundWidth) / 2) + 156,
                ((height - backgroundHeight) / 2 ) + 11, handler.blockEntity.energyStorage);
    }

    private void renderEnergyAreaTooltips(DrawContext context, int pMouseX, int pMouseY, int x, int y) {
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, 156, 11, 8, 64)) {
            context.drawTooltip(Screens.getTextRenderer(this), energyInfoArea.getTooltips(),
                    Optional.empty(), pMouseX - x, pMouseY - y);
        }
    }
//
//    private void renderFluidTooltip(DrawContext context, int mouseX, int mouseY, int x, int y, int offsetX, int offsetY, FluidStackRenderer renderer) {
//        if(isMouseAboveArea(mouseX, mouseY, x, y, offsetX, offsetY, renderer)) {
//            context.drawTooltip(Screens.getTextRenderer(this), renderer.getTooltip(handler.blockEntity.fluidStorage, TooltipContext.Default.BASIC),
//                    Optional.empty(), mouseX - x, mouseY - y);
//        }
//    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        renderEnergyAreaTooltips(context, mouseX, mouseY, x, y);
//        renderFluidTooltip(context, mouseX, mouseY, x, y, 26, 11, fluidStackRenderer);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

//      x,y = screenlocation from where the gui.png is drawn
//      backgroundWidth/Height is size part of gui.png that should be displayed.
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(context, x, y);

        energyInfoArea.draw(context);
//        fluidStackRenderer.drawFluid(context, handler.blockEntity.fluidStorage, x + 26, y + 11, 16, 39,
//                (FluidConstants.BUCKET / 81) * 64);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
//          Draw the object at 176,0 at location x+85, y+30 with width 8 and height that's scaled.
            context.drawTexture(TEXTURE, x + 85, y + 30, 176, 0, 8, handler.getScaledProgress());
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, FluidStackRenderer renderer) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, renderer.getWidth(), renderer.getHeight());
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, int width, int height) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, width, height);
    }
}