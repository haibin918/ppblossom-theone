package com.meicai.ppblossom.theone.commons.datasource;

import com.meicai.ppblossom.theone.commons.enums.DatasourceEnum;

public class DataSourceHolder {

    private static final ThreadLocal<String> dataSource = new ThreadLocal<String>();

    public static String getDataSource() {
        String datasourceCode = dataSource.get();
        return datasourceCode == null ? DatasourceEnum.LADDER.getCode() : datasourceCode;
    }

    public static void setDataSource(String datasourceCode) {
        dataSource.set(datasourceCode);
    }

    public static void removeDataSource(){
        dataSource.remove();
    }

}
