package books.examples.effectiveJava.article2_builder;

/**
 * Created by mnikonova on 27.05.15.
 */

//exists only for classes with multiple params, where part of parameters are optional

public class NutritionFacts {

    private final int size;
    private final int servings;
    private final int calories;

    public static class Builder {
        //required
        private final int size;
        private final int servings;
        //optianal (initialized)
        private int calories = 0;

        public Builder(int size, int servings) {
            this.size = size;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        size = builder.size;
        servings = builder.servings;
        calories = builder.calories;
    }

    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(240, 8).build();
        NutritionFacts nutritionFacts2 = new Builder(240, 8).calories(200).build();
    }

}
