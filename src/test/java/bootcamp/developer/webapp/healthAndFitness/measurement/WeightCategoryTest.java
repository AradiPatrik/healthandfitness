package bootcamp.developer.webapp.healthAndFitness.measurement;

import static org.assertj.core.api.Assertions.*;

import bootcamp.developer.webapp.healthAndFitness.measurement.WeightCategory;
import org.junit.Test;

public class WeightCategoryTest {

    private double bmi;

    private void givenABmiOf(double value) {
        this.bmi = value;
    }

    private void thenCategoryShouldBe(WeightCategory category) {
        assertThat(WeightCategory.getWeightCategoryFromBMI(bmi)).isEqualTo(category);
    }

    @Test
    public void testBmiWithValueOf1ShouldBeVerySeverelyUnderweight() {
        givenABmiOf(1);
        thenCategoryShouldBe(WeightCategory.VERY_SEVERELY_UNDERWEIGHT);
    }

    @Test
    public void testBmiWithValueOf15_5ShouldBeSeverelyUnderweight() {
        givenABmiOf(15.5);
        thenCategoryShouldBe(WeightCategory.SEVERELY_UNDERWEIGHT);
    }

    @Test
    public void testBmiWithValueOf17ShouldBeUnderweight() {
        givenABmiOf(17);
        thenCategoryShouldBe(WeightCategory.UNDERWEIGHT);
    }

    @Test
    public void testBmiWithValueOf20ShouldBeNormal() {
        givenABmiOf(20);
        thenCategoryShouldBe(WeightCategory.NORMAL);
    }

    @Test
    public void testBmiWithValueOf27ShouldBeOverweight() {
        givenABmiOf(27);
        thenCategoryShouldBe(WeightCategory.OVERWEIGHT);
    }

    @Test
    public void testBmiWithValueOf30ShouldBeModeratelyObese() {
        givenABmiOf(30);
        thenCategoryShouldBe(WeightCategory.MODERATELY_OBESE);
    }

    @Test
    public void testBmiWithValueOf36ShouldBeSeverelyObese() {
        givenABmiOf(36);
        thenCategoryShouldBe(WeightCategory.SEVERELY_OBESE);
    }

    @Test
    public void testBmiWithValueOf43ShouldBeVerySeverelyObese() {
        givenABmiOf(43);
        thenCategoryShouldBe(WeightCategory.VERY_SEVERELY_OBESE);
    }
}
