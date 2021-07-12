package by.teachmeskills.persistence.dao.query.product;

public class ProductJPQLQueries {

    public static final String GET_ALL = "FROM ProductEntity";
    public static final String GET_BY_TITLE = "FROM ProductEntity WHERE title = :title";
    public static final String GET_BY_TITLE_NAME = "Products.findByTitle";

}
