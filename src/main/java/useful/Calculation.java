package useful;

import model.Article;

@FunctionalInterface
public interface Calculation {
    int calculation(Article article);
}
