package org.wso2.gitissueservice.utils;

import javax.sql.DataSource;

/**
 * This class holding Data source object.
 */
public class DataValueHolder {
    private DataSource datasource;
    private static DataValueHolder dataValueHolder =  new DataValueHolder();

    private DataValueHolder() {

    }

    public static DataValueHolder getInstance() {
        return dataValueHolder;
    }

    public void setDataSource(DataSource datasource) {
        this.datasource = datasource;
    }

    public DataSource getDataSource() {
        return datasource;
    }
}
