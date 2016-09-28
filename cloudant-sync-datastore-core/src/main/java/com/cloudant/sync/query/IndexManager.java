package com.cloudant.sync.query;

import java.util.List;
import java.util.Map;

/**
 * Created by tomblench on 28/09/2016.
 */

public interface IndexManager {


    Map<String, Map<String, Object>> listIndexes() throws QueryException;

    String ensureIndexed(List<FieldSort> fieldNames);

    String ensureIndexed(List<FieldSort> fieldNames, String indexName) throws QueryException;

    String ensureIndexed(List<FieldSort> fieldNames, String indexName, IndexType indexType)
            throws QueryException;

    String ensureIndexed(List<FieldSort> fieldNames,
                         String indexName,
                         IndexType indexType,
                         Map<String, String> IndexSettings) throws QueryException;


    void deleteIndex(String indexName) throws QueryException;

    void updateAllIndexes(); // not sure if this should throw or not.

    QueryResult find(Map<String, Object> query) throws QueryException;

    QueryResult find(Map<String, Object> query,
                     long skip,
                     long limit,
                     List<String> fields,
                     List<FieldSort> sortDocument)
            throws QueryException;

    boolean isTextSearchEnabled();

    // TODO we may not want to expose this publicly
    void close();

}
