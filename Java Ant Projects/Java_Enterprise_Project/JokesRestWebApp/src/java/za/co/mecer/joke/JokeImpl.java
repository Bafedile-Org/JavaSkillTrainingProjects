package za.co.mecer.joke;

/**
 *
 * @author Dimakatso Sebatane
 */
public class JokeImpl implements Joke {

    private String joke, category;

    public JokeImpl() {
    }

    public JokeImpl(String joke, String category) {
        this.joke = joke;
        this.category = category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public void setJoke(String joke) {
        this.joke = joke;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String getJoke() {
        return joke;
    }

    @Override
    public String toString() {
        return String.format("%s:{%s}", category, joke);
    }
}
