package binnie.extratrees.alcohol;

public interface ICocktailIngredient {
	String getDisplayName();

	String getIdentifier();

	int getColour();

	int getTransparency();

	String getTooltip(final int p0);

	float getABV();
}
