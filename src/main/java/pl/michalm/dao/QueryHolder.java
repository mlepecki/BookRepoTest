package pl.michalm.dao;

public interface QueryHolder {

    String ID_GREATER_THAN_QUERY = "FROM BOOK WHERE id < ?1";
}
