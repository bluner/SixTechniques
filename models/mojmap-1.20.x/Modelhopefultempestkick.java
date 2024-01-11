// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelhopefultempestkick<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "hopefultempestkick"), "main");
	private final ModelPart side1;
	private final ModelPart side2;
	private final ModelPart side3;
	private final ModelPart side4;

	public Modelhopefultempestkick(ModelPart root) {
		this.side1 = root.getChild("side1");
		this.side2 = root.getChild("side2");
		this.side3 = root.getChild("side3");
		this.side4 = root.getChild("side4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition side1 = partdefinition.addOrReplaceChild("side1", CubeListBuilder.create().texOffs(0, 4)
				.addBox(-5.0F, -4.0F, -19.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(2, 0).mirror()
				.addBox(-5.0F, -4.0F, -17.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(4, 8)
				.addBox(-5.0F, -4.0F, -15.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 8)
				.addBox(-5.0F, -5.0F, -11.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
				.addBox(-5.0F, -5.0F, -13.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(6, 8)
				.addBox(-5.0F, -5.0F, -9.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(12, 12)
				.addBox(-5.0F, -2.0F, -21.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(12, 12)
				.addBox(-5.0F, -2.0F, -23.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
				.addBox(-5.0F, -2.0F, -25.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(6, 8)
				.addBox(-5.0F, -6.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(12, 16)
				.addBox(-5.0F, -6.0F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(16, 16).addBox(-5.0F,
						-6.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(4.0F, 24.0F, 1.0F));

		PartDefinition side2 = partdefinition.addOrReplaceChild("side2",
				CubeListBuilder.create().texOffs(0, 2)
						.addBox(-1.0F, -6.0F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -6.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -6.0F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -5.0F, 10.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -5.0F, 6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -5.0F, 8.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -4.0F, 16.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -4.0F, 12.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -4.0F, 14.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -2.0F, 22.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -2.0F, 18.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -2.0F, 20.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition side3 = partdefinition.addOrReplaceChild("side3", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = side3.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 2)
						.addBox(-1.0F, -2.0F, 20.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -2.0F, 18.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -2.0F, 22.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -6.0F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -6.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -6.0F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -5.0F, 10.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -5.0F, 6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -5.0F, 8.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -4.0F, 16.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -4.0F, 12.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -4.0F, 14.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition side4 = partdefinition.addOrReplaceChild("side4", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r2 = side4.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 2)
						.addBox(-1.0F, -4.0F, -18.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -4.0F, -16.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -4.0F, -14.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -5.0F, -10.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -5.0F, -12.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -5.0F, -8.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -2.0F, -20.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -2.0F, -22.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -2.0F, -24.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -6.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -6.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(-1.0F, -6.0F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		side1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		side2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		side3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		side4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}